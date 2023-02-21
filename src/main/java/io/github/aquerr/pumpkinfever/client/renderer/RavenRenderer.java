package io.github.aquerr.pumpkinfever.client.renderer;

import io.github.aquerr.pumpkinfever.client.model.RavenModel;
import io.github.aquerr.pumpkinfever.mob.RavenEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RavenRenderer extends MobRenderer<RavenEntity, RavenModel>
{
   public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation("textures/entity/parrot/parrot_red_blue.png");

   public RavenRenderer(EntityRendererProvider.Context context) {
      super(context, new RavenModel(context.bakeLayer(ModelLayers.PARROT)), 0.3F);
   }

   public ResourceLocation getTextureLocation(RavenEntity ravenEntity) {
      return TEXTURE_LOCATION;
   }

   public float getBob(RavenEntity ravenEntity, float p_115661_) {
      float f = Mth.lerp(p_115661_, ravenEntity.oFlap, ravenEntity.flap);
      float f1 = Mth.lerp(p_115661_, ravenEntity.oFlapSpeed, ravenEntity.flapSpeed);
      return (Mth.sin(f) + 1.0F) * f1;
   }
}
