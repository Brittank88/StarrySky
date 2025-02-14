package de.dafuqs.starrysky;

import de.dafuqs.starrysky.advancements.SpheroidAdvancementIdentifier;
import de.dafuqs.starrysky.dimension.SystemGenerator;
import de.dafuqs.starrysky.dimension.spheroid.spheroids.Spheroid;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.WorldAccess;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class Support {

    public static class SpheroidDistance {
        public Spheroid spheroid;
        public double squaredDistance;

        public SpheroidDistance(Spheroid spheroid, double squaredDistance) {
            this.spheroid = spheroid;
            this.squaredDistance = squaredDistance;
        }
    }

    private static final List<Point> aroundPoints = new ArrayList<>() {{
       add(new Point(0, 0));
       add(new Point(1, -1));
       add(new Point(1, 0));
       add(new Point(1, 1));
       add(new Point(0, -1));
       add(new Point(0, 1));
       add(new Point(-1, -1));
       add(new Point(-1, 0));
       add(new Point(-1, 1));
    }};

    public static SpheroidDistance getClosestSpheroidToPlayer(PlayerEntity serverPlayerEntity) {
        Vec3d playerPos = serverPlayerEntity.getPos();
        BlockPos playerPosBlock = new BlockPos((int) playerPos.x, (int) playerPos.y, (int) playerPos.z);
        List<Spheroid> localSystem = SystemGenerator.getSystemGeneratorOfWorld(serverPlayerEntity.getEntityWorld().getRegistryKey()).getSystemAtChunkPos(playerPosBlock.getX() / 16, playerPosBlock.getZ() / 16);

        Spheroid closestSpheroid = null;
        double currentMinDistance = Double.MAX_VALUE;
        for (Spheroid p : localSystem) {
            double currDist = playerPosBlock.getSquaredDistance(p.getPosition());
            if(currDist < currentMinDistance) {
                currentMinDistance = currDist;
                closestSpheroid = p;
            }
        }

        return new SpheroidDistance(closestSpheroid, currentMinDistance);
    }

    public static SpheroidDistance getClosestSpheroid3x3(ServerWorld serverWorld, BlockPos position, SpheroidAdvancementIdentifier spheroidAdvancementIdentifier) {
        SystemGenerator spheroidGenerator = SystemGenerator.getSystemGeneratorOfWorld(serverWorld.getRegistryKey());

        Spheroid closestSpheroid = null;
        double currentMinDistance = Double.MAX_VALUE;
        for(Point currentPoint : aroundPoints) {
            Point systemPos = getSystemCoordinateFromChunkCoordinate(position.getX() / 16, position.getZ() / 16);

            List<Spheroid> currentSystem = spheroidGenerator.getSystemAtPoint(new Point(systemPos.x + currentPoint.x, systemPos.y + currentPoint.y));
            for (Spheroid p : currentSystem) {
                if (p.getSpheroidAdvancementIdentifier().equals(spheroidAdvancementIdentifier)) {
                    double currDist = position.getSquaredDistance(p.getPosition());
                    if (currDist < currentMinDistance) {
                        currentMinDistance = currDist;
                        closestSpheroid = p;
                    }
                }
            }

            if(closestSpheroid != null) {
                return new SpheroidDistance(closestSpheroid, currentMinDistance);
            }
        }

        return null;
    }

    public static <E> E getWeightedRandom(LinkedHashMap<E, Float> weights, Random random) {
        E result = null;
        double bestValue = Double.MAX_VALUE;

        for (E element : weights.keySet()) {
            double value = -Math.log(random.nextDouble()) / (weights.get(element));

            if (value < bestValue) {
                bestValue = value;
                result = element;
            }
        }
        return result;
    }

    /**
     * System size of 50 results in system 0,0 at 0>+800, -1,0 at -800>0
     * @param chunkX X coordinate of chunk
     * @param chunkZ Z coordinate of chunk
     * @return the system point
     */
    public static Point getSystemCoordinateFromChunkCoordinate(int chunkX, int chunkZ) {
        int sysX;
        if (chunkX >= 0) {
            sysX = chunkX / StarrySkyCommon.STARRY_SKY_CONFIG.systemSizeChunks;
        } else {
            sysX = (int) Math.floor(chunkX / (float) StarrySkyCommon.STARRY_SKY_CONFIG.systemSizeChunks);
        }

        int sysZ;
        if (chunkZ >= 0) {
            sysZ = chunkZ / StarrySkyCommon.STARRY_SKY_CONFIG.systemSizeChunks;
        } else {
            sysZ = (int) Math.floor(chunkZ / (float) StarrySkyCommon.STARRY_SKY_CONFIG.systemSizeChunks);
        }
        return new Point(sysX, sysZ);
    }

    /**
     * The bounds values lowest and highest are part of the result set
     * @param lowest
     * @param highest
     * @return
     */
    public static int getRandomBetween(Random random, int lowest, int highest) {
        return random.nextInt(highest - lowest + 1) + lowest;
    }

    public static double getDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2));
    }

    public static double getSquaredDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) + (z1 - z2) * (z1 - z2);
    }

    public static double getDistance(BlockPos blockPos1, BlockPos blockPos2) {
        return getDistance(blockPos1.getX(), blockPos1.getY(), blockPos1.getZ(), blockPos2.getX(), blockPos2.getY(), blockPos2.getZ());
    }

    public static boolean isBlockPosInChunkPos(ChunkPos chunkPos, BlockPos blockPos) {
        return (blockPos.getX() >= chunkPos.getStartX()
                && blockPos.getX() < chunkPos.getStartX() + 16
                && blockPos.getZ() >= chunkPos.getStartZ()
                && blockPos.getZ() < chunkPos.getStartZ() + 16);
    }

    public static boolean inSameChunk(BlockPos blockPos1, BlockPos blockPos2) {
        return (blockPos1.getX() / 16 == blockPos2.getX() / 16) && (blockPos1.getZ() / 16 == blockPos2.getZ() / 16);
    }

    /***
     * Move down as long as air is found. We are now on the surface of a piece of land
     * @param world the world to search
     * @param position the position to start searching from downwards
     * @param minHeight the minimum height. If that value is reached search will be ended and minHeight returned
     * @return The air block above ground if found. minHeight if not found
     */
    public static int getLowerGroundBlock(WorldAccess world, BlockPos position, int minHeight) {
        BlockPos.Mutable blockPosMutable = new BlockPos.Mutable(position.getX(), position.getY(), position.getZ());
        while (blockPosMutable.getY() > minHeight) {
            if (world.isAir(blockPosMutable) || !world.getFluidState(blockPosMutable).isEmpty()) {
                blockPosMutable.move(Direction.DOWN);
            } else {
                return blockPosMutable.getY() + 1;
            }
        }
        return blockPosMutable.getY();
    }

    /**
     * Move up as long as air is found. We are now on the bottom surface of a piece of land
     * @param world the world to search
     * @param position the position to start searching from upwards
     * @param maxHeight the maximum height. If that value is reached search will be ended and maxHeight returned
     * @return The air block below ground if found. maxHeight if not found
     */
    public static int getUpperGroundBlock(WorldAccess world, BlockPos position, int maxHeight) {
        BlockPos.Mutable blockPosMutable = new BlockPos.Mutable(position.getX(), position.getY(), position.getZ());
        while (blockPosMutable.getY() < maxHeight) {
            if (world.isAir(blockPosMutable) || !world.getFluidState(blockPosMutable).isEmpty()) {
                blockPosMutable.move(Direction.UP);
            } else {
                return blockPosMutable.getY() - 1;
            }
        }

        return blockPosMutable.getY();
    }

}
