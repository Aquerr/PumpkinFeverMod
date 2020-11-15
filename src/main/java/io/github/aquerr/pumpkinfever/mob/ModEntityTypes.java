package io.github.aquerr.pumpkinfever.mob;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

public class ModEntityTypes
{
    public static final EntityType<DaredevilEntity> DAREDEVIL_ENTITY_ENTITY_TYPE = EntityType.Builder
            .create(DaredevilEntity::new, EntityClassification.MONSTER)
            .size(1.3964844F, 1.6F) //Same as horse
            .build(new ResourceLocation(PumpkinFever.MOD_ID, "daredevil").toString());

    public static final EntityType<HeadlessHorsemanEntity> HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE = EntityType.Builder
            .create(HeadlessHorsemanEntity::new, EntityClassification.MONSTER)
            .size(0.6F, 1.99F) //Same as skeleton
            .build(new ResourceLocation(PumpkinFever.MOD_ID, "headless_horseman").toString());

    public static final EntityType<PumpkinnoEntity> PUMPKINNO_ENTITY_ENTITY_TYPE = EntityType.Builder
            .create(PumpkinnoEntity::new, EntityClassification.MONSTER)
            .size(0.7F, 0.7F)
            .build(new ResourceLocation(PumpkinFever.MOD_ID, "pumpkinno").toString());

    public static final EntityType<PumpkinpoEntity> PUMPKINPO_ENTITY_ENTITY_TYPE = EntityType.Builder
            .create(PumpkinpoEntity::new, EntityClassification.MONSTER)
            .size(0.7F, 0.7F)
            .build(new ResourceLocation(PumpkinFever.MOD_ID, "pumpkinpo").toString());

    public static void registerEntityTypes(final IForgeRegistry<EntityType<?>> registry)
    {
        registry.register(DAREDEVIL_ENTITY_ENTITY_TYPE.setRegistryName("daredevil"));
        registry.register(HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE.setRegistryName("headless_horseman"));
        registry.register(PUMPKINNO_ENTITY_ENTITY_TYPE.setRegistryName("pumpkinno"));
        registry.register(PUMPKINPO_ENTITY_ENTITY_TYPE.setRegistryName("pumpkinpo"));
    }
}
