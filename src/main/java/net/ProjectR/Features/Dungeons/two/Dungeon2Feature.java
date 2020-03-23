package net.ProjectR.Features.Dungeons.two;

import java.util.Random;

import net.ProjectR.Registration.FeatureReg;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.AbstractTempleFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class Dungeon2Feature extends AbstractTempleFeature<DefaultFeatureConfig> {

    public Dungeon2Feature() {
        super(DefaultFeatureConfig::deserialize);
    }

    @Override
    protected int getSeedModifier() {
        return 41435325;
    }

    @Override
    public String getName() {
        return "dungeon2_structure";
    }

    @Override
    public int getRadius() {
        return 3;
    }

    @Override
    public boolean shouldStartAt(BiomeAccess biomeAccess, ChunkGenerator<?> chunkGenerator, Random random, int chunkX,
            int chunkZ, Biome biome) {
        //return super.shouldStartAt(biomeAccess, chunkGenerator, random, chunkX, chunkZ, biome);
        return true;
    }

    @Override
    public StructureStartFactory getStructureStartFactory() {
        return Dungeon2StructureStart::new;
    }

    public static class Dungeon2StructureStart extends StructureStart {
        public Dungeon2StructureStart(StructureFeature<?> structureFeature_1, int int_1, int int_2, BlockBox box, int int_3,
                long long_1) {
            super(structureFeature_1, int_1, int_2, box, int_3, long_1);
        }

        @Override
        public void initialize(ChunkGenerator<?> chunkGenerator, StructureManager structureManager, int x, int z,
                Biome biome) {
            DefaultFeatureConfig defaultFeatureConfig = (DefaultFeatureConfig)chunkGenerator.getStructureConfig(biome, FeatureReg.Dungeon2Feature);
            int i = x * 16;
            int j = z * 16;
            BlockPos blockPos = new BlockPos(i, 0, j);
            BlockRotation blockRotation = BlockRotation.NONE;
            //.values()[this.random.nextInt(BlockRotation.values().length)];
            Dungeon2Gen.addParts(structureManager, blockPos, blockRotation, this.children, this.random,
                            defaultFeatureConfig);
            this.setBoundingBoxFromChildren();
        }
    }
}