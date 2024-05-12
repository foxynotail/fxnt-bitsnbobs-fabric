package net.fxnt.bitsnbobs.blocks.slabBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;

public class SlabsLoot {

    public interface associationCallback {
        void associate(Block block);
    }

    public void get(associationCallback callback) {
        for (SlabInfo info : SlabsBlock.blocks) {
            callback.associate(ModBlocks.getBlock(info.getName() + "_slab"));
        }
    }

}
