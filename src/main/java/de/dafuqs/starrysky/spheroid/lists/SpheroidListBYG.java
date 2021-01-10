package de.dafuqs.starrysky.spheroid.lists;

import de.dafuqs.starrysky.StarrySkyCommon;
import de.dafuqs.starrysky.advancements.SpheroidAdvancementIdentifier;
import de.dafuqs.starrysky.dimension.SpheroidDistributionType;
import de.dafuqs.starrysky.dimension.SpheroidLoader;
import de.dafuqs.starrysky.dimension.decorators.*;
import de.dafuqs.starrysky.spheroid.types.*;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BambooBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

import static de.dafuqs.starrysky.dimension.SpheroidLoader.SpheroidDimensionType.*;

public class SpheroidListBYG extends SpheroidList {

    private static final String MOD_ID = "byg";

    public static boolean shouldGenerate() {
        return FabricLoader.getInstance().isModLoaded(MOD_ID) && StarrySkyCommon.STARRY_SKY_CONFIG.generateBYGSpheroids;
    }

    public static void setup(SpheroidLoader spheroidLoader) {
        StarrySkyCommon.LOGGER.info("[StarrySky] Loading BYG integration...");

        setupOverworld(spheroidLoader);
        setupNether(spheroidLoader);
        setupEnd(spheroidLoader);
    }

    private static void setupOverworld(SpheroidLoader spheroidLoader) {
        // VERY RARE ORES
        BlockState byg_ametrine_ore = Registry.BLOCK.get(new Identifier(MOD_ID,"ametrine_ore")).getDefaultState();
        BlockState byg_pendorite_ore = Registry.BLOCK.get(new Identifier(MOD_ID,"pendorite_ore")).getDefaultState();

        // WOOD
        BlockState byg_aspen_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"aspen_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_aspen_log = Registry.BLOCK.get(new Identifier(MOD_ID,"aspen_log")).getDefaultState();
        BlockState byg_blue_enchanted_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"blue_enchanted_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_blue_enchanted_log = Registry.BLOCK.get(new Identifier(MOD_ID,"blue_enchanted_log")).getDefaultState();
        BlockState byg_baobab_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"baobab_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_baobab_log = Registry.BLOCK.get(new Identifier(MOD_ID,"baobab_log")).getDefaultState();
        BlockState byg_pink_cherry_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"pink_cherry_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_white_cherry_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"white_cherry_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_cherry_log = Registry.BLOCK.get(new Identifier(MOD_ID,"cherry_log")).getDefaultState();
        BlockState byg_cika_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"cika_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_cika_log = Registry.BLOCK.get(new Identifier(MOD_ID,"cika_log")).getDefaultState();
        BlockState byg_cypress_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"cypress_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_cypress_log = Registry.BLOCK.get(new Identifier(MOD_ID,"cypress_log")).getDefaultState();
        BlockState byg_ebony_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"ebony_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_ebony_log = Registry.BLOCK.get(new Identifier(MOD_ID,"ebony_log")).getDefaultState();
        BlockState byg_fir_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"fir_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_fir_log = Registry.BLOCK.get(new Identifier(MOD_ID,"fir_log")).getDefaultState();
        BlockState byg_green_enchanted_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"green_enchanted_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_green_enchanted_log = Registry.BLOCK.get(new Identifier(MOD_ID,"green_enchanted_log")).getDefaultState();
        BlockState byg_holly_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"holly_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_holly_berry_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"holly_berry_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_holly_log = Registry.BLOCK.get(new Identifier(MOD_ID,"holly_log")).getDefaultState();
        BlockState byg_jacaranda_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"jacaranda_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_indigo_jacaranda_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"indigo_jacaranda_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_jacaranda_log = Registry.BLOCK.get(new Identifier(MOD_ID,"jacaranda_log")).getDefaultState();
        BlockState byg_mahogany_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"mahogany_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_mahogany_log = Registry.BLOCK.get(new Identifier(MOD_ID,"mahogany_log")).getDefaultState();
        BlockState byg_mangrove_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"mangrove_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_mangrove_log = Registry.BLOCK.get(new Identifier(MOD_ID,"mangrove_log")).getDefaultState();
        BlockState byg_maple_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"maple_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_red_maple_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"red_maple_leaves")).getDefaultState();
        BlockState byg_silver_maple_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"silver_maple_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_maple_log = Registry.BLOCK.get(new Identifier(MOD_ID,"maple_log")).getDefaultState();
        BlockState byg_nightshade_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"nightshade_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_flowering_nightshade_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"flowering_nightshade_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_nightshade_log = Registry.BLOCK.get(new Identifier(MOD_ID,"nightshade_log")).getDefaultState();
        BlockState byg_palm_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"palm_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_palm_log = Registry.BLOCK.get(new Identifier(MOD_ID,"palm_log")).getDefaultState();
        BlockState byg_palo_verde_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"palo_verde_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_flowering_palo_verde_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"flowering_palo_verde_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_palo_verde_log = Registry.BLOCK.get(new Identifier(MOD_ID,"palo_verde_log")).getDefaultState();
        BlockState byg_pine_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"pine_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_pine_log = Registry.BLOCK.get(new Identifier(MOD_ID,"pine_log")).getDefaultState();
        BlockState byg_rainbow_eucalyptus_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"rainbow_eucalyptus_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_rainbow_eucalyptus_log = Registry.BLOCK.get(new Identifier(MOD_ID,"rainbow_eucalyptus_log")).getDefaultState();
        BlockState byg_redwood_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"redwood_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_redwood_log = Registry.BLOCK.get(new Identifier(MOD_ID,"redwood_log")).getDefaultState();
        BlockState byg_willow_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"willow_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_willow_log = Registry.BLOCK.get(new Identifier(MOD_ID,"willow_log")).getDefaultState();


        BlockState byg_lament_log = Registry.BLOCK.get(new Identifier(MOD_ID,"lament_log")).getDefaultState();
        BlockState byg_lament_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"lament_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_skyris_log = Registry.BLOCK.get(new Identifier(MOD_ID,"skyris_log")).getDefaultState();
        BlockState byg_skyris_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"skyris_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_green_apple_skyris_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"green_apple_skyris_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_witch_hazel_log = Registry.BLOCK.get(new Identifier(MOD_ID,"witch_hazel_log")).getDefaultState();
        BlockState byg_witch_hazel_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"witch_hazel_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_blooming_witch_hazel_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"blooming_witch_hazel_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_zelkova_log = Registry.BLOCK.get(new Identifier(MOD_ID,"zelkova_log")).getDefaultState();
        BlockState byg_zelkova_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"zelkova_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_withering_oak_log = Registry.BLOCK.get(new Identifier(MOD_ID,"withering_oak_log")).getDefaultState();
        BlockState byg_withering_oak_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"withering_oak_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_araucaria_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"araucaria_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);

        // no dedicated log types
        BlockState byg_blue_spruce_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"blue_spruce_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_brown_birch_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"brown_birch_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_joshua_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"joshua_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_ripe_joshua_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"ripe_joshua_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_orange_birch_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"orange_birch_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_orange_oak_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"orange_oak_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_orange_spruce_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"orange_spruce_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_orchard_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"orchard_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_flowering_orchard_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"flowering_orchard_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_ripe_orchard_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"ripe_orchard_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_red_birch_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"red_birch_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_red_oak_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"red_oak_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_red_spruce_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"red_spruce_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_yellow_birch_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"yellow_birch_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState byg_yellow_spruce_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"yellow_spruce_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);

        // MEADOW
        BlockState byg_meadow_dirt = Registry.BLOCK.get(new Identifier(MOD_ID,"meadow_dirt")).getDefaultState();
        BlockState byg_meadow_grass_block = Registry.BLOCK.get(new Identifier(MOD_ID,"meadow_grass_block")).getDefaultState();

        // DACITE
        BlockState byg_dacite = Registry.BLOCK.get(new Identifier(MOD_ID,"dacite")).getDefaultState();
        BlockState byg_podzol_dacite = Registry.BLOCK.get(new Identifier(MOD_ID,"podzol_dacite")).getDefaultState();
        BlockState byg_overgrown_dacite = Registry.BLOCK.get(new Identifier(MOD_ID,"overgrown_dacite")).getDefaultState();

        // VANILLA STONE VARIANTS
        BlockState byg_overgrown_stone = Registry.BLOCK.get(new Identifier(MOD_ID,"overgrown_stone")).getDefaultState();
        BlockState byg_mossy_stone = Registry.BLOCK.get(new Identifier(MOD_ID,"mossy_stone")).getDefaultState();

