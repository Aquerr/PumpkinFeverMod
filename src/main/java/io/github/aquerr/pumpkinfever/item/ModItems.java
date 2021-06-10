package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.block.ModBlocks;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinBoots;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinChestplate;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinHelmet;
import io.github.aquerr.pumpkinfever.item.armor.PumpkinLeggings;
import io.github.aquerr.pumpkinfever.item.tool.PumpkinIronSword;
import io.github.aquerr.pumpkinfever.mob.ModEntityTypeRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems
{
    // BlockItems
    public static final Item PUMPKIN_VINE = new BlockItem(ModBlocks.PUMPKIN_VINE_BLOCK, new Item.Properties().group(PumpkinFeverItemGroup.getInstance())).setRegistryName(ModBlocks.PUMPKIN_VINE_BLOCK.getRegistryName());
    public static final Item TINY_PUMPKIN = new BlockItem(ModBlocks.TINY_PUMPKIN, new Item.Properties().group(PumpkinFeverItemGroup.getInstance())).setRegistryName(ModBlocks.TINY_PUMPKIN.getRegistryName());
    public static final Item TINY_PUMPKIN_LANTERN = new BlockItem(ModBlocks.TINY_PUMPKIN_LANTERN, new Item.Properties().group(PumpkinFeverItemGroup.getInstance())).setRegistryName(ModBlocks.TINY_PUMPKIN_LANTERN.getRegistryName());

    // Armor
    public static final PumpkinHelmet PUMPKIN_HELMET = new PumpkinHelmet();
    public static final PumpkinChestplate PUMPKIN_CHESTPLATE = new PumpkinChestplate();
    public static final PumpkinLeggings PUMPKIN_LEGGINGS = new PumpkinLeggings();
    public static final PumpkinBoots PUMPKIN_BOOTS = new PumpkinBoots();

    // Pumpkin tools
    public static final PumpkinIronSword PUMPKIN_SWORD = new PumpkinIronSword();

    // Other Items
    public static final PumpkinDust PUMPKIN_DUST = new PumpkinDust();
    public static final CandyItem CANDY = new CandyItem();
    public static final CandyBasketItem CANDY_BASKET = new CandyBasketItem();
    public static final PumpkinFriesItem PUMPKIN_FRIES = new PumpkinFriesItem();
    public static final PumpkinSoupCreamItem PUMPKIN_SOUP_CREAM = new PumpkinSoupCreamItem();

    // Spawn Eggs
    public static final Item DAREDEVIL_SPAWN_EGG = new SpawnEggItem(ModEntityTypeRegistry.DAREDEVIL_ENTITY_ENTITY_TYPE, 4996656, 986895, (new Item.Properties()).group(PumpkinFeverItemGroup.getInstance())).setRegistryName("daredevil_spawn_egg");
    public static final Item HEADLESS_HORSEMAN_SPAWN_EGG = new SpawnEggItem(ModEntityTypeRegistry.HEADLESS_HORSEMAN_ENTITY_ENTITY_TYPE, 4996656, 986895, (new Item.Properties()).group(PumpkinFeverItemGroup.getInstance())).setRegistryName("headless_horseman_spawn_egg");

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

        registry.register(PUMPKIN_SWORD);

        registry.register(DAREDEVIL_SPAWN_EGG);
        registry.register(HEADLESS_HORSEMAN_SPAWN_EGG);
    }

    public static void registerModels()
    {

    }
}
