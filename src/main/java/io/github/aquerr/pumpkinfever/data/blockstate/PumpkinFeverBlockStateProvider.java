package io.github.aquerr.pumpkinfever.data.blockstate;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import io.github.aquerr.pumpkinfever.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class PumpkinFeverBlockStateProvider extends BlockStateProvider
{
    public PumpkinFeverBlockStateProvider(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, PumpkinFever.MOD_ID, existingFileHelper);
    }

    @Override
    public @NotNull String getName()
    {
        return "PumpkinFeverBlockStateProvider";
    }

    @Override
    protected void registerStatesAndModels()
    {
        // TODO: Uncomment lines below... after making a texture for tiny pumpkin.
//        simpleBlock(ModBlocks.PUMPKIN_VINE_BLOCK.get());
//        simpleBlock(ModBlocks.TINY_PUMPKIN.get());
//        simpleBlock(ModBlocks.TINY_PUMPKIN_LANTERN.get());
    }
}
