package net.ProjectR.Leveling;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import net.minecraft.text.LiteralText;

public class levelHudGui extends LightweightGuiDescription {
    public levelHudGui() {
        WGridPanel root = new WGridPanel();
        setRootPanel(root);
        root.setSize(100, 100);
        WLabel label = new WLabel(new LiteralText("Level"));
        root.add(label, 0, 1, 1, 1);
    }
}