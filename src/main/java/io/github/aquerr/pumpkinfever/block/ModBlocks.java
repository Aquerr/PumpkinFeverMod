package io.github.aquerr.pumpkinfever.block;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, PumpkinFever.MOD_ID);
    public static final RegistryObject<PumpkinVineBlock> PUMPKIN_VINE_BLOCK = BLOCKS.register(PumpkinVineBlock.REGISTRY_NAME, PumpkinVineBlock::new);
    public static final RegistryObject<TinyPumpkin> TINY_PUMPKIN = BLOCKS.register(TinyPumpkin.REGISTRY_NAME, TinyPumpkin::new);
    public static final RegistryObject<TinyPumpkinLantern> TINY_PUMPKIN_LANTERN = BLOCKS.register(TinyPumpkinLantern.REGISTRY_NAME, TinyPumpkinLantern::new);
}
