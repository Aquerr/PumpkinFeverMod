package io.github.aquerr.pumpkinfever.item.armor.pumpkiniron;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import io.github.aquerr.pumpkinfever.item.armor.pumpkin.PumpkinArmorMaterial;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class PumpkinInfusedIronChestplate extends ArmorItem
{
    public PumpkinInfusedIronChestplate()
    {
        super(PumpkinInfusedIronArmorMaterial.getMaterial(), EquipmentSlot.CHEST, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_infused_iron_chestplate");
    }
}
