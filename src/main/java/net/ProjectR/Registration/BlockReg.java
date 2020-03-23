package net.ProjectR.Registration;

import net.ProjectR.Blocks.DenseCoal;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockReg {
    public static final DenseCoal DENSE_COAL = new DenseCoal(Block.Settings.of(Material.STONE));
    
    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("projectr", "dense_coal"), new BlockItem(DENSE_COAL, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

    }
}
