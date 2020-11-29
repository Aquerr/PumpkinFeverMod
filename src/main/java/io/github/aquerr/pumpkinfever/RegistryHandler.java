package io.github.aquerr.pumpkinfever;

import io.github.aquerr.pumpkinfever.block.ModBlocks;
import io.github.aquerr.pumpkinfever.item.ModItems;
import io.github.aquerr.pumpkinfever.mob.ModEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
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
        ModEntityTypes.registerEntityTypes(event.getRegistry());
    }
}
