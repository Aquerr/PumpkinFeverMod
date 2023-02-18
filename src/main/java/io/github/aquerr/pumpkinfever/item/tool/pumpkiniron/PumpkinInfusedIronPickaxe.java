package io.github.aquerr.pumpkinfever.item.tool.pumpkiniron;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;

public class PumpkinInfusedIronPickaxe extends PickaxeItem
{
    public static final String REGISTRY_NAME = "pumpkin_infused_iron_pickaxe";

    public PumpkinInfusedIronPickaxe()
    {
        super(Tiers.DIAMOND, 1, -2.8F, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
    }
}
