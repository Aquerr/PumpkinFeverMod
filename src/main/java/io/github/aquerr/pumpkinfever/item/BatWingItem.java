package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class BatWingItem extends Item
{
    public static final String REGISTRY_NAME = "bat_wing";

    public BatWingItem()
    {
        super(new Properties().tab(PumpkinFeverItemGroup.getInstance()).rarity(Rarity.RARE));
    }
}
