package io.github.aquerr.pumpkinfever.item.armor.pumpkiniron;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import io.github.aquerr.pumpkinfever.item.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public class PumpkinInfusedIronArmorMaterial implements ArmorMaterial
{
    private static final PumpkinInfusedIronArmorMaterial PUMPKIN_INFUSED_IRON_ARMOR_MATERIAL = new PumpkinInfusedIronArmorMaterial();

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private static final int MAX_DAMAGE_FACTOR = 28;

    // Currently same as leather armor
    private final int[] damageReductionAmountArray = new int[]{2, 6, 7, 2};

    public static ArmorMaterial getMaterial()
    {
        return PUMPKIN_INFUSED_IRON_ARMOR_MATERIAL;
    }

    private PumpkinInfusedIronArmorMaterial()
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
        return 9;
    }

    @Override
    public SoundEvent getEquipSound()
    {
        return SoundEvents.ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient()
    {
        return Ingredient.of(ModItems.PUMPKIN_INFUSED_IRON.get());
    }

    @Override
    public String getName()
    {
        return new ResourceLocation(PumpkinFever.MOD_ID, "pumpkin_infused_iron").toString();
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
