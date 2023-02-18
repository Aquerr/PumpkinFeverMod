package io.github.aquerr.pumpkinfever.item.food;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;

public class PumpkinSoupCreamItem extends Item
{
    public static final String REGISTRY_NAME = "pumpkin_soup_cream";

    public PumpkinSoupCreamItem()
    {
        super(new Properties().food(ModFoods.PUMPKIN_SOUP_CREAM).tab(PumpkinFeverItemGroup.getInstance()));
    }
}
