package io.github.aquerr.pumpkinfever.item.armor.pumpkin;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class PumpkinArmorMaterial implements ArmorMaterial
{
    private static final PumpkinArmorMaterial PUMPKIN_ARMOR_MATERIAL = new PumpkinArmorMaterial();

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private static final int MAX_DAMAGE_FACTOR = 4;

    // Currently same as leather armor
    private final int[] damageReductionAmountArray = new int[]{1, 2, 3, 1};

    public static ArmorMaterial getMaterial()
    {
        return PUMPKIN_ARMOR_MATERIAL;
    }

    private PumpkinArmorMaterial()
    {

    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot equipmentSlot)
    {
        return MAX_DAMAGE_ARRAY[equipmentSlot.getIndex()] * MAX_DAMAGE_FACTOR;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot equipmentSlot)
    {
        return damageReductionAmountArray[equipmentSlot.getIndex()];
    }

    @Override
    public int getEnchantmentValue()
    {
        return 17;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return SoundEvents.ARMOR_EQUIP_LEATHER;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(Items.PUMPKIN);
    }

    @Override
    public String getName()
    {
        return new ResourceLocation(PumpkinFever.MOD_ID, "pumpkin").toString();
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
