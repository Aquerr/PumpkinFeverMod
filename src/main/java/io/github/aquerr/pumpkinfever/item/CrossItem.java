package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class CrossItem extends Item
{
    public CrossItem()
    {
        super(new Properties().group(PumpkinFever.ITEM_GROUP).rarity(Rarity.UNCOMMON).setNoRepair().maxDamage(20));
        setRegistryName("cross");
    }
}
