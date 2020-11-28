package io.github.aquerr.pumpkinfever.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.resources.IReloadableResourceManager;

public class CandyMerchantRenderer extends VillagerRenderer
{
    public CandyMerchantRenderer(EntityRendererManager renderManagerIn, IReloadableResourceManager resourceManagerIn)
    {
        super(renderManagerIn, resourceManagerIn);
    }
}
