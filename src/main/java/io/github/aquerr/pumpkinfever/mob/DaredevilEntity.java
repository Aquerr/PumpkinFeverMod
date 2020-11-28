package io.github.aquerr.pumpkinfever.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.world.World;

public class DaredevilEntity extends HorseEntity
{
    public static final String REGISTRY_NAME = "daredevil";

    public DaredevilEntity(EntityType<? extends HorseEntity> type, World worldIn)
    {
        super(type, worldIn);
    }
}
