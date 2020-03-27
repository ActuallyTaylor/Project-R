package net.ProjectR.mixin;

import net.ProjectR.Registration.ArmorReg;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class TickHook {

	@Inject(at = @At("TAIL"), method = "tick()V")
	private void init(final CallbackInfo info) {
      final PlayerEntity player = ((PlayerEntity) (Object) this);
      final ItemStack helmet = player.getEquippedStack(EquipmentSlot.HEAD);
      final ItemStack chestplate = player.getEquippedStack(EquipmentSlot.CHEST);
      final ItemStack leggings = player.getEquippedStack(EquipmentSlot.LEGS);
      final ItemStack boots = player.getEquippedStack(EquipmentSlot.FEET);

      if (helmet.getItem() == ArmorReg.PRISMARINE_HELMET && chestplate.getItem() == ArmorReg.PRISMARINE_CHESTPLATE && leggings.getItem() == ArmorReg.PRISMARINE_LEGGINGS && boots.getItem() == ArmorReg.PRISMARINE_BOOTS) {
          player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING,10, 0, false, false, true));
      }
        
      if (helmet.getItem() == ArmorReg.MAGMA_HELMET && chestplate.getItem() == ArmorReg.MAGMA_CHESTPLATE && leggings.getItem() == ArmorReg.MAGMA_LEGGINGS && boots.getItem() == ArmorReg.MAGMA_BOOTS) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,10, 0, false, false, true));
      }
    }
}
