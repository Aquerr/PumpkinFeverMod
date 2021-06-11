package io.github.aquerr.pumpkinfever.mob;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.EnumSet;
import java.util.List;

public class DaredevilEntity extends HorseEntity
{
    public static final String REGISTRY_NAME = "daredevil";

    private Goal nearestAttackablePlayerGoal;

    public DaredevilEntity(EntityType<? extends HorseEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RunAroundLikeCrazyGoal(this, 1.2D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 0.7D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));

        this.nearestAttackablePlayerGoal = new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true);

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setCallsForHelp(MonsterEntity.class));
        this.targetSelector.addGoal(2, nearestAttackablePlayerGoal);
    }

    public static AttributeModifierMap getAttributes()
    {
        return func_234237_fg_().createMutableAttribute(Attributes.FOLLOW_RANGE, 35.0D).createMutableAttribute(Attributes.ATTACK_DAMAGE, 2).create();
    }

    @Override
    public void livingTick()
    {
        super.livingTick();

        if (this.world.isRemote)
        {
            for(int i = 0; i < 2; ++i)
            {
                if (this.rand.nextInt(50) <= 24) {
                    this.world.addParticle(ParticleTypes.SMOKE, this.getPosXRandom(0.5D), this.getPosYRandom(), this.getPosZRandom(0.5D), 0.0D, 0.0D, 0.0D);
                }

                if (isBeingRidden())
                {
                    if (this.rand.nextInt(100) <= 40)
                    {
//                        this.world.addParticle(ParticleTypes.FLAME,
//                                this.getPosXRandom(0.4D) + Math.cos(Math.toRadians(this.getYaw(0) + 270)),
//                                this.getPosYHeight(0.2D),
//                                this.getPosZRandom(0.4D) + Math.sin(Math.toRadians(this.getYaw(0) + 270)),
//                                0.0D,
//                                0.0D,
//                                0.0D);
                        this.world.addParticle(ParticleTypes.FLAME,
//                                this.getPosXRandom(0.6D) + Math.cos(Math.toRadians(this.getYaw(0) + 270)),
                                this.getPosXRandom(0.6D),
                                this.getPosYHeight(0.2D),
                                this.getPosZRandom(0.6D),
//                                this.getPosZRandom(0.6D) + Math.sin(Math.toRadians(this.getYaw(0) + 270)),
                                0.0D,
                                0.0D,
                                0.0D);
                    }
                }
            }
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn)
    {
        return super.attackEntityAsMob(entityIn);
    }

    @Override
    public void setRevengeTarget(@Nullable LivingEntity livingBase)
    {
        if (livingBase instanceof PlayerEntity && livingBase.getUniqueID().equals(getOwnerUniqueId()))
        {
            return;
        }

        super.setRevengeTarget(livingBase);
    }

    @Override
    public boolean setTamedBy(PlayerEntity player)
    {
        modifyGoalsAfterTaming(player);
        return super.setTamedBy(player);
    }

    @Override
    public boolean canMateWith(AnimalEntity otherAnimal)
    {
        return false;
    }

    @Override
    public boolean canBreed()
    {
        return false;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return new ResourceLocation("minecraft:horse");
    }

    private void modifyGoalsAfterTaming(PlayerEntity tamedByPlayer)
    {
//        this.goalSelector.addGoal(6, new FollowOwnerGoal(tamedByPlayer, 1.0D, 10.0F, 2.0F, false));

        this.targetSelector.removeGoal(nearestAttackablePlayerGoal);
        this.targetSelector.addGoal(1, new DefendOwnerPlayerGoal(this, tamedByPlayer));
    }


    public class DefendOwnerPlayerGoal extends TargetGoal {
        private final DaredevilEntity daredevilEntity;
        private LivingEntity owner;
        private LivingEntity aggressor;
        private final EntityPredicate distancePredicate = (new EntityPredicate()).setDistance(16.0D);

        public DefendOwnerPlayerGoal(DaredevilEntity daredevilEntity, LivingEntity livingEntity) {
            super(daredevilEntity, false, true);
            this.daredevilEntity = daredevilEntity;
            this.owner = livingEntity;
            this.setMutexFlags(EnumSet.of(Goal.Flag.TARGET));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {

            AxisAlignedBB axisalignedbb = this.daredevilEntity.getBoundingBox().grow(10.0D, 8.0D, 10.0D);
            List<LivingEntity> list = this.daredevilEntity.world.getTargettableEntitiesWithinAABB(LivingEntity.class, this.distancePredicate, this.daredevilEntity, axisalignedbb);

            LivingEntity aggressor = owner.getRevengeTarget();

            for(LivingEntity livingentity : list)
            {
                if (aggressor != daredevilEntity && livingentity == aggressor)
                {
                    this.aggressor = livingentity;
                    break;
                }
            }

            if (aggressor == null)
            {
                return false;
            }
            else
            {
                if (!(this.owner instanceof PlayerEntity))
                    return true;
                else return !this.owner.isSpectator() && !((PlayerEntity) this.owner).isCreative();
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.daredevilEntity.setAttackTarget(this.aggressor);
            super.startExecuting();
        }
    }
}
