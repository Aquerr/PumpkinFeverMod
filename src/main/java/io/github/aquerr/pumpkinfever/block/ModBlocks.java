package io.github.aquerr.pumpkinfever.block;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegisterEvent;

public class ModBlocks
{
    public static final PumpkinVineBlock PUMPKIN_VINE_BLOCK = new PumpkinVineBlock();
    public static final TinyPumpkin TINY_PUMPKIN = new TinyPumpkin();
    public static final TinyPumpkinLantern TINY_PUMPKIN_LANTERN = new TinyPumpkinLantern();

    public static void registerBlocks(RegisterEvent.RegisterHelper<Block> registry)
    {
        registry.register(PumpkinVineBlock.REGISTRY_NAME, PUMPKIN_VINE_BLOCK);
        registry.register(TinyPumpkin.REGISTRY_NAME, TINY_PUMPKIN);
        registry.register(TinyPumpkinLantern.REGISTRY_NAME, TINY_PUMPKIN_LANTERN);
    }
}
