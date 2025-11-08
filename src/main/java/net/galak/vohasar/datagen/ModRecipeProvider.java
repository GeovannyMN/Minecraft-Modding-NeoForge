package net.galak.vohasar.datagen;

import net.galak.vohasar.block.ModBlocks;
import net.galak.vohasar.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        List<ItemLike> VOHASARITE_SMEALTABLES = List.of(ModItems.RAW_VOHASARITE,
                ModBlocks.VOHASARITE_ORE, ModBlocks.VOHASARITE_DEEPSLATE_ORE, ModBlocks.VOHASARITE_NETHER_ORE, ModBlocks.VOHASARITE_END_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VOHASARITE_BLOCK.get())
                .pattern("V V")
                .pattern("V V")
                .pattern(" V ")
                .define('V', ModItems.VOHASARITE.get())
                .unlockedBy("has_vohasar", has(ModItems.VOHASARITE)).save(recipeOutput);
        ;

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_VOHASARITE_BLOCK.get())
                .pattern("V V")
                .pattern("V V")
                .pattern(" V ")
                .define('V', ModItems.RAW_VOHASARITE.get())
                .unlockedBy("has_raw_vohasar", has(ModItems.VOHASARITE)).save(recipeOutput);
        ;

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.VOHASAR_CHARCOAL.get(), 9)
                .requires(ModItems.VOHASAR_ASHES)
                .unlockedBy("has_vohasar_ashes", has(ModItems.VOHASAR_ASHES)).save(recipeOutput);
        ;

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.VOHASARITE.get(), 5)
                .requires(ModBlocks.VOHASARITE_BLOCK)
                .unlockedBy("has_vohasar_block", has(ModItems.VOHASARITE)).save(recipeOutput);
        ;

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_VOHASARITE.get(), 5)
                .requires(ModBlocks.RAW_VOHASARITE_BLOCK)
                .unlockedBy("has_vohasar_block", has(ModBlocks.RAW_VOHASARITE_BLOCK)).save(recipeOutput);
        ;

        oreSmelting(recipeOutput, VOHASARITE_SMEALTABLES, RecipeCategory.MISC,
                ModItems.VOHASARITE.get(), 0.25f, 250, "vohasarite");

        oreBlasting(recipeOutput, VOHASARITE_SMEALTABLES, RecipeCategory.MISC,
                ModItems.VOHASARITE.get(), 0.5f, 125, "vohasarite");

        stairBuilder(ModBlocks.VOHASARITE_STAIR.get(), Ingredient.of(ModItems.VOHASARITE))
                .group("vohasarite").unlockedBy("has_vohasarite", has(ModItems.VOHASARITE)).save(recipeOutput);

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VOHASARITE_SLAB.get(), ModItems.VOHASARITE.get());

        buttonBuilder(ModBlocks.VOHASARITE_BUTTON.get(), Ingredient.of(ModItems.VOHASARITE.get())).group("vohasarite")
                .unlockedBy("has_vohasarite", has(ModItems.VOHASARITE.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.VOHASARITE_PRESSURE_PLATE.get(), ModItems.VOHASARITE.get());

        fenceBuilder(ModBlocks.VOHASARITE_FENCE.get(), Ingredient.of(ModItems.VOHASARITE.get())).group("vohasarite")
                .unlockedBy("has_vohasarite", has(ModItems.VOHASARITE.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.VOHASARITE_FENCE_GATE.get(), Ingredient.of(ModItems.VOHASARITE.get())).group("vohasarite")
                .unlockedBy("has_vohasarite", has(ModItems.VOHASARITE.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.VOHASARITE_WALL.get(), ModItems.VOHASARITE.get());

        doorBuilder(ModBlocks.VOHASARITE_DOOR.get(), Ingredient.of(ModItems.VOHASARITE.get())).group("vohasarite")
                .unlockedBy("has_vohasarite", has(ModItems.VOHASARITE.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.VOHASARITE_TRAPDOOR.get(), Ingredient.of(ModItems.VOHASARITE.get())).group("vohasarite")
                .unlockedBy("has_vohasarite", has(ModItems.VOHASARITE.get())).save(recipeOutput);
    }
}
