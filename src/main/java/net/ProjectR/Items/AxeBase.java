package net.ProjectR.Items;

import net.minecraft.item.*;


public class AxeBase extends AxeItem {
    public AxeBase(ToolMaterial toolMaterial_1, int attackDamage, float attackSpeed) {
        super(toolMaterial_1, attackDamage, attackSpeed, (new Item.Settings().group(ItemGroup.TOOLS)));
    }
}