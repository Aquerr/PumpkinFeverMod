package io.github.aquerr.pumpkinfever.data.loot;

import io.github.aquerr.pumpkinfever.block.ModBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class BlockLootTable extends BlockLoot
{
    @Override
    protected void addTables()
    {
        super.dropWhenSilkTouch(ModBlocks.PUMPKIN_VINE_BLOCK.get());
        super.dropSelf(ModBlocks.TINY_PUMPKIN.get());
        super.dropSelf(ModBlocks.TINY_PUMPKIN_LANTERN.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
