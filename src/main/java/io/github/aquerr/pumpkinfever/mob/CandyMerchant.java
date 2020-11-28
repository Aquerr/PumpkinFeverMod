package io.github.aquerr.pumpkinfever.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.world.World;

public class CandyMerchant extends VillagerEntity
{
    public static final String REGISTRY_NAME = "candy_merchant";

    public CandyMerchant(EntityType<? extends VillagerEntity> type, World worldIn)
    {
        super(type, worldIn);
    }
}
