package io.github.aquerr.pumpkinfever.item.armor;

import io.github.aquerr.pumpkinfever.item.PumpkinFeverItemGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class PumpkinChestplate extends ArmorItem
{
    public PumpkinChestplate()
    {
        super(PumpkinArmorMaterial.getMaterial(), EquipmentSlotType.CHEST, new Properties().group(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_chestplate");
    }
}
