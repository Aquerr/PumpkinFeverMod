package io.github.aquerr.pumpkinfever.block;


import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class TinyPumpkinLantern extends HorizontalDirectionalBlock
{
    public TinyPumpkinLantern()
    {
        super(Properties.of(Material.VEGETABLE).strength(1.0F).lightLevel(value -> 15).requiresCorrectToolForDrops().sound(SoundType.WOOD));
        setRegistryName("tiny_pumpkin_lantern");
    }
}
