package io.github.aquerr.pumpkinfever.sound;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PumpkinFever.MOD_ID);

    public static final RegistryObject<SoundEvent> CROW_SOUND = SOUND_EVENTS.register("crow", () -> new SoundEvent(new ResourceLocation(PumpkinFever.MOD_ID, "crow"), 6));
}
