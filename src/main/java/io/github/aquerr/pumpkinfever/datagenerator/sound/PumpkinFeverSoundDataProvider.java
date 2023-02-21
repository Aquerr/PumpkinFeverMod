package io.github.aquerr.pumpkinfever.datagenerator.sound;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinition;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class PumpkinFeverSoundDataProvider extends SoundDefinitionsProvider
{
    public PumpkinFeverSoundDataProvider(DataGenerator generator, ExistingFileHelper helper)
    {
        super(generator, PumpkinFever.MOD_ID, helper);
    }

    @Override
    public void registerSounds()
    {
        ResourceLocation crowSoundResourceLocation = new ResourceLocation(PumpkinFever.MOD_ID, "crow");
        add(crowSoundResourceLocation, SoundDefinition.definition()
                .subtitle("sound." + PumpkinFever.MOD_ID + ".crow")
                .with(
                        SoundDefinition.Sound.sound(crowSoundResourceLocation, SoundDefinition.SoundType.SOUND),
                        SoundDefinition.Sound.sound(crowSoundResourceLocation, SoundDefinition.SoundType.SOUND)
                        .pitch(1.1)
                )
        );

        ResourceLocation pumpkinLaughSoundResourceLocation = new ResourceLocation(PumpkinFever.MOD_ID, "pumpkin_laugh");
        add(pumpkinLaughSoundResourceLocation, SoundDefinition.definition()
                .subtitle("sound." + PumpkinFever.MOD_ID + ".pumpkin_laugh")
                .with(
                        SoundDefinition.Sound.sound(pumpkinLaughSoundResourceLocation, SoundDefinition.SoundType.SOUND),
                        SoundDefinition.Sound.sound(pumpkinLaughSoundResourceLocation, SoundDefinition.SoundType.SOUND)
                                .pitch(1.1)
                )
        );
    }
}
