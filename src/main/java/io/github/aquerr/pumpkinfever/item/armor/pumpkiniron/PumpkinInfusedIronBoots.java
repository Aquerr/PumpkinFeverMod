package io.github.aquerr.pumpkinfever.item.armor.pumpkiniron;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import io.github.aquerr.pumpkinfever.item.armor.pumpkin.PumpkinArmorMaterial;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class PumpkinInfusedIronBoots extends ArmorItem
{
    public PumpkinInfusedIronBoots()
    {
        super(PumpkinInfusedIronArmorMaterial.getMaterial(), EquipmentSlot.FEET, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_infused_iron_boots");
    }
}
