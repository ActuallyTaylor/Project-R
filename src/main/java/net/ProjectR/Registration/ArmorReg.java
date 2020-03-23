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
    }
}