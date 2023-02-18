package io.github.aquerr.pumpkinfever.item.tool.pumpkin;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class PumpkinSword extends SwordItem
{
    public static final String REGISTRY_NAME = "pumpkin_sword";

    public PumpkinSword()
    {
        super(Tiers.WOOD, 3, -2.4f, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
    }
}