        // COMMON STONES
        BlockState byg_red_rock = Registry.BLOCK.get(new Identifier(MOD_ID,"red_rock")).getDefaultState();
        BlockState byg_rocky_stone = Registry.BLOCK.get(new Identifier(MOD_ID,"rocky_stone")).getDefaultState();
        BlockState byg_scoria_stone = Registry.BLOCK.get(new Identifier(MOD_ID,"scoria_stone")).getDefaultState();
        BlockState byg_soapstone = Registry.BLOCK.get(new Identifier(MOD_ID,"soapstone")).getDefaultState();

        // COLORED SAND
        BlockState byg_black_sand = Registry.BLOCK.get(new Identifier(MOD_ID,"black_sand")).getDefaultState();
        BlockState byg_white_sand = Registry.BLOCK.get(new Identifier(MOD_ID,"white_sand")).getDefaultState();
        BlockState byg_blue_sand = Registry.BLOCK.get(new Identifier(MOD_ID,"blue_sand")).getDefaultState();
        BlockState byg_purple_sand = Registry.BLOCK.get(new Identifier(MOD_ID,"purple_sand")).getDefaultState();
        BlockState byg_pink_sand = Registry.BLOCK.get(new Identifier(MOD_ID,"pink_sand")).getDefaultState();

        // OTHERS
        BlockState byg_peat = Registry.BLOCK.get(new Identifier(MOD_ID,"peat")).getDefaultState();
        BlockState byg_mud_block = Registry.BLOCK.get(new Identifier(MOD_ID,"mud_block")).getDefaultState();
        BlockState byg_black_ice = Registry.BLOCK.get(new Identifier(MOD_ID,"black_ice")).getDefaultState();
        BlockState byg_packed_black_ice = Registry.BLOCK.get(new Identifier(MOD_ID,"packed_black_ice")).getDefaultState();

        // PLANTS
        BlockState byg_blueberry_bush = Registry.BLOCK.get(new Identifier(MOD_ID,"blueberry_bush")).getDefaultState(); // => blue dye
        BlockState byg_cattail = Registry.BLOCK.get(new Identifier(MOD_ID,"cattail")).getDefaultState();
        BlockState byg_golden_spined_cactus = Registry.BLOCK.get(new Identifier(MOD_ID,"golden_spined_cactus")).getDefaultState();
        BlockState byg_horseweed = Registry.BLOCK.get(new Identifier(MOD_ID,"horseweed")).getDefaultState();
        BlockState byg_mini_cactus = Registry.BLOCK.get(new Identifier(MOD_ID,"mini_cactus")).getDefaultState();
        BlockState byg_poison_ivy = Registry.BLOCK.get(new Identifier(MOD_ID,"poison_ivy")).getDefaultState();
        BlockState byg_prickly_pear_cactus = Registry.BLOCK.get(new Identifier(MOD_ID,"prickly_pear_cactus")).getDefaultState();
        BlockState byg_reeds = Registry.BLOCK.get(new Identifier(MOD_ID,"reeds")).getDefaultState(); // => brown dye
        BlockState byg_prairie_grass = Registry.BLOCK.get(new Identifier(MOD_ID,"prairie_grass")).getDefaultState();
        BlockState byg_tall_prairie_grass = Registry.BLOCK.get(new Identifier(MOD_ID,"tall_prairie_grass")).getDefaultState();
        BlockState byg_beach_grass = Registry.BLOCK.get(new Identifier(MOD_ID,"beach_grass")).getDefaultState();
        BlockState byg_small_beach_grass = Registry.BLOCK.get(new Identifier(MOD_ID,"small_beach_grass")).getDefaultState();
        BlockState byg_winter_succulent = Registry.BLOCK.get(new Identifier(MOD_ID,"winter_succulent")).getDefaultState();
        BlockState byg_winter_grass = Registry.BLOCK.get(new Identifier(MOD_ID,"winter_grass")).getDefaultState();


        PlantDecorator byg_blueberry_bush_decorator = new PlantDecorator(byg_blueberry_bush, 0.05F); // MEADOW_GRASSBLOCK, OVERGROWN_DACITE, OVERGROWN_STONE, GRASS_BLOCK
        PlantDecorator byg_mini_cactus_decorator = new PlantDecorator(byg_mini_cactus, 0.03F);
        PlantDecorator byg_cattail_decorator = new PlantDecorator(byg_cattail, 0.1F); // DoublePlant, in swamp water    // TODO
        PlantDecorator byg_golden_spined_cactus_decorator = new PlantDecorator(byg_golden_spined_cactus, 0.1F);    // TODO
        PlantDecorator byg_horseweed_decorator = new PlantDecorator(byg_horseweed, 0.1F);    // TODO
        PlantDecorator byg_poison_ivy_decorator = new PlantDecorator(byg_poison_ivy, 0.1F); // Vines    // TODO
        PlantDecorator byg_prickly_pear_cactus_decorator = new PlantDecorator(byg_prickly_pear_cactus, 0.05F);
        PlantDecorator byg_reeds_decorator = new PlantDecorator(byg_reeds, 0.1F); // DoublePlant, in swamp water    // TODO
        PlantDecorator byg_winter_succulent_decorator = new PlantDecorator(byg_winter_succulent, 0.07F);
        PlantDecorator byg_winter_grass_decorator = new PlantDecorator(byg_winter_grass, 0.05F);

        PlantDecorator byg_prairie_grass_decorator = new PlantDecorator(byg_prairie_grass, 0.2F);
        PlantDecorator byg_beach_grass_decorator = new PlantDecorator(byg_beach_grass, 0.1F);
        PlantDecorator byg_small_beach_grass_decorator = new PlantDecorator(byg_small_beach_grass, 0.1F);
        DoublePlantDecorator byg_tall_prairie_grass_decorator = new DoublePlantDecorator(byg_tall_prairie_grass, 0.2F);

