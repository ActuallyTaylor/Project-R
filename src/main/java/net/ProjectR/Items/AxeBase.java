package net.ProjectR.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class AxeBase extends AxeItem {
    public AxeBase(ToolMaterial toolMaterial_1, int attackDamage, float attackSpeed) {
        super(toolMaterial_1, attackDamage, attackSpeed, (new Item.Settings().group(ItemGroup.TOOLS)));
    }
}