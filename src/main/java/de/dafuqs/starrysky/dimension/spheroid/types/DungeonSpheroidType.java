package de.dafuqs.starrysky.dimension.spheroid.types;

import de.dafuqs.starrysky.dimension.spheroid.SpheroidEntitySpawnDefinition;
import de.dafuqs.starrysky.StarrySkyCommon;
import de.dafuqs.starrysky.Support;
import de.dafuqs.starrysky.advancements.SpheroidAdvancementIdentifier;
import de.dafuqs.starrysky.dimension.SpheroidDecorator;
import de.dafuqs.starrysky.dimension.spheroid.spheroids.DungeonSpheroid;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.world.gen.ChunkRandom;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.apache.logging.log4j.Level.ERROR;

public class DungeonSpheroidType extends SpheroidType {

    private final EntityType entityType;
    private final LinkedHashMap<BlockState, Float> validShellBlocks;
    private final int minShellRadius;
    private final int maxShellRadius;

    public DungeonSpheroidType(SpheroidAdvancementIdentifier spheroidAdvancementIdentifier, int minRadius, int maxRadius, EntityType entityType, LinkedHashMap<BlockState, Float> validShellBlocks, int minShellRadius, int maxShellRadius) {
        super(spheroidAdvancementIdentifier, minRadius, maxRadius);

        if(entityType == null) {
            StarrySkyCommon.log(ERROR, "DungeonSpheroidType: Registered a SpheroidType with null entity!");
        }

        this.entityType = entityType;
        this.validShellBlocks = validShellBlocks;
        this.minShellRadius = minShellRadius;
        this.maxShellRadius = maxShellRadius;
    }

    @Override
    public String getDescription() {
        return "DungeonSpheroid";
    }

    public DungeonSpheroid getRandomSpheroid(ChunkRandom chunkRandom) {
        int radius = getRandomRadius(chunkRandom);
        int shellRadius = Support.getRandomBetween(chunkRandom, this.minShellRadius, this.maxShellRadius);

        BlockState shellBlock = Support.getWeightedRandom(validShellBlocks, chunkRandom);
        ArrayList<SpheroidDecorator> spheroidDecorators = getSpheroidDecoratorsWithChance(chunkRandom);
        ArrayList<SpheroidEntitySpawnDefinition> entityTypesToSpawn = getRandomEntityTypesToSpawn(chunkRandom);

        return new DungeonSpheroid(chunkRandom, spheroidAdvancementIdentifier, radius, spheroidDecorators, entityTypesToSpawn, entityType, shellBlock, shellRadius);
    }

}
