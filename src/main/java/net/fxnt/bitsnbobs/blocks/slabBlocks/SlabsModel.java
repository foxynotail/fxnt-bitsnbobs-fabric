package net.fxnt.bitsnbobs.blocks.slabBlocks;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class SlabsModel {

    // Block State Generator
    public static BlockStateGenerator generateBlockStates(Block block, String slabBottom, String slabDouble, String slabTop) {
        BlockStateGenerator blockStateGenerator = new BlockStateGenerator() {
            @Override
            public Block getBlock() {
                return block;
            }

            @Override
            public JsonElement get() {
                JsonParser parser = new JsonParser();
                JsonElement elm = parser.parse("{ \"type=bottom\": { \"model\" = \"" + slabBottom + "\" }, " +
                        "\"type=double\": { \"model\" = \"" + slabDouble + "\" }, " +
                        "\"type=top\": { \"model\" = \"" + slabTop + "\" } }"
                );
                JsonObject variant = new JsonObject();
                variant.add("variants", elm);
                return variant;
            }
        };
        return blockStateGenerator;
    }

    public static BlockStateGenerator generateModels(Block block, String blockName, String slabBottom, String slabDouble, String slabTop, String topBottom) {
        BlockStateGenerator blockModelGenerator = new BlockStateGenerator() {
            @Override
            public Block getBlock() {
                return block;
            }

            @Override
            public JsonElement get() {
                JsonParser parser = new JsonParser();
                String parent = "minecraft:block/slab";
                if (topBottom == "top") {
                    parent = "minecraft:block/slab_top";
                }
                JsonElement elm = parser.parse("{ \"parent\": \"" + parent + "\", " +
                        "\"textures\": {" +
                        "\"bottom\": \"minecraft:block/" + blockName + "\", "+
                        "\"side\": \"minecraft:block/" + blockName + "\", " +
                        "\"top\": \"minecraft:block/" + blockName + "\" " +
                        "} }"
                );
                JsonObject model = elm.getAsJsonObject();
                return model;
            }
        };
        return blockModelGenerator;
    }

    public static void generate(BlockModelGenerators blockStateModelGenerator) {

        BitsNBobs.LOGGER.info("Generating Block States and Models for Slabs");
        for (SlabInfo info : SlabsBlock.blocks) {
            Boolean customModel = info.customModel();
            if (!customModel) {
                String blockName = info.getName();
                Block block = ModBlocks.getBlock(blockName + "_slab");
                String slabBottom = "bitsnbobs:block/" + blockName + "_slab";
                String slabDouble = "minecraft:block/" + blockName;
                String slabTop = "bitsnbobs:block/" + blockName + "_slab_top";
                BlockStateGenerator slabBlockState = generateBlockStates(block, slabBottom, slabDouble, slabTop);
                blockStateModelGenerator.blockStateOutput.accept(slabBlockState);
                BlockStateGenerator slabBlockModel = generateModels(block, blockName, slabBottom, slabDouble, slabTop, "bottom");
                blockStateModelGenerator.modelOutput.accept(new ResourceLocation(BitsNBobs.MOD_ID, "block/" + blockName + "_slab"), slabBlockModel);
                slabBlockModel = generateModels(block, blockName, slabBottom, slabDouble, slabTop, "top");
                blockStateModelGenerator.modelOutput.accept(new ResourceLocation(BitsNBobs.MOD_ID, "block/" + blockName + "_slab_top"), slabBlockModel);

                /*
                ResourceLocation locBottom = new ResourceLocation(BitsNBobs.MOD_ID, "block/" + blockName + "_slab_top");
                ResourceLocation locTop = new ResourceLocation(BitsNBobs.MOD_ID, "block/" + blockName + "_slab");
                ResourceLocation locDouble = new ResourceLocation("minecraft", "block/" + blockName);
                blockStateModelGenerator.modelOutput.accept(new ResourceLocation(BitsNBobs.MOD_ID, "block/" + blockName + "_slab"),
                        BlockModelGenerators.createSlab(block, locBottom, locTop, locDouble));

                 */
            }
        }
    }
}
