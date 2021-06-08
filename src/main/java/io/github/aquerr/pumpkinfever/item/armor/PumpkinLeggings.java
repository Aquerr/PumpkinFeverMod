package io.github.aquerr.pumpkinfever.item.armor;

import io.github.aquerr.pumpkinfever.item.PumpkinFeverItemGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class PumpkinLeggings extends ArmorItem
{
    public PumpkinLeggings()
    {
        super(PumpkinArmorMaterial.getMaterial(), EquipmentSlotType.LEGS, new Properties().group(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_leggings");
    }
}
