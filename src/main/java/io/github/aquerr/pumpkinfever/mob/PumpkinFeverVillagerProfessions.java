package io.github.aquerr.pumpkinfever.mob;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

public class PumpkinFeverVillagerProfessions
{
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, PumpkinFever.MOD_ID);

    public static final RegistryObject<VillagerProfession> CANDY_MERCHANT_PROFESSION = VILLAGER_PROFESSIONS.register(CandyMerchant.REGISTRY_NAME, () -> CandyMerchant.CANDY_MERCHANT_PROFESSION);

    public static void registerProfessions(RegisterEvent.RegisterHelper<VillagerProfession> registerHelper)
    {
//        VillagerTrades.TRADES.put(CandyMerchant.CANDY_MERCHANT_PROFESSION, CandyMerchant.TRADES);
    }
}
