package io.github.aquerr.pumpkinfever.item.armor;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class PumpkinLeggings extends ArmorItem
{
    public PumpkinLeggings()
    {
        super(PumpkinArmorMaterial.getMaterial(), EquipmentSlotType.LEGS, new Properties().group(PumpkinFever.ITEM_GROUP));
        setRegistryName("pumpkin_leggings");
    }
}
