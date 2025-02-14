package de.dafuqs.starrysky.dimension.spheroid.spheroids.unique;

import de.dafuqs.starrysky.StarrySkyCommon;
import de.dafuqs.starrysky.Support;
import de.dafuqs.starrysky.advancements.SpheroidAdvancementIdentifier;
import de.dafuqs.starrysky.dimension.SpheroidDecorator;
import de.dafuqs.starrysky.dimension.spheroid.SpheroidEntitySpawnDefinition;
import de.dafuqs.starrysky.dimension.spheroid.spheroids.Spheroid;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EndPortalFrameBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootTables;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.ChunkRandom;

import java.util.ArrayList;
import java.util.Random;

import static org.apache.logging.log4j.Level.WARN;

public class StrongholdSpheroid extends Spheroid {

    private final BlockState STONE_BRICKS = Blocks.STONE_BRICKS.getDefaultState();
    private final BlockState INFESTED_STONE_BRICKS = Blocks.INFESTED_STONE_BRICKS.getDefaultState();
    private final BlockState MOSSY_STONE_BRICKS = Blocks.MOSSY_STONE_BRICKS.getDefaultState();
    private final BlockState OAK_PLANKS = Blocks.OAK_PLANKS.getDefaultState();
    private final BlockState END_PORTAL_FRAME = Blocks.END_PORTAL_FRAME.getDefaultState();
    private final BlockState SPAWNER = Blocks.SPAWNER.getDefaultState();
    private final BlockState LAVA = Blocks.LAVA.getDefaultState();
    private final BlockState IRON_BARS = Blocks.IRON_BARS.getDefaultState();
    private final BlockState BOOKSHELF = Blocks.BOOKSHELF.getDefaultState();
    private final BlockState AIR = Blocks.AIR.getDefaultState();

    private final Identifier CORRIDOR_CHEST = LootTables.STRONGHOLD_CORRIDOR_CHEST;
    private final Identifier CROSSING_CHEST = LootTables.STRONGHOLD_CROSSING_CHEST;
    private final Identifier LIBRARY_CHEST = LootTables.STRONGHOLD_LIBRARY_CHEST;

    private final int shellRadius;
    private BlockPos portalPosition;
    private final ArrayList<BlockPos> interiorDecoratorPositions = new ArrayList<>();

    public StrongholdSpheroid(ChunkRandom random, SpheroidAdvancementIdentifier spheroidAdvancementIdentifier, int radius, ArrayList<SpheroidDecorator> spheroidDecorators, ArrayList<SpheroidEntitySpawnDefinition> entityTypesToSpawn, int shellRadius) {
        super(spheroidAdvancementIdentifier, random, spheroidDecorators, radius, entityTypesToSpawn);
        this.shellRadius = shellRadius;
    }

    @Override
    public String getDescription() {
        return "+++ StrongholdSpheroid +++" +
                "\nPosition: x=" + this.getPosition().getX() + " y=" + this.getPosition().getY() + " z=" + this.getPosition().getZ() +
                "\nRadius: " + this.radius +
                "\nShellRadius: " + this.shellRadius;
    }

    @Override
    public void generate(Chunk chunk) {
        int chunkX = chunk.getPos().x;
        int chunkZ = chunk.getPos().z;

        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        int z = this.getPosition().getZ();

        int shellDistance = this.radius - this.shellRadius;

        random.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
        for (int x2 = Math.max(chunkX * 16, x - this.radius); x2 <= Math.min(chunkX * 16 + 15, x + this.radius); x2++) {
            for (int y2 = y - this.radius; y2 <= y + this.radius; y2++) {
                for (int z2 = Math.max(chunkZ * 16, z - this.radius); z2 <= Math.min(chunkZ * 16 + 15, z + this.radius); z2++) {

                    BlockPos currBlockPos = new BlockPos(x2, y2, z2);
                    long d = Math.round(Support.getDistance(x, y, z, x2, y2, z2));

                    if (d <= shellDistance) {
                        if (y2 % 10 == (this.position.getY() + 8) % 10 || x2 % 10 == (this.position.getX() + 5) % 10 || z2 % 10 == (this.position.getZ() + 5) % 10) {
                            if ((y2-y) % 6 == 0 && ((x2-x) % 4 == 2 || (z2-z) % 4 == 0)) {
                                chunk.setBlockState(currBlockPos, MOSSY_STONE_BRICKS, false);
                            } else {
                                chunk.setBlockState(currBlockPos, STONE_BRICKS, false);
                            }
                        } else {
                            // AIR
                        }
                    } else if (d <= this.radius) {
                        if (y2 % 2 == 0) {
                            if(x2 % 5 == 0) {
                                chunk.setBlockState(currBlockPos, INFESTED_STONE_BRICKS, false);
                            } else {
                                chunk.setBlockState(currBlockPos, STONE_BRICKS, false);
                            }
                        } else {
                            if(x2 % 2 == 0 && z2 % 2 == 0) {
                                chunk.setBlockState(currBlockPos, MOSSY_STONE_BRICKS, false);
                            } else {
                                chunk.setBlockState(currBlockPos, STONE_BRICKS, false);
                            }
                        }
                    }
                    if(d < this.getRadius() - 9 && (y2 % 10 == (this.position.getY() + 9) % 10 && x2 % 10 == (this.position.getX()) % 10 && z2 % 10 == (this.position.getZ()) % 10)) {
                        if(d == 1) {
                            // place end portal in center
                            portalPosition = currBlockPos;
                        } else {
                            interiorDecoratorPositions.add(currBlockPos);
                        }
                    }
                }
            }
        }
    }

