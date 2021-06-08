package io.github.aquerr.pumpkinfever.item;

import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class PumpkinDust extends Item
{
    public PumpkinDust()
    {
        super(new Properties().maxStackSize(64).setNoRepair().rarity(Rarity.COMMON).group(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_dust");
    }
}
