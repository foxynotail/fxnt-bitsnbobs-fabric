package net.fxnt.bitsnbobs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.fxnt.bitsnbobs.blocks.glassLightBlocks.GlassLightTags;
import net.fxnt.bitsnbobs.blocks.grateBlocks.GrateTags;
import net.fxnt.bitsnbobs.blocks.layerBlocks.LayersTags;
import net.fxnt.bitsnbobs.blocks.lightBlocks.LightTags;
import net.fxnt.bitsnbobs.blocks.simpleBlocks.SimpleTags;
import net.fxnt.bitsnbobs.blocks.slabBlocks.SlabsTags;
import net.fxnt.bitsnbobs.blocks.thatchBlocks.ThatchTags;
import net.fxnt.bitsnbobs.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        BitsNBobs.LOGGER.info("Generating Block Tags...");

        // Light Blocks
        lightTagAssociationHandler lightCallbackHandler = new lightTagAssociationHandler();
        LightTags lightTags = new LightTags();
        lightTags.get(lightCallbackHandler);

        // Glass Light Blocks
        glassLightTagAssociationHandler glassLightCallbackHandler = new glassLightTagAssociationHandler();
        GlassLightTags glassLightTags = new GlassLightTags();
        glassLightTags.get(glassLightCallbackHandler);

        // Custom Slabs
        slabsTagAssociationHandler slabCallbackHandler = new slabsTagAssociationHandler();
        SlabsTags slabsTags = new SlabsTags();
        slabsTags.get(slabCallbackHandler);

        // Layer Blocks
        layersTagAssociationHandler layersCallbackHandler = new layersTagAssociationHandler();
        LayersTags layersTags = new LayersTags();
        layersTags.get(layersCallbackHandler);

        // Grate Blocks
        grateTagAssociationHandler grateCallbackHandler = new grateTagAssociationHandler();
        GrateTags grateTags = new GrateTags();
        grateTags.get(grateCallbackHandler);

        // Simple Blocks
        simpleTagAssociationHandler simpleCallbackHandler = new simpleTagAssociationHandler();
        SimpleTags simpleTags = new SimpleTags();
        simpleTags.get(simpleCallbackHandler);

        // Thatch Blocks
        thatchTagAssociationHandler thatchCallbackHandler = new thatchTagAssociationHandler();
        ThatchTags thatchTags = new ThatchTags();
        thatchTags.get(thatchCallbackHandler);

        // Dirt & Grass
        getOrCreateTagBuilder(ModTags.GRASS_BLOCKS)
                .add(ModBlocks.getBlock("grass_slab"))
                .add(ModBlocks.getBlock("grass_layers_block"));
        getOrCreateTagBuilder(ModTags.PLANTABLE_BLOCKS)
                .add(ModBlocks.getBlock("grass_slab"))
                .add(ModBlocks.getBlock("dirt_slab"))
                .add(ModBlocks.getBlock("coarse_dirt_slab"))
                .add(ModBlocks.getBlock("sand_slab"));

    }

    // Inner class to handle tag association callbacks
    private class lightTagAssociationHandler implements LightTags.associationCallback {
        @Override
        public void associate(Block block, TagKey tag) {
            getOrCreateTagBuilder(tag).add(block);
        }
    }
    private class glassLightTagAssociationHandler implements GlassLightTags.associationCallback {
        @Override
        public void associate(Block block, TagKey tag) {
            getOrCreateTagBuilder(tag).add(block);
        }
    }
    private class slabsTagAssociationHandler implements SlabsTags.associationCallback {
        @Override
        public void associate(Block block, TagKey tag) {
            getOrCreateTagBuilder(tag).add(block);
        }
    }
    private class layersTagAssociationHandler implements LayersTags.associationCallback {
        @Override
        public void associate(Block block, TagKey tag) {
            getOrCreateTagBuilder(tag).add(block);
        }
    }
    private class grateTagAssociationHandler implements GrateTags.associationCallback {
        @Override
        public void associate(Block block, TagKey tag) {
            getOrCreateTagBuilder(tag).add(block);
        }
    }
    private class simpleTagAssociationHandler implements SimpleTags.associationCallback {
        @Override
        public void associate(Block block, TagKey tag) {
            getOrCreateTagBuilder(tag).add(block);
        }
    }
    private class thatchTagAssociationHandler implements ThatchTags.associationCallback {
        @Override
        public void associate(Block block, TagKey tag) {
            getOrCreateTagBuilder(tag).add(block);
        }
    }
}
