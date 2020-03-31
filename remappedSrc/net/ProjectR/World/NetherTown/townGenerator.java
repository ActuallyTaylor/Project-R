package net.ProjectR.World.NetherTown;

import java.util.List;
import java.util.Random;

import net.minecraft.structure.processor.BlockIgnoreStructureProcessor;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.ProjectR.Registration.StructureReg;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.*;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.Heightmap;

public class townGenerator {
    private static final Identifier TOWN_TEMPLATE = new Identifier("projectr:nethertown1");

    public static void addP(StructureManager manager, BlockPos pos, BlockRotation rotation, List<StructurePiece> pieces,
            Random random, DefaultFeatureConfig defaultConfig) {
        pieces.add(new townGenerator.piece(manager, TOWN_TEMPLATE, pos, rotation, 5));
    }

    public static class piece extends SimpleStructurePiece {
        private final Identifier template;
        private final BlockRotation rotation;

        public piece(StructureManager manager, Identifier identifier, BlockPos pos, BlockRotation rotation,
                int yOffset) {
            super(StructureReg.townPieceType, 0); // Replace with peice type
            this.template = identifier;
            BlockPos blockPos = new BlockPos(0, 0, 0);
            this.pos = pos.add(blockPos.getX(), blockPos.getY() - yOffset, blockPos.getZ());
            this.rotation = rotation;
            this.initializeStructureData(manager);
        }

        public piece(StructureManager manager, CompoundTag tag) {
            super(StructureReg.townPieceType, tag); // Replace with peice type
            this.template = new Identifier(tag.getString("Template"));
            this.rotation = BlockRotation.valueOf(tag.getString("Rot"));
            this.initializeStructureData(manager);
        }

        private void initializeStructureData(StructureManager manager) {
            Structure structure_1 = manager.getStructureOrBlank(this.template);
            StructurePlacementData structurePlacementData_1 = (new StructurePlacementData()).setRotation(this.rotation)
                    .setMirror(BlockMirror.NONE).setPosition(pos)
                    .addProcessor(BlockIgnoreStructureProcessor.IGNORE_STRUCTURE_BLOCKS);
            this.setStructureData(structure_1, this.pos, structurePlacementData_1);
        }

        @Override
        public boolean generate(IWorld world, ChunkGenerator<?> generator, Random random, BlockBox box, ChunkPos pos,BlockPos pos3) {
            int yHeight = world.getTopY(Heightmap.Type.WORLD_SURFACE_WG, this.pos.getX(), this.pos.getZ());
            BlockPos blockPos3 = this.pos;
            this.pos = this.pos.add(0, yHeight, 0); // Spawns in corner - Should probably change but works for now lol
            boolean bl = super.generate(world, generator, random, box, pos, blockPos3);

            this.pos = blockPos3;
            return bl;
        }

        @Override
        protected void handleMetadata(String metadata, BlockPos pos, IWorld world, Random random,
                BlockBox boundingBox) {
            if ("chest".equals(metadata)) {
                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
                BlockEntity blockEntity = world.getBlockEntity(pos.down());
                if (blockEntity instanceof ChestBlockEntity) {
                    // ((ChestBlockEntity) blockEntity).setLootTable(chestLoot, random.nextLong());
                    ((ChestBlockEntity) blockEntity).setLootTable(LootTables.SIMPLE_DUNGEON_CHEST, random.nextLong());

                }
            }
        }

    }
}
