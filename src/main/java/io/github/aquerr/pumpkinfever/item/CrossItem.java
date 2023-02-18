package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;

public class CrossItem extends Item
{
    public static final String REGISTRY_NAME = "cross";

    public CrossItem()
    {
        super(new Properties().tab(PumpkinFeverItemGroup.getInstance()).rarity(Rarity.UNCOMMON).setNoRepair().durability(20));
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext)
    {
        return super.useOn(useOnContext);
    }
}
