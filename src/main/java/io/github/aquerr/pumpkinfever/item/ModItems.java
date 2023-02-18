package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import io.github.aquerr.pumpkinfever.block.ModBlocks;
import io.github.aquerr.pumpkinfever.block.PumpkinVineBlock;
import io.github.aquerr.pumpkinfever.block.TinyPumpkin;
import io.github.aquerr.pumpkinfever.block.TinyPumpkinLantern;
import io.github.aquerr.pumpkinfever.item.armor.pumpkin.PumpkinBoots;
import io.github.aquerr.pumpkinfever.item.armor.pumpkin.PumpkinChestplate;
import io.github.aquerr.pumpkinfever.item.armor.pumpkin.PumpkinHelmet;
import io.github.aquerr.pumpkinfever.item.armor.pumpkin.PumpkinLeggings;
import io.github.aquerr.pumpkinfever.item.armor.pumpkiniron.PumpkinInfusedIronBoots;
import io.github.aquerr.pumpkinfever.item.armor.pumpkiniron.PumpkinInfusedIronChestplate;
import io.github.aquerr.pumpkinfever.item.armor.pumpkiniron.PumpkinInfusedIronHelmet;
import io.github.aquerr.pumpkinfever.item.armor.pumpkiniron.PumpkinInfusedIronLeggings;
import io.github.aquerr.pumpkinfever.item.food.*;
import io.github.aquerr.pumpkinfever.item.tool.pumpkin.PumpkinSword;
import io.github.aquerr.pumpkinfever.item.tool.pumpkiniron.*;
import io.github.aquerr.pumpkinfever.mob.PumpkinFeverEntityTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.RegisterEvent;

public class ModItems
{
    // BlockItems
    public static final Item PUMPKIN_VINE = new BlockItem(ModBlocks.PUMPKIN_VINE_BLOCK, new Item.Properties().tab(PumpkinFeverItemGroup.getInstance()));
    public static final Item TINY_PUMPKIN = new BlockItem(ModBlocks.TINY_PUMPKIN, new Item.Properties().tab(PumpkinFeverItemGroup.getInstance()));
    public static final Item TINY_PUMPKIN_LANTERN = new BlockItem(ModBlocks.TINY_PUMPKIN_LANTERN, new Item.Properties().tab(PumpkinFeverItemGroup.getInstance()));

    // Armor
    public static final PumpkinHelmet PUMPKIN_HELMET = new PumpkinHelmet();
    public static final PumpkinChestplate PUMPKIN_CHESTPLATE = new PumpkinChestplate();
    public static final PumpkinLeggings PUMPKIN_LEGGINGS = new PumpkinLeggings();
    public static final PumpkinBoots PUMPKIN_BOOTS = new PumpkinBoots();

    public static final PumpkinInfusedIronHelmet PUMPKIN_INFUSED_IRON_HELMET = new PumpkinInfusedIronHelmet();
    public static final PumpkinInfusedIronChestplate PUMPKIN_INFUSED_IRON_CHESTPLATE = new PumpkinInfusedIronChestplate();
    public static final PumpkinInfusedIronLeggings PUMPKIN_INFUSED_IRON_LEGGINGS = new PumpkinInfusedIronLeggings();
    public static final PumpkinInfusedIronBoots PUMPKIN_INFUSED_IRON_BOOTS = new PumpkinInfusedIronBoots();

    // Pumpkin tools
    public static final PumpkinSword PUMPKIN_SWORD = new PumpkinSword();
    public static final PumpkinInfusedIronSword PUMPKIN_INFUSED_IRON_SWORD = new PumpkinInfusedIronSword();
    public static final PumpkinInfusedIronShovel PUMPKIN_INFUSED_IRON_SHOVEL = new PumpkinInfusedIronShovel();
    public static final PumpkinInfusedIronHoe PUMPKIN_INFUSED_IRON_HOE = new PumpkinInfusedIronHoe();
    public static final PumpkinInfusedIronAxe PUMPKIN_INFUSED_IRON_AXE = new PumpkinInfusedIronAxe();
    public static final PumpkinInfusedIronPickaxe PUMPKIN_INFUSED_IRON_PICKAXE = new PumpkinInfusedIronPickaxe();

    // Other Items
    public static final PumpkinDust PUMPKIN_DUST = new PumpkinDust();
    public static final LollipopItem LOLLIPOP_ITEM = new LollipopItem();
    public static final CandyBasketItem CANDY_BASKET = new CandyBasketItem();
    public static final PumpkinFriesItem PUMPKIN_FRIES = new PumpkinFriesItem();
    public static final PumpkinSoupCreamItem PUMPKIN_SOUP_CREAM = new PumpkinSoupCreamItem();
    public static final PumpkinInfusedIron PUMPKIN_INFUSED_IRON = new PumpkinInfusedIron();
    public static final BatFleshItem BAT_FLESH = new BatFleshItem();
    public static final BatWingItem BAT_WING = new BatWingItem();
    public static final BatWingsItem BAT_WINGS = new BatWingsItem();
    public static final CrossItem CROSS_ITEM = new CrossItem();

