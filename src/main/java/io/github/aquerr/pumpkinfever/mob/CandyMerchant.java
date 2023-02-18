package io.github.aquerr.pumpkinfever.mob;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.github.aquerr.pumpkinfever.PumpkinFever;
import io.github.aquerr.pumpkinfever.item.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

public class CandyMerchant
{
    public static final String REGISTRY_NAME = "candyman";

    public static final PoiType CANDYMAN_POI_TYPE = new PoiType(ImmutableSet.copyOf(Blocks.CARVED_PUMPKIN.getStateDefinition().getPossibleStates()), 1, 1);

    public static final VillagerProfession CANDY_MERCHANT_PROFESSION = new VillagerProfession(new ResourceLocation(PumpkinFever.MOD_ID, REGISTRY_NAME).toString(),
            (typeHolder) -> typeHolder.get().equals(CANDYMAN_POI_TYPE),
            (poiType) -> poiType.get().equals(CANDYMAN_POI_TYPE),
            ImmutableSet.of(),
            ImmutableSet.of(),
            SoundEvents.VILLAGER_CELEBRATE);

    public static final Int2ObjectOpenHashMap TRADES = new Int2ObjectOpenHashMap<>(ImmutableMap.of(
            1, new VillagerTrades.ItemListing[]{new CandyMerchant.CandyMerchantOfferEmeraldForItems(Items.CARVED_PUMPKIN, 3, 16, 1, 2)},
            2, new VillagerTrades.ItemListing[] {new CandyMerchant.CandyMerchantOfferEmeraldForItems(ModItems.LOLLIPOP_ITEM, 1, 16, 2, 1),
                    new CandyMerchant.CandyMerchantOfferEmeraldForItems(Items.PUMPKIN, 3, 16, 1, 2)}));

    public static class CandyMerchantOfferEmeraldForItems implements VillagerTrades.ItemListing
    {
        private final Item item;
        private final int cost;
        private final int maxUses;
        private final int villagerXp;
        private final float priceMultiplier;
        private final int amountPerPurchase;

        public CandyMerchantOfferEmeraldForItems(ItemLike itemLike, int cost, int maxUses, int amountPerPurchase, int villagerXp) {
            this.item = itemLike.asItem();
            this.cost = cost;
            this.maxUses = maxUses;
            this.villagerXp = villagerXp;
            this.priceMultiplier = 0.05F;
            this.amountPerPurchase = amountPerPurchase;
        }

        @Nullable
        @Override
        public MerchantOffer getOffer(Entity p_219693_, RandomSource p_219694_)
        {
            return new MerchantOffer(
                    new ItemStack(Items.EMERALD, cost),
                    new ItemStack(item, amountPerPurchase),
                    maxUses,
                    villagerXp,
                    priceMultiplier);
        }
    }
}
