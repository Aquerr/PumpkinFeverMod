package io.github.aquerr.pumpkinfever.item.food;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LollipopItem extends Item
{
    public static final String REGISTRY_NAME = "lollipop";

    public LollipopItem()
    {
        super(new Properties().food(ModFoods.LOLLIPOP).tab(PumpkinFeverItemGroup.getInstance()));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity)
    {
        itemStack = super.finishUsingItem(itemStack, level, livingEntity);
        return itemStack;
    }
}
