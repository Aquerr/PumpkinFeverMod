package io.github.aquerr.pumpkinfever.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class PumpkinnoEntity extends MonsterEntity
{
    public static final String REGISTRY_NAME = "pumpkinno";

    public PumpkinnoEntity(EntityType<? extends MonsterEntity> type, World worldIn)
    {
        super(type, worldIn);
    }
}