        // FLOWERS
        BlockState byg_allium_flower_bush = Registry.BLOCK.get(new Identifier(MOD_ID,"allium_flower_bush")).getDefaultState();
        BlockState byg_alpine_bellfower = Registry.BLOCK.get(new Identifier(MOD_ID,"alpine_bellfower")).getDefaultState();
        BlockState byg_amaranth = Registry.BLOCK.get(new Identifier(MOD_ID,"amaranth")).getDefaultState();
        BlockState byg_angelica = Registry.BLOCK.get(new Identifier(MOD_ID,"angelica")).getDefaultState();
        BlockState byg_begonia = Registry.BLOCK.get(new Identifier(MOD_ID,"begonia")).getDefaultState();
        BlockState byg_bistort = Registry.BLOCK.get(new Identifier(MOD_ID,"bistort")).getDefaultState();
        BlockState byg_black_rose = Registry.BLOCK.get(new Identifier(MOD_ID,"black_rose")).getDefaultState();
        BlockState byg_blue_sage = Registry.BLOCK.get(new Identifier(MOD_ID,"blue_sage")).getDefaultState();
        BlockState byg_california_poppy = Registry.BLOCK.get(new Identifier(MOD_ID,"california_poppy")).getDefaultState();
        BlockState byg_crocus = Registry.BLOCK.get(new Identifier(MOD_ID,"crocus")).getDefaultState();
        BlockState byg_cyan_amaranth = Registry.BLOCK.get(new Identifier(MOD_ID,"cyan_amaranth")).getDefaultState();
        BlockState byg_cyan_rose = Registry.BLOCK.get(new Identifier(MOD_ID,"cyan_rose")).getDefaultState();
        BlockState byg_cyan_tulip = Registry.BLOCK.get(new Identifier(MOD_ID,"cyan_tulip")).getDefaultState();
        BlockState byg_daffodil = Registry.BLOCK.get(new Identifier(MOD_ID,"daffodil")).getDefaultState();
        BlockState byg_delphinium = Registry.BLOCK.get(new Identifier(MOD_ID,"delphinium")).getDefaultState();
        BlockState byg_fairy_slipper = Registry.BLOCK.get(new Identifier(MOD_ID,"fairy_slipper")).getDefaultState();
        BlockState byg_firecrasker_flower_bush = Registry.BLOCK.get(new Identifier(MOD_ID,"firecrasker_flower_bush")).getDefaultState();
        BlockState byg_foxglove = Registry.BLOCK.get(new Identifier(MOD_ID,"foxglove")).getDefaultState();
        BlockState byg_green_tulip = Registry.BLOCK.get(new Identifier(MOD_ID,"green_tulip")).getDefaultState();
        BlockState byg_guzmania = Registry.BLOCK.get(new Identifier(MOD_ID,"guzmania")).getDefaultState();
        BlockState byg_incan_lily = Registry.BLOCK.get(new Identifier(MOD_ID,"incan_lily")).getDefaultState();
        BlockState byg_iris = Registry.BLOCK.get(new Identifier(MOD_ID,"iris")).getDefaultState();
        BlockState byg_japanese_orchid = Registry.BLOCK.get(new Identifier(MOD_ID,"japanese_orchid")).getDefaultState();
        BlockState byg_kovan_flower = Registry.BLOCK.get(new Identifier(MOD_ID,"kovan_flower")).getDefaultState();
        BlockState byg_lazarus_bellflower = Registry.BLOCK.get(new Identifier(MOD_ID,"lazarus_bellflower")).getDefaultState();
        BlockState byg_lolipop_flower = Registry.BLOCK.get(new Identifier(MOD_ID,"lolipop_flower")).getDefaultState();
        BlockState byg_magenta_amaranth = Registry.BLOCK.get(new Identifier(MOD_ID,"magenta_amaranth")).getDefaultState();
        BlockState byg_magenta_tulip = Registry.BLOCK.get(new Identifier(MOD_ID,"magenta_tulip")).getDefaultState();
        BlockState byg_orange_amaranth = Registry.BLOCK.get(new Identifier(MOD_ID,"orange_amaranth")).getDefaultState();
        BlockState byg_orange_daisy = Registry.BLOCK.get(new Identifier(MOD_ID,"orange_daisy")).getDefaultState();
        BlockState byg_osiria_rose = Registry.BLOCK.get(new Identifier(MOD_ID,"osiria_rose")).getDefaultState();
        BlockState byg_peach_leather_flower = Registry.BLOCK.get(new Identifier(MOD_ID,"peach_leather_flower")).getDefaultState();
        BlockState byg_pink_allium = Registry.BLOCK.get(new Identifier(MOD_ID,"pink_allium")).getDefaultState();
        BlockState byg_pink_allium_flower_bush = Registry.BLOCK.get(new Identifier(MOD_ID,"pink_allium_flower_bush")).getDefaultState();
        BlockState byg_pink_anemone = Registry.BLOCK.get(new Identifier(MOD_ID,"pink_anemone")).getDefaultState();
        BlockState byg_pink_daffodil = Registry.BLOCK.get(new Identifier(MOD_ID,"pink_daffodil")).getDefaultState();
        BlockState byg_pink_orchid = Registry.BLOCK.get(new Identifier(MOD_ID,"pink_orchid")).getDefaultState();
        BlockState byg_protea_flower = Registry.BLOCK.get(new Identifier(MOD_ID,"protea_flower")).getDefaultState();
        BlockState byg_purple_amaranth = Registry.BLOCK.get(new Identifier(MOD_ID,"purple_amaranth")).getDefaultState();
        BlockState byg_purple_orchid = Registry.BLOCK.get(new Identifier(MOD_ID,"purple_orchid")).getDefaultState();
        BlockState byg_purple_sage = Registry.BLOCK.get(new Identifier(MOD_ID,"purple_sage")).getDefaultState();
        BlockState byg_purple_tulip = Registry.BLOCK.get(new Identifier(MOD_ID,"purple_tulip")).getDefaultState();
        BlockState byg_red_cornflower = Registry.BLOCK.get(new Identifier(MOD_ID,"red_cornflower")).getDefaultState();
        BlockState byg_red_orchid = Registry.BLOCK.get(new Identifier(MOD_ID,"red_orchid")).getDefaultState();
        BlockState byg_richea = Registry.BLOCK.get(new Identifier(MOD_ID,"richea")).getDefaultState();
        BlockState byg_rose = Registry.BLOCK.get(new Identifier(MOD_ID,"rose")).getDefaultState();
        BlockState byg_silver_vase_flower = Registry.BLOCK.get(new Identifier(MOD_ID,"silver_vase_flower")).getDefaultState();
        BlockState byg_snowdrops = Registry.BLOCK.get(new Identifier(MOD_ID,"snowdrops")).getDefaultState();
        BlockState byg_torch_ginger = Registry.BLOCK.get(new Identifier(MOD_ID,"torch_ginger")).getDefaultState();
        BlockState byg_violet_leather_flower = Registry.BLOCK.get(new Identifier(MOD_ID,"violet_leather_flower")).getDefaultState();
        BlockState byg_white_anemone = Registry.BLOCK.get(new Identifier(MOD_ID,"white_anemone")).getDefaultState();
        BlockState byg_white_sage = Registry.BLOCK.get(new Identifier(MOD_ID,"white_sage")).getDefaultState();
        BlockState byg_winter_cyclamen = Registry.BLOCK.get(new Identifier(MOD_ID,"winter_cyclamen")).getDefaultState();
        BlockState byg_winter_rose = Registry.BLOCK.get(new Identifier(MOD_ID,"winter_rose")).getDefaultState();
        BlockState byg_winter_scilla = Registry.BLOCK.get(new Identifier(MOD_ID,"winter_scilla")).getDefaultState();
        BlockState byg_yellow_daffodil = Registry.BLOCK.get(new Identifier(MOD_ID,"yellow_daffodil")).getDefaultState();
        BlockState byg_yellow_tulip = Registry.BLOCK.get(new Identifier(MOD_ID,"yellow_tulip")).getDefaultState();

        // TALL FLOWERS
        BlockState byg_tall_allium = Registry.BLOCK.get(new Identifier(MOD_ID,"tall_allium")).getDefaultState();
        BlockState byg_tall_pink_allium = Registry.BLOCK.get(new Identifier(MOD_ID,"tall_pink_allium")).getDefaultState();
        BlockState byg_azalea = Registry.BLOCK.get(new Identifier(MOD_ID,"azalea")).getDefaultState();

        ArrayList<BlockState> coloredSand = new ArrayList<BlockState>() {{
            add(byg_black_sand);
            add(byg_white_sand);
            add(byg_blue_sand);
            add(byg_purple_sand);
            add(byg_pink_sand);
        }};

        // VERY RARE ORES
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.ORE, 0.01F, new CoreSpheroidType(null, 5, 6, byg_ametrine_ore, MAP_STONES, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.ORE, 0.01F, new CoreSpheroidType(null, 5, 6, byg_pendorite_ore, MAP_STONES, 2, 3));

