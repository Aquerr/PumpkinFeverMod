package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;

public class PumpkinInfusedIron extends Item
{
    public static final String REGISTRY_NAME = "pumpkin_infused_iron";

    public PumpkinInfusedIron()
    {
        super(new Properties().tab(PumpkinFeverItemGroup.getInstance()));
    }
}
