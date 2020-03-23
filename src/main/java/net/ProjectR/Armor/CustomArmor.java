package net.ProjectR.Armor;

import java.util.function.Supplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

public enum CustomArmor implements ArmorMaterial {
    PRISMARINE("prismarine", 35, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1.0F, 0.0f, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.PRISMARINE_SHARD});
    }),
    MAGMA("magma", 35, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1.0F, 0.0f, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{Items.MAGMA_BLOCK});
    });

    private final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final Lazy<Ingredient> repairIngredientSupplier;
    private final float knockbackRes;
    private final  String itemName;

    private CustomArmor(final String itemName, final int dura, final int[] protec, final int enchant, final SoundEvent soundEvent_1, final float tough, final float knockback, final Supplier<Ingredient> supplier_1) {
        this.itemName = itemName;
        this.name = this.itemName;
        this.durabilityMultiplier = dura;
        this.protectionAmounts = protec;
        this.enchantability = enchant;
        this.equipSound = soundEvent_1;
        this.toughness = tough;
        this.repairIngredientSupplier = new Lazy(supplier_1);
        this.knockbackRes = knockback;
    }

    public int getDurability(final EquipmentSlot equipmentSlot_1) {
        return BASE_DURABILITY[equipmentSlot_1.getEntitySlotId()] * this.durabilityMultiplier;
    }

    public int getProtectionAmount(final EquipmentSlot equipmentSlot_1) {
        return this.protectionAmounts[equipmentSlot_1.getEntitySlotId()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredientSupplier.get();
    }

    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackRes;
    }
}