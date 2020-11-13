package io.github.aquerr.pumpkinfever.block;

import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

//TODO: Should connect to pumpkins and other pumpkin vines like redstone.
public class PumpkinVineBlock extends HorizontalBlock
{
    public PumpkinVineBlock()
    {
        super(Properties.create(Material.LEAVES).harvestTool(ToolType.AXE).hardnessAndResistance(1.0F).sound(SoundType.PLANT));
        setRegistryName("pumpkin_vine");
    }
}
