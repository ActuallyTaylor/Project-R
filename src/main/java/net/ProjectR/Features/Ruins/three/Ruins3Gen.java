package net.ProjectR.Features.Ruins.three;

import java.util.List;
import java.util.Random;

import net.ProjectR.Registration.FeatureReg;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.*;
import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.Identifier;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.BlockBox;
import net.minecraft.world.Heightmap;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;

public class Ruins3Gen {
    public static final Identifier id = new Identifier("projectr:ruins3");

    public static void addParts(StructureManager structureManager_1, BlockPos blockPos_1, BlockRotation rotation_1,
            List<StructurePiece> list_1, Random random_1, DefaultFeatureConfig featureConfig) {
        list_1.add(new Ruins3Gen.Piece(structureManager_1, id, blockPos_1, rotation_1));
    }

    public static class Piece extends SimpleStructurePiece {
        private BlockRotation rotation;
        private Identifier template;
     
        public Piece(StructureManager structureManager_1, Identifier identifier_1, BlockPos blockPos_1, BlockRotation rotation_1) {
            super(FeatureReg.Ruin3PieceType, 0);
     
            this.pos = blockPos_1;
            this.rotation = rotation_1;
            this.template = identifier_1;
     
            this.setStructureData(structureManager_1);
        }
     
        public Piece(StructureManager structureManager_1, CompoundTag compoundTag_1) {
            super(FeatureReg.Ruin3PieceType, compoundTag_1);
            this.template = new Identifier(compoundTag_1.getString("Template"));
            this.rotation = BlockRotation.valueOf(compoundTag_1.getString("Rot"));
            this.setStructureData(structureManager_1);
        }
     
        @Override
        protected void toNbt(CompoundTag compoundTag_1) {
            super.toNbt(compoundTag_1);
            compoundTag_1.putString("Template", this.template.toString());
            compoundTag_1.putString("Rot", this.rotation.name());
        }
     
        public void setStructureData(StructureManager structureManager) {
            Structure structure_1 = structureManager.getStructureOrBlank(this.template);
            StructurePlacementData structurePlacementData_1 = (new StructurePlacementData()).setRotation(this.rotation).setMirror(BlockMirror.NONE).setPosition(pos).addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
            this.setStructureData(structure_1, this.pos, structurePlacementData_1);
        }
     

        @Override
        protected void handleMetadata(String metadata, BlockPos pos, IWorld world, Random random,
                BlockBox boundingBox) {
            if ("r3chest".equals(metadata)) {
                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
                BlockEntity blockEntity = world.getBlockEntity(pos.down());
                if (blockEntity instanceof ChestBlockEntity) {
                    // ((ChestBlockEntity) blockEntity).setLootTable(chestLoot, random.nextLong());
                    ((ChestBlockEntity) blockEntity).setLootTable(LootTables.IGLOO_CHEST_CHEST, random.nextLong());

                }
            }
        }
        @Override
        public boolean generate(IWorld world, ChunkGenerator<?> generator, Random random, BlockBox box, ChunkPos pos) {
            int yHeight = world.getTopY(Heightmap.Type.WORLD_SURFACE_WG, this.pos.getX() + 8, this.pos.getZ() + 8);
            this.pos = this.pos.add(0, yHeight, 0);
            return super.generate(world, generator, random, box, pos);
        }
    }
}