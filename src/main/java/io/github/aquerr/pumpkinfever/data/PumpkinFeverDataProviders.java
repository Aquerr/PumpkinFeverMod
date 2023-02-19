package io.github.aquerr.pumpkinfever.data;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import io.github.aquerr.pumpkinfever.data.blockstate.PumpkinFeverBlockStateProvider;
import io.github.aquerr.pumpkinfever.data.lang.PumpkinFeverPolishLanguageProvider;
import io.github.aquerr.pumpkinfever.data.loot.PumpkinFeverLootTableProvider;
import io.github.aquerr.pumpkinfever.data.model.PumpkinFeverItemModelProvider;
import io.github.aquerr.pumpkinfever.data.recpie.PumpkinFeverRecipeProvider;
import io.github.aquerr.pumpkinfever.data.tags.PumpkinFeverBlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = PumpkinFever.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class PumpkinFeverDataProviders
{
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event)
    {
        DataGenerator dataGenerator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        dataGenerator.addProvider(event.includeClient(), new PumpkinFeverBlockStateProvider(dataGenerator, existingFileHelper));
        dataGenerator.addProvider(event.includeClient(), new PumpkinFeverItemModelProvider(dataGenerator, existingFileHelper));

        //TODO: Uncomment after removing lang file...
//        dataGenerator.addProvider(event.includeClient(), new PumpkinFeverEnglishLanguageProvider(dataGenerator));
        dataGenerator.addProvider(event.includeClient(), new PumpkinFeverPolishLanguageProvider(dataGenerator));

        dataGenerator.addProvider(event.includeServer(), new PumpkinFeverLootTableProvider(dataGenerator));
        dataGenerator.addProvider(event.includeServer(), new PumpkinFeverBlockTagsProvider(dataGenerator, existingFileHelper));
        dataGenerator.addProvider(event.includeServer(), new PumpkinFeverRecipeProvider(dataGenerator));
    }
}