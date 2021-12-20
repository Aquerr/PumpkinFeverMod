package io.github.aquerr.pumpkinfever.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods
{
    public static final FoodProperties CANDY_BASKET = new FoodProperties.Builder().nutrition(8).saturationMod(0.8F).build();
    public static final FoodProperties LOLLIPOP = new FoodProperties.Builder().nutrition(2).saturationMod(0.2F).build();
    public static final FoodProperties PUMPKIN_FRIES = new FoodProperties.Builder().nutrition(2).saturationMod(0.15F).build();
    public static final FoodProperties PUMPKIN_SOUP_CREAM = new FoodProperties.Builder().nutrition(8).saturationMod(0.6F).build();

    // Duration = 600
    // Amplifier = 0
    // Probability 0.8F
    public static final FoodProperties BAT_FLESH = new FoodProperties.Builder().nutrition(3).saturationMod(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.8F).meat().build();
}
