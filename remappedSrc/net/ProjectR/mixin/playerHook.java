package net.ProjectR.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class playerHook {

    String[] playerSkill;

    @Inject(at = @At("TAIL"),method = "writeCustomDataToTag(C)V")
	public void writeData(CompoundTag ct,CallbackInfo ci)
	{
		//ct.putInt("prLevel", this.prLevel);

	}

    @Inject(at = @At("TAIL"),method = "readCustomDataFromTag(C)V")
	public void readData(CompoundTag ct,CallbackInfo ci)
	{
		//this.prLevel = ct.getInt("prLevel");

    }
    
    @Inject(at = @At("HEAD"),method = "canMine(w,b,g)V")
	public void mineEdits(World world, BlockPos blockPos, GameMode gameMode, CallbackInfo ci)
	{
        
    }
}

