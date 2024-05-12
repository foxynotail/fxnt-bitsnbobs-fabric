package net.fxnt.bitsnbobs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.blocks.glassLightBlocks.GlassLightModel;
import net.fxnt.bitsnbobs.blocks.grateBlocks.GrateModel;
import net.fxnt.bitsnbobs.blocks.layerBlocks.LayersModel;
import net.fxnt.bitsnbobs.blocks.lightBlocks.LightModel;
import net.fxnt.bitsnbobs.blocks.simpleBlocks.SimpleModel;
import net.fxnt.bitsnbobs.blocks.slabBlocks.SlabsModel;
import net.fxnt.bitsnbobs.blocks.thatchBlocks.ThatchModel;
import net.fxnt.bitsnbobs.items.ModItems;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplates;


public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        BitsNBobs.LOGGER.info("Generating Block States and Models...");

        // Custom Slabs
        LightModel.generate(blockStateModelGenerator);
        GlassLightModel.generate(blockStateModelGenerator);
        SlabsModel.generate(blockStateModelGenerator);
        LayersModel.generate(blockStateModelGenerator);
        GrateModel.generate(blockStateModelGenerator);
        SimpleModel.generate(blockStateModelGenerator);
        ThatchModel.generate(blockStateModelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        BitsNBobs.LOGGER.info("Generating Item Models...");
        itemModelGenerator.generateFlatItem(ModItems.ROUGH_DIAMOND, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.NETHERITE_DUST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNPROCESSED_NETHERITE_DUST, ModelTemplates.FLAT_ITEM);
    }
}
