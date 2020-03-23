package net.ProjectR.Registration;

import net.ProjectR.Items.AxeBase;
import net.ProjectR.Items.CustomTool;
import net.ProjectR.Items.HoeBase;
import net.ProjectR.Items.PickaxeBase;
import net.ProjectR.Items.ShovelBase;
import net.ProjectR.Items.SwordBase;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ToolReg {
    // Prismarine
    public static final Item PRISMARINE_PICKAXE = new PickaxeBase(CustomTool.PRISMARINE, 1, -2.8f);
    public static final Item PRISMARINE_SWORD = new SwordBase(CustomTool.PRISMARINE, 3, -2.4f);
    public static final Item PRISMARINE_SHOVEL = new ShovelBase(CustomTool.PRISMARINE, 1.5f, -3.0f);
    public static final Item PRISMARINE_AXE = new AxeBase(CustomTool.PRISMARINE, 6, -3.1f);
    public static final Item PRISMARINE_HOE = new HoeBase(CustomTool.PRISMARINE, -2, -1f);
    
    //Magma
    public static final Item MAGMA_PICKAXE = new PickaxeBase(CustomTool.MAGMA, 1, -2.8f);
    public static final Item MAGMA_SWORD = new SwordBase(CustomTool.MAGMA, 3, -2.4f);
    public static final Item MAGMA_SHOVEL = new ShovelBase(CustomTool.MAGMA, 1.5f, -3.0f);
    public static final Item MAGMA_AXE = new AxeBase(CustomTool.MAGMA, 6, -3.1f);
    public static final Item MAGMA_HOE = new HoeBase(CustomTool.MAGMA, -2, -1f);
    
    public static void register() {
        // Prismarine
        Registry.register(Registry.ITEM, new Identifier("projectr", "prismarine_pickaxe"), PRISMARINE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("projectr", "prismarine_sword"), PRISMARINE_SWORD);
        Registry.register(Registry.ITEM, new Identifier("projectr", "prismarine_shovel"), PRISMARINE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("projectr", "prismarine_axe"), PRISMARINE_AXE);
        Registry.register(Registry.ITEM, new Identifier("projectr", "prismarine_hoe"), PRISMARINE_HOE);
    
        //Magma
        Registry.register(Registry.ITEM, new Identifier("projectr", "magma_pickaxe"), MAGMA_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("projectr", "magma_sword"), MAGMA_SWORD);
        Registry.register(Registry.ITEM, new Identifier("projectr", "magma_shovel"), MAGMA_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("projectr", "magma_axe"), MAGMA_AXE);
        Registry.register(Registry.ITEM, new Identifier("projectr", "magma_hoe"), MAGMA_HOE);
    }
}