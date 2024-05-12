package net.fxnt.bitsnbobs.blocks.slabBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.fxnt.bitsnbobs.tags.ModTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class SlabsTags {
    public interface associationCallback {
        void associate(Block block, TagKey tag);
    }

    public void get(associationCallback callback) {
        for (SlabInfo info : SlabsBlock.blocks) {
            Block block = ModBlocks.getBlock(info.getName() + "_slab");
            callback.associate(block, ModTags.SLABS);
            callback.associate(block, ModTags.MINEABLE_SHOVEL);
        }
    }

}
