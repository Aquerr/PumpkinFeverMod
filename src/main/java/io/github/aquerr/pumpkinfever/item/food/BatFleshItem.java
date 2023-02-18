package io.github.aquerr.pumpkinfever.item.food;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;

public class BatFleshItem extends Item
{
    public static final String REGISTRY_NAME = "bat_flesh";

    public BatFleshItem()
    {
        super(new Properties().food(ModFoods.BAT_FLESH).tab(PumpkinFeverItemGroup.getInstance()));
    }
}
