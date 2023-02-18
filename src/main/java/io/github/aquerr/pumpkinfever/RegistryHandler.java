package io.github.aquerr.pumpkinfever;

import io.github.aquerr.pumpkinfever.block.ModBlocks;
import io.github.aquerr.pumpkinfever.item.ModItems;
import io.github.aquerr.pumpkinfever.mob.PumpkinFeverPoiTypes;
import io.github.aquerr.pumpkinfever.mob.PumpkinFeverVillagerProfessions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

@Mod.EventBusSubscriber(modid = PumpkinFever.MOD_ID ,bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler
{
    @SubscribeEvent
    public static void onRegisterEvent(final RegisterEvent event)
    {
        event.register(ForgeRegistries.Keys.BLOCKS, ModBlocks::registerBlocks);
        event.register(ForgeRegistries.Keys.ITEMS, ModItems::registerItems);
        event.register(ForgeRegistries.Keys.VILLAGER_PROFESSIONS, PumpkinFeverVillagerProfessions::registerProfessions);
        event.register(ForgeRegistries.Keys.POI_TYPES, PumpkinFeverPoiTypes::registerPoiTypes);
    }
}
