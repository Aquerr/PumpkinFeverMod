package io.github.aquerr.pumpkinfever.item.armor;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class PumpkinHelmet extends ArmorItem
{
    public PumpkinHelmet()
    {
        super(PumpkinArmorMaterial.getMaterial(), EquipmentSlot.HEAD, new Item.Properties().tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_helmet");
    }
}
