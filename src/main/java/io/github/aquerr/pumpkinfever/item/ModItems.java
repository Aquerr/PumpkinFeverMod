package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFever;
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
import io.github.aquerr.pumpkinfever.item.food.BatFleshItem;
import io.github.aquerr.pumpkinfever.item.food.CandyBasketItem;
import io.github.aquerr.pumpkinfever.item.food.LollipopItem;
import io.github.aquerr.pumpkinfever.item.food.PumpkinFriesItem;
import io.github.aquerr.pumpkinfever.item.food.PumpkinSoupCreamItem;
import io.github.aquerr.pumpkinfever.item.tool.pumpkin.PumpkinSword;
import io.github.aquerr.pumpkinfever.item.tool.pumpkiniron.PumpkinInfusedIronAxe;
import io.github.aquerr.pumpkinfever.item.tool.pumpkiniron.PumpkinInfusedIronHoe;
import io.github.aquerr.pumpkinfever.item.tool.pumpkiniron.PumpkinInfusedIronPickaxe;
import io.github.aquerr.pumpkinfever.item.tool.pumpkiniron.PumpkinInfusedIronShovel;
import io.github.aquerr.pumpkinfever.item.tool.pumpkiniron.PumpkinInfusedIronSword;
import io.github.aquerr.pumpkinfever.mob.DaredevilEntity;
import io.github.aquerr.pumpkinfever.mob.HeadlessHorsemanEntity;
import io.github.aquerr.pumpkinfever.mob.PumpkinFeverEntityTypes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, PumpkinFever.MOD_ID);

    // BlockItems
    public static final RegistryObject<Item> PUMPKIN_VINE = ITEMS.register(PumpkinVineBlock.REGISTRY_NAME, () -> new BlockItem(ModBlocks.PUMPKIN_VINE_BLOCK.get(), new Item.Properties().tab(PumpkinFeverItemGroup.getInstance())));
    public static final RegistryObject<Item> TINY_PUMPKIN = ITEMS.register(TinyPumpkin.REGISTRY_NAME, () -> new BlockItem(ModBlocks.TINY_PUMPKIN.get(), new Item.Properties().tab(PumpkinFeverItemGroup.getInstance())));
    public static final RegistryObject<Item> TINY_PUMPKIN_LANTERN = ITEMS.register(TinyPumpkinLantern.REGISTRY_NAME, () -> new BlockItem(ModBlocks.TINY_PUMPKIN_LANTERN.get(), new Item.Properties().tab(PumpkinFeverItemGroup.getInstance())));

    // Armor
    public static final RegistryObject<PumpkinHelmet> PUMPKIN_HELMET = ITEMS.register(PumpkinHelmet.REGISTRY_NAME, PumpkinHelmet::new);
    public static final RegistryObject<PumpkinChestplate> PUMPKIN_CHESTPLATE = ITEMS.register(PumpkinChestplate.REGISTRY_NAME, PumpkinChestplate::new);
    public static final RegistryObject<PumpkinLeggings> PUMPKIN_LEGGINGS = ITEMS.register(PumpkinLeggings.REGISTRY_NAME, PumpkinLeggings::new);
    public static final RegistryObject<PumpkinBoots> PUMPKIN_BOOTS = ITEMS.register(PumpkinBoots.REGISTRY_NAME, PumpkinBoots::new);

    public static final RegistryObject<PumpkinInfusedIronHelmet> PUMPKIN_INFUSED_IRON_HELMET = ITEMS.register(PumpkinInfusedIronHelmet.REGISTRY_NAME, PumpkinInfusedIronHelmet::new);
    public static final RegistryObject<PumpkinInfusedIronChestplate> PUMPKIN_INFUSED_IRON_CHESTPLATE = ITEMS.register(PumpkinInfusedIronChestplate.REGISTRY_NAME, PumpkinInfusedIronChestplate::new);
    public static final RegistryObject<PumpkinInfusedIronLeggings> PUMPKIN_INFUSED_IRON_LEGGINGS = ITEMS.register(PumpkinInfusedIronLeggings.REGISTRY_NAME, PumpkinInfusedIronLeggings::new);
    public static final RegistryObject<PumpkinInfusedIronBoots> PUMPKIN_INFUSED_IRON_BOOTS = ITEMS.register(PumpkinInfusedIronBoots.REGISTRY_NAME, PumpkinInfusedIronBoots::new);

    // Pumpkin tools
    public static final RegistryObject<PumpkinSword> PUMPKIN_SWORD = ITEMS.register(PumpkinSword.REGISTRY_NAME, PumpkinSword::new);
    public static final RegistryObject<PumpkinInfusedIronSword> PUMPKIN_INFUSED_IRON_SWORD = ITEMS.register(PumpkinInfusedIronSword.REGISTRY_NAME, PumpkinInfusedIronSword::new);
    public static final RegistryObject<PumpkinInfusedIronShovel> PUMPKIN_INFUSED_IRON_SHOVEL = ITEMS.register(PumpkinInfusedIronShovel.REGISTRY_NAME, PumpkinInfusedIronShovel::new);
    public static final RegistryObject<PumpkinInfusedIronHoe> PUMPKIN_INFUSED_IRON_HOE = ITEMS.register(PumpkinInfusedIronHoe.REGISTRY_NAME, PumpkinInfusedIronHoe::new);
    public static final RegistryObject<PumpkinInfusedIronAxe> PUMPKIN_INFUSED_IRON_AXE = ITEMS.register(PumpkinInfusedIronAxe.REGISTRY_NAME, PumpkinInfusedIronAxe::new);
    public static final RegistryObject<PumpkinInfusedIronPickaxe> PUMPKIN_INFUSED_IRON_PICKAXE = ITEMS.register(PumpkinInfusedIronPickaxe.REGISTRY_NAME, PumpkinInfusedIronPickaxe::new);

    // Other Items
    public static final RegistryObject<PumpkinDust> PUMPKIN_DUST = ITEMS.register(PumpkinDust.REGISTRY_NAME, PumpkinDust::new);
    public static final RegistryObject<LollipopItem> LOLLIPOP_ITEM = ITEMS.register(LollipopItem.REGISTRY_NAME, LollipopItem::new);
    public static final RegistryObject<CandyBasketItem> CANDY_BASKET = ITEMS.register(CandyBasketItem.REGISTRY_NAME, CandyBasketItem::new);
    public static final RegistryObject<PumpkinFriesItem> PUMPKIN_FRIES = ITEMS.register(PumpkinFriesItem.REGISTRY_NAME, PumpkinFriesItem::new);
    public static final RegistryObject<PumpkinSoupCreamItem> PUMPKIN_SOUP_CREAM = ITEMS.register(PumpkinSoupCreamItem.REGISTRY_NAME, PumpkinSoupCreamItem::new);
    public static final RegistryObject<PumpkinInfusedIron> PUMPKIN_INFUSED_IRON = ITEMS.register(PumpkinInfusedIron.REGISTRY_NAME, PumpkinInfusedIron::new);
    public static final RegistryObject<BatFleshItem> BAT_FLESH = ITEMS.register(BatFleshItem.REGISTRY_NAME, BatFleshItem::new);
    public static final RegistryObject<BatWingItem> BAT_WING = ITEMS.register(BatWingItem.REGISTRY_NAME, BatWingItem::new);
    public static final RegistryObject<BatWingsItem> BAT_WINGS = ITEMS.register(BatWingsItem.REGISTRY_NAME, BatWingsItem::new);
    public static final RegistryObject<CrossItem> CROSS_ITEM = ITEMS.register(CrossItem.REGISTRY_NAME, CrossItem::new);

    // Spawn Eggs
    public static final RegistryObject<Item> DAREDEVIL_SPAWN_EGG = ITEMS.register(DaredevilEntity.REGISTRY_NAME + "_spawn_egg", () -> new ForgeSpawnEggItem(PumpkinFeverEntityTypes.DAREDEVIL_ENTITY_ENTITY_TYPE, 4996656, 986895, (new Item.Properties()).tab(PumpkinFeverItemGroup.getInstance())));
    public static final RegistryObject<Item> HEADLESS_HORSEMAN_SPAWN_EGG = ITEMS.register(HeadlessHorsemanEntity.REGISTRY_NAME + "_spawn_egg", () -> new ForgeSpawnEggItem(PumpkinFeverEntityTypes.HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE, 4996656, 986895, (new Item.Properties()).tab(PumpkinFeverItemGroup.getInstance())));
}
