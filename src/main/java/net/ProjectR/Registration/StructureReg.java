package net.ProjectR.Registration;

import net.ProjectR.World.Ruins.ruinFeature;
import net.ProjectR.World.Ruins.ruinGenerator;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class StructureReg {

	public static final StructurePieceType ruinPieceType = Registry.register(Registry.STRUCTURE_PIECE, "ruin_piece", ruinGenerator.Piece::new);
	public static final StructureFeature<DefaultFeatureConfig> ruinFeature = Registry.register(Registry.FEATURE, "ruin_feature", new ruinFeature());
	public static final StructureFeature<?> ruinStructure = Registry.register(Registry.STRUCTURE_FEATURE, "ruin_structure", ruinFeature);


    public static void register()
    {
		Feature.STRUCTURES.put("Ruin Feature", ruinFeature);

		for(Biome biome : Registry.BIOME)
		{
			if(biome.getCategory() == Biome.Category.DESERT || biome.getCategory() == Biome.Category.EXTREME_HILLS || biome.getCategory() == Biome.Category.FOREST || biome.getCategory() == Biome.Category.JUNGLE || biome.getCategory() == Biome.Category.PLAINS || biome.getCategory() == Biome.Category.SAVANNA || biome.getCategory() == Biome.Category.TAIGA || biome.getCategory() == Biome.Category.MUSHROOM)
			{
				biome.addStructureFeature(ruinFeature.configure(FeatureConfig.DEFAULT));
                biome.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES, ruinFeature.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.CHANCE_PASSTHROUGH.configure(new ChanceDecoratorConfig(25))));
            } 
		}
    }
}