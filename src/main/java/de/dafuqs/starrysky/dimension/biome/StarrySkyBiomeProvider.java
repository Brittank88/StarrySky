package de.dafuqs.starrysky.dimension.biome;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import de.dafuqs.starrysky.StarrySkyCommon;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.RegistryLookupCodec;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;

import java.util.List;

public class StarrySkyBiomeProvider extends BiomeSource {

    public static final Identifier STARRY_SKY_BIOME_IDENTIFIER = new Identifier(StarrySkyCommon.MOD_ID, "starry_sky_biome");
    public static final Identifier STARRY_SKY_NETHER_BIOME_IDENTIFIER = new Identifier(StarrySkyCommon.MOD_ID, "starry_sky_nether_biome");
    public static final Identifier STARRY_SKY_END_BIOME_IDENTIFIER = new Identifier(StarrySkyCommon.MOD_ID, "starry_sky_end_biome");

    public static void registerBiomeProvider() {
        Registry.register(Registry.BIOME_SOURCE, new Identifier(StarrySkyCommon.MOD_ID, "biome_source"), StarrySkyBiomeProvider.CODEC);
        Registry.register(Registry.BIOME_SOURCE, new Identifier(StarrySkyCommon.MOD_ID, "nether_biome_source"), StarrySkyNetherBiomeProvider.CODEC);
        Registry.register(Registry.BIOME_SOURCE, new Identifier(StarrySkyCommon.MOD_ID, "end_biome_source"), StarrySkyEndBiomeProvider.CODEC);
    }

    public static final Codec<StarrySkyBiomeProvider> CODEC =
            RecordCodecBuilder.create((instance) -> instance.group(
                    Codec.LONG.fieldOf("seed").stable().forGetter((StarrySkyBiomeProvider) -> StarrySkyBiomeProvider.SEED),
                    RegistryLookupCodec.of(Registry.BIOME_KEY).forGetter((vanillaLayeredBiomeSource) -> vanillaLayeredBiomeSource.BIOME_REGISTRY))
            .apply(instance, instance.stable(StarrySkyBiomeProvider::new)));

    private final long SEED;
    private final Registry<Biome> BIOME_REGISTRY;
    public static Registry<Biome> layersBiomeRegistry;

    private static final List<RegistryKey<Biome>> BIOMES = ImmutableList.of(
            RegistryKey.of(Registry.BIOME_KEY, STARRY_SKY_BIOME_IDENTIFIER));

    public StarrySkyBiomeProvider(long seed, Registry<Biome> biomeRegistry) {
        super(BIOMES.stream().map((registryKey) -> () -> (Biome)biomeRegistry.get(registryKey)));
        this.SEED = seed;
        this.BIOME_REGISTRY = biomeRegistry;
        StarrySkyBiomeProvider.layersBiomeRegistry = biomeRegistry;
    }

    public Biome getBiomeForNoiseGen(int x, int y, int z) {
        return BIOME_REGISTRY.get(STARRY_SKY_BIOME_IDENTIFIER);
    }

    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return CODEC;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public BiomeSource withSeed(long seed) {
        return new StarrySkyBiomeProvider(seed, this.BIOME_REGISTRY);
    }
}
