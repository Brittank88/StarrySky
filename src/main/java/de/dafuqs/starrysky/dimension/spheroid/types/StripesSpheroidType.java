package de.dafuqs.starrysky.dimension.spheroid.types;

import de.dafuqs.starrysky.dimension.spheroid.SpheroidEntitySpawnDefinition;
import de.dafuqs.starrysky.StarrySkyCommon;
import de.dafuqs.starrysky.advancements.SpheroidAdvancementIdentifier;
import de.dafuqs.starrysky.dimension.SpheroidDecorator;
import de.dafuqs.starrysky.dimension.spheroid.spheroids.StripesSpheroid;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.ChunkRandom;

import java.util.ArrayList;

import static org.apache.logging.log4j.Level.ERROR;

public class StripesSpheroidType extends SpheroidType {

    private final ArrayList<BlockState> stripesBlockStates;

    public StripesSpheroidType(SpheroidAdvancementIdentifier spheroidAdvancementIdentifier, int minRadius, int maxRadius, ArrayList<BlockState> stripesBlockStates) {
        super(spheroidAdvancementIdentifier, minRadius, maxRadius);

        if(stripesBlockStates == null || stripesBlockStates.size() == 0) {
            StarrySkyCommon.log(ERROR, "ShellSpheroidType: Registered a SpheroidType with empty stripesBlockStates!");
        }

        this.stripesBlockStates = stripesBlockStates;
    }

    @Override
    public String getDescription() {
        return "StripesSpheroid";
    }

    public StripesSpheroid getRandomSpheroid(ChunkRandom chunkRandom) {
        int radius = getRandomRadius(chunkRandom);

        ArrayList<SpheroidDecorator> spheroidDecorators = getSpheroidDecoratorsWithChance(chunkRandom);
        ArrayList<SpheroidEntitySpawnDefinition> entityTypesToSpawn = getRandomEntityTypesToSpawn(chunkRandom);

        return new StripesSpheroid(chunkRandom, spheroidAdvancementIdentifier, radius, spheroidDecorators, entityTypesToSpawn, stripesBlockStates);
    }

}
