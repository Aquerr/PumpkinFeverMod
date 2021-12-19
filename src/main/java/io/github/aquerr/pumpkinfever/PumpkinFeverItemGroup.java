package io.github.aquerr.pumpkinfever;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class PumpkinFeverItemGroup extends CreativeModeTab
{
    public static PumpkinFeverItemGroup INSTANCE;

    public static PumpkinFeverItemGroup getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new PumpkinFeverItemGroup();
        return INSTANCE;
    }

    public PumpkinFeverItemGroup()
    {
        super("pumpkinfever");
    }

    @Override
    public ItemStack makeIcon()
    {
        return Items.JACK_O_LANTERN.getDefaultInstance();
    }
}
