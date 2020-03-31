package net.ProjectR.mixin;

import net.minecraft.network.MessageType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;

@Mixin(PlayerEntity.class)
public class experienceHook {
    public int prLevel = 0;
	public int prXP;
	public int prNeedXP = 25;
	private boolean passed = false;

    @Inject(at = @At("HEAD"), method = "addExperience(I)V")
	private void addExperienceHead(int experience, CallbackInfo info) {
        //final PlayerEntity player = ((PlayerEntity) (Object) this);
		addXP(experience);
	}

    @Inject(at = @At("TAIL"),method = "writeCustomDataToTag(Lnet/minecraft/nbt/CompoundTag;)V")
	public void writeData(CompoundTag ct,CallbackInfo ci)
	{
        ct.putInt("prLevel", this.prLevel);
		ct.putInt("prXP", this.prXP);
		ct.putInt("prNeedXP", this.prNeedXP);
	}

    @Inject(at = @At("TAIL"),method = "readCustomDataFromTag(Lnet/minecraft/nbt/CompoundTag;)V")
	public void readData(CompoundTag ct,CallbackInfo ci)
	{
        this.prLevel = 1;//ct.getInt("prLevel");
		this.prXP = 0;//ct.getInt("prXP");
		this.prNeedXP = 25;//ct.getInt("prNeedXp");
	}

    public void addXP(int xp) {
        this.prXP += xp;
        if(prXP > prNeedXP) {
            prNeedXP = formula(prNeedXP);
            levelUp();
        }
        System.out.println(prXP);
    }

    public void levelUp() {
        if(prLevel <= 20) {
            if(prLevel < prLevel + 1 && !passed) {
                passed = true;
                prLevel++;
                prNeedXP = formula(prNeedXP);
                LiteralText level = new LiteralText(Integer.toString(prLevel));
                level.setStyle(new Style().setColor(Formatting.BLUE));
                ((ServerPlayerEntity) ((PlayerEntity) (Object) this)).sendChatMessage(
                        new LiteralText("Congratulations! You have reached level ").append(level), MessageType.GAME_INFO);
                passed = false;
            }
        }
    }

    public int formula(int need) {
        if(!passed) {
            int newNeed = 0;
            double factor = 1.1;
            newNeed = (int) Math.pow(need, factor);
            System.out.println("NEW NEED: " + newNeed);
            return newNeed;
        }
        return need;
    }
}