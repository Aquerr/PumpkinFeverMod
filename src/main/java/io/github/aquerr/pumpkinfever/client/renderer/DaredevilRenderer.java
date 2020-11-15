package io.github.aquerr.pumpkinfever.client.renderer;

import io.github.aquerr.pumpkinfever.PumpkinFever;
import io.github.aquerr.pumpkinfever.mob.DaredevilEntity;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DaredevilRenderer extends AbstractHorseRenderer<DaredevilEntity, HorseModel<DaredevilEntity>>
{
    public DaredevilRenderer(EntityRendererManager renderManagerIn)
    {
        super(renderManagerIn, new HorseModel<>(0.0F), 1.1F);
    }

    @Override
    public ResourceLocation getEntityTexture(DaredevilEntity entity)
    {
        return new ResourceLocation(PumpkinFever.MOD_ID, "textures/entity/daredevil.png");
    }
}
