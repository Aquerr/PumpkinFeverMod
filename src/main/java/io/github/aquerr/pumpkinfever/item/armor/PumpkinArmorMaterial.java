package io.github.aquerr.pumpkinfever.item.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class PumpkinArmorMaterial implements IArmorMaterial
{
    private static final PumpkinArmorMaterial PUMPKIN_ARMOR_MATERIAL = new PumpkinArmorMaterial();

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private static final int MAX_DAMAGE_FACTOR = 4;

    // Currently same as leather armor
    private final int[] damageReductionAmountArray = new int[]{1, 2, 3, 1};

    public static IArmorMaterial getMaterial()
    {
        return PUMPKIN_ARMOR_MATERIAL;
    }

    private PumpkinArmorMaterial()
    {

    }

    @Override
    public int getDurability(EquipmentSlotType slotIn)
    {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * MAX_DAMAGE_FACTOR;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn)
    {
        return damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability()
    {
        return 17;
    }

    @Override
    public SoundEvent getSoundEvent()
    {
        return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
    }

    @Override
    public Ingredient getRepairMaterial()
    {
        return Ingredient.fromItems(Items.PUMPKIN);
    }

    @Override
    public String getName()
    {
        return "pumpkin";
    }

    @Override
    public float getToughness()
    {
        return 0;
    }

    @Override
    public float getKnockbackResistance()
    {
        return 0;
    }
}
