package net.fxnt.bitsnbobs.blocks.thatchBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;

public class ThatchLoot {

    public interface associationCallback {
        void associate(Block block);
    }

    public void get(associationCallback callback) {
        for (ThatchInfo info : ThatchBlock.blocks) {
            callback.associate(ModBlocks.getBlock(info.getName()));
        }
    }
}
