package io.github.aquerr.pumpkinfever.mob;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.registries.RegisterEvent;

public class PumpkinFeverVillagerProfessions
{

    public static void registerProfessions(RegisterEvent.RegisterHelper<VillagerProfession> registerHelper)
    {
        registerHelper.register(CandyMerchant.REGISTRY_NAME, CandyMerchant.CANDY_MERCHANT_PROFESSION);

        VillagerTrades.TRADES.put(CandyMerchant.CANDY_MERCHANT_PROFESSION, CandyMerchant.TRADES);
    }
}
