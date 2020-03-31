package net.ProjectR.Registration;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockReg {
    public static final Block BLUESHROOMLIGHT = new Block(AbstractBlock.Settings.of(Material.ORGANIC, MaterialColor.BLUE).strength(1.0F).sounds(BlockSoundGroup.SHROOMLIGHT).lightLevel(blockStatex -> {
        return 15;
    }));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("projectr", "blueshroomlight"), new BlockItem(BLUESHROOMLIGHT, new Item.Settings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.BLOCK, new Identifier("projectr", "blueshroomlight"), BLUESHROOMLIGHT);
    }
}
