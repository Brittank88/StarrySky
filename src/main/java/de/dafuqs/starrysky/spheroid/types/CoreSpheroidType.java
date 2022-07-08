package de.dafuqs.starrysky.spheroid.types;

import de.dafuqs.starrysky.StarrySkyCommon;
import de.dafuqs.starrysky.Support;
import de.dafuqs.starrysky.advancements.SpheroidAdvancementIdentifier;
import de.dafuqs.starrysky.spheroid.SpheroidDecorator;
import de.dafuqs.starrysky.spheroid.SpheroidEntitySpawnDefinition;
import de.dafuqs.starrysky.spheroid.spheroids.CoreSpheroid;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.random.ChunkRandom;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.apache.logging.log4j.Level.ERROR;


public class CoreSpheroidType extends SpheroidType {

    private final BlockState coreBlock;
    private final LinkedHashMap<BlockState, Float> shellBlockStates;
    private final int minCoreRadius;
    private final int maxCoreRadius;

    public CoreSpheroidType(SpheroidAdvancementIdentifier spheroidAdvancementIdentifier, int minRadius, int maxRadius, BlockState coreBlock, BlockState shellBlock, int minCoreRadius, int maxCoreRadius) {
        this(spheroidAdvancementIdentifier, minRadius, maxRadius, coreBlock, new LinkedHashMap<>(){{put(shellBlock, 1.0F);}}, minCoreRadius, maxCoreRadius);
    }

    public CoreSpheroidType(SpheroidAdvancementIdentifier spheroidAdvancementIdentifier, int minRadius, int maxRadius, BlockState coreBlock, LinkedHashMap<BlockState, Float> shellBlockStates, int minCoreRadius, int maxCoreRadius) {
        super(spheroidAdvancementIdentifier, minRadius, maxRadius);

        if(coreBlock == Blocks.AIR.getDefaultState()) {
            StarrySkyCommon.log(ERROR, "CoreSpheroidType: Registered a SpheroidType with null coreBlock!");
        }
        if(shellBlockStates == null || shellBlockStates.size() == 0) {
            StarrySkyCommon.log(ERROR, "CoreSpheroidType: Registered a SpheroidType with empty shellBlockStates!");
        }

        this.coreBlock = coreBlock;
        this.shellBlockStates = shellBlockStates;
        this.minCoreRadius = minCoreRadius;
        this.maxCoreRadius = maxCoreRadius;
    }

    public String getDescription() {
        return "CoreSpheroid";
    }

    public CoreSpheroid getRandomSpheroid(ChunkRandom chunkRandom) {
        int radius = getRandomRadius(chunkRandom);
        int coreRadius = Support.getRandomBetween(chunkRandom, this.minCoreRadius, this.maxCoreRadius);

        ArrayList<SpheroidDecorator> spheroidDecorators = getSpheroidDecoratorsWithChance(chunkRandom);
        ArrayList<SpheroidEntitySpawnDefinition> entityTypesToSpawn = getRandomEntityTypesToSpawn(chunkRandom);
        BlockState shellBlockState = Support.getWeightedRandom(shellBlockStates, chunkRandom);

        return new CoreSpheroid(chunkRandom, spheroidAdvancementIdentifier, radius, spheroidDecorators, entityTypesToSpawn, coreBlock, shellBlockState, coreRadius);
    }

}