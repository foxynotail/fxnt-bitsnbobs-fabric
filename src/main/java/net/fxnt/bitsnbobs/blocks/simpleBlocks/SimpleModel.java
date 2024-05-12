package net.fxnt.bitsnbobs.blocks.simpleBlocks;

import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.world.level.block.Block;

public class SimpleModel {
    public static void generate(BlockModelGenerators blockStateModelGenerator) {
        BitsNBobs.LOGGER.info("Generating Block States and Models for Simple Blocks");
        for (SimpleInfo info : SimpleBlock.blocks) {
            Block block = ModBlocks.getBlock(info.getName());
            blockStateModelGenerator.createTrivialCube(block);
        }
    }
}
