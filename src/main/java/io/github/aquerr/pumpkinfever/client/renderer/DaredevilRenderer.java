package io.github.aquerr.pumpkinfever.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.aquerr.pumpkinfever.PumpkinFever;
import io.github.aquerr.pumpkinfever.mob.DaredevilEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.entity.Pose;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
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

    @Override
    public void render(DaredevilEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn)
    {
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
}
