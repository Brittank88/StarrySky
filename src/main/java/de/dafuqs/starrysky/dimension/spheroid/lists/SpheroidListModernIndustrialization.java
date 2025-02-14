package de.dafuqs.starrysky.dimension.spheroid.lists;

import de.dafuqs.starrysky.StarrySkyCommon;
import de.dafuqs.starrysky.dimension.SpheroidLoader;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BlockState;

import static de.dafuqs.starrysky.dimension.SpheroidLoader.SpheroidDimensionType.OVERWORLD;
import static org.apache.logging.log4j.Level.INFO;

public class SpheroidListModernIndustrialization extends SpheroidList {

    private static final String MOD_ID = "modern_industrialization";

    public static boolean shouldGenerate() {
        return FabricLoader.getInstance().isModLoaded(MOD_ID) && StarrySkyCommon.STARRY_SKY_CONFIG.generateModernIndustrializationSpheroids;
    }

    public static void setup(SpheroidLoader spheroidLoader) {
        StarrySkyCommon.log(INFO, "Loading Modern Industrialization integration...");

        BlockState modern_industrialization_copper_ore = getDefaultBlockState(MOD_ID,"copper_ore");
        BlockState modern_industrialization_tin_ore = getDefaultBlockState(MOD_ID,"tin_ore");
        BlockState modern_industrialization_lead_ore = getDefaultBlockState(MOD_ID,"lead_ore");
        BlockState modern_industrialization_lignite_coal_ore = getDefaultBlockState(MOD_ID,"lignite_coal_ore");
        BlockState modern_industrialization_nickel_ore = getDefaultBlockState(MOD_ID,"nickel_ore");
        BlockState modern_industrialization_salt_ore = getDefaultBlockState(MOD_ID,"salt_ore");
        BlockState modern_industrialization_silver_ore = getDefaultBlockState(MOD_ID,"silver_ore");
        BlockState modern_industrialization_antimony_ore = getDefaultBlockState(MOD_ID,"antimony_ore");
        BlockState modern_industrialization_bauxite_ore = getDefaultBlockState(MOD_ID,"bauxite_ore");

        spheroidLoader.registerDynamicOre(OVERWORLD, "copper", modern_industrialization_copper_ore);
        spheroidLoader.registerDynamicOre(OVERWORLD, "tin", modern_industrialization_tin_ore);
        spheroidLoader.registerDynamicOre(OVERWORLD, "lignite_coal", modern_industrialization_lignite_coal_ore);
        spheroidLoader.registerDynamicOre(OVERWORLD, "nickel", modern_industrialization_nickel_ore);
        spheroidLoader.registerDynamicOre(OVERWORLD, "salt", modern_industrialization_salt_ore);
        spheroidLoader.registerDynamicOre(OVERWORLD, "silver", modern_industrialization_silver_ore);
        spheroidLoader.registerDynamicOre(OVERWORLD, "lead", modern_industrialization_lead_ore);
        spheroidLoader.registerDynamicOre(OVERWORLD, "antimony", modern_industrialization_antimony_ore);
        spheroidLoader.registerDynamicOre(OVERWORLD, "bauxite", modern_industrialization_bauxite_ore);
    }

}
