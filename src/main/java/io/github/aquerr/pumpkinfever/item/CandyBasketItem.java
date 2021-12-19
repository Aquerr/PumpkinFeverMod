package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;

public class CandyBasketItem extends Item
{
    public CandyBasketItem()
    {
        super(new Properties().food(ModFoods.CANDY_BASKET).tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("candy_basket");
    }
}