    // Spawn Eggs
//    public static final Item DAREDEVIL_SPAWN_EGG = new ForgeSpawnEggItem(() -> PumpkinFeverEntityTypes.DAREDEVIL_ENTITY_ENTITY_TYPE.get(), 4996656, 986895, (new Item.Properties()).tab(PumpkinFeverItemGroup.getInstance()));
//    public static final Item HEADLESS_HORSEMAN_SPAWN_EGG = new ForgeSpawnEggItem(() -> PumpkinFeverEntityTypes.HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE.get(), 4996656, 986895, (new Item.Properties()).tab(PumpkinFeverItemGroup.getInstance()));

    public static void registerItems(RegisterEvent.RegisterHelper<Item> registry)
    {
        registry.register(PumpkinVineBlock.REGISTRY_NAME, PUMPKIN_VINE);
        registry.register(TinyPumpkin.REGISTRY_NAME, TINY_PUMPKIN);
        registry.register(TinyPumpkinLantern.REGISTRY_NAME, TINY_PUMPKIN_LANTERN);

        // Armor -- Start
        registry.register(PumpkinHelmet.REGISTRY_NAME, PUMPKIN_HELMET);
        registry.register(PumpkinChestplate.REGISTRY_NAME, PUMPKIN_CHESTPLATE);
        registry.register(PumpkinLeggings.REGISTRY_NAME, PUMPKIN_LEGGINGS);
        registry.register(PumpkinBoots.REGISTRY_NAME, PUMPKIN_BOOTS);

        registry.register(PumpkinInfusedIronHelmet.REGISTRY_NAME, PUMPKIN_INFUSED_IRON_HELMET);
        registry.register(PumpkinInfusedIronChestplate.REGISTRY_NAME, PUMPKIN_INFUSED_IRON_CHESTPLATE);
        registry.register(PumpkinInfusedIronLeggings.REGISTRY_NAME, PUMPKIN_INFUSED_IRON_LEGGINGS);
        registry.register(PumpkinInfusedIronBoots.REGISTRY_NAME, PUMPKIN_INFUSED_IRON_BOOTS);
        // Armor -- End

        registry.register(PumpkinDust.REGISTRY_NAME, PUMPKIN_DUST);
        registry.register(LollipopItem.REGISTRY_NAME, LOLLIPOP_ITEM);
        registry.register(CandyBasketItem.REGISTRY_NAME, CANDY_BASKET);
        registry.register(PumpkinFriesItem.REGISTRY_NAME, PUMPKIN_FRIES);
        registry.register(PumpkinSoupCreamItem.REGISTRY_NAME, PUMPKIN_SOUP_CREAM);
        registry.register(PumpkinInfusedIron.REGISTRY_NAME, PUMPKIN_INFUSED_IRON);
        registry.register(BatFleshItem.REGISTRY_NAME, BAT_FLESH);
        registry.register(BatWingItem.REGISTRY_NAME, BAT_WING);
        registry.register(BatWingsItem.REGISTRY_NAME, BAT_WINGS);
        registry.register(CrossItem.REGISTRY_NAME, CROSS_ITEM);

        // Tools -- Start
        registry.register(PumpkinSword.REGISTRY_NAME, PUMPKIN_SWORD);
        registry.register(PumpkinInfusedIronSword.REGISTRY_NAME, PUMPKIN_INFUSED_IRON_SWORD);
        registry.register(PumpkinInfusedIronHoe.REGISTRY_NAME, PUMPKIN_INFUSED_IRON_HOE);
        registry.register(PumpkinInfusedIronShovel.REGISTRY_NAME, PUMPKIN_INFUSED_IRON_SHOVEL);
        registry.register(PumpkinInfusedIronAxe.REGISTRY_NAME, PUMPKIN_INFUSED_IRON_AXE);
        registry.register(PumpkinInfusedIronPickaxe.REGISTRY_NAME, PUMPKIN_INFUSED_IRON_PICKAXE);
        // Tools -- End

        // SpawnEggs -- Start
//        registry.register("daredevil_spawn_egg", DAREDEVIL_SPAWN_EGG);
//        registry.register("headless_horseman_spawn_egg", HEADLESS_HORSEMAN_SPAWN_EGG);
        // SpawnEggs -- Stop
    }
}
