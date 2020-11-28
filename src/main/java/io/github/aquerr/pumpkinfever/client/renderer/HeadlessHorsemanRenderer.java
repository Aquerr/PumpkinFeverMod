package io.github.aquerr.pumpkinfever.client.renderer;

import io.github.aquerr.pumpkinfever.mob.HeadlessHorsemanEntity;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HeadlessHorsemanRenderer extends BipedRenderer<HeadlessHorsemanEntity, PlayerModel<HeadlessHorsemanEntity>>
{

    public HeadlessHorsemanRenderer(EntityRendererManager renderManagerIn)
    {
        super(renderManagerIn, new PlayerModel<>(0.0F, true), 0.5F);
        this.addLayer(new HeldItemLayer<>(this));
    }

    @Override
    @MethodsReturnNonnullByDefault
    public ResourceLocation getEntityTexture(HeadlessHorsemanEntity entity)
    {
        return new ResourceLocation("textures/entity/skeleton/skeleton.png");
    }
}
