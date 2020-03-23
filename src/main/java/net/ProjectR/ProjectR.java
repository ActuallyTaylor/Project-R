package net.ProjectR;

import net.fabricmc.api.ModInitializer;

import net.ProjectR.Registration.ToolReg;
import net.ProjectR.LootTables.NetherMobs;
import net.ProjectR.Registration.ArmorReg;
import net.ProjectR.Registration.BlockReg;
import net.ProjectR.Registration.FeatureReg;
import net.ProjectR.Registration.ItemReg;

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

        //Load Biomes
        FeatureReg.register();


    }
}
