package de.dafuqs.starrysky.dimension.spheroid.types;

import de.dafuqs.starrysky.dimension.spheroid.SpheroidEntitySpawnDefinition;
import de.dafuqs.starrysky.StarrySkyCommon;
import de.dafuqs.starrysky.Support;
import de.dafuqs.starrysky.advancements.SpheroidAdvancementIdentifier;
import de.dafuqs.starrysky.dimension.SpheroidDecorator;
import de.dafuqs.starrysky.dimension.spheroid.spheroids.DoubleCoreSpheroid;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.ChunkRandom;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.apache.logging.log4j.Level.ERROR;

public class DoubleCoreSpheroidType extends SpheroidType {

    private final BlockState innerCoreBlock;
    private final BlockState outerCoreBlock;
    private final LinkedHashMap<BlockState, Float> validShellBlocks;
    private final int minInnerCoreRadius;
    private final int maxInnerCoreRadius;
    private final int minShellRadius;
    private final int maxShellRadius;

    public DoubleCoreSpheroidType(SpheroidAdvancementIdentifier spheroidAdvancementIdentifier, int minRadius, int maxRadius, BlockState innerCoreBlock, BlockState outerCoreBlock, BlockState shellBlock, int minInnerCoreRadius, int maxInnerCoreRadius, int minShellRadius, int maxShellRadius) {
        this(spheroidAdvancementIdentifier, minRadius, maxRadius, innerCoreBlock, outerCoreBlock, new LinkedHashMap<BlockState, Float>(){{put(shellBlock, 1.0F);}}, minInnerCoreRadius, maxInnerCoreRadius,  minShellRadius, maxShellRadius);
    }

    public DoubleCoreSpheroidType(SpheroidAdvancementIdentifier spheroidAdvancementIdentifier, int minRadius, int maxRadius, BlockState innerCoreBlock, BlockState outerCoreBlock, LinkedHashMap<BlockState, Float> validShellBlocks, int minInnerCoreRadius, int maxInnerCoreRadius, int minShellRadius, int maxShellRadius) {
        super(spheroidAdvancementIdentifier, minRadius, maxRadius);

        if(innerCoreBlock == Blocks.AIR.getDefaultState()) {
            StarrySkyCommon.log(ERROR, "DoubleCoreSpheroidType: Registered a SpheroidType with null innerCoreBlock!");
        }
        if(outerCoreBlock == Blocks.AIR.getDefaultState()) {
            StarrySkyCommon.log(ERROR, "DoubleCoreSpheroidType: Registered a SpheroidType with null outerCoreBlock!");
        }
        if(validShellBlocks == null || validShellBlocks.size() == 0) {
            StarrySkyCommon.log(ERROR, "DoubleCoreSpheroidType: Registered a SpheroidType with empty validShellBlocks!");
        }

        this.innerCoreBlock = innerCoreBlock;
        this.outerCoreBlock = outerCoreBlock;
        this.validShellBlocks = validShellBlocks;
        this.minInnerCoreRadius = minInnerCoreRadius;
        this.maxInnerCoreRadius = maxInnerCoreRadius;
        this.minShellRadius = minShellRadius;
        this.maxShellRadius = maxShellRadius;
    }

    public String getDescription() {
        return "DoubleCoreSpheroid";
    }

    public DoubleCoreSpheroid getRandomSpheroid(ChunkRandom chunkRandom) {
        int radius = getRandomRadius(chunkRandom);
        int shellRadius = Support.getRandomBetween(chunkRandom, this.minShellRadius, this.maxShellRadius);
        int innerCoreRadius = Support.getRandomBetween(chunkRandom, this.minInnerCoreRadius, this.maxInnerCoreRadius);

        ArrayList<SpheroidDecorator> spheroidDecorators = getSpheroidDecoratorsWithChance(chunkRandom);
        ArrayList<SpheroidEntitySpawnDefinition> entityTypesToSpawn = getRandomEntityTypesToSpawn(chunkRandom);
        BlockState shellBlock = Support.getWeightedRandom(validShellBlocks, chunkRandom);

        return new DoubleCoreSpheroid(chunkRandom, spheroidAdvancementIdentifier, radius, spheroidDecorators, entityTypesToSpawn, innerCoreBlock, outerCoreBlock, shellBlock, innerCoreRadius, shellRadius);
    }

}
