package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class PumpkinDust extends Item
{
    public PumpkinDust()
    {
        super(new Properties().maxStackSize(64).setNoRepair().rarity(Rarity.COMMON).group(PumpkinFever.ITEM_GROUP));
        setRegistryName("pumpkin_dust");
    }
}
