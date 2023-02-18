package io.github.aquerr.pumpkinfever.item.food;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;

public class PumpkinFriesItem extends Item
{
    public static final String REGISTRY_NAME = "pumpkin_fries";

    public PumpkinFriesItem()
    {
        super(new Properties().food(ModFoods.PUMPKIN_FRIES).tab(PumpkinFeverItemGroup.getInstance()));
    }
}
