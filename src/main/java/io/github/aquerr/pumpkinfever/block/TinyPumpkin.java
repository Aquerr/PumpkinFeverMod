package io.github.aquerr.pumpkinfever.block;

import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class TinyPumpkin extends HorizontalDirectionalBlock
{
    public static final String REGISTRY_NAME = "tiny_pumpkin";

    public TinyPumpkin()
    {
        super(Properties.of(Material.VEGETABLE).strength(1.0F).requiresCorrectToolForDrops().sound(SoundType.WOOD));
    }
}
