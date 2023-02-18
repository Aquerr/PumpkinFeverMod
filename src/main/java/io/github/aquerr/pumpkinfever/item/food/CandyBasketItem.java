package io.github.aquerr.pumpkinfever.item.food;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;

public class CandyBasketItem extends Item
{
    public static final String REGISTRY_NAME = "candy_basket";
    public CandyBasketItem()
    {
        super(new Properties().food(ModFoods.CANDY_BASKET).tab(PumpkinFeverItemGroup.getInstance()));
    }
}
