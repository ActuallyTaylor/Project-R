package net.ProjectR.Registration;

import net.ProjectR.Leveling.levelBaseScreen;
import net.ProjectR.Leveling.levelGUI;
import net.ProjectR.Leveling.upgradeLevel;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import net.minecraft.world.World;


public class KeyReg {

    public static void register() {
        FabricKeyBinding keyBinding = FabricKeyBinding.Builder.create(new Identifier("projectr", "skill_bind"), InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_P, "ProjectR Keybinds").build();
        KeyBindingRegistry.INSTANCE.addCategory("ProjectR Keybinds");
        KeyBindingRegistry.INSTANCE.register(keyBinding);

        FabricKeyBinding levelUP = FabricKeyBinding.Builder.create(new Identifier("projectr", "level_bind"), InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_O, "ProjectR Keybinds").build();
        KeyBindingRegistry.INSTANCE.addCategory("ProjectR Keybinds");
        KeyBindingRegistry.INSTANCE.register(levelUP);

        ClientTickCallback.EVENT.register(e ->
        {
            if(keyBinding.isPressed()) {
                World world = MinecraftClient.getInstance().world;
                if(world.isClient) {
                    MinecraftClient.getInstance().openScreen(new levelBaseScreen(new levelGUI()));
                }
            }
            if(levelUP.isPressed()) {
                World world = MinecraftClient.getInstance().world;
                if(world.isClient) {
                    MinecraftClient.getInstance().openScreen(new levelBaseScreen(new upgradeLevel()));
                }
            }
        });
    }
}
