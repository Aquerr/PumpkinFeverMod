package io.github.aquerr.pumpkinfever.item.armor;

import io.github.aquerr.pumpkinfever.item.PumpkinFeverItemGroup;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class PumpkinBoots extends ArmorItem
{
    public PumpkinBoots()
    {
        super(PumpkinArmorMaterial.getMaterial(), EquipmentSlotType.FEET, new Properties().group(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_boots");
    }
}
