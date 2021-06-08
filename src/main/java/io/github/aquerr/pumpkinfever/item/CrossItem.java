package io.github.aquerr.pumpkinfever.item;

import net.minecraft.item.Item;
import net.minecraft.item.Rarity;

public class CrossItem extends Item
{
    public CrossItem()
    {
        super(new Properties().group(PumpkinFeverItemGroup.getInstance()).rarity(Rarity.UNCOMMON).setNoRepair().maxDamage(20));
        setRegistryName("cross");
    }
}
