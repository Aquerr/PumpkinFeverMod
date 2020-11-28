package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.item.Item;

public class CandyItem extends Item
{
    public CandyItem()
    {
        super(new Properties().food(PumpkinFever.Foods.CANDY).group(PumpkinFever.ITEM_GROUP));
        setRegistryName("candy");
    }
}
