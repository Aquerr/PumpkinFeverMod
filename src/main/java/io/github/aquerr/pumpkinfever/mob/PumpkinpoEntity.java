package io.github.aquerr.pumpkinfever.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.world.World;

public class PumpkinpoEntity extends MobEntity
{
    public static final String REGISTRY_NAME = "pumpkinpo";

    public PumpkinpoEntity(EntityType<? extends MobEntity> type, World worldIn)
    {
        super(type, worldIn);
    }
}
