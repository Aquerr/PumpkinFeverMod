package io.github.aquerr.pumpkinfever.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.world.World;

public class HeadlessHorsemanEntity extends MonsterEntity
{
    public static final String REGISTRY_NAME = "headless_horseman";

    public HeadlessHorsemanEntity(EntityType<? extends MonsterEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public static AttributeModifierMap getAttributes()
    {
        return MobEntity.func_233666_p_().create();
    }
}
