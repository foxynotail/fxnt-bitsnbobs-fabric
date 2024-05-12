package net.fxnt.bitsnbobs.blocks.grateBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;

public class GrateLoot {

    public interface associationCallback {
        void associate(Block block);
    }

    public void get(associationCallback callback) {
        for (GrateInfo info : GrateBlock.blocks) {
            callback.associate(ModBlocks.getBlock(info.getName() + "_grate_block"));
        }
    }
}
