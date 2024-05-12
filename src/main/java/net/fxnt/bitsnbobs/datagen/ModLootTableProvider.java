package net.fxnt.bitsnbobs.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.blocks.glassLightBlocks.GlassLightLoot;
import net.fxnt.bitsnbobs.blocks.grateBlocks.GrateLoot;
import net.fxnt.bitsnbobs.blocks.layerBlocks.LayersLoot;
import net.fxnt.bitsnbobs.blocks.lightBlocks.LightLoot;
import net.fxnt.bitsnbobs.blocks.simpleBlocks.SimpleLoot;
import net.fxnt.bitsnbobs.blocks.slabBlocks.SlabsLoot;
import net.fxnt.bitsnbobs.blocks.thatchBlocks.ThatchLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        BitsNBobs.LOGGER.info("Generating Loot Tables...");

        // Light Blocks
        lightLootAssociationHandler lightCallbackHandler = new lightLootAssociationHandler();
        LightLoot lightLoot = new LightLoot();
        lightLoot.get(lightCallbackHandler);

        // Glass Light Blocks
        glassLightLootAssociationHandler glassLightCallbackHandler = new glassLightLootAssociationHandler();
        GlassLightLoot glassLightLoot = new GlassLightLoot();
        glassLightLoot.get(glassLightCallbackHandler);

        // Custom Slabs
        slabsLootAssociationHandler slabCallbackHandler = new slabsLootAssociationHandler();
        SlabsLoot slabsLoot = new SlabsLoot();
        slabsLoot.get(slabCallbackHandler);

        // Block Layers
        layersLootAssociationHandler layersCallbackHandler = new layersLootAssociationHandler();
        LayersLoot layersLoot = new LayersLoot();
        layersLoot.get(layersCallbackHandler);

        // Grate Blocks
        grateLootAssociationHandler grateCallbackHandler = new grateLootAssociationHandler();
        GrateLoot grateLoot = new GrateLoot();
        grateLoot.get(grateCallbackHandler);

        // Simple Blocks
        simpleLootAssociationHandler simpleCallbackHandler = new simpleLootAssociationHandler();
        SimpleLoot simpleLoot = new SimpleLoot();
        simpleLoot.get(simpleCallbackHandler);

        // Thatch Blocks
        thatchLootAssociationHandler thatchCallbackHandler = new thatchLootAssociationHandler();
        ThatchLoot thatchLoot = new ThatchLoot();
        thatchLoot.get(thatchCallbackHandler);

    }

    // Inner class to handle loot association callbacks
    private class lightLootAssociationHandler implements LightLoot.associationCallback {
        @Override
        public void associate(Block block) {
            dropSelf(block);
        }
    }
    private class glassLightLootAssociationHandler implements GlassLightLoot.associationCallback {
        @Override
        public void associate(Block block) {
            dropSelf(block);
        }
    }
    private class slabsLootAssociationHandler implements SlabsLoot.associationCallback {
        @Override
        public void associate(Block block) {
            add(block, createSlabItemTable(block));
        }
    }
    private class layersLootAssociationHandler implements LayersLoot.associationCallback {
        @Override
        public void associate(Block block, LootTable.Builder lootTable) {
            add(block, lootTable);
        }
    }
    private class grateLootAssociationHandler implements GrateLoot.associationCallback {
        @Override
        public void associate(Block block) {
            dropSelf(block);
        }
    }
    private class simpleLootAssociationHandler implements SimpleLoot.associationCallback {
        @Override
        public void associate(Block block) {
            dropSelf(block);
        }
    }
    private class thatchLootAssociationHandler implements ThatchLoot.associationCallback {
        @Override
        public void associate(Block block) {
            dropSelf(block);
        }
    }

}
