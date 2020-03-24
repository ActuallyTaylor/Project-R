package net.ProjectR.World.Ruins;

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
    public boolean shouldStartAt(final BiomeAccess biomeAccess, final ChunkGenerator<?> chunkGenerator, final Random random, final int chunkX,
            final int chunkZ, final Biome biome) {
        return true;
    }

    public static class ruinStructureStart extends StructureStart {
        public ruinStructureStart(final StructureFeature<?> sFeature, final int i, final int j,final BlockBox blockbox, final int k, final long l) {
            super(sFeature, i, j, blockbox, k, l);
        }

        @Override
        public void initialize(final ChunkGenerator<?> chunkGenerator, final StructureManager structureManager, final int x, final int z,
                final Biome biome) {
            final DefaultFeatureConfig defaultFeatureConfig = chunkGenerator.getStructureConfig(biome, StructureReg.ruinFeature);//Add Feature
            final int x2 = x * 16;
            final int z2 = z * 16;
            final BlockPos startingPos = new BlockPos(x2, 0, z2);
            final BlockRotation rotation = BlockRotation.values()[this.random.nextInt(BlockRotation.values().length)];
            ruinGenerator.addParts(structureManager, startingPos, rotation, this.children, this.random,
                    defaultFeatureConfig);
            this.setBoundingBoxFromChildren();
        }
    }
}