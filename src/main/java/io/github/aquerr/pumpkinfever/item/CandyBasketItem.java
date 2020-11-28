package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.item.Item;

public class CandyBasketItem extends Item
{
    public CandyBasketItem()
    {
        super(new Properties().food(PumpkinFever.Foods.CANDY_BASKET).group(PumpkinFever.ITEM_GROUP));
        setRegistryName("candy_basket");
    }
}
