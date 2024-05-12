package net.fxnt.bitsnbobs.blocks.grateBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.fxnt.bitsnbobs.tags.ModTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class GrateTags {
    public interface associationCallback {
        void associate(Block block, TagKey tag);
    }

    public void get(associationCallback callback) {
        for (GrateInfo info : GrateBlock.blocks) {
            Block block = ModBlocks.getBlock(info.getName() + "_grate_block");
            callback.associate(block, ModTags.GRATE_BLOCKS);
            callback.associate(block, ModTags.MINEABLE_PICKAXE);
            callback.associate(block, ModTags.WRENCH_PICKUP);
            callback.associate(block, ModTags.FRAMEABLE);
        }
    }

}
