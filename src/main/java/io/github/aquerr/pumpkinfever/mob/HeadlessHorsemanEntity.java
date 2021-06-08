package io.github.aquerr.pumpkinfever.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class HeadlessHorsemanEntity extends MonsterEntity
{
    public static final String REGISTRY_NAME = "headless_horseman";

    public HeadlessHorsemanEntity(EntityType<? extends MonsterEntity> type, World worldIn)
    {
        super(type, worldIn);
    }
}
