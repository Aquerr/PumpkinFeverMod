package io.github.aquerr.pumpkinfever.item.tool;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class PumpkinIronSword extends SwordItem
{
    public PumpkinIronSword()
    {
        super(Tiers.IRON, 2, -2.0f, new Item.Properties().tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_iron_sword");
    }
}
