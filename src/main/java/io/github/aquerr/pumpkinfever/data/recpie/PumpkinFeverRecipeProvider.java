package io.github.aquerr.pumpkinfever.data.recpie;

import io.github.aquerr.pumpkinfever.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class PumpkinFeverRecipeProvider extends RecipeProvider
{
    public PumpkinFeverRecipeProvider(DataGenerator dataGenerator)
    {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer)
    {
        ShapelessRecipeBuilder.shapeless(ModItems.PUMPKIN_INFUSED_IRON.get(), 1)
                .requires(Items.IRON_INGOT)
                .requires(ModItems.PUMPKIN_DUST.get(), 2)
                .unlockedBy("enhanced_iron", has(ModItems.PUMPKIN_DUST.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(ModItems.PUMPKIN_DUST.get(), 4)
                .requires(Tags.Items.TOOLS_AXES)
                .requires(Items.PUMPKIN)
                .unlockedBy("crush_the_pumpkin", has(Items.PUMPKIN))
                .save(consumer);
    }
}
