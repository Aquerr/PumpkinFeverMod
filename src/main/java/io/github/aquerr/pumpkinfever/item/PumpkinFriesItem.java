package io.github.aquerr.pumpkinfever.item;

import net.minecraft.item.Item;

public class PumpkinFriesItem extends Item
{
    public PumpkinFriesItem()
    {
        super(new Properties().food(ModFoods.PUMPKIN_FRIES).group(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_fries");
    }
}
