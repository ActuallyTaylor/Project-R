package net.ProjectR.LootTables;

import net.ProjectR.Registration.ItemReg;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.BinomialLootTableRange;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;

public class NetherMobs {
    
    public static void insertLootTable() {
        // No magic constants!
        final Identifier GHAST_LOOT_TABLE_ID = new Identifier("minecraft", "entities/ghast");
        final Identifier HOGLIN_LOOT_TABLE_ID = new Identifier("minecraft", "entities/hoglin");
        final Identifier PIGLIN_LOOT_TABLE_ID = new Identifier("minecraft", "entities/piglin");
        final Identifier BLAZE_LOOT_TABLE_ID = new Identifier("minecraft", "entities/blaze");

        // Actual code
 
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
        if (GHAST_LOOT_TABLE_ID.equals(id)) {
            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .withRolls(BinomialLootTableRange.create(1, 0.3f))
            .withEntry(ItemEntry.builder(ItemReg.MAGMA_SHARD));

            supplier.withPool(poolBuilder);
        } else if (HOGLIN_LOOT_TABLE_ID.equals(id)) {
            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .withRolls(BinomialLootTableRange.create(1, 0.3f))
            .withEntry(ItemEntry.builder(ItemReg.MAGMA_SHARD));

            supplier.withPool(poolBuilder);
        } else if (PIGLIN_LOOT_TABLE_ID.equals(id)) {
            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .withRolls(BinomialLootTableRange.create(1, 0.3f))
            .withEntry(ItemEntry.builder(ItemReg.MAGMA_SHARD));

            supplier.withPool(poolBuilder);
        } else if (BLAZE_LOOT_TABLE_ID.equals(id)) {
            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            .withRolls(BinomialLootTableRange.create(1, 0.3f))
            .withEntry(ItemEntry.builder(ItemReg.MAGMA_SHARD));

            supplier.withPool(poolBuilder);
        }
        });
    }
}
