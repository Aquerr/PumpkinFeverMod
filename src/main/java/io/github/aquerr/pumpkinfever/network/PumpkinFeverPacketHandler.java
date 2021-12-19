package io.github.aquerr.pumpkinfever.network;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class PumpkinFeverPacketHandler
{
    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(PumpkinFever.MOD_ID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void registerMessages()
    {
        int messageIndex = 1;

//        INSTANCE.registerMessage(messageIndex++, );
    }
}
