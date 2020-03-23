package net.ProjectR.Items;

import com.google.common.base.Supplier;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum CustomTool implements ToolMaterial {
    PRISMARINE(3, 1650, 9.0F, 3.0F, 22, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.PRISMARINE_SHARD});
    }),
    MAGMA(3, 1600, 9.0F, 3.0F, 22, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.MAGMA_BLOCK});
    });
  
    private final int durabilty;
    private final float attackDamage;
    private final int miningLevel;
    private final float miningSpeed;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private CustomTool(final int miningLevel, final int itemDurability, final float miningSpeed, final float attackDamage, final int enchantibility, final Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.durabilty = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantibility;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.durabilty;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
    
}