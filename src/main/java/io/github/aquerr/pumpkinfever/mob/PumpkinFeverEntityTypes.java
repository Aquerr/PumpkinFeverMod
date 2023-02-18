package io.github.aquerr.pumpkinfever.mob;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import io.github.aquerr.pumpkinfever.client.renderer.DaredevilRenderer;
import io.github.aquerr.pumpkinfever.client.renderer.HeadlessHorsemanRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(modid = PumpkinFever.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PumpkinFeverEntityTypes
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PumpkinFever.MOD_ID);



//    public static final EntityType<VillagerEntity> VILLAGER =
//    register("villager", EntityType.Builder.<VillagerEntity>create(VillagerEntity::new, EntityClassification.MISC).size(0.6F, 1.95F));
//
//    public static final EntityType<CandyMerchant> CANDY_MERCHANT_ENTITY_TYPE = EntityType.Builder.of(CandyMerchant::new, MobCategory.MISC)
//            .sized(0.6F, 1.95F)
//            .build(new ResourceLocation(PumpkinFever.MOD_ID, CandyMerchant.REGISTRY_NAME).toString());

    public static final RegistryObject<EntityType<DaredevilEntity>> DAREDEVIL_ENTITY_ENTITY_TYPE = ENTITY_TYPES.register(DaredevilEntity.REGISTRY_NAME, () -> EntityType.Builder
            .of(DaredevilEntity::new, MobCategory.MONSTER)
            .sized(1.3964844F, 1.6F) //Same as horse
            .setTrackingRange(10)
            .build(new ResourceLocation(PumpkinFever.MOD_ID, DaredevilEntity.REGISTRY_NAME).toString()));


    public static final RegistryObject<EntityType<HeadlessHorsemanEntity>> HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE = ENTITY_TYPES.register(HeadlessHorsemanEntity.REGISTRY_NAME, () -> EntityType.Builder
            .of(HeadlessHorsemanEntity::new, MobCategory.MONSTER)
            .sized(0.6F, 1.99F) //Same as skeleton
            .setTrackingRange(10)
            .build(new ResourceLocation(PumpkinFever.MOD_ID, HeadlessHorsemanEntity.REGISTRY_NAME).toString()));

    public static final RegistryObject<EntityType<PumpkinnoEntity>> PUMPKINNO_ENTITY_ENTITY_TYPE = ENTITY_TYPES.register(PumpkinnoEntity.REGISTRY_NAME, () -> EntityType.Builder
            .of(PumpkinnoEntity::new, MobCategory.MONSTER)
            .sized(0.7F, 0.7F)
            .setTrackingRange(10)
            .build(new ResourceLocation(PumpkinFever.MOD_ID, PumpkinnoEntity.REGISTRY_NAME).toString()));

    public static final RegistryObject<EntityType<PumpkinpoEntity>> PUMPKINPO_ENTITY_ENTITY_TYPE = ENTITY_TYPES.register(PumpkinpoEntity.REGISTRY_NAME, () -> EntityType.Builder
            .of(PumpkinpoEntity::new, MobCategory.MONSTER)
            .sized(0.7F, 0.7F)
            .setTrackingRange(10)
            .build(new ResourceLocation(PumpkinFever.MOD_ID, PumpkinpoEntity.REGISTRY_NAME).toString()));

    @SubscribeEvent
    public static void onEntityAttributeRegister(final EntityAttributeCreationEvent event)
    {
        event.put(DAREDEVIL_ENTITY_ENTITY_TYPE.get(), DaredevilEntity.createMobAttributes().build());
        event.put(HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE.get(), HeadlessHorsemanEntity.createMobAttributes().build());
        event.put(PUMPKINNO_ENTITY_ENTITY_TYPE.get(), PumpkinnoEntity.createMobAttributes().build());
        event.put(PUMPKINPO_ENTITY_ENTITY_TYPE.get(), PumpkinpoEntity.createMobAttributes().build());
    }
}
