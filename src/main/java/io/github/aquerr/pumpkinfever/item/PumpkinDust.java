package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class PumpkinDust extends Item
{
    public static final String REGISTRY_NAME = "pumpkin_dust";

    public PumpkinDust()
    {
        super(new Properties().stacksTo(64).setNoRepair().rarity(Rarity.COMMON).tab(PumpkinFeverItemGroup.getInstance()));
    }
}
