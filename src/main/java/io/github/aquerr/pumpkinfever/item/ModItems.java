package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import io.github.aquerr.pumpkinfever.block.ModBlocks;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinBoots;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinChestplate;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinHelmet;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinLeggings;
import io.github.aquerr.pumpkinfever.item.tool.PumpkinIronSword;
import io.github.aquerr.pumpkinfever.mob.ModEntityTypeRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems
{
    // BlockItems
    public static final Item PUMPKIN_VINE = new BlockItem(ModBlocks.PUMPKIN_VINE_BLOCK, new Item.Properties().tab(PumpkinFeverItemGroup.getInstance())).setRegistryName(ModBlocks.PUMPKIN_VINE_BLOCK.getRegistryName());
    public static final Item TINY_PUMPKIN = new BlockItem(ModBlocks.TINY_PUMPKIN, new Item.Properties().tab(PumpkinFeverItemGroup.getInstance())).setRegistryName(ModBlocks.TINY_PUMPKIN.getRegistryName());
    public static final Item TINY_PUMPKIN_LANTERN = new BlockItem(ModBlocks.TINY_PUMPKIN_LANTERN, new Item.Properties().tab(PumpkinFeverItemGroup.getInstance())).setRegistryName(ModBlocks.TINY_PUMPKIN_LANTERN.getRegistryName());

    // Armor
    public static final PumpkinHelmet PUMPKIN_HELMET = new PumpkinHelmet();
    public static final PumpkinChestplate PUMPKIN_CHESTPLATE = new PumpkinChestplate();
    public static final PumpkinLeggings PUMPKIN_LEGGINGS = new PumpkinLeggings();
    public static final PumpkinBoots PUMPKIN_BOOTS = new PumpkinBoots();

    // Pumpkin tools
    public static final PumpkinIronSword PUMPKIN_SWORD = new PumpkinIronSword();

    // Other Items
    public static final PumpkinDust PUMPKIN_DUST = new PumpkinDust();
    public static final LollipopItem CANDY = new LollipopItem();
    public static final CandyBasketItem CANDY_BASKET = new CandyBasketItem();
    public static final PumpkinFriesItem PUMPKIN_FRIES = new PumpkinFriesItem();
    public static final PumpkinSoupCreamItem PUMPKIN_SOUP_CREAM = new PumpkinSoupCreamItem();
    public static final PumpkinInfusedIron PUMPKIN_INFUSED_IRON = new PumpkinInfusedIron();
    public static final BatFleshItem BAT_FLESH = new BatFleshItem();
    public static final BatWingItem BAT_WING = new BatWingItem();
    public static final BatWingsItem BAT_WINGS = new BatWingsItem();

    // Spawn Eggs
    public static final Item DAREDEVIL_SPAWN_EGG = new ForgeSpawnEggItem(() -> ModEntityTypeRegistry.DAREDEVIL_ENTITY_ENTITY_TYPE, 4996656, 986895, (new Item.Properties()).tab(PumpkinFeverItemGroup.getInstance())).setRegistryName("daredevil_spawn_egg");
    public static final Item HEADLESS_HORSEMAN_SPAWN_EGG = new ForgeSpawnEggItem(() -> ModEntityTypeRegistry.HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE, 4996656, 986895, (new Item.Properties()).tab(PumpkinFeverItemGroup.getInstance())).setRegistryName("headless_horseman_spawn_egg");

    public static void registerItems(final IForgeRegistry<Item> registry)
    {
        registry.register(PUMPKIN_VINE);
        registry.register(TINY_PUMPKIN);
        registry.register(TINY_PUMPKIN_LANTERN);

        registry.register(PUMPKIN_HELMET);
        registry.register(PUMPKIN_CHESTPLATE);
        registry.register(PUMPKIN_LEGGINGS);
        registry.register(PUMPKIN_BOOTS);

        registry.register(PUMPKIN_DUST);
        registry.register(CANDY);
        registry.register(CANDY_BASKET);
        registry.register(PUMPKIN_FRIES);
        registry.register(PUMPKIN_SOUP_CREAM);
        registry.register(PUMPKIN_INFUSED_IRON);
        registry.register(BAT_FLESH);
        registry.register(BAT_WING);
        registry.register(BAT_WINGS);

        registry.register(PUMPKIN_SWORD);

        registry.register(DAREDEVIL_SPAWN_EGG);
        registry.register(HEADLESS_HORSEMAN_SPAWN_EGG);
    }

    public static void registerModels()
    {

    }
}
