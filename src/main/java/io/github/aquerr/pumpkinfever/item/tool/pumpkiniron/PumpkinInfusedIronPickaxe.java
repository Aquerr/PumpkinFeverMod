package io.github.aquerr.pumpkinfever.item.tool.pumpkiniron;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;

public class PumpkinInfusedIronPickaxe extends PickaxeItem
{
    public PumpkinInfusedIronPickaxe()
    {
        super(Tiers.DIAMOND, 1, -2.8F, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_infused_iron_pickaxe");
    }
}
