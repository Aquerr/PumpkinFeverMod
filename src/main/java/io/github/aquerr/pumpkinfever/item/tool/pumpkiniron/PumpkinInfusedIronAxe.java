package io.github.aquerr.pumpkinfever.item.tool.pumpkiniron;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tiers;

public class PumpkinInfusedIronAxe extends AxeItem
{
    public PumpkinInfusedIronAxe()
    {
        super(Tiers.DIAMOND, 7.0F, -3.1F, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_infused_iron_axe");
    }
}
