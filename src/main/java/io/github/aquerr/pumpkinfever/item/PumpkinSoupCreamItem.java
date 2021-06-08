package io.github.aquerr.pumpkinfever.item;

import net.minecraft.item.Item;

public class PumpkinSoupCreamItem extends Item
{
    public PumpkinSoupCreamItem()
    {
        super(new Properties().food(ModFoods.PUMPKIN_SOUP_CREAM).group(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_soup_cream");
    }
}
