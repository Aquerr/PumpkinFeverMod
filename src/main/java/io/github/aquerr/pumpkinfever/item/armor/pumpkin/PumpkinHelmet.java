package io.github.aquerr.pumpkinfever.item.armor.pumpkin;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

public class PumpkinHelmet extends ArmorItem
{
    public static final String REGISTRY_NAME = "pumpkin_helmet";
    public PumpkinHelmet()
    {
        super(PumpkinArmorMaterial.getMaterial(), EquipmentSlot.HEAD, new Item.Properties().tab(PumpkinFeverItemGroup.getInstance()));
    }
}
