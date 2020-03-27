package net.ProjectR.Registration;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemReg {
    //Magma
    public static final Item MAGMA_SHARD = new Item(new Item.Settings().group(ItemGroup.MISC));
    
    //Crying Obsidian
    public static final Item CRYING_OBSIDIAN_SHARD = new Item(new Item.Settings().group(ItemGroup.MISC));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("projectr", "magma_shard"), MAGMA_SHARD);
        Registry.register(Registry.ITEM, new Identifier("projectr", "crying_obsidian_shard"), CRYING_OBSIDIAN_SHARD);

    }
}
