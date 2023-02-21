package io.github.aquerr.pumpkinfever.client;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import io.github.aquerr.pumpkinfever.block.ModBlocks;
import io.github.aquerr.pumpkinfever.client.model.layer.RavenOnShoulderLayer;
import io.github.aquerr.pumpkinfever.client.renderer.DaredevilRenderer;
import io.github.aquerr.pumpkinfever.client.renderer.HeadlessHorsemanRenderer;
import io.github.aquerr.pumpkinfever.client.renderer.RavenRenderer;
import io.github.aquerr.pumpkinfever.mob.ModEntityTypes;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = PumpkinFever.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventsHandler
{
//    public static ModelLayerLocation RAVEN_ON_SHOULDER = new ModelLayerLocation(new ResourceLocation("minecraft:player"), "raven_on_shoulder");

//    @SubscribeEvent
//    public static void onLayerRegister(EntityRenderersEvent.RegisterLayerDefinitions event)
//    {
//        event.registerLayerDefinition(RAVEN_ON_SHOULDER, () -> );
//    }

    @SubscribeEvent
    public static void onEntityLayerAdd(EntityRenderersEvent.AddLayers event)
    {
        event.getSkins().stream()
                .map(skinName -> event.<PlayerRenderer>getSkin(skinName))
                .forEach(playerRenderer -> applyLayersForPlayerSkin(playerRenderer, event.getEntityModels()));
    }

    private static void applyLayersForPlayerSkin(PlayerRenderer playerRenderer, EntityModelSet entityModels)
    {
        playerRenderer.addLayer(new RavenOnShoulderLayer<>(playerRenderer, entityModels));
    }

    @SubscribeEvent
    public static void onEntityRenderersEvent(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(ModEntityTypes.DAREDEVIL_ENTITY_ENTITY_TYPE.get(), DaredevilRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE.get(), HeadlessHorsemanRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.RAVEN_ENTITY_TYPE.get(), RavenRenderer::new);
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PUMPKIN_VINE_BLOCK.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        // TODO: Change ModelLayers.PARROT with our own location
//        event.registerLayerDefinition(ModelLayers, RavenModel::createBodyLayer);
    }
}
