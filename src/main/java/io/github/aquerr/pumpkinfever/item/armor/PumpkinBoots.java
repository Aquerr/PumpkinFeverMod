package io.github.aquerr.pumpkinfever.item.armor;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class PumpkinBoots extends ArmorItem
{
    public PumpkinBoots()
    {
        super(PumpkinArmorMaterial.getMaterial(), EquipmentSlotType.FEET, new Properties().group(PumpkinFever.ITEM_GROUP));
        setRegistryName("pumpkin_boots");
    }
}
