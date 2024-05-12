package net.fxnt.bitsnbobs.blocks.layerBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;

public class LayersRecipe {

    public interface associationCallback {
        void associate(Block toBlock, Block fromBlock, int count);
    }

    public void get(associationCallback callback) {
        for (LayersInfo info : LayersBlock.blocks) {
            String blockName = info.getName();
            Block toBlock = ModBlocks.getBlock(blockName + "_layers_block");
            Block fromBlock = info.getVanillaBlock();
            callback.associate(toBlock, fromBlock, 1);
        }
    }
}
