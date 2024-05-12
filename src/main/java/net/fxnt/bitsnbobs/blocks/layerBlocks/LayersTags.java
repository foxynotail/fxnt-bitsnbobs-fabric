package net.fxnt.bitsnbobs.blocks.layerBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.fxnt.bitsnbobs.tags.ModTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class LayersTags {
    public interface associationCallback {
        void associate(Block block, TagKey tag);
    }

    public void get(associationCallback callback) {

        for (LayersInfo info : LayersBlock.blocks) {
            Block block = ModBlocks.getBlock(info.getName() + "_layers_block");
            callback.associate(block, ModTags.LAYER_BLOCKS);
            callback.associate(block, ModTags.MINEABLE_PICKAXE);
            callback.associate(block, ModTags.MINEABLE_AXE);
            callback.associate(block, ModTags.MINEABLE_SHOVEL);
            callback.associate(block, ModTags.MINEABLE_HOE);
        }
    }
}
