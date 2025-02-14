package de.dafuqs.starrysky.dimension.spheroid.types.unique;

import de.dafuqs.starrysky.Support;
import de.dafuqs.starrysky.dimension.spheroid.SpheroidEntitySpawnDefinition;
import de.dafuqs.starrysky.advancements.SpheroidAdvancementIdentifier;
import de.dafuqs.starrysky.dimension.SpheroidDecorator;
import de.dafuqs.starrysky.dimension.spheroid.spheroids.unique.OceanMonumentSpheroid;
import de.dafuqs.starrysky.dimension.spheroid.types.SpheroidType;
import net.minecraft.world.gen.ChunkRandom;

import java.util.ArrayList;

public class OceanMonumentSpheroidType extends SpheroidType {

    private final int minTreasureRadius;
    private final int maxTreasureRadius;
    private final int minShellRadius;
    private final int maxShellRadius;

    public OceanMonumentSpheroidType(SpheroidAdvancementIdentifier spheroidAdvancementIdentifier, int minRadius, int maxRadius, int minTreasureRadius, int maxTreasureRadius, int minShellRadius, int maxShellRadius) {
        super(spheroidAdvancementIdentifier, minRadius, maxRadius);

        this.minTreasureRadius = minTreasureRadius;
        this.maxTreasureRadius = maxTreasureRadius;
        this.minShellRadius = minShellRadius;
        this.maxShellRadius = maxShellRadius;
    }

    public String getDescription() {
        return "OceanMonumentSpheroid";
    }

    public OceanMonumentSpheroid getRandomSpheroid(ChunkRandom chunkRandom) {
        int radius = getRandomRadius(chunkRandom);
        int treasureRadius = Support.getRandomBetween(chunkRandom, this.minTreasureRadius, this.maxTreasureRadius);
        int shellRadius = Support.getRandomBetween(chunkRandom, this.minShellRadius, this.maxShellRadius);

        ArrayList<SpheroidDecorator> spheroidDecorators = getSpheroidDecoratorsWithChance(chunkRandom);
        ArrayList<SpheroidEntitySpawnDefinition> entityTypesToSpawn = getRandomEntityTypesToSpawn(chunkRandom);

        return new OceanMonumentSpheroid(chunkRandom, spheroidAdvancementIdentifier, radius, spheroidDecorators, entityTypesToSpawn, treasureRadius, shellRadius);
    }

}
