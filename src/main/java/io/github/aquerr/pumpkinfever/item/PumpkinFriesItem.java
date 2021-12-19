package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;

public class PumpkinFriesItem extends Item
{
    public PumpkinFriesItem()
    {
        super(new Properties().food(ModFoods.PUMPKIN_FRIES).tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_fries");
    }
}
