package net.ProjectR;

import net.ProjectR.Leveling.Player;
import net.ProjectR.Registration.*;
import net.fabricmc.api.ModInitializer;

import net.ProjectR.LootTables.NetherMobs;

public class ProjectR implements ModInitializer {

    public static Player currPlayer = new Player();

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

        //Load Keybinds
        KeyReg.register();

      }
}
