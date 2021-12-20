package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;

public class BatFleshItem extends Item
{
    public BatFleshItem()
    {
        super(new Properties().food(ModFoods.BAT_FLESH).tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("bat_flesh");
    }
}
