package io.github.aquerr.pumpkinfever.item.armor.pumpkiniron;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class PumpkinInfusedIronHelmet extends ArmorItem
{
    public static final String REGISTRY_NAME = "pumpkin_infused_iron_helmet";

    public PumpkinInfusedIronHelmet()
    {
        super(PumpkinInfusedIronArmorMaterial.getMaterial(), EquipmentSlot.HEAD, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
    }
}
