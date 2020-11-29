package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.item.Item;

public class PumpkinSoupCreamItem extends Item
{
    public PumpkinSoupCreamItem()
    {
        super(new Properties().food(ModFoods.PUMPKIN_SOUP_CREAM).group(PumpkinFever.ITEM_GROUP));
        setRegistryName("pumpkin_soup_cream");
    }
}
