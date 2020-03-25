package net.ProjectR.World.NetherTown;

import java.util.Random;

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

public class townFeature extends AbstractTempleFeature<DefaultFeatureConfig> {

    public townFeature() {
        super(DefaultFeatureConfig::deserialize);
    }

    @Override
    protected int getSeedModifier() {
        return 5632791;
    }

    @Override
    public StructureStartFactory getStructureStartFactory() {
        return townFeature.netherTownStructureStart::new;
    }

    @Override
    public String getName() {
        return "netherTown1";
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

    public static class netherTownStructureStart extends StructureStart {

        public netherTownStructureStart(StructureFeature<?> feature, int chunkX, int chunkZ, BlockBox box,
                int references, long seed) {
            super(feature, chunkX, chunkZ, box, references, seed);
        }

        @Override
        public void initialize(ChunkGenerator<?> chunkGenerator, StructureManager structureManager, int x, int z,
                Biome biome) {
            final DefaultFeatureConfig defaultFeatureConfig = chunkGenerator.getStructureConfig(biome, StructureReg.townFeature);//Add Feature
            final int x2 = x * 16;
            final int z2 = z * 16;
            final BlockPos startingPos = new BlockPos(x2, 0, z2);
            final BlockRotation rotation = BlockRotation.values()[this.random.nextInt(BlockRotation.values().length)];
            townGenerator.addP(structureManager, startingPos, rotation, this.children,this.random,defaultFeatureConfig);
            this.setBoundingBoxFromChildren();
        }
        
    }

}