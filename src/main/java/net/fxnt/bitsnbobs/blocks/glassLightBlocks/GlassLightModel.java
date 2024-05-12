package net.fxnt.bitsnbobs.blocks.glassLightBlocks;

import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.world.level.block.Block;

public class GlassLightModel {
    public static void generate(BlockModelGenerators blockStateModelGenerator) {
        BitsNBobs.LOGGER.info("Generating Block States and Models for Glass Light Blocks");
        for (GlassLightInfo info : GlassLightBlock.blocks) {
            String blockName = info.getName();
            Block block = ModBlocks.getBlock(blockName + "_glass_light_block");
            blockStateModelGenerator.createTrivialCube(block);
        }
    }
}
