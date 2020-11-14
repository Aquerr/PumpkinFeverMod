package io.github.aquerr.pumpkinfever;

import io.github.aquerr.pumpkinfever.block.PumpkinVineBlock;
import io.github.aquerr.pumpkinfever.block.TinyPumpkin;
import io.github.aquerr.pumpkinfever.block.TinyPumpkinLantern;
import io.github.aquerr.pumpkinfever.item.PumpkinDust;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinBoots;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinChestplate;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinHelmet;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinLeggings;
import io.github.aquerr.pumpkinfever.item.tool.PumpkinSword;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
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
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", net.minecraft.block.Blocks.DIRT.getRegistryName());

        //TODO: Add mob spawns...
//        ForgeRegistries.BIOMES
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    public static class Items
    {
        // Armor
        public static final PumpkinHelmet PUMPKIN_HELMET = new PumpkinHelmet();
        public static final PumpkinChestplate PUMPKIN_CHESTPLATE = new PumpkinChestplate();
        public static final PumpkinLeggings PUMPKIN_LEGGINGS = new PumpkinLeggings();
        public static final PumpkinBoots PUMPKIN_BOOTS = new PumpkinBoots();

        // Pumpkin tools
        public static final PumpkinSword PUMPKIN_SWORD = new PumpkinSword();

        // Other Items
        public static final PumpkinDust PUMPKIN_DUST = new PumpkinDust();

        public static void registerItems(final IForgeRegistry<Item> registry)
        {
            registry.register(PUMPKIN_HELMET);
            registry.register(PUMPKIN_CHESTPLATE);
            registry.register(PUMPKIN_LEGGINGS);
            registry.register(PUMPKIN_BOOTS);

            registry.register(PUMPKIN_DUST);
            registry.register(PUMPKIN_SWORD);
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

//        private static void registerBlockItem(final Block block)
//        {
//            final BlockItem itemBlock = new BlockItem(block);
//            itemBlock.setRegistryName(block.getRegistryName());
//            ForgeRegistries.ITEMS.register(itemBlock);
//        }
    }
}
