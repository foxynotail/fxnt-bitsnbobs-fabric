package net.fxnt.bitsnbobs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.blocks.glassLightBlocks.GlassLightInfo;
import net.fxnt.bitsnbobs.blocks.glassLightBlocks.GlassLightRecipe;
import net.fxnt.bitsnbobs.blocks.grateBlocks.GrateRecipe;
import net.fxnt.bitsnbobs.blocks.layerBlocks.LayersRecipe;
import net.fxnt.bitsnbobs.blocks.lightBlocks.LightInfo;
import net.fxnt.bitsnbobs.blocks.lightBlocks.LightRecipe;
import net.fxnt.bitsnbobs.blocks.simpleBlocks.SimpleRecipe;
import net.fxnt.bitsnbobs.blocks.slabBlocks.SlabsRecipe;
import net.fxnt.bitsnbobs.blocks.thatchBlocks.ThatchRecipe;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        BitsNBobs.LOGGER.info("Generating Recipes...");

        // Light Blocks
        lightslabsRecipeAssociationHandler lightCallbackHandler = new lightslabsRecipeAssociationHandler(exporter);
        LightRecipe lightRecipe = new LightRecipe();
        lightRecipe.get(lightCallbackHandler);

        // Glass Light Blocks
        glassLightslabsRecipeAssociationHandler glassLightCallbackHandler = new glassLightslabsRecipeAssociationHandler(exporter);
        GlassLightRecipe glassLightRecipe = new GlassLightRecipe();
        glassLightRecipe.get(glassLightCallbackHandler);

        // Custom Slabs
        slabsRecipeAssociationHandler slabCallbackHandler = new slabsRecipeAssociationHandler(exporter);
        SlabsRecipe slabsRecipe = new SlabsRecipe();
        slabsRecipe.get(slabCallbackHandler);

        // Layer Blocks
        layersRecipeAssociationHandler layersCallbackHandler = new layersRecipeAssociationHandler(exporter);
        LayersRecipe layersRecipe = new LayersRecipe();
        layersRecipe.get(layersCallbackHandler);

        // Grate Blocks
        grateRecipeAssociationHandler grateCallbackHandler = new grateRecipeAssociationHandler(exporter);
        GrateRecipe grateRecipe = new GrateRecipe();
        grateRecipe.get(grateCallbackHandler);

        // Simple Blocks
        simpleRecipeAssociationHandler simpleCallbackHandler = new simpleRecipeAssociationHandler(exporter);
        SimpleRecipe simpleRecipe = new SimpleRecipe();
        simpleRecipe.get(simpleCallbackHandler);

        // Thatch Blocks
        thatchRecipeAssociationHandler thatchCallbackHandler = new thatchRecipeAssociationHandler(exporter);
        ThatchRecipe thatchRecipe = new ThatchRecipe();
        thatchRecipe.get(thatchCallbackHandler);
    }

    // Inner class to handle tag association callbacks
    private class lightslabsRecipeAssociationHandler implements LightRecipe.associationCallback {
        private final Consumer<FinishedRecipe> exporter;

        public lightslabsRecipeAssociationHandler(Consumer<FinishedRecipe> exporter) {
            this.exporter = exporter;
        }
        @Override
        public void associate(LightInfo info) {
            LightRecipe.buildRecipe(info, exporter);
        }
    }
    private class glassLightslabsRecipeAssociationHandler implements GlassLightRecipe.associationCallback {
        final Consumer<FinishedRecipe> exporter;

        public glassLightslabsRecipeAssociationHandler(Consumer<FinishedRecipe> exporter) {
            this.exporter = exporter;
        }
        @Override
        public void associate(GlassLightInfo info) {
            GlassLightRecipe.buildRecipe(info, exporter);
        }
    }
    private class slabsRecipeAssociationHandler implements SlabsRecipe.associationCallback {
        private final Consumer<FinishedRecipe> exporter;

        public slabsRecipeAssociationHandler(Consumer<FinishedRecipe> exporter) {
            this.exporter = exporter;
        }
        @Override
        public void associate(Block toBlock, Block fromBlock) {
            slab(exporter, RecipeCategory.MISC, toBlock, fromBlock);
            stonecutterResultFromBase(exporter, RecipeCategory.MISC, toBlock.asItem(), fromBlock.asItem(), 2);
        }
    }
    private class layersRecipeAssociationHandler implements LayersRecipe.associationCallback {
        private final Consumer<FinishedRecipe> exporter;

        public layersRecipeAssociationHandler(Consumer<FinishedRecipe> exporter) {
            this.exporter = exporter;
        }
        @Override
        public void associate(Block toBlock, Block fromBlock, int count) {
            stonecutterResultFromBase(exporter, RecipeCategory.MISC, toBlock.asItem(), fromBlock.asItem(), 8);
        }
    }
    private class grateRecipeAssociationHandler implements GrateRecipe.associationCallback {
        private final Consumer<FinishedRecipe> exporter;

        public grateRecipeAssociationHandler(Consumer<FinishedRecipe> exporter) {
            this.exporter = exporter;
        }
        @Override
        public void associate(Block toBlock, Item recipeIngredient) {
            stonecutterResultFromBase(exporter, RecipeCategory.MISC, toBlock.asItem(), recipeIngredient, 2);
        }
    }
    private class simpleRecipeAssociationHandler implements SimpleRecipe.associationCallback {
        private final Consumer<FinishedRecipe> exporter;

        public simpleRecipeAssociationHandler(Consumer<FinishedRecipe> exporter) {
            this.exporter = exporter;
        }
        @Override
        public void associate(String type, Block toBlock, Item recipeIngredient, int recipeCount) {
            switch (type) {
                case "stonecutter" :
                    stonecutterResultFromBase(exporter, RecipeCategory.MISC, toBlock.asItem(), recipeIngredient, recipeCount);
                    break;
            }

        }
    }
    private class thatchRecipeAssociationHandler implements ThatchRecipe.associationCallback {
        private final Consumer<FinishedRecipe> exporter;

        public thatchRecipeAssociationHandler(Consumer<FinishedRecipe> exporter) {
            this.exporter = exporter;
        }
        @Override
        public void associate(Block toBlock) {
            nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.DEAD_BUSH, RecipeCategory.MISC, toBlock);
        }
    }
}
