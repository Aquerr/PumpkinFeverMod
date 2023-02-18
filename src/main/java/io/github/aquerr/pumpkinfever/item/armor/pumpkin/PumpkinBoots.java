package io.github.aquerr.pumpkinfever.item.armor.pumpkin;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class PumpkinBoots extends ArmorItem
{
    public static final String REGISTRY_NAME = "pumpkin_boots";

    public PumpkinBoots()
    {
        super(PumpkinArmorMaterial.getMaterial(), EquipmentSlot.FEET, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
    }
}
