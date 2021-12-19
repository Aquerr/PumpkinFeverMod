package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;

public class CandyItem extends Item
{
    public CandyItem()
    {
        super(new Properties().food(ModFoods.CANDY).tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("candy");
    }
}
