package de.dafuqs.starrysky.spheroid.spheroids;

import de.dafuqs.starrysky.Support;
import de.dafuqs.starrysky.advancements.SpheroidAdvancementIdentifier;
import de.dafuqs.starrysky.spheroid.SpheroidDecorator;
import de.dafuqs.starrysky.spheroid.SpheroidEntitySpawnDefinition;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.ChunkRandom;
import net.minecraft.world.chunk.Chunk;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShellSpheroid extends Spheroid {

    //STATIC CONFIG STUFF
    protected BlockState coreBlock;
    protected BlockState shellBlock;
    protected int shellRadius;
    private final LinkedHashMap<BlockState, Float> shellSpeckleBlockStates;

    public ShellSpheroid(ChunkRandom random, SpheroidAdvancementIdentifier spheroidAdvancementIdentifier, int radius, ArrayList<SpheroidDecorator> spheroidDecorators, ArrayList<SpheroidEntitySpawnDefinition> entityTypesToSpawn, BlockState coreBlock,
                         BlockState shellBlock, int shellRadius, LinkedHashMap<BlockState, Float> shellSpeckleBlockStates) {
        super(spheroidAdvancementIdentifier, random, spheroidDecorators, radius, entityTypesToSpawn);
        this.radius = radius;
        this.coreBlock = coreBlock;
        this.shellBlock = shellBlock;
        this.shellRadius = shellRadius;
        this.shellSpeckleBlockStates = shellSpeckleBlockStates;
    }

    public String getDescription() {
        return "+++ ShellSpheroid +++" +
                "\nPosition: x=" + this.getPosition().getX() + " y=" + this.getPosition().getY() + " z=" + this.getPosition().getZ() +
                "\nRadius: " + this.radius +
                "\nShell: " + this.shellBlock.toString() + " (Radius: " + this.shellRadius + ")" +
                "\nCore: " +this.coreBlock.toString();
    }

    @Override
    public void generate(Chunk chunk) {
        int chunkX = chunk.getPos().x;
        int chunkZ = chunk.getPos().z;

        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        int z = this.getPosition().getZ();

        boolean hasSpeckles = hasSpeckles();

        random.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
        for (int x2 = Math.max(chunkX * 16, x - this.radius); x2 <= Math.min(chunkX * 16 + 15, x + this.radius); x2++) {
            for (int y2 = y - this.radius; y2 <= y + this.radius; y2++) {
                for (int z2 = Math.max(chunkZ * 16, z - this.radius); z2 <= Math.min(chunkZ * 16 + 15, z + this.radius); z2++) {
                    BlockPos currBlockPos = new BlockPos(x2, y2, z2);
                    long d = Math.round(Support.getDistance(x, y, z, x2, y2, z2));
                    if (d <= (this.radius - this.shellRadius)) {
                        chunk.setBlockState(currBlockPos, this.coreBlock, false);
                    } else if (d <= this.radius) {
                        if (hasSpeckles) {
                            BlockState finalBlockState = shellBlock;
                            for (Map.Entry<BlockState, Float> shellSpeckleBlockState : shellSpeckleBlockStates.entrySet()) {
                                if(random.nextFloat() < shellSpeckleBlockState.getValue()) {
                                    finalBlockState = shellSpeckleBlockState.getKey();
                                    break;
                                }
                            }
                            chunk.setBlockState(currBlockPos, finalBlockState, false);
                        } else {
                            chunk.setBlockState(currBlockPos, this.shellBlock, false);
                        }
                        if(isTopBlock(d, x2, y2, z2)) {
                            addDecorationBlockPosition(currBlockPos);
                        }
                    }
                }
            }
        }
    }

    private boolean hasSpeckles() {
        return this.shellSpeckleBlockStates.size() > 0;
    }

}
