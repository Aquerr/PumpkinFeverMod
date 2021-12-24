package io.github.aquerr.pumpkinfever.mob;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RunAroundLikeCrazyGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.EnumSet;
import java.util.List;

public class DaredevilEntity extends Horse
{
    public static final String REGISTRY_NAME = "daredevil";

    private Goal nearestAttackablePlayerGoal;

    public DaredevilEntity(EntityType<? extends Horse> type, Level worldIn)
    {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(1, new RunAroundLikeCrazyGoal(this, 1.2D));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.7D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.nearestAttackablePlayerGoal = new NearestAttackableTargetGoal<>(this, Player.class, true, (livingEntity) -> !livingEntity.getUUID().equals(getOwnerUUID()));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setAlertOthers(Monster.class));
        this.targetSelector.addGoal(2, nearestAttackablePlayerGoal);

        this.goalSelector.addGoal(0, new FloatGoal(this));
//        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25D, Ingredient.of(Items.GOLDEN_CARROT, Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE), false));
    }

    public static AttributeSupplier.Builder createMobAttributes()
    {
        return Horse.createBaseHorseAttributes().add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.ATTACK_DAMAGE, 2);
    }

    @Override
    public void tick()
    {
        super.tick();
        if (this.level.isClientSide)
        {
            for(int i = 0; i < 2; ++i)
            {
                if (this.random.nextInt(50) <= 24) {
                    this.level.addParticle(ParticleTypes.SMOKE, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), 0.0D, 0.0D, 0.0D);
                }

                if (canBeControlledByRider())
                {
                    if (this.random.nextInt(100) <= 40)
                    {
//                        this.world.addParticle(ParticleTypes.FLAME,
//                                this.getPosXRandom(0.4D) + Math.cos(Math.toRadians(this.getYaw(0) + 270)),
//                                this.getPosYHeight(0.2D),
//                                this.getPosZRandom(0.4D) + Math.sin(Math.toRadians(this.getYaw(0) + 270)),
//                                0.0D,
//                                0.0D,
//                                0.0D);
                        this.level.addParticle(ParticleTypes.FLAME,
//                                this.getPosXRandom(0.6D) + Math.cos(Math.toRadians(this.getYaw(0) + 270)),
                                this.getRandomX(0.6D),
                                this.getY(0.2D),
                                this.getRandomZ(0.6D),
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
    public boolean doHurtTarget(Entity entity)
    {
        return super.doHurtTarget(entity);
    }

    @Override
    public void setLastHurtByMob(LivingEntity livingEntity)
    {
        if (livingEntity instanceof Player && livingEntity.getUUID().equals(getOwnerUUID()))
        {
            return;
        }

        super.setLastHurtByMob(livingEntity);
    }

    @Override
    public boolean tameWithName(Player player)
    {
        modifyGoalsAfterTaming(player);
        return super.tameWithName(player);
    }

    @Override
    public boolean canMate(Animal animal)
    {
        return false;
    }

    @Override
    public boolean canBreed()
    {
        return false;
    }

    @Override
    protected ResourceLocation getDefaultLootTable()
    {
        return new ResourceLocation("minecraft:horse");
    }

    private void modifyGoalsAfterTaming(Player tamedByPlayer)
    {
//        this.goalSelector.addGoal(6, new FollowOwnerGoal(tamedByPlayer, 1.0D, 10.0F, 2.0F, false));

        this.targetSelector.removeGoal(nearestAttackablePlayerGoal);
        this.targetSelector.addGoal(1, new DefendOwnerPlayerGoal(this, tamedByPlayer));
    }


    public class DefendOwnerPlayerGoal extends TargetGoal
    {
        private final DaredevilEntity daredevilEntity;
        private LivingEntity owner;
        private LivingEntity aggressor;
        private final TargetingConditions attackTargeting = TargetingConditions.forCombat().range(16.0D);

        public DefendOwnerPlayerGoal(DaredevilEntity daredevilEntity, LivingEntity livingEntity) {
            super(daredevilEntity, false, true);
            this.daredevilEntity = daredevilEntity;
            this.owner = livingEntity;
            this.setFlags(EnumSet.of(Goal.Flag.TARGET));
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.daredevilEntity.setTarget(this.aggressor);
            super.start();
        }

        @Override
        public boolean canUse()
        {
            AABB aabb = this.daredevilEntity.getBoundingBox().inflate(10.0D, 8.0D, 10.0D);
            List<LivingEntity> list = this.daredevilEntity.level.getNearbyEntities(LivingEntity.class, this.attackTargeting, this.daredevilEntity, aabb);

            LivingEntity aggressor = owner.getLastHurtByMob();

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
                if (!(this.owner instanceof Player))
                    return true;
                else return !this.owner.isSpectator() && !((Player) this.owner).isCreative();
            }
        }
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag)
    {
        spawnGroupData = super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
        if (mobSpawnType == MobSpawnType.SPAWN_EGG)
        {
            // 50% chance to spawn Daredevil with Headless Horseman
            if (serverLevelAccessor.getRandom().nextInt(100) < 50)
            {
                createRidingHeadlessHorseman(serverLevelAccessor, difficultyInstance, mobSpawnType);
            }
        }
        else
        {
            // Always spawns with his owner - Headless Horseman
            createRidingHeadlessHorseman(serverLevelAccessor, difficultyInstance, mobSpawnType);
        }

        return spawnGroupData;
    }

    @Override
    public MobType getMobType()
    {
        return MobType.UNDEAD;
    }

    private void createRidingHeadlessHorseman(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType)
    {
        HeadlessHorsemanEntity headlessHorsemanEntity = PumpkinFeverEntityTypes.HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE.create(this.level);
        headlessHorsemanEntity.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
        headlessHorsemanEntity.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, null, null);
        headlessHorsemanEntity.startRiding(this);
    }
}
