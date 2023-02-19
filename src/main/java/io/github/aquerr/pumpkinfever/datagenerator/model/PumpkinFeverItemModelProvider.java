package io.github.aquerr.pumpkinfever.datagenerator.model;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import io.github.aquerr.pumpkinfever.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class PumpkinFeverItemModelProvider extends ItemModelProvider
{
    public PumpkinFeverItemModelProvider(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, PumpkinFever.MOD_ID, existingFileHelper);
    }

    @Override
    public @NotNull String getName()
    {
        return "PumpkinFeverItemModelProvider";
    }

    @Override
    public void registerModels()
    {
        basicItem(ModItems.LOLLIPOP_ITEM.get());
        basicItem(ModItems.PUMPKIN_DUST.get());
//        withExistingParent(ModItems.TINY_PUMPKIN.getId().getPath(), modLoc("block/tiny_pumpkin"));
    }
}
