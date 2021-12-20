package io.github.aquerr.pumpkinfever;

import com.google.common.collect.ImmutableMap;
import io.github.aquerr.pumpkinfever.block.ModBlocks;
import io.github.aquerr.pumpkinfever.item.ModItems;
import io.github.aquerr.pumpkinfever.mob.CandyMerchant;
import io.github.aquerr.pumpkinfever.mob.ModEntityTypeRegistry;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PumpkinFever.MOD_ID ,bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler
{
    @SubscribeEvent
    public static void onBlockRegister(final RegistryEvent.Register<Block> event)
    {
        ModBlocks.registerBlocks(event.getRegistry());
    }

    @SubscribeEvent
    public static void onItemRegister(final RegistryEvent.Register<Item> event)
    {
        ModItems.registerItems(event.getRegistry());
    }

    @SubscribeEvent
    public static void onModelRegister(final ModelRegistryEvent event)
    {
        ModItems.registerModels();
    }

    @SubscribeEvent
    public static void onEntityRegister(final RegistryEvent.Register<EntityType<?>> event)
    {
        ModEntityTypeRegistry.registerEntityTypes(event.getRegistry());
    }

    @SubscribeEvent
    public static void onProfessionRegister(final RegistryEvent.Register<VillagerProfession> event)
    {
        event.getRegistry().register(CandyMerchant.CANDY_MERCHAT_PROFESSION);

        VillagerTrades.TRADES.put(CandyMerchant.CANDY_MERCHAT_PROFESSION, CandyMerchant.TRADES);
    }

    @SubscribeEvent
    public static void onPoiTypeRegister(final RegistryEvent.Register<PoiType> event)
    {
        event.getRegistry().register(CandyMerchant.CANDYMAN_POI_TYPE);
    }
}
