package net.ProjectR.Registration;

import net.ProjectR.World.Biome.infectedBiome;
import net.fabricmc.fabric.api.biomes.v1.FabricBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biomes.v1.OverworldClimate;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class BiomeReg {

    public static final Biome INFECTED_BIOME = Registry.register(Registry.BIOME, new Identifier("projectr", "infected_biome"), new infectedBiome());

    public static void register() {
        OverworldBiomes.addContinentalBiome(INFECTED_BIOME, OverworldClimate.TEMPERATE, 0.7);
        OverworldBiomes.addContinentalBiome(INFECTED_BIOME, OverworldClimate.COOL, 0.7);
        OverworldBiomes.addHillsBiome(INFECTED_BIOME, Biomes.MOUNTAINS, 1);
        FabricBiomes.addSpawnBiome(INFECTED_BIOME);
    }
} 
