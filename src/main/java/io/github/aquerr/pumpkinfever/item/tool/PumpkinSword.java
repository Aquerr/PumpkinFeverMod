package io.github.aquerr.pumpkinfever.item.tool;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;

public class PumpkinSword extends SwordItem
{
    public PumpkinSword()
    {
        super(ItemTier.WOOD, 2, -2.0f, new Item.Properties().group(PumpkinFever.ITEM_GROUP));
    }
}
