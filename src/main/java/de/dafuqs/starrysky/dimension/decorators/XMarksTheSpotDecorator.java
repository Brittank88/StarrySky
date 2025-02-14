package de.dafuqs.starrysky.dimension.decorators;

import de.dafuqs.starrysky.dimension.SpheroidDecorator;
import de.dafuqs.starrysky.dimension.spheroid.spheroids.Spheroid;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;

import java.util.Random;


/**
 * Creates a small X on one side of the spheroid
 * Puts a loot chest in the absolute center (could be fun on lava spheroids!)
 */
public class XMarksTheSpotDecorator extends SpheroidDecorator {

    private final Identifier lootTable;
    private final BlockState markBlockState;
    private final boolean[] theX = {
        true,  false, false, false,  true,
        false,  true, false,  true, false,
        false, false,  true, false, false,
        false,  true, false,  true, false,
        true, false,  false, false,  true
    };

    public XMarksTheSpotDecorator(Identifier lootTable, BlockState markBlockState) {
        this.lootTable = lootTable;
        this.markBlockState = markBlockState;
    }

    @Override
    public void decorateSpheroid(StructureWorldAccess world, Spheroid spheroid, BlockPos origin, Random random) {
        if(!spheroid.isCenterInChunkBlockPos(origin)) {
            return;
        }

        placeLootChestAtPosition(world, spheroid.getPosition(), lootTable, random);

        // paint 1-3 "X"es on the sphere in random directions
        int r = random.nextInt(6);
        int amountOfXMarks = random.nextInt(2) + 1;
        for(int i = 0; i < amountOfXMarks; i++) {
            Direction randomDirection = Direction.values()[(r+i) % 6];
            paintXInDirection(world, spheroid, randomDirection);
        }
    }

    /**
     * Draws an "X" in a 5x5 pattern on a sphere.
     */
    private void paintXInDirection(StructureWorldAccess world, Spheroid spheroid, Direction direction) {
        int startX;
        int startY;
        int startZ;

        BlockPos spheroidPos = spheroid.getPosition();
        int radius = spheroid.getRadius();
        switch (direction) {
            case UP -> {
                startX = spheroidPos.getX() - 2;
                startY = spheroidPos.getY() - radius;
                startZ = spheroidPos.getZ() - 2;
            }
            case DOWN -> {
                startX = spheroidPos.getX() - 2;
                startY = spheroidPos.getY() + radius;
                startZ = spheroidPos.getZ() - 2;
            }
            case EAST -> {
                startX = spheroidPos.getX() - radius;
                startY = spheroidPos.getY() - 2;
                startZ = spheroidPos.getZ() - 2;
            }
            case WEST -> {
                startX = spheroidPos.getX() + radius;
                startY = spheroidPos.getY() - 2;
                startZ = spheroidPos.getZ() - 2;
            }
            case NORTH -> {
                startX = spheroidPos.getX() - 2;
                startY = spheroidPos.getY() - 2;
                startZ = spheroidPos.getZ() + spheroid.getRadius();
            }
            default -> {
                startX = spheroidPos.getX() - 2;
                startY = spheroidPos.getY() - 2;
                startZ = spheroidPos.getZ() - spheroid.getRadius();
            }
        }

        for(int i = -0; i < 5; i++) {
            for(int j = -0; j < 5; j++){
                if(theX[i*5+j]) {
                    BlockPos startBlockPos;
                    switch (direction) {
                        case UP, DOWN -> {
                            startBlockPos = new BlockPos(startX + i, startY, startZ + j);
                        }
                        case EAST, WEST -> {
                            startBlockPos = new BlockPos(startX, startY + i, startZ + j);
                        }
                        default -> {
                            startBlockPos = new BlockPos(startX + i, startY + j, startZ);
                        }
                    }
                    BlockPos currentBlockPos = findNextNonAirBlockInDirection(world, startBlockPos, direction, spheroid.getRadius());
                    if (currentBlockPos != null) {
                        world.setBlockState(currentBlockPos, markBlockState, 3);
                    }
                }
            }
        }
    }

}
