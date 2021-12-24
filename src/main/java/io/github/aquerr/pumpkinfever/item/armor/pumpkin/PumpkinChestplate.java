package io.github.aquerr.pumpkinfever.item.armor.pumpkin;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;

public class PumpkinChestplate extends ArmorItem
{
    public PumpkinChestplate()
    {
        super(PumpkinArmorMaterial.getMaterial(), EquipmentSlot.CHEST, new Properties().tab(PumpkinFeverItemGroup.getInstance()));
        setRegistryName("pumpkin_chestplate");
    }
}
