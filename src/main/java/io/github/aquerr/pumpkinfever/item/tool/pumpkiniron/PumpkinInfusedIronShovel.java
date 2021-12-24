package io.github.aquerr.pumpkinfever.item.tool.pumpkiniron;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tiers;

public class PumpkinInfusedIronShovel extends ShovelItem
{
    public PumpkinInfusedIronShovel()
    {
        super(Tiers.DIAMOND, 1.5F, -3.0F, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_infused_iron_shovel");
    }
}
