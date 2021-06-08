package io.github.aquerr.pumpkinfever.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class PumpkinFeverItemGroup extends ItemGroup
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
    public ItemStack createIcon()
    {
        return Items.PUMPKIN.getDefaultInstance();
    }
}
