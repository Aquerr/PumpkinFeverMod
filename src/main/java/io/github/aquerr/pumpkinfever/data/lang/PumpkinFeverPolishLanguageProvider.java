package io.github.aquerr.pumpkinfever.data.lang;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import io.github.aquerr.pumpkinfever.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class PumpkinFeverPolishLanguageProvider extends LanguageProvider
{
    public PumpkinFeverPolishLanguageProvider(DataGenerator dataGenerator)
    {
        super(dataGenerator, PumpkinFever.MOD_ID, "pl_pl");
    }

    @Override
    protected void addTranslations()
    {
        //TODO: Uzupełnić resztę...
        add("itemGroup." + PumpkinFever.MOD_ID, "Pumpkin Fever");
        add(ModItems.LOLLIPOP_ITEM.get(), "Lizak");
    }
}