        // WOOD
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 7, 14, byg_mahogany_log, byg_mahogany_leaves, 2, 4));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.4F, new ShellSpheroidType(null, 8, 15, byg_rainbow_eucalyptus_log, byg_rainbow_eucalyptus_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 10, 14, byg_fir_log, byg_fir_leaves, 3, 4));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 6, 10, byg_aspen_log, byg_aspen_leaves, 2, 2));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 10, 15, byg_baobab_log, byg_baobab_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.1F, new ShellSpheroidType(null, 6, 9, byg_blue_enchanted_log, byg_blue_enchanted_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.1F, new ShellSpheroidType(null, 6, 9, byg_green_enchanted_log, byg_green_enchanted_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.3F, new ShellSpheroidType(null, 9, 13, byg_cherry_log, byg_pink_cherry_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.3F, new ShellSpheroidType(null, 9, 13, byg_cherry_log, byg_white_cherry_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 8, 16, byg_cika_log, byg_cika_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 7, 10, byg_cypress_log, byg_cypress_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 8, 11, byg_ebony_log, byg_ebony_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.3F, new ShellSpheroidType(null, 7, 11, byg_jacaranda_log, byg_indigo_jacaranda_leaves, 3, 4));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.3F, new ShellSpheroidType(null, 7, 11, byg_jacaranda_log, byg_jacaranda_leaves, 3, 4));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 6, 9, byg_lament_log, byg_lament_leaves, 2, 2));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 7, 10, byg_mangrove_log, byg_mangrove_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.3F, new ShellSpheroidType(null, 7, 11, byg_maple_log, byg_maple_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.3F, new ShellSpheroidType(null, 7, 13, byg_maple_log, byg_red_maple_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.3F, new ShellSpheroidType(null, 7, 13, byg_maple_log, byg_silver_maple_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 6, 12, byg_palm_log, byg_palm_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 7, 10, byg_palo_verde_log, byg_palo_verde_leaves, 2, 3)
                .addShellSpeckles(byg_flowering_palo_verde_leaves, 0.2F));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 7, 10, byg_skyris_log, byg_skyris_leaves, 2, 2)
                .addShellSpeckles(byg_green_apple_skyris_leaves, 0.1F));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 7, 10, byg_witch_hazel_log, byg_witch_hazel_leaves, 2, 2)
                .addShellSpeckles(byg_blooming_witch_hazel_leaves, 0.15F));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 8, 15, byg_pine_log, byg_pine_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 13, 17, byg_redwood_log, byg_redwood_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 7, 11, byg_willow_log, byg_willow_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.9F, new ShellSpheroidType(null, 6, 10, byg_zelkova_log, byg_zelkova_leaves, 1, 2));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.9F, new ShellSpheroidType(null, 5, 7, byg_withering_oak_log, byg_withering_oak_leaves, 1, 1));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.9F, new ShellSpheroidType(null, 7, 13, byg_pine_log, byg_araucaria_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.9F, new ShellSpheroidType(null, 7, 13, byg_holly_log, byg_holly_leaves, 2, 3)
                .addShellSpeckles(byg_holly_berry_leaves, 0.15F));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.5F, new ShellSpheroidType(null, 7, 13, byg_nightshade_log, byg_nightshade_leaves, 2, 3)
                .addShellSpeckles(byg_flowering_nightshade_leaves, 0.15F));

        // WOOD USING OAK LOGS
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.8F, new ShellSpheroidType(null, 6, 8, Blocks.OAK_LOG.getDefaultState(), byg_joshua_leaves, 1, 1)
                .addShellSpeckles(byg_ripe_joshua_leaves, 0.08F));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 1.0F, new ShellSpheroidType(null, 7, 14, Blocks.OAK_LOG.getDefaultState(), byg_orchard_leaves, 2, 3)
                .addShellSpeckles(byg_flowering_orchard_leaves, 0.1F)
                .addShellSpeckles(byg_ripe_orchard_leaves, 0.1F));

        // ALTERNATE LEAF TYPES
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.4F, new ShellSpheroidType(null, 5, 15, Blocks.SPRUCE_LOG.getDefaultState(), byg_blue_spruce_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.4F, new ShellSpheroidType(null, 5, 15, Blocks.SPRUCE_LOG.getDefaultState(), byg_red_spruce_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.4F, new ShellSpheroidType(null, 5, 15, Blocks.SPRUCE_LOG.getDefaultState(), byg_yellow_spruce_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.4F, new ShellSpheroidType(null, 5, 15, Blocks.SPRUCE_LOG.getDefaultState(), byg_orange_spruce_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.4F, new ShellSpheroidType(null, 5, 15, Blocks.BIRCH_LOG.getDefaultState(), byg_brown_birch_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.4F, new ShellSpheroidType(null, 5, 15, Blocks.BIRCH_LOG.getDefaultState(), byg_orange_birch_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.4F, new ShellSpheroidType(null, 5, 15, Blocks.BIRCH_LOG.getDefaultState(), byg_red_birch_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.4F, new ShellSpheroidType(null, 5, 15, Blocks.BIRCH_LOG.getDefaultState(), byg_yellow_birch_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.4F, new ShellSpheroidType(null, 8, 15, Blocks.OAK_LOG.getDefaultState(), byg_orange_oak_leaves, 2, 3));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.4F, new ShellSpheroidType(null, 8, 15, Blocks.OAK_LOG.getDefaultState(), byg_red_oak_leaves, 2, 3));

        // OTHER SPHEROID TYPES
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.DECORATIVE, 0.5F, new ModularSpheroidType(null, 5, 14, byg_meadow_dirt)
                .setTopBlockState(byg_meadow_grass_block).addDecorator(byg_blueberry_bush_decorator, 0.3F));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.DECORATIVE, 0.5F, new ModularSpheroidType(null, 8, 14, byg_dacite)
                .setTopBlockState(byg_overgrown_dacite).addDecorator(byg_blueberry_bush_decorator, 0.3F)
                .addDecorator(byg_winter_succulent_decorator, 0.75F)
                .addDecorator(SpheroidListVanilla.SpheroidDecorators.FERNS_DECORATOR, 0.75F));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.DECORATIVE, 0.5F, new ModularSpheroidType(null, 8, 12, byg_dacite)
                .setTopBlockState(byg_podzol_dacite)
                .addDecorator(byg_winter_succulent_decorator, 0.75F)
                .addDecorator(SpheroidListVanilla.SpheroidDecorators.FERNS_DECORATOR, 0.75F)
                .addDecorator(SpheroidListVanilla.SpheroidDecorators.LARGE_FERNS_DECORATOR, 0.75F));

        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.DECORATIVE, 0.5F, new SupportedRainbowSpheroidType(null, 9, 14, coloredSand, Blocks.SANDSTONE.getDefaultState()));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.DECORATIVE, 0.5F, new LiquidSpheroidType(null, 8, 13, Blocks.WATER.getDefaultState(), MAP_GLASS, 1, 2, 50, 80, 50)
                .setCoreBlock(byg_mud_block, 4, 6));
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.DECORATIVE, 0.4F, new ModularSpheroidType(null, 6, 11, byg_peat));

        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.DECORATIVE, 0.1F, new CoreSpheroidType(null, 7, 13, byg_packed_black_ice, byg_black_ice, 3, 5));
        // FLOWERS
        SpheroidList.LIST_FLOWERS.add(byg_allium_flower_bush);
        SpheroidList.LIST_FLOWERS.add(byg_alpine_bellfower);
        SpheroidList.LIST_FLOWERS.add(byg_amaranth);
        SpheroidList.LIST_FLOWERS.add(byg_angelica);
        SpheroidList.LIST_FLOWERS.add(byg_begonia);
        SpheroidList.LIST_FLOWERS.add(byg_bistort);
        SpheroidList.LIST_FLOWERS.add(byg_black_rose);
        SpheroidList.LIST_FLOWERS.add(byg_blue_sage);
        SpheroidList.LIST_FLOWERS.add(byg_california_poppy);
        SpheroidList.LIST_FLOWERS.add(byg_crocus);
        SpheroidList.LIST_FLOWERS.add(byg_cyan_amaranth);
        SpheroidList.LIST_FLOWERS.add(byg_cyan_rose);
        SpheroidList.LIST_FLOWERS.add(byg_cyan_tulip);
        SpheroidList.LIST_FLOWERS.add(byg_daffodil);
        SpheroidList.LIST_FLOWERS.add(byg_delphinium);
        SpheroidList.LIST_FLOWERS.add(byg_fairy_slipper);
        SpheroidList.LIST_FLOWERS.add(byg_firecrasker_flower_bush);
        SpheroidList.LIST_FLOWERS.add(byg_foxglove);
        SpheroidList.LIST_FLOWERS.add(byg_green_tulip);
        SpheroidList.LIST_FLOWERS.add(byg_guzmania);
        SpheroidList.LIST_FLOWERS.add(byg_incan_lily);
        SpheroidList.LIST_FLOWERS.add(byg_iris);
        SpheroidList.LIST_FLOWERS.add(byg_japanese_orchid);
        SpheroidList.LIST_FLOWERS.add(byg_kovan_flower);
        SpheroidList.LIST_FLOWERS.add(byg_lazarus_bellflower);
        SpheroidList.LIST_FLOWERS.add(byg_lolipop_flower);
        SpheroidList.LIST_FLOWERS.add(byg_magenta_amaranth);
        SpheroidList.LIST_FLOWERS.add(byg_magenta_tulip);
        SpheroidList.LIST_FLOWERS.add(byg_orange_amaranth);
        SpheroidList.LIST_FLOWERS.add(byg_orange_daisy);
        SpheroidList.LIST_FLOWERS.add(byg_osiria_rose);
        SpheroidList.LIST_FLOWERS.add(byg_peach_leather_flower);
        SpheroidList.LIST_FLOWERS.add(byg_pink_allium);
        SpheroidList.LIST_FLOWERS.add(byg_pink_allium_flower_bush);
        SpheroidList.LIST_FLOWERS.add(byg_pink_anemone);
        SpheroidList.LIST_FLOWERS.add(byg_pink_daffodil);
        SpheroidList.LIST_FLOWERS.add(byg_pink_orchid);
        SpheroidList.LIST_FLOWERS.add(byg_protea_flower);
        SpheroidList.LIST_FLOWERS.add(byg_purple_amaranth);
        SpheroidList.LIST_FLOWERS.add(byg_purple_orchid);
        SpheroidList.LIST_FLOWERS.add(byg_purple_sage);
        SpheroidList.LIST_FLOWERS.add(byg_purple_tulip);
        SpheroidList.LIST_FLOWERS.add(byg_red_cornflower);
        SpheroidList.LIST_FLOWERS.add(byg_red_orchid);
        SpheroidList.LIST_FLOWERS.add(byg_richea);
        SpheroidList.LIST_FLOWERS.add(byg_rose);
        SpheroidList.LIST_FLOWERS.add(byg_silver_vase_flower);
        SpheroidList.LIST_FLOWERS.add(byg_snowdrops);
        SpheroidList.LIST_FLOWERS.add(byg_torch_ginger);
        SpheroidList.LIST_FLOWERS.add(byg_violet_leather_flower);
        SpheroidList.LIST_FLOWERS.add(byg_white_anemone);
        SpheroidList.LIST_FLOWERS.add(byg_white_sage);
        SpheroidList.LIST_FLOWERS.add(byg_winter_cyclamen);
        SpheroidList.LIST_FLOWERS.add(byg_winter_rose);
        SpheroidList.LIST_FLOWERS.add(byg_winter_scilla);
        SpheroidList.LIST_FLOWERS.add(byg_yellow_daffodil);
        SpheroidList.LIST_FLOWERS.add(byg_yellow_tulip);

        // TALL FLOWERS
        SpheroidList.LIST_TALL_FLOWERS.add(byg_azalea);
        SpheroidList.LIST_TALL_FLOWERS.add(byg_tall_allium);
        SpheroidList.LIST_TALL_FLOWERS.add(byg_tall_pink_allium);

        SpheroidList.MAP_STONES.put(byg_red_rock, 0.5F);
        SpheroidList.MAP_STONES.put(byg_rocky_stone, 0.5F);
        SpheroidList.MAP_STONES.put(byg_scoria_stone, 0.5F);
        SpheroidList.MAP_STONES.put(byg_soapstone, 0.5F);

        SpheroidList.MAP_DUNGEON_STONES.put(byg_overgrown_stone, 1.0F);
        SpheroidList.MAP_DUNGEON_STONES.put(byg_mossy_stone, 1.0F);

        // Decorators for vanilla spheroids
        SpheroidListVanilla.SAND.addDecorator(byg_mini_cactus_decorator, 0.2F);
        SpheroidListVanilla.SNOW_ICE.addDecorator(byg_winter_succulent_decorator, 0.2F);
        SpheroidListVanilla.SNOW_PACKED_ICE.addDecorator(byg_winter_succulent_decorator, 0.2F);
        SpheroidListVanilla.SNOW_BLUE_ICE.addDecorator(byg_winter_succulent_decorator, 0.2F);
        SpheroidListVanilla.SNOW_ICE.addDecorator(byg_winter_grass_decorator, 0.5F);
        SpheroidListVanilla.SNOW_PACKED_ICE.addDecorator(byg_winter_grass_decorator, 0.5F);
        SpheroidListVanilla.SNOW_BLUE_ICE.addDecorator(byg_winter_grass_decorator, 0.5F);
        SpheroidListVanilla.SAND.addDecorator(byg_prickly_pear_cactus_decorator, 0.2F);
        SpheroidListVanilla.RED_SAND.addDecorator(byg_prickly_pear_cactus_decorator, 0.1F);

        // prairie grass spheroid
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.DECORATIVE, 0.4F, new ModularSpheroidType(SpheroidAdvancementIdentifier.grass, 5, 20,  Blocks.DIRT.getDefaultState()).setTopBlockState(Blocks.GRASS_BLOCK.getDefaultState()).addDecorator(byg_prairie_grass_decorator, 1.0F).addDecorator(byg_tall_prairie_grass_decorator, 1.0F));
        // beach sand spheroid
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.DECORATIVE, 0.4F, new ModularSpheroidType(null, 5, 12, Blocks.SAND.getDefaultState()).setBottomBlockState(Blocks.SANDSTONE.getDefaultState()).addDecorator(byg_beach_grass_decorator, 1.0F).addDecorator(byg_small_beach_grass_decorator, 1.0F));
    }

    private static void setupNether(SpheroidLoader spheroidLoader) {

        // BRIMSTONE CAVERNS
        BlockState brimstone = Registry.BLOCK.get(new Identifier(MOD_ID,"brimstone")).getDefaultState();
        BlockState anthracite_ore = Registry.BLOCK.get(new Identifier(MOD_ID,"anthracite_ore")).getDefaultState(); // like coal
        BlockState boric_fire = Registry.BLOCK.get(new Identifier(MOD_ID,"boric_fire")).getDefaultState(); // like coal
        PlantDecorator BORIC_FIRE_DECORATOR = new PlantDecorator(boric_fire, 0.05F);

        SpheroidType BRIMSTONE = new ModularSpheroidType(null, 5, 12, brimstone)
                .addDecorator(BORIC_FIRE_DECORATOR, 0.75F);

        SpheroidType ANTRACITE_ORE = new CoreSpheroidType(null, 7, 12, anthracite_ore, brimstone, 3, 6)
                .addDecorator(BORIC_FIRE_DECORATOR, 0.5F);

        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, BRIMSTONE);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.ORE, 0.5F, ANTRACITE_ORE);

        // CRIMSON GARDENS
        BlockState overgrown_crimson_blackstone = Registry.BLOCK.get(new Identifier(MOD_ID,"overgrown_crimson_blackstone")).getDefaultState();
        BlockState tall_embur_roots = Registry.BLOCK.get(new Identifier(MOD_ID,"tall_embur_roots")).getDefaultState();
        DoublePlantDecorator TALL_EMBUR_ROOTS_DECORATOR = new DoublePlantDecorator(tall_embur_roots, 0.05F);
        SpheroidType CRIMSON_GARDENS = new ModularSpheroidType(null, 7, 12, Blocks.BLACKSTONE.getDefaultState())
                .setTopBlockState(overgrown_crimson_blackstone)
                .addDecorator(SpheroidListVanillaNether.SpheroidDecorators.CRIMSON_ROOTS, 0.5F)
                .addDecorator(SpheroidListVanilla.SpheroidDecorators.MUSHROOMS, 0.5F)
                .addDecorator(SpheroidListVanillaNether.SpheroidDecorators.CRIMSON_ROOTS, 0.5F)
                .addDecorator(TALL_EMBUR_ROOTS_DECORATOR, 0.5F)
                .addDecorator(SpheroidListVanillaNether.SpheroidDecorators.WEEPING_VINES, 0.5F);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, CRIMSON_GARDENS);

        // EMBUR BOG
        BlockState blue_netherrack = Registry.BLOCK.get(new Identifier(MOD_ID,"blue_netherrack")).getDefaultState();
        SpheroidType BLUE_NETHERRACK = new ModularSpheroidType(null, 5, 15, blue_netherrack);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, BLUE_NETHERRACK);

        // GLOWSTONE GARDENS
        BlockState weeping_roots_plant = Registry.BLOCK.get(new Identifier(MOD_ID,"weeping_roots_plant")).getDefaultState();
        UnderPlantDecorator WEEPING_ROOTS_PLANT_DECORATOR = new UnderPlantDecorator(weeping_roots_plant, 0.09F);
        SpheroidListVanillaNether.GLOWSTONE.addDecorator(WEEPING_ROOTS_PLANT_DECORATOR, 0.2F);

        // QUARTZ DESERT
        BlockState quartzite_sand = Registry.BLOCK.get(new Identifier(MOD_ID,"quartzite_sand")).getDefaultState();
        BlockState raw_quartz_block = Registry.BLOCK.get(new Identifier(MOD_ID,"raw_quartz_block")).getDefaultState();

        BlockState quartz_crystal = Registry.BLOCK.get(new Identifier(MOD_ID,"quartz_crystal")).getDefaultState();
        PlantDecorator QUARTZ_CRYSTAL_DECORATOR = new PlantDecorator(quartz_crystal, 0.1F);

        BlockState hanging_bones = Registry.BLOCK.get(new Identifier(MOD_ID,"hanging_bones")).getDefaultState();
        UnderPlantDecorator HANGING_BONES_DECORATOR = new UnderPlantDecorator(hanging_bones, 0.05F);

        SpheroidType QUARTZ_DESERT = new ShellSpheroidType(null, 10, 16, raw_quartz_block, quartzite_sand, 2, 4)
                .addShellSpeckles(quartzite_sand, 0.2F)
                .addDecorator(QUARTZ_CRYSTAL_DECORATOR, 0.95F)
                .addDecorator(HANGING_BONES_DECORATOR, 0.8F)
                .addDecorator(SpheroidListVanilla.SpheroidDecorators.MUSHROOMS, 0.25F)
                .addDecorator(SpheroidListVanillaNether.SpheroidDecorators.FIRE, 0.3F);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, QUARTZ_DESERT);

        // SUBZERO HYPOGEAL
        BlockState subzero_ash_block = Registry.BLOCK.get(new Identifier(MOD_ID,"subzero_ash_block")).getDefaultState();
        BlockState frost_magma = Registry.BLOCK.get(new Identifier(MOD_ID,"frost_magma")).getDefaultState();
        BlockState soul_fire = Registry.BLOCK.get(new Identifier(MOD_ID,"soul_fire")).getDefaultState(); // on top of frost magma
        PlantDecorator SOUL_FIRE_DECORATOR = new PlantDecorator(soul_fire, 0.15F);

        SpheroidType SUBZERO_ASH = new ShellSpheroidType(null, 10, 16, subzero_ash_block, subzero_ash_block, 2, 4)
                .addShellSpeckles(frost_magma, 0.2F);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, SUBZERO_ASH);

        SpheroidType FROST_MAGMA = new ModularSpheroidType(null, 10, 16, frost_magma)
                .addDecorator(SOUL_FIRE_DECORATOR, 0.9F);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, FROST_MAGMA);

        // SYTHIAN TORRIDS
        BlockState mossy_netherrack = Registry.BLOCK.get(new Identifier(MOD_ID,"mossy_netherrack")).getDefaultState();
        SpheroidType MOSSY_NETHERRACK = new ModularSpheroidType(null, 10, 16, mossy_netherrack);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, MOSSY_NETHERRACK);

        BlockState sythian_hyphae = Registry.BLOCK.get(new Identifier(MOD_ID,"sythian_hyphae")).getDefaultState();
        BlockState hanging_sythian_roots_plant = Registry.BLOCK.get(new Identifier(MOD_ID,"hanging_sythian_roots_plant")).getDefaultState();
        UnderPlantDecorator HANGING_SYTHIAN_ROOTS_DECORATOR = new UnderPlantDecorator(hanging_sythian_roots_plant, 0.1F);
        SpheroidType SYTHIAN_HYPHAE = new ModularSpheroidType(null, 10, 16, sythian_hyphae)
                .addDecorator(HANGING_SYTHIAN_ROOTS_DECORATOR, 1.0F);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, SYTHIAN_HYPHAE);

        BlockState sythian_nylium = Registry.BLOCK.get(new Identifier(MOD_ID,"sythian_nylium")).getDefaultState(); // on top of netherrack
        BlockState sythian_sprout = Registry.BLOCK.get(new Identifier(MOD_ID,"sythian_nylium")).getDefaultState(); // plant
        PlantDecorator SYTHIAN_SPROUT_DECORATOR = new PlantDecorator(sythian_sprout, 0.1F);
        BlockState sythian_stalk_block = Registry.BLOCK.get(new Identifier(MOD_ID,"sythian_stalk_block")).getDefaultState(); // like bamboo
        BambooDecorator SYTHIAN_STALK_DECORATOR = new BambooDecorator(sythian_stalk_block.with(BambooBlock.AGE, 0).with(BambooBlock.STAGE, 0));
        SpheroidType SYTHIAN_NYLIUM = new ModularSpheroidType(null, 10, 16, Blocks.NETHERRACK.getDefaultState())
                .setTopBlockState(sythian_nylium)
                .addDecorator(SYTHIAN_SPROUT_DECORATOR, 0.8F)
                .addDecorator(SYTHIAN_STALK_DECORATOR, 0.8F);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, SYTHIAN_NYLIUM);


        BlockState sythian_wart_block = Registry.BLOCK.get(new Identifier(MOD_ID,"sythian_wart_block")).getDefaultState();
        BlockState sythian_stem = Registry.BLOCK.get(new Identifier(MOD_ID,"sythian_stem")).getDefaultState();
        SpheroidType SYTHIAN_WART = new ShellSpheroidType(null, 10, 16, sythian_stem, sythian_wart_block, 1, 2)
                .addShellSpeckles(Blocks.SHROOMLIGHT.getDefaultState(), 0.05F);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.WOOD, 0.5F, SYTHIAN_WART);

        // WARPED DESERT
        BlockState soul_shroom_block = Registry.BLOCK.get(new Identifier(MOD_ID,"soul_shroom_block")).getDefaultState();
        BlockState soul_shroom_spore = Registry.BLOCK.get(new Identifier(MOD_ID,"soul_shroom_spore")).getDefaultState(); // TODO: has soul_shroom_spore_end at bottom
        UnderPlantDecorator SOUL_SHROOM_SPORE_DECORATOR = new UnderPlantDecorator(soul_shroom_spore, 0.1F);

        BlockState nylium_soul_sand = Registry.BLOCK.get(new Identifier(MOD_ID,"nylium_soul_sand")).getDefaultState();
        BlockState warped_cactus = Registry.BLOCK.get(new Identifier(MOD_ID,"warped_cactus")).getDefaultState();
        CactusDecorator WARPED_CACTUS_DECORATOR = new CactusDecorator(warped_cactus);
        BlockState warped_coral = Registry.BLOCK.get(new Identifier(MOD_ID,"warped_coral")).getDefaultState();
        PlantDecorator WARPED_CORAL_DECORATOR = new PlantDecorator(warped_coral, 0.05F);
        BlockState warped_coral_fan = Registry.BLOCK.get(new Identifier(MOD_ID,"warped_coral_fan")).getDefaultState();
        PlantDecorator WARPED_CORAL_FAN_DECORATOR = new PlantDecorator(warped_coral_fan, 0.02F);
        SpheroidType NYLIUM_SOUL_SAND = new ShellSpheroidType(null, 10, 16, nylium_soul_sand, nylium_soul_sand, 1, 1)
                .addShellSpeckles(soul_shroom_block, 0.05F)
                .addDecorator(WARPED_CACTUS_DECORATOR, 0.9F)
                .addDecorator(WARPED_CORAL_DECORATOR, 0.8F)
                .addDecorator(WARPED_CORAL_FAN_DECORATOR, 0.7F)
                .addDecorator(SOUL_SHROOM_SPORE_DECORATOR, 0.6F);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, NYLIUM_SOUL_SAND);

        BlockState nylium_soul_soil = Registry.BLOCK.get(new Identifier(MOD_ID,"nylium_soul_soil")).getDefaultState();
        SpheroidType NYLIUM_SOUL_SOIL = new ShellSpheroidType(null, 10, 16, nylium_soul_soil, nylium_soul_soil, 1, 1)
                .addShellSpeckles(soul_shroom_block, 0.05F)
                .addDecorator(SpheroidListVanillaNether.SpheroidDecorators.SOUL_FIRE, 0.9F)
                .addDecorator(WARPED_CACTUS_DECORATOR, 0.8F)
                .addDecorator(WARPED_CORAL_DECORATOR, 0.7F)
                .addDecorator(WARPED_CORAL_FAN_DECORATOR, 0.6F)
                .addDecorator(SOUL_SHROOM_SPORE_DECORATOR, 0.5F);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, NYLIUM_SOUL_SOIL);

        BlockState warped_coral_block = Registry.BLOCK.get(new Identifier(MOD_ID,"warped_coral_block")).getDefaultState();
        SpheroidType WARPED_CORAL_BLOCK = new ModularSpheroidType(null, 5, 7, warped_coral_block);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.4F, WARPED_CORAL_BLOCK);

        // WAILING GARTH
        BlockState overgrown_netherrack = Registry.BLOCK.get(new Identifier(MOD_ID,"overgrown_netherrack")).getDefaultState();
        BlockState whaling_grass = Registry.BLOCK.get(new Identifier(MOD_ID,"whaling_grass")).getDefaultState(); // on overgrown netherrack
        PlantDecorator WHALING_GRASS_DECORATOR = new PlantDecorator(whaling_grass, 0.1F);
        BlockState scorched_bush = Registry.BLOCK.get(new Identifier(MOD_ID,"scorched_bush")).getDefaultState();
        PlantDecorator SCORCHED_BUSH_DECORATOR = new PlantDecorator(scorched_bush, 0.05F);
        BlockState scorched_grass = Registry.BLOCK.get(new Identifier(MOD_ID,"scorched_grass")).getDefaultState();
        PlantDecorator SCORCHED_GRASS_DECORATOR = new PlantDecorator(scorched_grass, 0.1F);

        SpheroidType WAILING_GARTH = new ModularSpheroidType(null, 7, 14, Blocks.NETHERRACK.getDefaultState())
                .setTopBlockState(overgrown_netherrack)
                .addDecorator(WHALING_GRASS_DECORATOR, 0.9F)
                .addDecorator(SpheroidListVanillaNether.SpheroidDecorators.NETHER_SPROUTS, 0.7F)
                .addDecorator(SCORCHED_BUSH_DECORATOR, 0.5F)
                .addDecorator(SCORCHED_GRASS_DECORATOR, 0.9F);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.4F, WAILING_GARTH);

        BlockState black_puff_mushroom_block = Registry.BLOCK.get(new Identifier(MOD_ID,"black_puff_mushroom_block")).getDefaultState();
        BlockState brown_mushroom_block = Registry.BLOCK.get(new Identifier(MOD_ID,"brown_mushroom_block")).getDefaultState();
        SpheroidType BROWN_MUSHROOM = new MushroomSpheroidType (null, 6, 14, black_puff_mushroom_block, brown_mushroom_block, 2, 2);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.WOOD, 0.3F, BROWN_MUSHROOM);

        BlockState white_mushroom_stem = Registry.BLOCK.get(new Identifier(MOD_ID,"white_mushroom_stem")).getDefaultState();
        BlockState green_mushroom_block = Registry.BLOCK.get(new Identifier(MOD_ID,"green_mushroom_block")).getDefaultState();
        SpheroidType GREEN_MUSHROOM = new MushroomSpheroidType (null, 6, 14, white_mushroom_stem, green_mushroom_block, 2, 2);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.WOOD, 0.3F, GREEN_MUSHROOM);

        BlockState mushroom_stem = Blocks.MUSHROOM_STEM.getDefaultState();
        BlockState weeping_milkcap_mushroom_block = Registry.BLOCK.get(new Identifier(MOD_ID,"weeping_milkcap_mushroom_block")).getDefaultState();
        SpheroidType WEEPING_MILKCAP = new MushroomSpheroidType (null, 6, 14, mushroom_stem, weeping_milkcap_mushroom_block, 2, 2);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.WOOD, 0.3F, WEEPING_MILKCAP);

        BlockState brown_mushroom_stem = Registry.BLOCK.get(new Identifier(MOD_ID,"brown_mushroom_stem")).getDefaultState();
        BlockState wood_blewit_mushroom_block = Registry.BLOCK.get(new Identifier(MOD_ID,"wood_blewit_mushroom_block")).getDefaultState();
        SpheroidType BLEWIT_MUSHROOM = new MushroomSpheroidType (null, 6, 14, brown_mushroom_stem, wood_blewit_mushroom_block, 2, 2);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.WOOD, 0.3F, BLEWIT_MUSHROOM);

        // WITHERING WOODS
        BlockState withering_oak_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"withering_oak_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState withering_oak_log = Registry.BLOCK.get(new Identifier(MOD_ID,"withering_oak_log")).getDefaultState();
        SpheroidType WITHERING_WOOD = new ShellSpheroidType(null, 7, 13, withering_oak_log, withering_oak_leaves, 2, 3);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.WOOD, 0.4F, WITHERING_WOOD);

        BlockState magmatic_stone = Registry.BLOCK.get(new Identifier(MOD_ID,"magmatic_stone")).getDefaultState();
        SpheroidType MAGMATIC_STONE = new ModularSpheroidType(null, 7, 13, magmatic_stone);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.6F, MAGMATIC_STONE);

        // WEEPING MIRE
        BlockState lament_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"lament_leaves")).getDefaultState().with(Properties.DISTANCE_1_7, 1);
        BlockState lament_log = Registry.BLOCK.get(new Identifier(MOD_ID,"lament_log")).getDefaultState();
        SpheroidType LAMENT_WOOD = new ShellSpheroidType(null, 7, 10, lament_log, lament_leaves, 2, 3)
                .addShellSpeckles(Blocks.SHROOMLIGHT.getDefaultState(), 0.05F);
        spheroidLoader.registerSpheroidType(NETHER, SpheroidDistributionType.DECORATIVE, 0.5F, LAMENT_WOOD);

        BlockState lament_vine_plant = Registry.BLOCK.get(new Identifier(MOD_ID,"lament_vine_plant")).getDefaultState(); // hanging from netherrack
        // BlockState lament_vine = Registry.BLOCK.get(new Identifier(MOD_ID,"lament_vine_plant")).getDefaultState(); // on bottom ov lament vine
        UnderPlantDecorator LAMENT_VINE_DECORATOR = new UnderPlantDecorator(lament_vine_plant, 0.1F);
        WAILING_GARTH.addDecorator(LAMENT_VINE_DECORATOR, 0.15F);

        // ADDING TO VANILLA
        BlockState death_cap = Registry.BLOCK.get(new Identifier(MOD_ID,"death_cap")).getDefaultState(); // mushroom
        PlantDecorator DEATH_CAP_DECORATOR = new PlantDecorator(death_cap, 0.09F);
        SpheroidListVanillaNether.NETHERRACK.addDecorator(DEATH_CAP_DECORATOR, 0.1F);
    }

    private static void setupEnd(SpheroidLoader spheroidLoader) {
        BlockState end_stone = Blocks.END_STONE.getDefaultState();

        BlockState purpur_stone = Registry.BLOCK.get(new Identifier(MOD_ID,"purpur_stone")).getDefaultState();
        SpheroidType PURPUR_STONE_SMALL = new ModularSpheroidType(null, 4, 8, purpur_stone);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.ESSENTIAL, 0.5F, PURPUR_STONE_SMALL);

        SpheroidType PURPUR_STONE_BIG = new ModularSpheroidType(null, 9, 17, purpur_stone);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.ESSENTIAL, 0.5F, PURPUR_STONE_BIG);

        SpheroidType SPECKLED_END_STONE = new ShellSpheroidType(null, 5, 12, purpur_stone, end_stone, 3, 4)
                .addShellSpeckles(purpur_stone, 0.2F);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.ESSENTIAL, 0.5F, SPECKLED_END_STONE);

        // SHATTERED DESERT
        BlockState white_sand = Registry.BLOCK.get(new Identifier(MOD_ID,"white_sand")).getDefaultState();
        BlockState oddity_cactus = Registry.BLOCK.get(new Identifier(MOD_ID,"oddity_cactus")).getDefaultState(); // stacked like cactus
        CactusDecorator ODDITY_CACTUS_DECORATOR = new CactusDecorator(oddity_cactus);
        BlockState oddity_bush = Registry.BLOCK.get(new Identifier(MOD_ID,"oddity_bush")).getDefaultState(); // plant
        PlantDecorator ODDITY_BUSH_DECORATOR = new PlantDecorator(oddity_bush, 0.02F);

        SpheroidType SHATTERED_DESERT = new ModularSpheroidType(null, 8, 13, white_sand)
            .setBottomBlockState(end_stone)
            .addDecorator(ODDITY_BUSH_DECORATOR, 0.9F)
            .addDecorator(ODDITY_CACTUS_DECORATOR, 0.9F);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.DECORATIVE, 0.5F, SHATTERED_DESERT);

        BlockState black_sand = Registry.BLOCK.get(new Identifier(MOD_ID,"black_sand")).getDefaultState();
        BlockState black_sandstone = Registry.BLOCK.get(new Identifier(MOD_ID,"black_sandstone")).getDefaultState();
        SpheroidType BLACK_SAND = new ModularSpheroidType(null, 8, 13, black_sand)
                .setBottomBlockState(black_sandstone);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.DECORATIVE, 0.4F, BLACK_SAND);

        // NIGHTSHADE FOREST
        BlockState nightshade_phylium = Registry.BLOCK.get(new Identifier(MOD_ID,"nightshade_phylium")).getDefaultState();
        BlockState shade_sprouts = Registry.BLOCK.get(new Identifier(MOD_ID,"shade_sprouts")).getDefaultState(); // plant
        PlantDecorator SHADE_SPROUTS_DECORATOR = new PlantDecorator(shade_sprouts, 0.2F);
        BlockState nightshade_roots = Registry.BLOCK.get(new Identifier(MOD_ID,"nightshade_roots")).getDefaultState(); // double plant
        DoublePlantDecorator NIGHTSHADE_ROOTS_DECORATOR = new DoublePlantDecorator(nightshade_roots, 0.1F);
        SpheroidType NIGHTSHADE_FOREST = new ModularSpheroidType(null, 8, 13, end_stone)
                .setTopBlockState(nightshade_phylium)
                .addDecorator(SHADE_SPROUTS_DECORATOR, 0.9F)
                .addDecorator(NIGHTSHADE_ROOTS_DECORATOR, 0.9F);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.DECORATIVE, 0.5F, NIGHTSHADE_FOREST);

        BlockState nightshade_log = Registry.BLOCK.get(new Identifier(MOD_ID,"nightshade_log")).getDefaultState();
        BlockState nightshade_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"nightshade_leaves")).getDefaultState().with(LeavesBlock.DISTANCE, 1);
        SpheroidType NIGHTSHADE_WOOD = new ShellSpheroidType(null, 6, 9, nightshade_log, nightshade_leaves, 2, 4);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.WOOD, 0.3F, NIGHTSHADE_WOOD);

        // IVIS FIELDS + ETHEREAL ISLANDS
        BlockState ivis_phylium = Registry.BLOCK.get(new Identifier(MOD_ID,"ivis_phylium")).getDefaultState();
        BlockState ivis_roots = Registry.BLOCK.get(new Identifier(MOD_ID,"ivis_roots")).getDefaultState();
        PlantDecorator IVIS_ROOTS_DECORATOR = new PlantDecorator(ivis_roots, 0.15F);
        BlockState ether_bush = Registry.BLOCK.get(new Identifier(MOD_ID,"ether_bush")).getDefaultState();
        PlantDecorator ETHER_BUSH_DECORATOR = new PlantDecorator(ether_bush, 0.04F);

        SpheroidType IVIS_FIELDS = new ModularSpheroidType(null, 6, 14, end_stone)
                .setTopBlockState(ivis_phylium)
                .addDecorator(IVIS_ROOTS_DECORATOR, 0.9F)
                .addDecorator(ETHER_BUSH_DECORATOR, 0.4F);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.DECORATIVE, 0.5F, IVIS_FIELDS);

        BlockState bulbis_stem = Registry.BLOCK.get(new Identifier(MOD_ID,"bulbis_stem")).getDefaultState();
        BlockState bulbis_shell = Registry.BLOCK.get(new Identifier(MOD_ID,"bulbis_shell")).getDefaultState();
        SpheroidType BULBIS = new MushroomSpheroidType (null, 6, 14, bulbis_stem, bulbis_shell, 2, 2);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.WOOD, 0.3F, BULBIS);

        BlockState purple_bulbis_shell = Registry.BLOCK.get(new Identifier(MOD_ID,"purple_bulbis_shell")).getDefaultState();
        SpheroidType PURPLE_BULBIS = new MushroomSpheroidType (null, 6, 14, bulbis_stem, purple_bulbis_shell, 2, 2);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.WOOD, 0.3F, PURPLE_BULBIS);

        // CRYPTIC WASTES
        BlockState cryptic_stone = Registry.BLOCK.get(new Identifier(MOD_ID,"cryptic_stone")).getDefaultState();
        BlockState cryptic_magma_block = Registry.BLOCK.get(new Identifier(MOD_ID,"cryptic_magma_block")).getDefaultState();
        BlockState cryptic_fire = Registry.BLOCK.get(new Identifier(MOD_ID,"cryptic_fire")).getDefaultState();
        PlantDecorator CRYPTIC_FIRE_DECORATOR = new PlantDecorator(cryptic_fire, 0.15F);
        BlockState scorched_bush = Registry.BLOCK.get(new Identifier(MOD_ID,"scorched_bush")).getDefaultState();
        PlantDecorator SCORCHED_BUSH_DECORATOR = new PlantDecorator(scorched_bush, 0.1F);
        BlockState scorched_grass = Registry.BLOCK.get(new Identifier(MOD_ID,"scorched_grass")).getDefaultState();
        PlantDecorator SCORCHED_GRASS_DECORATOR = new PlantDecorator(scorched_grass, 0.05F);

        SpheroidType CRYPTIC_WASTES = new ShellSpheroidType(null, 8, 15, cryptic_stone, cryptic_stone, 1, 1)
                .addShellSpeckles(cryptic_magma_block, 0.2F)
                .addDecorator(CRYPTIC_FIRE_DECORATOR, 0.9F)
                .addDecorator(SCORCHED_BUSH_DECORATOR, 0.9F)
                .addDecorator(SCORCHED_GRASS_DECORATOR, 0.9F);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.DECORATIVE, 0.5F, CRYPTIC_WASTES);

        // ETHEREAL ISLANDS
        BlockState ether_stone = Registry.BLOCK.get(new Identifier(MOD_ID,"ether_stone")).getDefaultState();
        BlockState lignite_ore = Registry.BLOCK.get(new Identifier(MOD_ID,"lignite_ore")).getDefaultState();
        SpheroidType LIGNITE_ORE = new CoreSpheroidType(null, 8, 15, lignite_ore, ether_stone, 4, 6);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.ORE, 0.5F, LIGNITE_ORE);
        SpheroidType ETHER_STONE = new CoreSpheroidType(null, 8, 15, ether_stone, ether_stone, 1, 1);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.DECORATIVE, 0.5F, ETHER_STONE);

        BlockState ether_soil = Registry.BLOCK.get(new Identifier(MOD_ID,"ether_soil")).getDefaultState();
        BlockState ether_phylium = Registry.BLOCK.get(new Identifier(MOD_ID,"ether_phylium")).getDefaultState();
        BlockState thereal_bellflower = Registry.BLOCK.get(new Identifier(MOD_ID,"thereal_bellflower")).getDefaultState();
        PlantDecorator THEREAL_BELLFOWER_DECORATOR = new PlantDecorator(thereal_bellflower, 0.03F);
        BlockState ether_grass = Registry.BLOCK.get(new Identifier(MOD_ID,"ether_grass")).getDefaultState();
        PlantDecorator ETHER_GRASS_DECORATOR = new PlantDecorator(ether_grass, 0.15F);

        SpheroidType ETHER_SOIL = new ModularSpheroidType(null, 6, 10, ether_soil)
                .setTopBlockState(ether_phylium)
                .addDecorator(THEREAL_BELLFOWER_DECORATOR, 0.9F)
                .addDecorator(ETHER_GRASS_DECORATOR, 0.9F);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.DECORATIVE, 0.5F, ETHER_SOIL);

        BlockState ether_log = Registry.BLOCK.get(new Identifier(MOD_ID,"ether_log")).getDefaultState();
        BlockState ether_leaves = Registry.BLOCK.get(new Identifier(MOD_ID,"ether_leaves")).getDefaultState().with(LeavesBlock.DISTANCE, 1);
        SpheroidType ETHER_WOOD = new ShellSpheroidType(null, 6, 8, ether_log, ether_leaves, 3, 4);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.WOOD, 0.4F, ETHER_WOOD);

        // VISCAL ISLES
        SpheroidType ETHER_WOOD_WITHOUT_LEAVES = new ModularSpheroidType(null, 6, 8, ether_log);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.WOOD, 0.4F, ETHER_WOOD_WITHOUT_LEAVES);
        BlockState vermilion_sculk = Registry.BLOCK.get(new Identifier(MOD_ID,"vermilion_sculk")).getDefaultState();
        BlockState vermilion_sculk_growth = Registry.BLOCK.get(new Identifier(MOD_ID,"vermilion_sculk_growth")).getDefaultState();
        PlantDecorator VERMILION_SCOLK_GROWTH_DECORATOR = new PlantDecorator(vermilion_sculk_growth, 0.15F);
        BlockState therium_crystal = Registry.BLOCK.get(new Identifier(MOD_ID,"therium_crystal")).getDefaultState();
        PlantDecorator THERIUM_CRYSTAL_DECORATOR = new PlantDecorator(therium_crystal, 0.1F);

        SpheroidType VISCAL_ISLES = new ModularSpheroidType(null, 6, 10, ether_stone)
                .setTopBlockState(vermilion_sculk)
                .addDecorator(VERMILION_SCOLK_GROWTH_DECORATOR, 0.9F)
                .addDecorator(THERIUM_CRYSTAL_DECORATOR, 0.9F);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.DECORATIVE, 0.5F, VISCAL_ISLES);

        // SHULKREN FOREST
        BlockState shulkren_phylium = Registry.BLOCK.get(new Identifier(MOD_ID,"shulkren_phylium")).getDefaultState();
        BlockState shulkren_fungus = Registry.BLOCK.get(new Identifier(MOD_ID,"shulkren_fungus")).getDefaultState();
        PlantDecorator SHULKREN_FUNGUS_DECORATOR = new PlantDecorator(shulkren_fungus, 0.15F);
        SpheroidType SHULKREN_FOREST = new ModularSpheroidType(null, 6, 10, end_stone)
                .setTopBlockState(shulkren_phylium)
                .addDecorator(SHULKREN_FUNGUS_DECORATOR, 0.9F);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.DECORATIVE, 0.5F, SHULKREN_FOREST);

        BlockState white_mushroom_stem = Registry.BLOCK.get(new Identifier(MOD_ID,"white_mushroom_stem")).getDefaultState();
        BlockState shulkren_wart_block = Registry.BLOCK.get(new Identifier(MOD_ID,"shulkren_wart_block")).getDefaultState();
        BlockState purple_shroomlight = Registry.BLOCK.get(new Identifier(MOD_ID,"purple_shroomlight")).getDefaultState();
        BlockState shulkren_vine_plant = Registry.BLOCK.get(new Identifier(MOD_ID,"shulkren_vine_plant")).getDefaultState();
        UnderPlantDecorator SHULKREN_VINE_DECORATOR = new UnderPlantDecorator(shulkren_vine_plant, 0.1F);

        SpheroidType SHULKREN_WART = new ShellSpheroidType(null, 7, 10, white_mushroom_stem, shulkren_wart_block, 1, 3)
                .addShellSpeckles(purple_shroomlight, 0.1F)
                .addDecorator(SHULKREN_VINE_DECORATOR, 0.9F);
        spheroidLoader.registerSpheroidType(END, SpheroidDistributionType.WOOD, 0.4F, SHULKREN_WART);


    }


}
