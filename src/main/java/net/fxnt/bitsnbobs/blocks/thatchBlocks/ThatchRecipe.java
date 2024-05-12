package net.fxnt.bitsnbobs.blocks.thatchBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;

public class ThatchRecipe {

    public interface associationCallback {
        void associate(Block toBlock);
    }

    public void get(associationCallback callback) {
        for (ThatchInfo info : ThatchBlock.blocks) {
            Block toBlock = ModBlocks.getBlock(info.getName());
            if (info.getName()=="thatch_block") {
                callback.associate(toBlock);
            }
        }
    }
}
