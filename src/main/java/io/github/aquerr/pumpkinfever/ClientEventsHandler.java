package io.github.aquerr.pumpkinfever;

import io.github.aquerr.pumpkinfever.block.ModBlocks;
import io.github.aquerr.pumpkinfever.client.renderer.DaredevilRenderer;
import io.github.aquerr.pumpkinfever.client.renderer.HeadlessHorsemanRenderer;
import io.github.aquerr.pumpkinfever.mob.PumpkinFeverEntityTypes;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = PumpkinFever.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventsHandler
{
    @SubscribeEvent
    public static void onEntityRenderersEvent(EntityRenderersEvent.RegisterRenderers event)
    {
        event.registerEntityRenderer(PumpkinFeverEntityTypes.DAREDEVIL_ENTITY_ENTITY_TYPE.get(), DaredevilRenderer::new);
        event.registerEntityRenderer(PumpkinFeverEntityTypes.HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE.get(), HeadlessHorsemanRenderer::new);
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event)
    {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PUMPKIN_VINE_BLOCK.get(), RenderType.cutout());
    }
}
