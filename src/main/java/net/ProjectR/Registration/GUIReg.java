package net.ProjectR.Registration;

import net.ProjectR.Leveling.levelHudGui;
import net.ProjectR.Leveling.levelHudScreen;
import net.minecraft.client.MinecraftClient;

public class GUIReg {
    public static void register() {
        MinecraftClient.getInstance().openScreen(new levelHudScreen(new levelHudGui()));
    }
}
