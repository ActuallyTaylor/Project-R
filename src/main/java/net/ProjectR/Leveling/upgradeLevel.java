package net.ProjectR.Leveling;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.data.Alignment;
import net.ProjectR.ProjectR;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;

public class upgradeLevel extends LightweightGuiDescription{

    public upgradeLevel() {
        Player player = ProjectR.currPlayer;
        WGridPanel root = new WGridPanel();
        setRootPanel(root);

        root.setSize(180,90);

        WLabel Title = new WLabel(new LiteralText("Pick a skill to level up"));
        Title.setAlignment(Alignment.CENTER);
        root.add(Title, 5, 0,2,2);

        WButton upgradeFightButton = new WButton(new TranslatableText("gui.projectr.fightButton"));
        root.add(upgradeFightButton, 0, 1, 6, 1);

        WButton upgradMiningButton = new WButton(new TranslatableText("gui.projectr.miningButton"));
        root.add(upgradMiningButton, 0, 3, 6, 1);

        WButton upgradeExplorationButton = new WButton(new TranslatableText("gui.projectr.explorationButton"));
        root.add(upgradeExplorationButton, 0, 5, 6, 1);

        WButton upgradeCraftingButton = new WButton(new TranslatableText("gui.projectr.craftingButton"));
        root.add(upgradeCraftingButton, 3, 7, 6, 1);

        WButton upgradeSmithingButton = new WButton(new TranslatableText("gui.projectr.smithingButton"));
        root.add(upgradeSmithingButton, 7, 1, 6, 1);

        WButton upgradeFarmingButton = new WButton(new TranslatableText("gui.projectr.farmingButton"));
        root.add(upgradeFarmingButton, 7, 3, 6, 1);

        WButton upgradeTradingButton = new WButton(new TranslatableText("gui.projectr.tradingButton"));
        root.add(upgradeTradingButton, 7, 5, 6, 1);

//        WLabel MiningLabel = new WLabel(new LiteralText("Mining Skill: " + player.miningLevel));
//        root.add(MiningLabel, 0, 2,2,1);
//
//        WLabel ExplorationLabel = new WLabel(new LiteralText("Exploration Skill: " + player.explorationLevel));
//        root.add(ExplorationLabel, 0, 3,2,1);
//
//        WLabel CraftingLabel = new WLabel(new LiteralText("Crafting Skill: " + player.craftingLevel));
//        root.add(CraftingLabel, 0, 4,2,1);
//
//        WLabel SmithingLabel = new WLabel(new LiteralText("Smithing Skill: " + player.smithingLevel));
//        root.add(SmithingLabel, 0, 5,2,1);
//
//        WLabel FarmingLabel = new WLabel(new LiteralText("Farming Skill: " + player.farmingLevel));
//        root.add(FarmingLabel, 0, 6,2,1);
//
//        WLabel TradingLabel = new WLabel(new LiteralText("Trading Skill: " + player.tradingLevel));
//        root.add(TradingLabel, 0, 7,2,1);
//
//        WLabel xpLabel = new WLabel(new LiteralText("XP: " + player.xp + "/" + player.neededXP));
//        root.add(xpLabel, 2, 8,2,1);
//
//        WLabel xpLevel = new WLabel(new LiteralText("Level: " + player.level));
//        root.add(xpLevel, 5, 8,2,1);

        root.validate(this);
    }

}