    /**
     * StrongholdSpheroid uses the decorator to place all the
     * internal rooms more easily
     * @param world The world
     * @param random The decoration random
     */
    @Override
    public void decorate(StructureWorldAccess world, Random random, BlockPos origin) {
        if(portalPosition != null) {
            if(Support.inSameChunk(origin, portalPosition)) {
                placeEndPortal(world, portalPosition.up());
            }
        } else {
            StarrySkyCommon.log(WARN, "Generating a Stronghold Spheroid at " + position.getX() + " " + position.getY() + " " + position.getZ() + " without an end portal?");
        }

        for (BlockPos interiorDecoratorPosition : interiorDecoratorPositions) {
            if(Support.inSameChunk(origin, interiorDecoratorPosition)) {
                int randomStructure = random.nextInt(5);
                switch (randomStructure) {
                    case 0 -> placeLibrary(world, interiorDecoratorPosition);
                    case 1 -> placeCorridor(world, interiorDecoratorPosition);
                    case 2 -> placeCrossing(world, interiorDecoratorPosition);
                    case 3 -> placePrison(world, interiorDecoratorPosition);
                    default -> placeFullCube(world, interiorDecoratorPosition);
                }
            }
        }
    }

    private void placeEndPortal(WorldAccess worldAccess, BlockPos blockPos) {
        for (int x2 = - 3; x2 <= 3; x2++) {
            for (int z2 = - 3; z2 <= 3; z2++) {

                BlockPos destinationBlockPos = blockPos.add(x2, 0, z2);
                if((Math.abs(x2) == 3 || Math.abs(z2) == 3)) {
                    if (!(Math.abs(x2) == 3 && Math.abs(z2) == 3)) {
                        worldAccess.setBlockState(destinationBlockPos.down(), STONE_BRICKS, 3);
                    }
                } else if(!(Math.abs(x2) == 2 && Math.abs(z2) == 2)) {
                    if ((Math.abs(x2) == 2 || Math.abs(z2) == 2)) {
                        // Place end portal
                        Direction direction;
                        if (x2 == -2) {
                            direction = Direction.EAST;
                        } else if (x2 == 2) {
                            direction = Direction.WEST;
                        } else if (z2 == -2) {
                            direction = Direction.SOUTH;
                        } else {
                            direction = Direction.NORTH;
                        }

                        if(random.nextBoolean()) {
                            worldAccess.setBlockState(destinationBlockPos, END_PORTAL_FRAME.with(EndPortalFrameBlock.FACING, direction), 3);
                        } else {
                            worldAccess.setBlockState(destinationBlockPos, END_PORTAL_FRAME.with(EndPortalFrameBlock.FACING, direction).with(EndPortalFrameBlock.EYE, true), 3);
                        }
                        worldAccess.setBlockState(destinationBlockPos.down(), STONE_BRICKS, 3);
                        worldAccess.setBlockState(destinationBlockPos.down(2), STONE_BRICKS, 3);
                    } else {
                        worldAccess.setBlockState(destinationBlockPos, AIR, 3);
                        worldAccess.setBlockState(destinationBlockPos.down(), AIR, 3);
                        worldAccess.setBlockState(destinationBlockPos.down(2), LAVA, 3);
                        worldAccess.setBlockState(destinationBlockPos.down(3), STONE_BRICKS, 3);
                    }
                    worldAccess.setBlockState(destinationBlockPos.up(), AIR, 3);
                    worldAccess.setBlockState(destinationBlockPos.up(2), AIR, 3);
                    worldAccess.setBlockState(destinationBlockPos.up(3), AIR, 3);
                } else {
                    placeSpawner(worldAccess, destinationBlockPos.down(2), EntityType.SILVERFISH);
                }
            }
        }
    }

