package net.fxnt.bitsnbobs.blocks.lightBlocks;

import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.world.level.block.Block;

public class LightModel {
    public static void generate(BlockModelGenerators blockStateModelGenerator) {
        BitsNBobs.LOGGER.info("Generating Block States and Models for Light Blocks");
        for (LightInfo info : LightBlock.blocks) {
            String blockName = info.getName();
            Block block = ModBlocks.getBlock(blockName + "_light_block");
            blockStateModelGenerator.createTrivialCube(block);
        }
    }
}
