/*
 CRIMSON_FUNGUS_CONFIG = new HugeFungusFeatureConfig(Blocks.CRIMSON_NYLIUM.getDefaultState(), Blocks.CRIMSON_STEM.getDefaultState(), Blocks.NETHER_WART_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
      CRIMSON_FUNGUS_NOT_PLANTED_CONFIG = new HugeFungusFeatureConfig(CRIMSON_FUNGUS_CONFIG.validBaseBlock, CRIMSON_FUNGUS_CONFIG.stemState, CRIMSON_FUNGUS_CONFIG.hatState, CRIMSON_FUNGUS_CONFIG.decorationState, false);
      WARPED_FUNGUS_CONFIG = new HugeFungusFeatureConfig(Blocks.WARPED_NYLIUM.getDefaultState(), Blocks.WARPED_STEM.getDefaultState(), Blocks.WARPED_WART_BLOCK.getDefaultState(), Blocks.SHROOMLIGHT.getDefaultState(), true);
      WARPED_FUNGUS_NOT_PLANTED_CONFIG = new HugeFungusFeatureConfig(WARPED_FUNGUS_CONFIG.validBaseBlock, WARPED_FUNGUS_CONFIG.stemState, WARPED_FUNGUS_CONFIG.hatState, WARPED_FUNGUS_CONFIG.decorationState, false);
*/

package net.ProjectR.mixin;

import net.ProjectR.Registration.BlockReg;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(HugeFungusFeatureConfig.class)
public class shroomHook {
    @Shadow @Mutable @Final public static HugeFungusFeatureConfig WARPED_FUNGUS_CONFIG = new HugeFungusFeatureConfig(Blocks.WARPED_NYLIUM.getDefaultState(), Blocks.WARPED_STEM.getDefaultState(), Blocks.WARPED_WART_BLOCK.getDefaultState(), BlockReg.BLUESHROOMLIGHT.getDefaultState(), true);
    @Shadow @Mutable @Final public static HugeFungusFeatureConfig WARPED_FUNGUS_NOT_PLANTED_CONFIG = new HugeFungusFeatureConfig(WARPED_FUNGUS_CONFIG.validBaseBlock, WARPED_FUNGUS_CONFIG.stemState, WARPED_FUNGUS_CONFIG.hatState, WARPED_FUNGUS_CONFIG.decorationState, false);
}