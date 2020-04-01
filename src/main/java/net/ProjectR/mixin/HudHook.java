package net.ProjectR.mixin;

import net.ProjectR.Leveling.Player;
import net.ProjectR.ProjectR;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(InGameHud.class)
public class HudHook extends DrawableHelper {
	private MinecraftClient client = MinecraftClient.getInstance();

	@Redirect(method = "renderExperienceBar(I)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;drawTexture(IIIIII)V"))
	public void shrinkXPBar(InGameHud inGameHud, int x, int y, int u, int v, int width, int height) {
		inGameHud.drawTexture(x, y, u, v, (int) (width * 0.45), height);
	}

	@Inject(at = @At("TAIL"), method = "renderExperienceBar(I)V")
	private void renderBar(int i, CallbackInfo ci) {
		Player player = ProjectR.currPlayer;

		client.getProfiler().push("expBar");
		client.getTextureManager().bindTexture(DrawableHelper.GUI_ICONS_TEXTURE);
		int need = player.neededXP;
		if (need > 0) {
			int prog = (int)player.xp;
			int scaledHeight = this.client.getWindow().getScaledHeight() - 32 + 3;
			this.drawTexture(0, prog, 30, 64, 91, 5);
			if (prog > 0) {
				this.drawTexture(0, prog, 30, 69, need, 5);
			}
		}
	}
}