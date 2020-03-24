package net.ProjectR.World.Ruins;

import java.util.Random;
import java.util.List;

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

public class ruinGenerator {
    private static final Identifier RUIN_1_TEMPLATE = new Identifier("projectr:ruins1");
    private static final Identifier RUIN_2_TEMPLATE = new Identifier("projectr:ruins2");
    private static final Identifier RUIN_3_TEMPLATE = new Identifier("projectr:ruins3");
    private static final Identifier RUIN_4_TEMPLATE = new Identifier("projectr:ruins4");
    private static final Identifier RUIN_5_TEMPLATE = new Identifier("projectr:ruins5");

    public static void addParts(StructureManager manager, BlockPos pos, BlockRotation rotation,
            List<StructurePiece> pieces, Random random, DefaultFeatureConfig defaultConfig) {
        int rand = (int) ((Math.random() * (6 - 0)) + 0);
        if(rand == 0) {
            pieces.add(new ruinGenerator.Piece(manager, RUIN_1_TEMPLATE, pos, rotation, 0));
        } else if (rand == 1) {
            pieces.add(new ruinGenerator.Piece(manager, RUIN_2_TEMPLATE, pos, rotation, 0));
        } else if (rand == 2) {
            pieces.add(new ruinGenerator.Piece(manager, RUIN_3_TEMPLATE, pos, rotation, 0));
        } else if (rand == 3) {
            pieces.add(new ruinGenerator.Piece(manager, RUIN_4_TEMPLATE, pos, rotation, 0));
        } else if (rand == 4) {
            pieces.add(new ruinGenerator.Piece(manager, RUIN_5_TEMPLATE, pos, rotation, 5));
        } else if (rand == 5) {
        }
    }

    public static class Piece extends SimpleStructurePiece {
        private final Identifier template;
        private final BlockRotation rotation;

        public Piece(StructureManager manager, Identifier identifier, BlockPos pos, BlockRotation rotation,
                int yOffset) {
            super(StructureReg.ruinPieceType, 0); // Replace with peice type
            this.template = identifier;
            BlockPos blockPos = new BlockPos(0, 0, 0);
            this.pos = pos.add(blockPos.getX(), blockPos.getY() - yOffset, blockPos.getZ());
            this.rotation = rotation;
            this.initializeStructureData(manager);
        }

        public Piece(StructureManager manager, CompoundTag tag) {
            super(StructureReg.ruinPieceType, tag); // Replace with peice type
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

        public boolean generate(IWorld world, ChunkGenerator<?> generator, Random random, BlockBox box, ChunkPos pos) {
            int yHeight = world.getTopY(Heightmap.Type.WORLD_SURFACE_WG, this.pos.getX(), this.pos.getZ());
            BlockPos blockPos3 = this.pos;
            this.pos = this.pos.add(0, yHeight, 0); //Spawns in corner - Should probably change but works for now lol
            boolean bl = super.generate(world, generator, random, box, pos);

            this.pos = blockPos3;
            return bl;
         }
 
    }
}
