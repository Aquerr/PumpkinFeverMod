package io.github.aquerr.pumpkinfever.item.armor.pumpkin;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class PumpkinLeggings extends ArmorItem
{
    public static final String REGISTRY_NAME = "pumpkin_leggings";

    public PumpkinLeggings()
    {
        super(PumpkinArmorMaterial.getMaterial(), EquipmentSlot.LEGS, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
    }
}
