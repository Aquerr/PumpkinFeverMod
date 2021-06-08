package io.github.aquerr.pumpkinfever;

import io.github.aquerr.pumpkinfever.block.ModBlocks;
import io.github.aquerr.pumpkinfever.client.renderer.CandyMerchantRenderer;
import io.github.aquerr.pumpkinfever.client.renderer.DaredevilRenderer;
import io.github.aquerr.pumpkinfever.client.renderer.HeadlessHorsemanRenderer;
import io.github.aquerr.pumpkinfever.mob.ModEntityTypes;
import io.github.aquerr.pumpkinfever.network.PumpkinFeverPacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PumpkinFever.MOD_ID)
public class PumpkinFever
{
    public static final String MOD_ID = "pumpkinfever";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    private PumpkinFeverPacketHandler pumpkinFeverPacketHandler;

    public PumpkinFever() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        this.pumpkinFeverPacketHandler = new PumpkinFeverPacketHandler();

//        ForgeRegistries.BIOMES
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);

        registerRenderers();
    }

    private void registerRenderers()
    {
        final EntityRendererManager entityRendererManager = Minecraft.getInstance().getRenderManager();
        entityRendererManager.register(ModEntityTypes.DAREDEVIL_ENTITY_ENTITY_TYPE, new DaredevilRenderer(entityRendererManager));
        entityRendererManager.register(ModEntityTypes.HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE, new HeadlessHorsemanRenderer(entityRendererManager));
        entityRendererManager.register(ModEntityTypes.CANDY_MERCHANT_ENTITY_TYPE, new CandyMerchantRenderer(entityRendererManager, (IReloadableResourceManager) Minecraft.getInstance().getResourceManager()));

        RenderTypeLookup.setRenderLayer(ModBlocks.PUMPKIN_VINE_BLOCK, RenderType.getCutout());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        //TODO: Remove this...
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        //TODO: Remove this...
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
}
