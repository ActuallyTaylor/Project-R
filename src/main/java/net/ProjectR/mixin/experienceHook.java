package net.ProjectR.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;

@Mixin(PlayerEntity.class)
public class experienceHook {
    public int prLevel;
	public int prXP;
	public int prNeedXP;

    @Inject(at = @At("HEAD"), method = "addExperience(I)V")
	private void addExperienceHead(int experience, CallbackInfo info) {
		//final PlayerEntity player = ((PlayerEntity) (Object) this);
		addXP(experience);
		
	}

    @Inject(at = @At("TAIL"),method = "writeCustomDataToTag(C)V")
	public void writeData(CompoundTag ct,CallbackInfo ci)
	{
		ct.putInt("prLevel", this.prLevel);
		ct.putInt("prXP", this.prXP);
		ct.putInt("prNeedXP", this.prNeedXP);
	}

    @Inject(at = @At("TAIL"),method = "readCustomDataFromTag(C)V")
	public void readData(CompoundTag ct,CallbackInfo ci)
	{
		this.prLevel = ct.getInt("prLevel");
		this.prXP = ct.getInt("rpXP");
		this.prNeedXP = ct.getInt("prNeedXp");
	}

    public void addXP(int xp) {
        this.prXP += xp;
        if(prXP > prNeedXP) {
            prNeedXP = formula(prNeedXP);
            levelUp();
        }
    }

    public void levelUp() {
        if(prLevel <= 20) {
            prLevel ++;
        }
    }

    public int formula(int need) {
        int newNeed = 0;
        newNeed = (int) Math.pow(need, 1.25);
        return newNeed;
    }
}