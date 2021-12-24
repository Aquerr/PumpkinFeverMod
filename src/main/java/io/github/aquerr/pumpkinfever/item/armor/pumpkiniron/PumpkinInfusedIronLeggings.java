package io.github.aquerr.pumpkinfever.item.armor.pumpkiniron;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import io.github.aquerr.pumpkinfever.item.armor.pumpkin.PumpkinArmorMaterial;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class PumpkinInfusedIronLeggings extends ArmorItem
{
    public PumpkinInfusedIronLeggings()
    {
        super(PumpkinInfusedIronArmorMaterial.getMaterial(), EquipmentSlot.LEGS, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_infused_iron_leggings");
    }
}
