package io.github.aquerr.pumpkinfever.item.tool.pumpkiniron;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tiers;

public class PumpkinInfusedIronHoe extends HoeItem
{
    public static final String REGISTRY_NAME = "pumpkin_infused_iron_hoe";

    public PumpkinInfusedIronHoe()
    {
        super(Tiers.DIAMOND, -1, -0.5F, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
    }
}
