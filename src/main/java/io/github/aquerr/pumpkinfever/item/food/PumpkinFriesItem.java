package io.github.aquerr.pumpkinfever.item.food;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import io.github.aquerr.pumpkinfever.item.food.ModFoods;
import net.minecraft.world.item.Item;

public class PumpkinFriesItem extends Item
{
    public PumpkinFriesItem()
    {
        super(new Properties().food(ModFoods.PUMPKIN_FRIES).tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_fries");
    }
}
