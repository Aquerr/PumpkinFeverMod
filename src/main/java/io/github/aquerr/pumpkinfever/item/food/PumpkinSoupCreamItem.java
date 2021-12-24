package io.github.aquerr.pumpkinfever.item.food;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import io.github.aquerr.pumpkinfever.item.food.ModFoods;
import net.minecraft.world.item.Item;

public class PumpkinSoupCreamItem extends Item
{
    public PumpkinSoupCreamItem()
    {
        super(new Properties().food(ModFoods.PUMPKIN_SOUP_CREAM).tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_soup_cream");
    }
}
