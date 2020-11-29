package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.item.Item;

public class PumpkinFriesItem extends Item
{
    public PumpkinFriesItem()
    {
        super(new Properties().food(ModFoods.PUMPKIN_FRIES).group(PumpkinFever.ITEM_GROUP));
        setRegistryName("pumpkin_fries");
    }
}
