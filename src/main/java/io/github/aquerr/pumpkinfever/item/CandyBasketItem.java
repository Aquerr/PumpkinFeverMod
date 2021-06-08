package io.github.aquerr.pumpkinfever.item;

import net.minecraft.item.Item;

public class CandyBasketItem extends Item
{
    public CandyBasketItem()
    {
        super(new Properties().food(ModFoods.CANDY_BASKET).group(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("candy_basket");
    }
}
