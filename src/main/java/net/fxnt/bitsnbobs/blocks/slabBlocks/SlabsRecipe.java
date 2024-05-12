package net.fxnt.bitsnbobs.blocks.slabBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;

public class SlabsRecipe {

    public interface associationCallback {
        void associate(Block toBlock, Block fromBlock);
    }

    public void get(associationCallback callback) {
        for (SlabInfo info : SlabsBlock.blocks) {
            String blockName = info.getName();
            Block toBlock = ModBlocks.getBlock(blockName + "_slab");
            Block fromBlock = info.getVanillaBlock();
            callback.associate(toBlock, fromBlock);
        }
    }
}
