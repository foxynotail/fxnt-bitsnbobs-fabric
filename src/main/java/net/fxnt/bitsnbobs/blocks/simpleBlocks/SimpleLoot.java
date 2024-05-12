package net.fxnt.bitsnbobs.blocks.simpleBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;

public class SimpleLoot {

    public interface associationCallback {
        void associate(Block block);
    }

    public void get(associationCallback callback) {
        for (SimpleInfo info : SimpleBlock.blocks) {
            callback.associate(ModBlocks.getBlock(info.getName()));
        }
    }
}
