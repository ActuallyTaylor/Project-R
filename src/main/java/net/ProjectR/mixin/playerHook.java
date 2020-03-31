package net.ProjectR.mixin;

import net.ProjectR.Leveling.Player;
import net.ProjectR.ProjectR;
import net.minecraft.network.MessageType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundTag;

@Mixin(PlayerEntity.class)
public class playerHook {
    @Shadow @Final public PlayerScreenHandler playerScreenHandler;
    public int prLevel = 0;
	public int prXP;
	public int prNeedXP = 25;
	private boolean passed = false;
    @Inject(at = @At("TAIL"), method = "tick()V")
    private void init(final CallbackInfo info) {

    }

    @Inject(at = @At("HEAD"), method = "addExperience(I)V")
	private void addExperienceHead(int experience, CallbackInfo info) {
        //final PlayerEntity player = ((PlayerEntity) (Object) this);
		addXP(experience);
	}

    @Inject(at = @At("TAIL"),method = "writeCustomDataToTag(Lnet/minecraft/nbt/CompoundTag;)V")
	public void writeData(CompoundTag ct,CallbackInfo ci)
	{
        System.out.println("---------- Write Data ----------");
        Player player = ProjectR.currPlayer;

        ct.putInt("prLevel", this.prLevel);
		ct.putInt("prXP", this.prXP);
		ct.putInt("prNeedXP", this.prNeedXP);
        ct.putInt("craftingLevel", player.craftingLevel);
        ct.putInt("explorationLevel", player.explorationLevel);
        ct.putInt("farmingLevel", player.farmingLevel);
        ct.putInt("fightingLevel", player.fightingLevel);
        ct.putInt("miningLevel", player.miningLevel);
        ct.putInt("smithingLevel", player.smithingLevel);
        ct.putInt("tradingLevel", player.tradingLevel);

    }

    @Inject(at = @At("TAIL"),method = "readCustomDataFromTag(Lnet/minecraft/nbt/CompoundTag;)V")
	public void readData(CompoundTag ct,CallbackInfo ci)
	{
	    System.out.println("---------- Read Data ----------");
	    Player player = ProjectR.currPlayer;

        this.prLevel = ct.getInt("prLevel");
		this.prXP = ct.getInt("prXP");
		if(ct.getInt("prNeedXp") == 0) {
            this.prNeedXP = 25;
        } else {
            this.prNeedXP = ct.getInt("prNeedXp");
        }
		player.craftingLevel = ct.getInt("craftingLevel");
        player.explorationLevel = ct.getInt("explorationLevel");
        player.farmingLevel = ct.getInt("farmingLevel");
        player.fightingLevel = ct.getInt("fightingLevel");
        player.miningLevel = ct.getInt("miningLevel");
        player.smithingLevel = ct.getInt("smithingLevel");
        player.tradingLevel = ct.getInt("tradingLevel");

        updatePlayer();
	}

	public void updatePlayer() {
        Player player = ProjectR.currPlayer;

        player.xp = prXP;
        player.neededXP = prNeedXP;
        player.level = prLevel;

    }

    public void addXP(int xp) {
        this.prXP += xp;
        if(prXP > prNeedXP) {
            prNeedXP = formula(prNeedXP);
            levelUp();
        }
        updatePlayer();
    }

    public void levelUp() {
        if (prLevel <= 20) {
            if (prLevel < prLevel + 1 && !passed) {
                passed = true;
                prLevel++;
                prNeedXP = formula(prNeedXP);
                LiteralText level = new LiteralText(Integer.toString(prLevel));
                level.setStyle(new Style().setColor(Formatting.BLUE));
                ((ServerPlayerEntity) ((PlayerEntity) (Object) this)).sendChatMessage(
                        new LiteralText("Congratulations! You have reached level ").append(level), MessageType.GAME_INFO);
                passed = false;
                updatePlayer();
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