package io.github.aquerr.pumpkinfever;

import io.github.aquerr.pumpkinfever.block.ModBlocks;
import io.github.aquerr.pumpkinfever.item.ModItems;
import io.github.aquerr.pumpkinfever.mob.ModEntityTypes;
import io.github.aquerr.pumpkinfever.mob.PumpkinFeverVillagerProfessions;
import io.github.aquerr.pumpkinfever.network.PumpkinFeverPacketHandler;
import io.github.aquerr.pumpkinfever.sound.ModSounds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.loading.FileUtils;
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
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        ModBlocks.BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ModItems.ITEMS.register(modEventBus);
        ModEntityTypes.ENTITY_TYPES.register(modEventBus);
        PumpkinFeverVillagerProfessions.VILLAGER_PROFESSIONS.register(modEventBus);
        ModSounds.SOUND_EVENTS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        LOGGER.info("Creating config files...");
        FileUtils.getOrCreateDirectory(FMLPaths.CONFIGDIR.get().resolve(MOD_ID), MOD_ID);
//        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configuration.GENERAL_SPEC, MOD_ID + "/mod_config.toml");

        LOGGER.info("Config files created...");
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        this.pumpkinFeverPacketHandler = new PumpkinFeverPacketHandler();

//        ForgeRegistries.BIOMES
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
