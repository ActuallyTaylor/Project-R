package net.ProjectR.Leveling;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.data.Alignment;
import net.ProjectR.ProjectR;
import net.ProjectR.mixin.playerHook;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.MinecraftClientGame;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.MessageType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

@Environment(EnvType.CLIENT)
public class upgradeLevel extends LightweightGuiDescription{

    private MinecraftClient client;

    public upgradeLevel() {
        client = MinecraftClient.getInstance();
        Player player = ProjectR.currPlayer;
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(180,90);

        Runnable fightRun = new Runnable() {
            public void run() {
                player.fightingLevel ++;
                closeScreen();
            }
        };

        Runnable mineRun = new Runnable() {
            public void run() {
                player.miningLevel ++;
                closeScreen();
            }
        };

        Runnable explorRun = new Runnable() {
            public void run() {
                player.explorationLevel ++;
                closeScreen();
            }
        };

        Runnable craftRun = new Runnable() {
            public void run() {
                player.craftingLevel ++;
                closeScreen();
            }
        };

        Runnable smithRun = new Runnable() {
            public void run() {
                player.smithingLevel ++;
                closeScreen();
            }
        };

        Runnable farmRun = new Runnable() {
            public void run() {
                player.farmingLevel ++;
                closeScreen();
            }
        };

        Runnable tradeRun = new Runnable() {
            public void run() {
                player.tradingLevel ++;
                closeScreen();
            }
        };

        WLabel Title = new WLabel(new LiteralText("Pick a skill to level up"));
        Title.setAlignment(Alignment.CENTER);
        root.add(Title, 5, 0,3,2);

        WButton upgradeFightButton = new WButton(new TranslatableText("gui.projectr.fightButton"));
        root.add(upgradeFightButton, 0, 1, 6, 1);
        upgradeFightButton.setOnClick(fightRun);

        WButton upgradMiningButton = new WButton(new TranslatableText("gui.projectr.miningButton"));
        root.add(upgradMiningButton, 0, 3, 6, 1);
        upgradMiningButton.setOnClick(mineRun);

        WButton upgradeExplorationButton = new WButton(new TranslatableText("gui.projectr.explorationButton"));
        root.add(upgradeExplorationButton, 0, 5, 6, 1);
        upgradeExplorationButton.setOnClick(explorRun);

        WButton upgradeCraftingButton = new WButton(new TranslatableText("gui.projectr.craftingButton"));
        root.add(upgradeCraftingButton, 0, 7, 6, 1);
        upgradeCraftingButton.setOnClick(craftRun);

        WButton upgradeSmithingButton = new WButton(new TranslatableText("gui.projectr.smithingButton"));
        root.add(upgradeSmithingButton, 7, 1, 6, 1);
        upgradeSmithingButton.setOnClick(smithRun);

        WButton upgradeFarmingButton = new WButton(new TranslatableText("gui.projectr.farmingButton"));
        root.add(upgradeFarmingButton, 7, 3, 6, 1);
        upgradeFarmingButton.setOnClick(farmRun);

        WButton upgradeTradingButton = new WButton(new TranslatableText("gui.projectr.tradingButton"));
        root.add(upgradeTradingButton, 7, 5, 6, 1);
        upgradeTradingButton.setOnClick(tradeRun);

        root.validate(this);
    }

    public void closeScreen() {
        this.client.openScreen((Screen)null);
    }
}