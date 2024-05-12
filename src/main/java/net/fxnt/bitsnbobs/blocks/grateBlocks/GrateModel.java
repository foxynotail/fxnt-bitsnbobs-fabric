package net.fxnt.bitsnbobs.blocks.grateBlocks;

import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.world.level.block.Block;

public class GrateModel {
    public static void generate(BlockModelGenerators blockStateModelGenerator) {
        BitsNBobs.LOGGER.info("Generating Block States and Models for Grate Blocks");
        for (GrateInfo info : GrateBlock.blocks) {
            Block block = ModBlocks.getBlock(info.getName() + "_grate_block");
            blockStateModelGenerator.createTrivialCube(block);
        }
    }
}
