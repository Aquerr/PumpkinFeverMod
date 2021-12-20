package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;

public class LollipopItem extends Item
{
    public LollipopItem()
    {
        super(new Properties().food(ModFoods.LOLLIPOP).tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("lollipop");
    }
}
