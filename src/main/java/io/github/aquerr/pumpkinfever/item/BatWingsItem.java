package io.github.aquerr.pumpkinfever.item;

import io.github.aquerr.pumpkinfever.PumpkinFeverItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Iterator;

public class BatWingsItem extends Item
{
    public static final String REGISTRY_NAME = "bat_wings";

    public BatWingsItem()
    {
        super(new Properties().tab(PumpkinFeverItemGroup.getInstance()).rarity(Rarity.EPIC).durability(2000));
    }

    @SubscribeEvent
    public void onLivingTick(LivingEvent.LivingTickEvent livingTickEvent)
    {
        LivingEntity livingEntity = livingTickEvent.getEntity();
        if (!(livingEntity instanceof Player))
        {
            return;
        }

        Player player = (Player) livingEntity;
        if (player.isCreative() || player.isSpectator())
            return;

        ItemStack batWings = findBatWings(player.getInventory());
        if (batWings == ItemStack.EMPTY)
            return;

        batWings.hurtAndBreak(1, player, (player1) -> {
            player1.displayClientMessage(Component.literal("Your bat wings have been destroyed!"), true);
        });
    }

    private ItemStack findBatWings(Inventory inventory)
    {
        Iterator<ItemStack> iterator = inventory.items.iterator();
        while (iterator.hasNext())
        {
            ItemStack itemStack = iterator.next();
            if (itemStack.getItem() instanceof BatWingItem)
                return itemStack;
        }
        return ItemStack.EMPTY;
    }
}
