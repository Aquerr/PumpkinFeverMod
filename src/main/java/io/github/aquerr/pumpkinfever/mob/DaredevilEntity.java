package io.github.aquerr.pumpkinfever.mob;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.World;

public class DaredevilEntity extends HorseEntity
{
    public static final String REGISTRY_NAME = "daredevil";

    public DaredevilEntity(EntityType<? extends HorseEntity> type, World worldIn)
    {
        super(type, worldIn);
    }

    @Override
    public void livingTick()
    {
        super.livingTick();

        if (this.world.isRemote) {
//            if (this.rand.nextInt(24) == 0 && !this.isSilent()) {
//                this.world.playSound(this.getPosX() + 0.5D, this.getPosY() + 0.5D, this.getPosZ() + 0.5D, SoundEvents.ENTITY_BLAZE_BURN, this.getSoundCategory(), 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
//            }

            for(int i = 0; i < 2; ++i) {
                this.world.addParticle(ParticleTypes.SMOKE, this.getPosXRandom(0.5D), this.getPosYRandom(), this.getPosZRandom(0.5D), 0.0D, 0.0D, 0.0D);

                if (this.moveController.getX() == 0 && this.moveController.getY() == 0 && this.moveController.getZ() == 0)
                {
                    this.world.addParticle(ParticleTypes.FLAME, this.getPosXRandom(0.4D) + Math.cos(Math.toRadians(this.getYaw(0) + 270)),
                            this.getPosYHeight(0.2D), this.getPosZRandom(0.4D) + Math.sin(Math.toRadians(this.getYaw(0) + 270)), 0.0D, 0.0D, 0.0D);
                }
            }
        }

//        getEntityWorld().addParticle();
    }
}
