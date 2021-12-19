package io.github.aquerr.pumpkinfever.block;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks
{
    public static final PumpkinVineBlock PUMPKIN_VINE_BLOCK = new PumpkinVineBlock();
    public static final TinyPumpkin TINY_PUMPKIN = new TinyPumpkin();
    public static final TinyPumpkinLantern TINY_PUMPKIN_LANTERN = new TinyPumpkinLantern();

    public static void registerBlocks(IForgeRegistry<Block> registry)
    {
        registry.register(PUMPKIN_VINE_BLOCK);
        registry.register(TINY_PUMPKIN);
        registry.register(TINY_PUMPKIN_LANTERN);
    }
}
