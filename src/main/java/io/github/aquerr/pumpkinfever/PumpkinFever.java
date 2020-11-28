package io.github.aquerr.pumpkinfever;

import io.github.aquerr.pumpkinfever.block.PumpkinVineBlock;
import io.github.aquerr.pumpkinfever.block.TinyPumpkin;
import io.github.aquerr.pumpkinfever.block.TinyPumpkinLantern;
import io.github.aquerr.pumpkinfever.client.renderer.CandyMerchantRenderer;
import io.github.aquerr.pumpkinfever.client.renderer.DaredevilRenderer;
import io.github.aquerr.pumpkinfever.client.renderer.HeadlessHorsemanRenderer;
import io.github.aquerr.pumpkinfever.item.CandyBasketItem;
import io.github.aquerr.pumpkinfever.item.CandyItem;
import io.github.aquerr.pumpkinfever.item.PumpkinDust;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinBoots;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinChestplate;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinHelmet;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinLeggings;
import io.github.aquerr.pumpkinfever.item.tool.PumpkinIronSword;
import io.github.aquerr.pumpkinfever.mob.ModEntityTypes;
import io.github.aquerr.pumpkinfever.network.PumpkinFeverPacketHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.item.*;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PumpkinFever.MOD_ID)
public class PumpkinFever
{
    public static final String MOD_ID = "pumpkinfever";
    public static final ItemGroup ITEM_GROUP = new ItemGroup("pumpkinfever")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(net.minecraft.item.Items.PUMPKIN);
        }
    };

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

        //TODO: Add mob spawns...
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

    public static class Items
    {
        // BlockItems
        public static final Item PUMPKIN_VINE = new BlockItem(Blocks.PUMPKIN_VINE_BLOCK, new Item.Properties().group(PumpkinFever.ITEM_GROUP));
        public static final Item TINY_PUMPKIN = new BlockItem(Blocks.TINY_PUMPKIN, new Item.Properties().group(PumpkinFever.ITEM_GROUP));
        public static final Item TINY_PUMPKIN_LANTERN = new BlockItem(Blocks.TINY_PUMPKIN_LANTERN, new Item.Properties().group(PumpkinFever.ITEM_GROUP));

        // Armor
        public static final PumpkinHelmet PUMPKIN_HELMET = new PumpkinHelmet();
        public static final PumpkinChestplate PUMPKIN_CHESTPLATE = new PumpkinChestplate();
        public static final PumpkinLeggings PUMPKIN_LEGGINGS = new PumpkinLeggings();
        public static final PumpkinBoots PUMPKIN_BOOTS = new PumpkinBoots();

        // Pumpkin tools
        public static final PumpkinIronSword PUMPKIN_SWORD = new PumpkinIronSword();

        // Other Items
        public static final PumpkinDust PUMPKIN_DUST = new PumpkinDust();
        public static final CandyItem CANDY = new CandyItem();
        public static final CandyBasketItem CANDY_BASKET = new CandyBasketItem();

        // Spawn Eggs
        public static final Item DAREDEVIL_SPAWN_EGG = new SpawnEggItem(ModEntityTypes.DAREDEVIL_ENTITY_ENTITY_TYPE, 4996656, 986895, (new Item.Properties()).group(PumpkinFever.ITEM_GROUP)).setRegistryName("daredevil_spawn_egg");
        public static final Item HEADLESS_HORSEMAN_SPAWN_EGG = new SpawnEggItem(ModEntityTypes.HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE, 4996656, 986895, (new Item.Properties()).group(PumpkinFever.ITEM_GROUP)).setRegistryName("headless_horseman_spawn_egg");

        public static void registerItems(final IForgeRegistry<Item> registry)
        {
            registry.register(PUMPKIN_VINE);
            registry.register(TINY_PUMPKIN);
            registry.register(TINY_PUMPKIN_LANTERN);

            registry.register(PUMPKIN_HELMET);
            registry.register(PUMPKIN_CHESTPLATE);
            registry.register(PUMPKIN_LEGGINGS);
            registry.register(PUMPKIN_BOOTS);

            registry.register(PUMPKIN_DUST);
            registry.register(CANDY);
            registry.register(CANDY_BASKET);

            registry.register(PUMPKIN_SWORD);

            registry.register(DAREDEVIL_SPAWN_EGG);
            registry.register(HEADLESS_HORSEMAN_SPAWN_EGG);
        }

        public static void registerModels()
        {

        }
    }

    public static class Blocks
    {
        public static final PumpkinVineBlock PUMPKIN_VINE_BLOCK = new PumpkinVineBlock();
        public static final TinyPumpkin TINY_PUMPKIN = new TinyPumpkin();
        public static final TinyPumpkinLantern TINY_PUMPKIN_LANTERN = new TinyPumpkinLantern();

        public static void registerBlocks(IForgeRegistry<Block> registry)
        {
            registry.register(PUMPKIN_VINE_BLOCK);
            registry.register(TINY_PUMPKIN);
            registry.register(TINY_PUMPKIN_LANTERN);
        }
    }

    public static class Foods
    {
        public static final Food CANDY_BASKET = new Food.Builder().hunger(8).saturation(0.8F).build();
        public static final Food CANDY = new Food.Builder().hunger(2).saturation(0.2F).build();
    }
}
