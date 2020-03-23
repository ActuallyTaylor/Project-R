package net.ProjectR.Registration;

import net.ProjectR.Features.Dungeons.two.Dungeon2Feature;
import net.ProjectR.Features.Dungeons.one.Dungeon1Gen;
import net.ProjectR.Features.Dungeons.one.Dungeon1Feature;
import net.ProjectR.Features.Dungeons.two.Dungeon2Gen;
import net.ProjectR.Features.Ruins.one.Ruins1Feature;
import net.ProjectR.Features.Ruins.one.Ruins1Gen;
import net.ProjectR.Features.Ruins.three.Ruins3Feature;
import net.ProjectR.Features.Ruins.three.Ruins3Gen;
import net.ProjectR.Features.Ruins.two.Ruins2Feature;
import net.ProjectR.Features.Ruins.two.Ruins2Gen;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.GenerationStep;

public class FeatureReg {
    //Ruins
        //1
    public static final StructurePieceType Ruin1PieceType = Registry.register(Registry.STRUCTURE_PIECE, "ruins_1_piece_type", Ruins1Gen.Piece::new);
    public static final StructureFeature<DefaultFeatureConfig> Ruin1Feature = Registry.register(Registry.FEATURE, "ruins_1_feature", new Ruins1Feature());
    public static final StructureFeature<?> Ruin1Structure = Registry.register(Registry.STRUCTURE_FEATURE, "ruins_1_structure", Ruin1Feature);
        //2
    public static final StructurePieceType Ruin2PieceType = Registry.register(Registry.STRUCTURE_PIECE, "ruins_2_piece_type", Ruins2Gen.Piece::new);
    public static final StructureFeature<DefaultFeatureConfig> Ruin2Feature = Registry.register(Registry.FEATURE, "ruins_2_feature", new Ruins2Feature());
    public static final StructureFeature<?> Ruin2Structure = Registry.register(Registry.STRUCTURE_FEATURE, "ruins_2_structure", Ruin2Feature);
        //3
    public static final StructurePieceType Ruin3PieceType = Registry.register(Registry.STRUCTURE_PIECE, "ruins_3_piece_type", Ruins3Gen.Piece::new);
    public static final StructureFeature<DefaultFeatureConfig> Ruin3Feature = Registry.register(Registry.FEATURE, "ruins_3_feature", new Ruins3Feature());
    public static final StructureFeature<?> Ruin3Structure = Registry.register(Registry.STRUCTURE_FEATURE, "ruins_3_structure", Ruin3Feature);

    //Dungeon
        //1
    public static final StructurePieceType Dungeon1PieceType = Registry.register(Registry.STRUCTURE_PIECE, "dungeon1_piece_type", Dungeon1Gen.Piece::new);
    public static final StructureFeature<DefaultFeatureConfig> Dungeon1Feature = Registry.register(Registry.FEATURE, "dungeon1_feature", new Dungeon1Feature());
    public static final StructureFeature<?> Dungeon1Structure = Registry.register(Registry.STRUCTURE_FEATURE, "dungeon1_structure", Dungeon1Feature);
        //2
    public static final StructurePieceType Dungeon2PieceType = Registry.register(Registry.STRUCTURE_PIECE, "dungeon2_piece_type", Dungeon2Gen.Piece::new);
    public static final StructureFeature<DefaultFeatureConfig> Dungeon2Feature = Registry.register(Registry.FEATURE, "dungeon2_feature", new Dungeon2Feature());
    public static final StructureFeature<?> Dungeon2Structure = Registry.register(Registry.STRUCTURE_FEATURE, "dungeon2_structure", Dungeon2Feature);
    
    public static void register() {
        Feature.STRUCTURES.put("ruins_1", Ruin1Feature);
        Feature.STRUCTURES.put("ruins_2", Ruin2Feature);
        Feature.STRUCTURES.put("ruins_3", Ruin3Feature);
        Feature.STRUCTURES.put("dungeon_1", Dungeon1Feature);
        Feature.STRUCTURES.put("dungeon_2", Dungeon2Feature);

        for(Biome biome : Registry.BIOME) {
            if(biome.getCategory() == Biome.Category.PLAINS) {
                biome.addStructureFeature(Ruin1Feature.configure(FeatureConfig.DEFAULT));
                biome.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES, Ruin1Feature.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.CHANCE_PASSTHROUGH.configure(new ChanceDecoratorConfig(60))));

                biome.addStructureFeature(Ruin2Feature.configure(FeatureConfig.DEFAULT));
                biome.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES, Ruin2Feature.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.CHANCE_PASSTHROUGH.configure(new ChanceDecoratorConfig(160))));

                biome.addStructureFeature(Ruin3Feature.configure(FeatureConfig.DEFAULT));
                biome.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES, Ruin3Feature.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.CHANCE_PASSTHROUGH.configure(new ChanceDecoratorConfig(135))));
                
                biome.addStructureFeature(Dungeon1Feature.configure(FeatureConfig.DEFAULT));
                biome.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES, Dungeon1Feature.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.CHANCE_PASSTHROUGH.configure(new ChanceDecoratorConfig(530))));

                biome.addStructureFeature(Dungeon2Feature.configure(FeatureConfig.DEFAULT));
                biome.addFeature(GenerationStep.Feature.SURFACE_STRUCTURES, Dungeon2Feature.configure(FeatureConfig.DEFAULT).createDecoratedFeature(Decorator.CHANCE_PASSTHROUGH.configure(new ChanceDecoratorConfig(300))));
            }
        }
    }
}
// || biome.getCategory() == Biome.Category.FOREST || biome.getCategory() == Biome.Category.JUNGLE || biome.getCategory() == Biome.Category.TAIGA ||  biome.getCategory() == Biome.Category.SAVANNA 
/*
      NONE("none"),
      TAIGA("taiga"),
      EXTREME_HILLS("extreme_hills"),
      JUNGLE("jungle"),
      MESA("mesa"),
      PLAINS("plains"),
      SAVANNA("savanna"),
      ICY("icy"),
      THEEND("the_end"),
      BEACH("beach"),
      FOREST("forest"),
      OCEAN("ocean"),
      DESERT("desert"),
      RIVER("river"),
      SWAMP("swamp"),
      MUSHROOM("mushroom"),
      NETHER("nether");

*/