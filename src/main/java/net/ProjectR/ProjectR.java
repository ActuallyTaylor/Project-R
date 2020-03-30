package net.ProjectR;

import net.fabricmc.api.ModInitializer;

import net.ProjectR.LootTables.NetherMobs;
import net.ProjectR.Registration.ArmorReg;
import net.ProjectR.Registration.BiomeReg;
import net.ProjectR.Registration.BlockReg;
import net.ProjectR.Registration.ItemReg;
import net.ProjectR.Registration.StructureReg;
import net.ProjectR.Registration.ToolReg;

public class ProjectR implements ModInitializer {

  @Override
    public void onInitialize() {
        //Register Armor
        ArmorReg.register();
        
        //Register Tools
        ToolReg.register();

        //Register Items
        ItemReg.register();

        //Load Blocks
        BlockReg.register();
        
        //Load Loot Tables
        NetherMobs.insertLootTable();

        //Load Structures
        StructureReg.register();

        //Load Biomes
        BiomeReg.register();

      }
}
