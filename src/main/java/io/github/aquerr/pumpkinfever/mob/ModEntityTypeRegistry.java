package io.github.aquerr.pumpkinfever.mob;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import javax.swing.text.html.HTML;

@Mod.EventBusSubscriber(modid = PumpkinFever.MOD_ID ,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityTypeRegistry
{
//    public static final EntityType<VillagerEntity> VILLAGER =
//    register("villager", EntityType.Builder.<VillagerEntity>create(VillagerEntity::new, EntityClassification.MISC).size(0.6F, 1.95F));

    public static final EntityType<CandyMerchant> CANDY_MERCHANT_ENTITY_TYPE = EntityType.Builder
            .create(CandyMerchant::new, EntityClassification.MISC)
            .size(0.6F, 1.95F)
            .build(new ResourceLocation(PumpkinFever.MOD_ID, CandyMerchant.REGISTRY_NAME).toString());

    public static final EntityType<DaredevilEntity> DAREDEVIL_ENTITY_ENTITY_TYPE = EntityType.Builder
            .create(DaredevilEntity::new, EntityClassification.MONSTER)
            .size(1.3964844F, 1.6F) //Same as horse
            .trackingRange(10)
            .build(new ResourceLocation(PumpkinFever.MOD_ID, DaredevilEntity.REGISTRY_NAME).toString());

    public static final EntityType<HeadlessHorsemanEntity> HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE = EntityType.Builder
            .create(HeadlessHorsemanEntity::new, EntityClassification.MONSTER)
            .size(0.6F, 1.99F) //Same as skeleton
            .build(new ResourceLocation(PumpkinFever.MOD_ID, HeadlessHorsemanEntity.REGISTRY_NAME).toString());

    public static final EntityType<PumpkinnoEntity> PUMPKINNO_ENTITY_ENTITY_TYPE = EntityType.Builder
            .create(PumpkinnoEntity::new, EntityClassification.MONSTER)
            .size(0.7F, 0.7F)
            .build(new ResourceLocation(PumpkinFever.MOD_ID, PumpkinnoEntity.REGISTRY_NAME).toString());

    public static final EntityType<PumpkinpoEntity> PUMPKINPO_ENTITY_ENTITY_TYPE = EntityType.Builder
            .create(PumpkinpoEntity::new, EntityClassification.MONSTER)
            .size(0.7F, 0.7F)
            .build(new ResourceLocation(PumpkinFever.MOD_ID, PumpkinpoEntity.REGISTRY_NAME).toString());

    public static void registerEntityTypes(final IForgeRegistry<EntityType<?>> registry)
    {
        registry.register(CANDY_MERCHANT_ENTITY_TYPE.setRegistryName(CandyMerchant.REGISTRY_NAME));
        registry.register(DAREDEVIL_ENTITY_ENTITY_TYPE.setRegistryName(DaredevilEntity.REGISTRY_NAME));
        registry.register(HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE.setRegistryName(HeadlessHorsemanEntity.REGISTRY_NAME));
        registry.register(PUMPKINNO_ENTITY_ENTITY_TYPE.setRegistryName(PumpkinnoEntity.REGISTRY_NAME));
        registry.register(PUMPKINPO_ENTITY_ENTITY_TYPE.setRegistryName(PumpkinpoEntity.REGISTRY_NAME));
    }

    @SubscribeEvent
    public static void onEntityAttributeRegister(EntityAttributeCreationEvent event)
    {
        event.put(CANDY_MERCHANT_ENTITY_TYPE, CandyMerchant.getAttributes());
        event.put(DAREDEVIL_ENTITY_ENTITY_TYPE, DaredevilEntity.getAttributes());
        event.put(HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE, HeadlessHorsemanEntity.getAttributes());
        event.put(PUMPKINNO_ENTITY_ENTITY_TYPE, PumpkinnoEntity.getAttributes());
        event.put(PUMPKINPO_ENTITY_ENTITY_TYPE, PumpkinpoEntity.getAttributes());

    }
}