    private void placeFullCube(WorldAccess worldAccess, BlockPos blockPos) {
        for (int x2 = - 4; x2 < 5; x2++) {
            for (int y2 = 0; y2 < 9; y2++) {
                for (int z2 = -4; z2 < 5; z2++) {
                    BlockPos destinationBlockPos = blockPos.add(x2, y2, z2);
                    worldAccess.setBlockState(destinationBlockPos, INFESTED_STONE_BRICKS, 3);
                }
            }
        }
    }

    private void placeLibrary(WorldAccess worldAccess, BlockPos blockPos) {
        for (int x2 = - 4; x2 < 5; x2++) {
            for (int y2 = 0; y2 < 4; y2++) {
                for (int z2 = -4; z2 < 5; z2++) {
                    if(Math.abs(x2) == 4 || Math.abs(z2) == 4 || (Math.abs(x2 % 2) == 1 && Math.abs(z2 % 2) == 1)) {
                        BlockPos destinationBlockPos = blockPos.add(x2, y2, z2);
                        if(y2 == 3) {
                            worldAccess.setBlockState(destinationBlockPos, OAK_PLANKS, 3);
                        } else {
                            worldAccess.setBlockState(destinationBlockPos, BOOKSHELF, 3);
                        }
                    }
                }
            }
        }
        placeCenterChestWithLootTable(worldAccess.getChunk(blockPos), blockPos, LIBRARY_CHEST, random, false);
    }

    private void placePrison(WorldAccess worldAccess, BlockPos blockPos) {
            for (int x2 = - 4; x2 < 5; x2++) {
            for (int y2 = 0; y2 < 9; y2++) {
                BlockPos destinationBlockPos = blockPos.add(x2, y2, 0);
                worldAccess.setBlockState(destinationBlockPos, IRON_BARS.with(PaneBlock.EAST, true).with(PaneBlock.WEST, true), 3);
            }
        }
        for (int y2 = 0; y2 < 9; y2++) {
            for (int z2 = -4; z2 < 5; z2++) {
                BlockPos destinationBlockPos = blockPos.add(0, y2, z2);
                worldAccess.setBlockState(destinationBlockPos, IRON_BARS.with(PaneBlock.NORTH, true).with(PaneBlock.SOUTH, true), 3);
            }
        }

        for (int y2 = 0; y2 < 9; y2++) {
            BlockPos destinationBlockPos = blockPos.add(0, y2, 0);
            worldAccess.setBlockState(destinationBlockPos, IRON_BARS.with(PaneBlock.EAST, true).with(PaneBlock.WEST, true).with(PaneBlock.NORTH, true).with(PaneBlock.SOUTH, true), 3);
        }
    }

    private void placeCrossing(WorldAccess worldAccess, BlockPos blockPos) {
        for (int x2 = -1; x2 < 2; x2++) {
            for (int y2 = 0; y2 < 3; y2++) {
                for (int z2 = -1; z2 < 2; z2++) {
                    BlockPos destinationBlockPos = blockPos.add(x2, y2, z2);
                    worldAccess.setBlockState(destinationBlockPos, MOSSY_STONE_BRICKS, 3);
                }
            }
        }

        placeCenterChestWithLootTable(worldAccess.getChunk(blockPos), blockPos, CROSSING_CHEST, random, false);
    }

    private void placeCorridor(WorldAccess worldAccess, BlockPos blockPos) {
        for (int x2 = -1; x2 < 2; x2++) {
            for (int y2 = 0; y2 < 9; y2++) {
                for (int z2 = -1; z2 < 2; z2++) {
                    BlockState blockState;
                    BlockPos destinationBlockPos = blockPos.add(x2, y2, z2);
                    if(y2 == 0 || (Math.abs(x2) == 1 && Math.abs(z2) == 1)) {
                        blockState = STONE_BRICKS;
                    } else if(y2 < 4) {
                        if(x2 == -1 || x2 == 1) {
                            blockState = IRON_BARS.with(PaneBlock.SOUTH, true).with(PaneBlock.NORTH, true);
                        } else if(z2 == -1 || z2 == 1) {
                            blockState = IRON_BARS.with(PaneBlock.WEST, true).with(PaneBlock.EAST, true);
                        } else {
                            blockState = AIR;
                        }
                    } else  {
                        blockState = STONE_BRICKS;
                    }
                    worldAccess.setBlockState(destinationBlockPos, blockState, 3);
                }
            }
        }

        placeCenterChestWithLootTable(worldAccess.getChunk(blockPos), blockPos.up(), CORRIDOR_CHEST, random, false);

    }

}
