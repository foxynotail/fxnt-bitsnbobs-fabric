package net.fxnt.bitsnbobs.blocks.layerBlocks;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class LayersModel {
    // Block State Generator
    public static BlockStateGenerator generateBlockStates(Block block, String blockName) {
        BlockStateGenerator blockStateGenerator = new BlockStateGenerator() {
            @Override
            public Block getBlock() {
                return block;
            }

            @Override
            public JsonElement get() {
                JsonParser parser = new JsonParser();
                JsonElement elm = parser.parse("{ " +
                        "\"layers=1\": { \"model\": \"bitsnbobs:block/" + blockName + "_1\" }, " +
                        "\"layers=2\": { \"model\": \"bitsnbobs:block/" + blockName + "_2\" }, " +
                        "\"layers=3\": { \"model\": \"bitsnbobs:block/" + blockName + "_3\" }, " +
                        "\"layers=4\": { \"model\": \"bitsnbobs:block/" + blockName + "_4\" }, " +
                        "\"layers=5\": { \"model\": \"bitsnbobs:block/" + blockName + "_5\" }, " +
                        "\"layers=6\": { \"model\": \"bitsnbobs:block/" + blockName + "_6\" }, " +
                        "\"layers=7\": { \"model\": \"bitsnbobs:block/" + blockName + "_7\" } " +
                        "}"
                );
                JsonObject variant = new JsonObject();
                variant.add("variants", elm);
                return variant;
            }
        };
        return blockStateGenerator;
    }

    public static BlockStateGenerator generateModels(Block block, String blockName, String layer, String top, String bottom, String side, String overlay, String renderType) {
        BlockStateGenerator blockModelGenerator = new BlockStateGenerator() {
            @Override
            public Block getBlock() {
                return block;
            }

            @Override
            public JsonElement get() {
                String setRenderType = "";
                if (renderType != null) {
                    setRenderType = "\"render_type\": \"minecraft:" + renderType + "\",";
                }
                JsonParser parser = new JsonParser();
                String parent = "bitsnbobs:block/layers_block_" + layer;
                JsonElement elm = parser.parse("{ " + setRenderType +
                        "\"parent\": \"" + parent + "\", " +
                            "\"textures\": {" +
                            "\"top\": \"minecraft:block/" + top + "\", " +
                            "\"bottom\": \"minecraft:block/" + bottom + "\", "+
                            "\"side\": \"minecraft:block/" + side + "\", " +
                            "\"particle\": \"minecraft:block/" + side + "\", " +
                            "\"overlay\": \"minecraft:block/" + overlay + "\" " +
                            "} " +
                        "}"
                );
                JsonObject model = elm.getAsJsonObject();
                return model;
            }
        };
        return blockModelGenerator;
    }

    public static BlockStateGenerator generateItemModels(Block block, String blockName, String topTexture) {
        BlockStateGenerator itemModelGenerator = new BlockStateGenerator() {
            @Override
            public Block getBlock() {
                return block;
            }

            @Override
            public JsonElement get() {
                JsonParser parser = new JsonParser();
                String parent = "minecraft:block/carpet";
                JsonElement elm = parser.parse("{ " +
                        "\"parent\": \"" + parent + "\", " +
                        "\"textures\": {" +
                            "\"wool\": \"minecraft:block/" + topTexture + "\" " +
                        "} " +
                        "}"
                );
                JsonObject model = elm.getAsJsonObject();
                return model;
            }
        };
        return itemModelGenerator;
    }

    public static void generate(BlockModelGenerators blockStateModelGenerator) {

        BitsNBobs.LOGGER.info("Generating Block States and Models for Layer Blocks");

        for (LayersInfo info : LayersBlock.blocks) {
            String blockName = info.getName();
            Block thisBlock = ModBlocks.getBlock(blockName + "_layers_block");
            List<String> textures = info.getTextures();
            String top = null;
            String bottom = null;
            String side = null;
            String overlay = null;
            String renderType = null;
            String itemTexture = null;
            if (textures.size()<1) {
                top = blockName;
                bottom = blockName;
                side = blockName;
                overlay = blockName;
            } else {
                top = textures.get(0);
                if (textures.size()>1) { bottom = textures.get(1); } else { bottom = top; }
                if (textures.size()>2) { side = textures.get(2); } else { side = bottom; }
                if (textures.size()>3) { overlay = textures.get(3); } else { overlay = side; }
                if (textures.size()>4) { renderType = textures.get(4); }
            }

            BlockStateGenerator slabBlockState = generateBlockStates(thisBlock, blockName + "_layers_block");
            blockStateModelGenerator.blockStateOutput.accept(slabBlockState);
            for (int l = 1; l <= 7; l++ ) {
                String layer = String.valueOf(l);
                BlockStateGenerator blockModel = generateModels(thisBlock, blockName, layer, top, bottom, side, overlay, renderType);
                blockStateModelGenerator.modelOutput.accept(new ResourceLocation(BitsNBobs.MOD_ID, "block/" + blockName + "_layers_block_" + layer), blockModel);
            }

            // FIX ITEM MODEL TO HAVE CARPET PARENT
            blockStateModelGenerator.skipAutoItemBlock(thisBlock);
            if (blockName != "grass") {
                // Grass is hardcoded as doesn't have grass color despite client settings
                BlockStateGenerator itemModel = generateItemModels(thisBlock, blockName, top);
                blockStateModelGenerator.modelOutput.accept(new ResourceLocation(BitsNBobs.MOD_ID, "item/" + blockName + "_layers_block"), itemModel);
            }
        }
    }
}
