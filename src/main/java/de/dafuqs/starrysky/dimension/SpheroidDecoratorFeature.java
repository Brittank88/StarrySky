package de.dafuqs.starrysky.dimension;

import com.mojang.serialization.Codec;
import de.dafuqs.starrysky.StarrySkyCommon;
import de.dafuqs.starrysky.dimension.spheroid.spheroids.Spheroid;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.apache.logging.log4j.Level;

import java.util.List;

public class SpheroidDecoratorFeature extends Feature {

    public SpheroidDecoratorFeature(Codec configCodec) {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext featureContext) {
        if(featureContext.getGenerator() instanceof StarrySkyChunkGenerator) {
            SystemGenerator systemGenerator = SystemGenerator.getSystemGeneratorOfWorld(featureContext.getWorld().toServerWorld().getRegistryKey());
            List<Spheroid> localSystem = systemGenerator.getSystemAtChunkPos(featureContext.getOrigin().getX() / 16, featureContext.getOrigin().getZ() / 16);
            for(Spheroid spheroid : localSystem) {
                if(spheroid.shouldDecorate(featureContext.getOrigin())) {

                    StarrySkyCommon.log(Level.DEBUG, "Decorating spheroid at x:" + featureContext.getOrigin().getX() + " z:" + featureContext.getOrigin().getZ() + spheroid.getDescription());
                    spheroid.decorate(featureContext.getWorld(), featureContext.getRandom(), featureContext.getOrigin());
                    StarrySkyCommon.log(Level.DEBUG, "Finished decorating.");
                }
            }
        }
        return false;
    }

}
