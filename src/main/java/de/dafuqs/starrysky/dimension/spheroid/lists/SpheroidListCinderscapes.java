package de.dafuqs.starrysky.dimension.spheroid.lists;

import de.dafuqs.starrysky.StarrySkyCommon;
import de.dafuqs.starrysky.dimension.SpheroidDistributionType;
import de.dafuqs.starrysky.dimension.SpheroidLoader;
import de.dafuqs.starrysky.dimension.decorators.TallFlowerBlockDecorator;
import de.dafuqs.starrysky.dimension.decorators.SingleBlockDecorator;
import de.dafuqs.starrysky.dimension.decorators.BottomBlockDecorator;
import de.dafuqs.starrysky.dimension.spheroid.types.*;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import java.util.ArrayList;

import static org.apache.logging.log4j.Level.INFO;

public class SpheroidListCinderscapes extends SpheroidList {

    private static final String MOD_ID = "cinderscapes";

    public static boolean shouldGenerate() {
        return FabricLoader.getInstance().isModLoaded(MOD_ID) && StarrySkyCommon.STARRY_SKY_CONFIG.generateCinderscapesSpheroids;
    }

    public static void setup(SpheroidLoader spheroidLoader) {
        StarrySkyCommon.log(INFO, "Loading Cinderscapes integration...");

        // sulfur
        BlockState sulfur_ore = getDefaultBlockState(MOD_ID,"sulfur_ore");


        // crystalline quartz blocks; as single and rainbow
        BlockState crystalline_quartz = getDefaultBlockState(MOD_ID,"crystalline_quartz");
        BlockState crystalline_sulfur_quartz = getDefaultBlockState(MOD_ID,"crystalline_sulfur_quartz");
        BlockState crystalline_rose_quartz = getDefaultBlockState(MOD_ID,"crystalline_rose_quartz");
        BlockState crystalline_smoky_quartz = getDefaultBlockState(MOD_ID,"crystalline_smoky_quartz");

        // quartz ore
        BlockState sulfur_quartz_ore = getDefaultBlockState(MOD_ID,"sulfur_quartz_ore");
        BlockState rose_quartz_ore = getDefaultBlockState(MOD_ID,"rose_quartz_ore");
        BlockState smoky_quartz_ore = getDefaultBlockState(MOD_ID,"smoky_quartz_ore");

        // quartz shards
        BlockState polypite_quartz = getDefaultBlockState(MOD_ID,"polypite_quartz");
        BlockState polypite_rose_quartz = getDefaultBlockState(MOD_ID,"polypite_rose_quartz");
        BlockState polypite_smoky_quartz = getDefaultBlockState(MOD_ID,"polypite_smoky_quartz");
        BlockState polypite_sulfur_quartz = getDefaultBlockState(MOD_ID,"polypite_sulfur_quartz");
        SingleBlockDecorator POLYPITE_QUARTZ_DECORATOR = new SingleBlockDecorator(polypite_quartz, 0.1F);
        SingleBlockDecorator POLYPITE_ROSE_QUARTZ_DECORATOR = new SingleBlockDecorator(polypite_rose_quartz, 0.1F);
        SingleBlockDecorator POLYPITE_SMOKY_QUARTZ_DECORATOR = new SingleBlockDecorator(polypite_smoky_quartz, 0.1F);
        SingleBlockDecorator POLYPITE_SULFUR_QUARTZ_DECORATOR = new SingleBlockDecorator(polypite_sulfur_quartz, 0.1F);

        // scorched wood
        BlockState scorched_stem = getDefaultBlockState(MOD_ID,"scorched_stem");
        BlockState scorched_hyphae = getDefaultBlockState(MOD_ID,"scorched_hyphae");

        // Luminous grove
        // from vanilla: nether sprouts, warped fungus, crimson fungus, crimson roots, warped roots,
        BlockState umbral_nylium = getDefaultBlockState(MOD_ID,"umbral_nylium"); // overgrown netherrack
        BlockState twilight_fescues = getDefaultBlockState(MOD_ID,"twilight_fescues");
        BlockState tall_photofern = getDefaultBlockState(MOD_ID,"tall_photofern"); // upper, lower
        BlockState photofern = getDefaultBlockState(MOD_ID,"photofern");
        BlockState twilight_tendrils = getDefaultBlockState(MOD_ID,"twilight_tendrils");
        BlockState luminous_pod = getDefaultBlockState(MOD_ID,"luminous_pod"); // upper, lower

        // Twilight vines
        BlockState twilight_vine_block = getDefaultBlockState(MOD_ID,"twilight_vine_block");
        BlockState ghastly_ectoplasm = getDefaultBlockState(MOD_ID,"ghastly_ectoplasm"); // top, middle, bottom

        // Umbral mushroom with shroomlight speckles
        BlockState umbral_stem = getDefaultBlockState(MOD_ID,"umbral_stem"); // "log";
        BlockState umbral_flesh_block = getDefaultBlockState(MOD_ID,"umbral_flesh_block"); // "branches"
        BlockState umbral_wart_block = getDefaultBlockState(MOD_ID,"umbral_wart_block"); // "leaves"

        // ash
        BlockState ash_block = getDefaultBlockState(MOD_ID,"ash_block");
        BlockState scorched_shrub = getDefaultBlockState(MOD_ID,"scorched_shrub");
        BlockState scorched_tendrils = getDefaultBlockState(MOD_ID,"scorched_tendrils");
        BlockState scorched_sprouts = getDefaultBlockState(MOD_ID,"scorched_sprouts");
        BlockState pyracinth = getDefaultBlockState(MOD_ID,"pyracinth");
        BlockState bramble_berry_bush = getDefaultBlockState(MOD_ID,"bramble_berry_bush");

        BlockState crystinium = getDefaultBlockState(MOD_ID,"crystinium");


        SpheroidType CRYSTALLINE_QUARTZ = new ModularSpheroidType(null, 5, 10,  crystalline_quartz);
        SpheroidType SULFUR_QUARTZ = new ModularSpheroidType(null, 5, 10,  crystalline_sulfur_quartz);
        SpheroidType ROSE_QUARTZ = new ModularSpheroidType(null, 5, 10,  crystalline_rose_quartz);
        SpheroidType SMOKY_QUARTZ = new ModularSpheroidType(null, 5, 10,  crystalline_smoky_quartz);

        ArrayList QUARTZS = new ArrayList<BlockState>() {{
            add(crystalline_quartz);
            add(crystalline_sulfur_quartz);
            add(crystalline_rose_quartz);
            add(crystalline_smoky_quartz);
        }};
        SpheroidType RAINBOW_QUARTZ = new RainbowSpheroidType(null, 5, 10, QUARTZS);

        SingleBlockDecorator CRYSTINIUM_DECORATOR = new SingleBlockDecorator(crystinium, 0.03F);
        ArrayList QUARTZ_ORES = new ArrayList<BlockState>() {{
            add(Blocks.NETHER_QUARTZ_ORE.getDefaultState());
            add(sulfur_quartz_ore);
            add(rose_quartz_ore);
            add(smoky_quartz_ore);
        }};

        // ORES
        SpheroidListVanillaNether.NETHER_QUARTZ.addDecorator(CRYSTINIUM_DECORATOR, 0.25F);
        SpheroidListVanillaNether.NETHER_QUARTZ.addDecorator(POLYPITE_QUARTZ_DECORATOR, 0.1F);

        SpheroidType SULFUR_ORE = new CoreSpheroidType(null, 5, 10, sulfur_ore, MAP_NETHER_STONES, 3, 5);

        SpheroidType SULFUR_QUARTZ_ORE = new CoreSpheroidType(null, 5, 15, sulfur_quartz_ore, MAP_NETHER_STONES, 4, 8)
                .addDecorator(CRYSTINIUM_DECORATOR, 0.25F)
                .addDecorator(POLYPITE_SULFUR_QUARTZ_DECORATOR, 0.5F);
        SpheroidType ROSE_QUARTZ_ORE = new CoreSpheroidType(null, 5, 15, rose_quartz_ore, MAP_NETHER_STONES, 4, 8)
                .addDecorator(CRYSTINIUM_DECORATOR, 0.25F)
                .addDecorator(POLYPITE_ROSE_QUARTZ_DECORATOR, 0.5F);
        SpheroidType SMOKY_QUARTZ_ORE = new CoreSpheroidType(null, 5, 15, smoky_quartz_ore, MAP_NETHER_STONES, 4, 8)
                .addDecorator(CRYSTINIUM_DECORATOR, 0.25F)
                .addDecorator(POLYPITE_SMOKY_QUARTZ_DECORATOR, 0.5F);
        SpheroidType RAINBOW_QUARTZ_ORE = new RainbowSpheroidType(null, 5, 15, QUARTZ_ORES);

        SpheroidType SCORCHED_WOOD      = new ShellSpheroidType(null, 6, 12, scorched_stem, scorched_hyphae, 2, 3);

        SingleBlockDecorator TWILIGHT_FESCUES_DECORATOR = new SingleBlockDecorator(twilight_fescues, 0.1F);
        SingleBlockDecorator FOTOFERN_DECORATOR = new SingleBlockDecorator(photofern, 0.1F);
        SingleBlockDecorator TWILIGHT_TENDRILS_DECORATOR = new SingleBlockDecorator(twilight_tendrils, 0.1F);
        TallFlowerBlockDecorator TALL_FOTOFERN_DECORATOR = new TallFlowerBlockDecorator(tall_photofern, 0.1F);
        TallFlowerBlockDecorator LUMINOUS_POD_DECORATOR = new TallFlowerBlockDecorator(luminous_pod, 0.1F);
        SpheroidType UMBRAL = new ModularSpheroidType(null, 10, 20,  Blocks.NETHERRACK.getDefaultState())
                .setTopBlockState(umbral_nylium)
                .addDecorator(TWILIGHT_FESCUES_DECORATOR, 0.8F)
                .addDecorator(FOTOFERN_DECORATOR, 0.8F)
                .addDecorator(TWILIGHT_TENDRILS_DECORATOR, 0.8F)
                .addDecorator(TALL_FOTOFERN_DECORATOR, 0.8F)
                .addDecorator(LUMINOUS_POD_DECORATOR, 0.8F);

        BottomBlockDecorator GHASTLY_ECTOPLASM_DECORATOR = new BottomBlockDecorator(ghastly_ectoplasm, 0.1F);
        SpheroidType TWILIGHT_VINES = new ModularSpheroidType(null, 5, 8,  twilight_vine_block)
                .addDecorator(GHASTLY_ECTOPLASM_DECORATOR, 0.9F);

        SpheroidType UMBRAL_MUSHROOM = new DoubleCoreSpheroidType(null, 5, 12, umbral_stem, umbral_flesh_block, umbral_wart_block, 2, 4, 2, 4);

        SingleBlockDecorator SCORCHED_SHRUB_DECORATOR = new SingleBlockDecorator(scorched_shrub, 0.08F);
        SingleBlockDecorator SCORCHED_TENDRILS_DECORATOR = new SingleBlockDecorator(scorched_tendrils, 0.12F);
        SingleBlockDecorator SCORCHED_SPROUTS_DECORATOR = new SingleBlockDecorator(scorched_sprouts, 0.15F);
        SingleBlockDecorator PYRACINTH_DECORATOR = new SingleBlockDecorator(pyracinth, 0.03F);
        SingleBlockDecorator BRAMBLE_BERRY_BUSH_DECORATOR = new SingleBlockDecorator(bramble_berry_bush, 0.25F);
        SpheroidType ASH = new ModularSpheroidType(null, 10, 20,  ash_block)
                .addDecorator(SCORCHED_SHRUB_DECORATOR, 0.8F)
                .addDecorator(SCORCHED_TENDRILS_DECORATOR, 0.8F)
                .addDecorator(SCORCHED_SPROUTS_DECORATOR, 0.8F)
                .addDecorator(PYRACINTH_DECORATOR, 0.8F)
                .addDecorator(BRAMBLE_BERRY_BUSH_DECORATOR, 0.8F);


        // REGISTERING SPHEROID TYPES

        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, CRYSTALLINE_QUARTZ);
        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, SULFUR_QUARTZ);
        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, ROSE_QUARTZ);
        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, SMOKY_QUARTZ);
        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.DECORATIVE, 0.2F, RAINBOW_QUARTZ);

        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.ORE, 0.5F, SULFUR_ORE);
        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.ORE, 0.2F, SULFUR_QUARTZ_ORE);
        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.ORE, 0.2F, ROSE_QUARTZ_ORE);
        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.ORE, 0.2F, SMOKY_QUARTZ_ORE);
        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.ORE, 0.1F, RAINBOW_QUARTZ_ORE);

        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.WOOD, 0.1F, SCORCHED_WOOD);
        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.WOOD, 0.1F, UMBRAL_MUSHROOM);

        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, TWILIGHT_VINES);
        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, UMBRAL);
        spheroidLoader.registerSpheroidType(SpheroidLoader.SpheroidDimensionType.NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, ASH);
    }

}
