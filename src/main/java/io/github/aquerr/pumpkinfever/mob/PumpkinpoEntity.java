package io.github.aquerr.pumpkinfever.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.World;

public class PumpkinpoEntity extends MobEntity
{
    public static final String REGISTRY_NAME = "pumpkinpo";

    public PumpkinpoEntity(EntityType<? extends MobEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    public static AttributeModifierMap getAttributes()
    {
        return registerAttributes().createMutableAttribute(Attributes.FOLLOW_RANGE, 35.0D).create();
    }
}
