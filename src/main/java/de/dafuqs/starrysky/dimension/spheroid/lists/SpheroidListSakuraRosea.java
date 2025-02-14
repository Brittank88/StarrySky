package de.dafuqs.starrysky.dimension.spheroid.lists;

import de.dafuqs.starrysky.StarrySkyCommon;
import de.dafuqs.starrysky.dimension.SpheroidDistributionType;
import de.dafuqs.starrysky.dimension.SpheroidLoader;
import de.dafuqs.starrysky.dimension.spheroid.types.ShellSpheroidType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;

import static de.dafuqs.starrysky.dimension.SpheroidLoader.SpheroidDimensionType.OVERWORLD;
import static org.apache.logging.log4j.Level.INFO;

public class SpheroidListSakuraRosea extends SpheroidList {

    private static final String MOD_ID = "sakurarosea";

    public static boolean shouldGenerate() {
        return FabricLoader.getInstance().isModLoaded(MOD_ID) && StarrySkyCommon.STARRY_SKY_CONFIG.generateSakuraRoseaSpheroids;
    }

    public static void setup(SpheroidLoader spheroidLoader) {
        StarrySkyCommon.log(INFO, "Loading Sakura Rosea integration...");

        BlockState sakurarosea_sakura_log          = getDefaultBlockState(MOD_ID,"sakura_log");
        BlockState sakurarosea_sakura_leaves       = getDefaultBlockState(MOD_ID,"sakura_leaves");
        BlockState sakurarosea_alt_sakura_leaves   = getDefaultBlockState(MOD_ID,"alt_sakura_leaves");
        BlockState sakurarosea_white_sakura_leaves = getDefaultBlockState(MOD_ID,"white_sakura_leaves");

        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.7F, new ShellSpheroidType(null, 7, 14, sakurarosea_sakura_log, sakurarosea_sakura_leaves.with(Properties.DISTANCE_1_7, 1), 2, 4));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.7F, new ShellSpheroidType(null, 7, 14, sakurarosea_sakura_log, sakurarosea_alt_sakura_leaves.with(Properties.DISTANCE_1_7, 1), 2, 4));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.7F, new ShellSpheroidType(null, 7, 14, sakurarosea_sakura_log, sakurarosea_white_sakura_leaves.with(Properties.DISTANCE_1_7, 1), 2, 4));
    }

}
