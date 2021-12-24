package io.github.aquerr.pumpkinfever.mob;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class PumpkinpoEntity extends Monster
{
    public static final String REGISTRY_NAME = "pumpkinpo";

    public PumpkinpoEntity(EntityType<? extends Monster> type, Level level)
    {
        super(type, level);
    }


    public static AttributeSupplier.Builder createMobAttributes()
    {
        return Monster.createMobAttributes().add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.FOLLOW_RANGE, 35.0D);
    }

    @Override
    public MobType getMobType()
    {
        return MobType.UNDEFINED;
    }
}
