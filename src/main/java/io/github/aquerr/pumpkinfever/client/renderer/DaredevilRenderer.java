package io.github.aquerr.pumpkinfever.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.aquerr.pumpkinfever.PumpkinFever;
import io.github.aquerr.pumpkinfever.mob.DaredevilEntity;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DaredevilRenderer extends AbstractHorseRenderer<DaredevilEntity, HorseModel<DaredevilEntity>>
{
//       public HorseRenderer(EntityRendererProvider.Context p_174167_) {
//      super(p_174167_, new HorseModel<>(p_174167_.bakeLayer(ModelLayers.HORSE)), 1.1F);
//      this.addLayer(new HorseMarkingLayer(this));
//      this.addLayer(new HorseArmorLayer(this, p_174167_.getModelSet()));
//   }
//
//   public ResourceLocation getTextureLocation(Horse p_114872_) {
//      return LOCATION_BY_VARIANT.get(p_114872_.getVariant());
//   }

    public DaredevilRenderer(EntityRendererProvider.Context context)
    {
        super(context, new HorseModel<>(context.bakeLayer(ModelLayers.HORSE)), 1.1F);
//      this.addLayer(new HorseMarkingLayer(this));
//      this.addLayer(new HorseArmorLayer(this, context.getModelSet()));
    }

    @Override
    public void render(DaredevilEntity daredevilEntity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLightIn)
    {
        super.render(daredevilEntity, entityYaw, partialTicks, poseStack, multiBufferSource, packedLightIn);
    }

    @Override
    public ResourceLocation getTextureLocation(DaredevilEntity p_114482_)
    {
        return new ResourceLocation(PumpkinFever.MOD_ID, "textures/entity/daredevil.png");
    }
}
