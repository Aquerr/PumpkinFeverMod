package io.github.aquerr.pumpkinfever.item;

import net.minecraft.item.Item;

public class CandyItem extends Item
{
    public CandyItem()
    {
        super(new Properties().food(ModFoods.CANDY).group(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("candy");
    }
}
