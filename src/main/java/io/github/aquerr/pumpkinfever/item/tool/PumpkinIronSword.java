package io.github.aquerr.pumpkinfever.item.tool;

import io.github.aquerr.pumpkinfever.item.PumpkinFeverItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;

public class PumpkinIronSword extends SwordItem
{
    public PumpkinIronSword()
    {
        super(ItemTier.WOOD, 2, -2.0f, new Item.Properties().group(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_iron_sword");
    }
}
