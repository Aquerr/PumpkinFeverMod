package io.github.aquerr.pumpkinfever.item.armor;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class PumpkinHelmet extends ArmorItem
{
    public PumpkinHelmet()
    {
        super(PumpkinArmorMaterial.getMaterial(), EquipmentSlotType.HEAD, new Item.Properties().group(PumpkinFever.ITEM_GROUP));
        setRegistryName("pumpkin_helmet");
    }
}
