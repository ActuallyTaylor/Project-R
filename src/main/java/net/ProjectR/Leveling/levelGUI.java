package net.ProjectR.Leveling;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.data.Alignment;
import net.ProjectR.ProjectR;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;

public class levelGUI extends LightweightGuiDescription {

    public levelGUI() {
        Player player = ProjectR.currPlayer;
        WGridPanel root = new WGridPanel();
        setRootPanel(root);

        root.setSize(180,90);

        WLabel Title = new WLabel(new LiteralText("Skill Tree"));
        Title.setAlignment(Alignment.CENTER);
        root.add(Title, 4, 0,2,2);

        WLabel FightingLabel = new WLabel(new LiteralText("Fighting Skill Level: " + player.fightingLevel));
        root.add(FightingLabel, 0, 1,2,1);

        WLabel MiningLabel = new WLabel(new LiteralText("Mining Skill: " + player.miningLevel));
        root.add(MiningLabel, 0, 2,2,1);

        WLabel ExplorationLabel = new WLabel(new LiteralText("Exploration Skill: " + player.explorationLevel));
        root.add(ExplorationLabel, 0, 3,2,1);

        WLabel CraftingLabel = new WLabel(new LiteralText("Crafting Skill: " + player.craftingLevel));
        root.add(CraftingLabel, 0, 4,2,1);

        WLabel SmithingLabel = new WLabel(new LiteralText("Smithing Skill: " + player.smithingLevel));
        root.add(SmithingLabel, 0, 5,2,1);

        WLabel FarmingLabel = new WLabel(new LiteralText("Farming Skill: " + player.farmingLevel));
        root.add(FarmingLabel, 0, 6,2,1);

        WLabel TradingLabel = new WLabel(new LiteralText("Trading Skill: " + player.tradingLevel));
        root.add(TradingLabel, 0, 7,2,1);

        WLabel xpLabel = new WLabel(new LiteralText("XP: " + player.xp + "/" + player.neededXP));
        root.add(xpLabel, 2, 8,2,1);

        WLabel xpLevel = new WLabel(new LiteralText("Level: " + player.level));
        root.add(xpLevel, 5, 8,2,1);

        root.validate(this);
    }

}
