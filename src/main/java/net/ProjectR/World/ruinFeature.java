package net.ProjectR.World;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.ProjectR.Registration.StructureReg;
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

public class ruinFeature extends AbstractTempleFeature<DefaultFeatureConfig> {

    public ruinFeature() {
        super(DefaultFeatureConfig::deserialize);
    }

	@Override
    protected int getSeedModifier() {
        return 5756486;
    }

    @Override
    public StructureStartFactory getStructureStartFactory() {
        return ruinFeature.ruinStructureStart::new;
    }

    @Override
    public String getName() {
        return "ruins_1";
    }

    @Override
    public int getRadius() {
        return 8;
    }

    @Override
    public boolean shouldStartAt(BiomeAccess biomeAccess, ChunkGenerator<?> chunkGenerator, Random random, int chunkX,
            int chunkZ, Biome biome) {
        return true;
    }

    public static class ruinStructureStart extends StructureStart {
        public ruinStructureStart(StructureFeature<?> sFeature, int i, int j,BlockBox blockbox, int k, long l) {
            super(sFeature, i, j, blockbox, k, l);
        }

        @Override
        public void initialize(ChunkGenerator<?> chunkGenerator, StructureManager structureManager, int x, int z,
                Biome biome) {
            DefaultFeatureConfig defaultFeatureConfig = chunkGenerator.getStructureConfig(biome, StructureReg.ruinFeature);//Add Feature
            int x2 = x * 16;
            int z2 = z * 16;
            BlockPos startingPos = new BlockPos(x2, 0, z2);
            BlockRotation rotation = BlockRotation.values()[this.random.nextInt(BlockRotation.values().length)];
            ruinGenerator.addParts(structureManager, startingPos, rotation, this.children, this.random,
                    defaultFeatureConfig);
            this.setBoundingBoxFromChildren();
        }
    }
}