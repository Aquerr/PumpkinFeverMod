package io.github.aquerr.pumpkinfever.mob;

import com.google.common.collect.ImmutableSet;
import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.Level;

public class CandyMerchant extends Villager
{
    public static final String REGISTRY_NAME = "candy_merchant";

    public static final VillagerProfession CANDY_MERCHAT_PROFESSION = new VillagerProfession("candyman", PoiType.NETHER_PORTAL, ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_CELEBRATE)
            .setRegistryName(PumpkinFever.MOD_ID + ":candyman");

    public CandyMerchant(EntityType<? extends Villager> p_35381_, Level p_35382_)
    {
        super(p_35381_, p_35382_);
    }

    public static AttributeSupplier.Builder createMobAttributes() {
        return Villager.createAttributes().add(Attributes.MOVEMENT_SPEED, 0.5D).add(Attributes.FOLLOW_RANGE, 48.0D);
    }
}
