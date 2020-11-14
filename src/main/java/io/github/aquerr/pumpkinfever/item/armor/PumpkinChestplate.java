package io.github.aquerr.pumpkinfever.item.armor;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class PumpkinChestplate extends ArmorItem
{
    public PumpkinChestplate()
    {
        super(PumpkinArmorMaterial.getMaterial(), EquipmentSlotType.CHEST, new Properties().group(PumpkinFever.ITEM_GROUP));
        setRegistryName("pumpkin_chestplate");
    }
}
