package de.dafuqs.starrysky.dimension.spheroid.lists;

import de.dafuqs.starrysky.StarrySkyCommon;
import de.dafuqs.starrysky.dimension.SpheroidDistributionType;
import de.dafuqs.starrysky.dimension.SpheroidLoader;
import de.dafuqs.starrysky.dimension.decorators.GroundDecorator;
import de.dafuqs.starrysky.dimension.decorators.SingleBlockDecorator;
import de.dafuqs.starrysky.dimension.decorators.BottomBlockDecorator;
import de.dafuqs.starrysky.dimension.spheroid.types.LiquidSpheroidType;
import de.dafuqs.starrysky.dimension.spheroid.types.ModularSpheroidType;
import de.dafuqs.starrysky.dimension.spheroid.types.ShellSpheroidType;
import de.dafuqs.starrysky.dimension.spheroid.types.SpheroidType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

import static de.dafuqs.starrysky.dimension.SpheroidLoader.SpheroidDimensionType.OVERWORLD;
import static org.apache.logging.log4j.Level.INFO;

public class SpheroidListEcotones extends SpheroidList {

    private static final String MOD_ID = "ecotones";


    public static boolean shouldGenerate() {
        return FabricLoader.getInstance().isModLoaded(MOD_ID) && StarrySkyCommon.STARRY_SKY_CONFIG.generateEcotonesSpheroids;
    }

    public static void setup(SpheroidLoader spheroidLoader) {
        StarrySkyCommon.log(INFO, "Loading Ecotones integration...");

        BlockState peat = getDefaultBlockState(MOD_ID,"peat"); // swamp
        BlockState short_grass = getDefaultBlockState(MOD_ID,"short_grass");
        BlockState reeds = getDefaultBlockState(MOD_ID,"reeds"); // swamp
        BlockState small_shrub = getDefaultBlockState(MOD_ID,"small_shrub");
        BlockState geyser = getDefaultBlockState(MOD_ID,"geyser");
        BlockState hazel_leaves = getDefaultBlockState(MOD_ID,"hazel_leaves"); // with oak log
        BlockState sandy_grass = getDefaultBlockState(MOD_ID,"sandy_grass");
        BlockState surface_rock = getDefaultBlockState(MOD_ID,"surface_rock");
        BlockState dried_dirt = getDefaultBlockState(MOD_ID,"dried_dirt"); // wasteland
        BlockState pinecone = getDefaultBlockState(MOD_ID,"pinecone");
        //BlockState lichen = getDefaultBlockState(MOD_ID,"lichen"); // on side of blocks

        SingleBlockDecorator small_shrub_decorator = new SingleBlockDecorator(small_shrub, 0.1F);
        SingleBlockDecorator sandy_grass_decorator = new SingleBlockDecorator(sandy_grass, 0.1F);
        SingleBlockDecorator short_grass_decorator = new SingleBlockDecorator(short_grass, 0.1F);
        GroundDecorator geyser_decorator = new GroundDecorator(geyser, 0.1F);
        SingleBlockDecorator surface_rock_decorator = new SingleBlockDecorator(surface_rock, 0.07F);
        BottomBlockDecorator pine_cone_decorator = new BottomBlockDecorator(pinecone, 0.25F);

        SpheroidType PEAT = new LiquidSpheroidType(null, 5, 9, Blocks.WATER.getDefaultState(), MAP_GLASS, 1, 2, 65, 100, 60)
                .setCoreBlock(peat, 3, 6)
                .addDecorator(SpheroidListVanilla.SpheroidDecorators.SEA_GREENS, 0.2F);
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.FLUID, 0.7F, PEAT);

        SpheroidType HAZEL_WOOD = new ShellSpheroidType(null, 7, 12, Blocks.OAK_LOG.getDefaultState(), hazel_leaves, 2, 4);
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.WOOD, 0.7F, HAZEL_WOOD);

        SpheroidType WASTELAND = new ModularSpheroidType(null, 6, 14, dried_dirt)
                .addDecorator(small_shrub_decorator, 0.8F);
        spheroidLoader.registerSpheroidType(OVERWORLD, SpheroidDistributionType.DECORATIVE, 0.7F, WASTELAND);

        SpheroidListVanilla.GRASS.addDecorator(short_grass_decorator, 0.2F);
        SpheroidListVanilla.SPRUCE_WOOD.addDecorator(pine_cone_decorator, 0.25F);

        SingleBlockDecorator reeds_decorator = new SingleBlockDecorator(reeds, 0.02F);
        SpheroidListVanilla.GRASS.addDecorator(reeds_decorator, 0.05F);

        SpheroidListVanilla.SAND.addDecorator(small_shrub_decorator, 0.05F);
        SpheroidListVanilla.SAND.addDecorator(sandy_grass_decorator, 0.07F);
        SpheroidListVanilla.RED_SAND.addDecorator(small_shrub_decorator, 0.05F);
        SpheroidListVanilla.RED_SAND.addDecorator(sandy_grass_decorator, 0.08F);

        SpheroidListVanilla.BEACH_GRASS.addDecorator(sandy_grass_decorator, 0.2F);
        SpheroidListVanilla.BEACH_SAND.addDecorator(sandy_grass_decorator, 0.2F);
        SpheroidListVanilla.BEACH_GRASS.addDecorator(surface_rock_decorator, 0.1F);
        SpheroidListVanilla.BEACH_SAND.addDecorator(surface_rock_decorator, 0.1F);

        SpheroidListVanilla.LAVA_STONE.addDecorator(geyser_decorator, 0.2F);

        SpheroidListVanilla.STONE.addDecorator(surface_rock_decorator, 0.1F);
        SpheroidListVanilla.STONE_HOLLOW.addDecorator(surface_rock_decorator, 0.1F);
        SpheroidListVanilla.COAL.addDecorator(surface_rock_decorator, 0.1F);
        SpheroidListVanilla.IRON.addDecorator(surface_rock_decorator, 0.1F);
        SpheroidListVanilla.GOLD.addDecorator(surface_rock_decorator, 0.1F);
        SpheroidListVanilla.DIAMOND.addDecorator(surface_rock_decorator, 0.1F);
        SpheroidListVanilla.REDSTONE.addDecorator(surface_rock_decorator, 0.1F);
        SpheroidListVanilla.LAPIS.addDecorator(surface_rock_decorator, 0.1F);

        // flowers
        BlockState clover = getDefaultBlockState(MOD_ID,"clover");
        BlockState wildflowers = getDefaultBlockState(MOD_ID,"wildflowers");
        BlockState bluebell = getDefaultBlockState(MOD_ID,"bluebell");
        BlockState wide_fern = getDefaultBlockState(MOD_ID,"wide_fern");
        BlockState small_lilac = getDefaultBlockState(MOD_ID,"small_lilac");
        BlockState moss = getDefaultBlockState(MOD_ID,"moss");
        BlockState cyan_rose = getDefaultBlockState(MOD_ID,"cyan_rose");

        // Add blocks to default lists
        LIST_FLOWERS.add(clover);
        LIST_FLOWERS.add(wildflowers);
        LIST_FLOWERS.add(bluebell);
        LIST_FLOWERS.add(wide_fern);
        LIST_FLOWERS.add(small_lilac);
        LIST_FLOWERS.add(moss);
        LIST_FLOWERS.add(cyan_rose);
    }

}
