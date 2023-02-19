package io.github.aquerr.pumpkinfever.datagenerator.tags;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import io.github.aquerr.pumpkinfever.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class PumpkinFeverBlockTagsProvider extends BlockTagsProvider
{
    public PumpkinFeverBlockTagsProvider(DataGenerator dataGenerator, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, PumpkinFever.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName()
    {
        return "PumpkinFeverBlockTagsProvider";
    }

    @Override
    protected void addTags()
    {
        // TODO:
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.PUMPKIN_VINE_BLOCK.get());
    }
}
