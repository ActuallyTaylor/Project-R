package net.ProjectR.Registration;

import net.ProjectR.Armor.CustomArmor;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ArmorReg {
    // Prismarine
    public static final Item PRISMARINE_HELMET = new ArmorItem(CustomArmor.PRISMARINE, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item PRISMARINE_CHESTPLATE = new ArmorItem(CustomArmor.PRISMARINE, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item PRISMARINE_LEGGINGS = new ArmorItem(CustomArmor.PRISMARINE, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item PRISMARINE_BOOTS = new ArmorItem(CustomArmor.PRISMARINE, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));
        
    //Magma
    public static final Item MAGMA_HELMET = new ArmorItem(CustomArmor.MAGMA, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item MAGMA_CHESTPLATE = new ArmorItem(CustomArmor.MAGMA, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item MAGMA_LEGGINGS = new ArmorItem(CustomArmor.MAGMA, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item MAGMA_BOOTS = new ArmorItem(CustomArmor.MAGMA, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));

    //Oak Wood
    public static final Item OAK_HELMET = new ArmorItem(CustomArmor.OAK_WOOD, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item OAK_CHESTPLATE = new ArmorItem(CustomArmor.OAK_WOOD, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item OAK_LEGGINGS = new ArmorItem(CustomArmor.OAK_WOOD, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item OAK_BOOTS = new ArmorItem(CustomArmor.OAK_WOOD, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));

    //Spruce Wood
    public static final Item SPRUCE_HELMET = new ArmorItem(CustomArmor.SPRUCE_WOOD, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item SPRUCE_CHESTPLATE = new ArmorItem(CustomArmor.SPRUCE_WOOD, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item SPRUCE_LEGGINGS = new ArmorItem(CustomArmor.SPRUCE_WOOD, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item SPRUCE_BOOTS = new ArmorItem(CustomArmor.SPRUCE_WOOD, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));

    //Birch Wood
    public static final Item BIRCH_HELMET = new ArmorItem(CustomArmor.BIRCH_WOOD, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item BIRCH_CHESTPLATE = new ArmorItem(CustomArmor.BIRCH_WOOD, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item BIRCH_LEGGINGS = new ArmorItem(CustomArmor.BIRCH_WOOD, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item BIRCH_BOOTS = new ArmorItem(CustomArmor.BIRCH_WOOD, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));

    //Jungle Wood
    public static final Item JUNGLE_HELMET = new ArmorItem(CustomArmor.JUNGLE_WOOD, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item JUNGLE_CHESTPLATE = new ArmorItem(CustomArmor.JUNGLE_WOOD, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item JUNGLE_LEGGINGS = new ArmorItem(CustomArmor.JUNGLE_WOOD, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item JUNGLE_BOOTS = new ArmorItem(CustomArmor.JUNGLE_WOOD, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));

    //Acacia Wood
    public static final Item ACACIA_HELMET = new ArmorItem(CustomArmor.ACACIA_WOOD, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item ACACIA_CHESTPLATE = new ArmorItem(CustomArmor.ACACIA_WOOD, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item ACACIA_LEGGINGS = new ArmorItem(CustomArmor.ACACIA_WOOD, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item ACACIA_BOOTS = new ArmorItem(CustomArmor.ACACIA_WOOD, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));
    
    //Dark Oak Wood
    public static final Item DARK_OAK_WOOD_HELMET = new ArmorItem(CustomArmor.DARK_OAK_WOOD, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item DARK_OAK_WOOD_CHESTPLATE = new ArmorItem(CustomArmor.DARK_OAK_WOOD, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item DARK_OAK_WOOD_LEGGINGS = new ArmorItem(CustomArmor.DARK_OAK_WOOD, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item DARK_OAK_WOOD_BOOTS = new ArmorItem(CustomArmor.DARK_OAK_WOOD, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));
    
    //Crying Obsidian
    public static final Item CRYING_OBSIDIAN_HELMET = new ArmorItem(CustomArmor.CRYING_OBSIDIAN, EquipmentSlot.HEAD, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item CRYING_OBSIDIAN_CHESTPLATE = new ArmorItem(CustomArmor.CRYING_OBSIDIAN, EquipmentSlot.CHEST, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item CRYING_OBSIDIAN_LEGGINGS = new ArmorItem(CustomArmor.CRYING_OBSIDIAN, EquipmentSlot.LEGS, (new Item.Settings().group(ItemGroup.COMBAT)));
    public static final Item CRYING_OBSIDIAN_BOOTS = new ArmorItem(CustomArmor.CRYING_OBSIDIAN, EquipmentSlot.FEET, (new Item.Settings().group(ItemGroup.COMBAT)));
    
    public static void register() {
        //Prismarine
        Registry.register(Registry.ITEM, new Identifier("projectr", "prismarine_helmet"), PRISMARINE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("projectr", "prismarine_chestplate"), PRISMARINE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("projectr", "prismarine_leggings"), PRISMARINE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("projectr", "prismarine_boots"), PRISMARINE_BOOTS);
    
        //Magma
        Registry.register(Registry.ITEM, new Identifier("projectr", "magma_helmet"), MAGMA_HELMET);
        Registry.register(Registry.ITEM, new Identifier("projectr", "magma_chestplate"), MAGMA_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("projectr", "magma_leggings"), MAGMA_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("projectr", "magma_boots"), MAGMA_BOOTS);

        //Oak Wood
        Registry.register(Registry.ITEM, new Identifier("projectr", "oak_helmet"), OAK_HELMET);
        Registry.register(Registry.ITEM, new Identifier("projectr", "oak_chestplate"), OAK_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("projectr", "oak_leggings"), OAK_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("projectr", "oak_boots"), OAK_BOOTS);

        //Spruce Wood
        Registry.register(Registry.ITEM, new Identifier("projectr", "spruce_helmet"), SPRUCE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("projectr", "spruce_chestplate"), SPRUCE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("projectr", "spruce_leggings"), SPRUCE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("projectr", "spruce_boots"), SPRUCE_BOOTS);

        //Birch Wood
        Registry.register(Registry.ITEM, new Identifier("projectr", "birch_helmet"), BIRCH_HELMET);
        Registry.register(Registry.ITEM, new Identifier("projectr", "birch_chestplate"), BIRCH_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("projectr", "birch_leggings"), BIRCH_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("projectr", "birch_boots"), BIRCH_BOOTS);        

        //Jungle Wood
        Registry.register(Registry.ITEM, new Identifier("projectr", "jungle_helmet"), JUNGLE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("projectr", "jungle_chestplate"), JUNGLE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("projectr", "jungle_leggings"), JUNGLE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("projectr", "jungle_boots"), JUNGLE_BOOTS); 
        
        //Acacia Wood
        Registry.register(Registry.ITEM, new Identifier("projectr", "acacia_helmet"), ACACIA_HELMET);
        Registry.register(Registry.ITEM, new Identifier("projectr", "acacia_chestplate"), ACACIA_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("projectr", "acacia_leggings"), ACACIA_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("projectr", "acacia_boots"), ACACIA_BOOTS);   
        
        //Dark Oak Wood
        Registry.register(Registry.ITEM, new Identifier("projectr", "dark_oak_helmet"), DARK_OAK_WOOD_HELMET);
        Registry.register(Registry.ITEM, new Identifier("projectr", "dark_oak_chestplate"), DARK_OAK_WOOD_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("projectr", "dark_oak_leggings"), DARK_OAK_WOOD_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("projectr", "dark_oak_boots"), DARK_OAK_WOOD_BOOTS);   

        //Crying Obsidian
        Registry.register(Registry.ITEM, new Identifier("projectr", "crying_obsidian_helmet"), CRYING_OBSIDIAN_HELMET);
        Registry.register(Registry.ITEM, new Identifier("projectr", "crying_obsidian_chestplate"), CRYING_OBSIDIAN_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("projectr", "crying_obsidian_leggings"), CRYING_OBSIDIAN_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("projectr", "crying_obsidian_boots"), CRYING_OBSIDIAN_BOOTS);   
    }
}