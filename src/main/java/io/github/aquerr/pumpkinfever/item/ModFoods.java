package io.github.aquerr.pumpkinfever.item;

import net.minecraft.item.Food;

public class ModFoods
{
    public static final Food CANDY_BASKET = new Food.Builder().hunger(8).saturation(0.8F).build();
    public static final Food CANDY = new Food.Builder().hunger(2).saturation(0.2F).build();
    public static final Food PUMPKIN_FRIES = new Food.Builder().hunger(2).saturation(0.15F).build();
    public static final Food PUMPKIN_SOUP_CREAM = new Food.Builder().hunger(8).saturation(0.6F).build();
}
