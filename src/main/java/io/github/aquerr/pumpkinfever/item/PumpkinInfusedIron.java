package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;

public class PumpkinInfusedIron extends Item
{
    public PumpkinInfusedIron()
    {
        super(new Properties().tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_infused_iron");
    }
}
