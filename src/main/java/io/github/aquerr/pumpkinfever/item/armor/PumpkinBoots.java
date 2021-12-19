package io.github.aquerr.pumpkinfever.item.armor;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class PumpkinBoots extends ArmorItem
{
    public PumpkinBoots()
    {
        super(PumpkinArmorMaterial.getMaterial(), EquipmentSlot.FEET, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_boots");
    }
}
