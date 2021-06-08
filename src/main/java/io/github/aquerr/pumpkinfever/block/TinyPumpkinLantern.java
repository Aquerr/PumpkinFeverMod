package io.github.aquerr.pumpkinfever.block;

import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class TinyPumpkinLantern extends HorizontalBlock
{
    public TinyPumpkinLantern()
    {
        super(Properties.create(Material.GOURD).hardnessAndResistance(1.0F).setLightLevel(value -> 15).harvestTool(ToolType.AXE).sound(SoundType.WOOD));
        setRegistryName("tiny_pumpkin_lantern");
    }
}
