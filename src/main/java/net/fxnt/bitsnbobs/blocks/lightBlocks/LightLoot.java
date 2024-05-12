package net.fxnt.bitsnbobs.blocks.lightBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;

public class LightLoot {

    public interface associationCallback {
        void associate(Block block);
    }

    public void get(associationCallback callback) {
        for (LightInfo info : LightBlock.blocks) {
            callback.associate(ModBlocks.getBlock(info.getName() + "_light_block"));
        }
    }
}
