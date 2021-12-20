package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class BatWingItem extends Item
{
    public BatWingItem()
    {
        super(new Properties().tab(PumpkinFeverItemGroup.getInstance()).rarity(Rarity.RARE));
        setRegistryName("bat_wing");
    }
}
