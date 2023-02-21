package io.github.aquerr.pumpkinfever.datagenerator;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import io.github.aquerr.pumpkinfever.datagenerator.blockstate.PumpkinFeverBlockStateProvider;
import io.github.aquerr.pumpkinfever.datagenerator.lang.PumpkinFeverPolishLanguageProvider;
import io.github.aquerr.pumpkinfever.datagenerator.loot.PumpkinFeverLootTableProvider;
import io.github.aquerr.pumpkinfever.datagenerator.model.PumpkinFeverItemModelProvider;
import io.github.aquerr.pumpkinfever.datagenerator.recpie.PumpkinFeverRecipeProvider;
import io.github.aquerr.pumpkinfever.datagenerator.sound.PumpkinFeverSoundDataProvider;
import io.github.aquerr.pumpkinfever.datagenerator.tags.PumpkinFeverBlockTagsProvider;
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
        dataGenerator.addProvider(event.includeClient(), new PumpkinFeverSoundDataProvider(dataGenerator, existingFileHelper));

        dataGenerator.addProvider(event.includeServer(), new PumpkinFeverLootTableProvider(dataGenerator));
        dataGenerator.addProvider(event.includeServer(), new PumpkinFeverBlockTagsProvider(dataGenerator, existingFileHelper));
        dataGenerator.addProvider(event.includeServer(), new PumpkinFeverRecipeProvider(dataGenerator));
    }
}