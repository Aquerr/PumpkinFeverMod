package io.github.aquerr.pumpkinfever.item.tool.pumpkiniron;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class PumpkinInfusedIronSword extends SwordItem
{
    public static final String REGISTRY_NAME = "pumpkin_infused_iron_sword";

    public PumpkinInfusedIronSword()
    {
        super(Tiers.DIAMOND, 3, -2.4f, new Item.Properties().tab(PumpkinFeverItemGroup.getInstance()));
    }
}
