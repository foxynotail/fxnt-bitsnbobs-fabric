package net.fxnt.bitsnbobs.blocks.simpleBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class SimpleTags {
    public interface associationCallback {
        void associate(Block block, TagKey tag);
    }

    public void get(associationCallback callback) {
        for (SimpleInfo info : SimpleBlock.blocks) {
            Block block = ModBlocks.getBlock(info.getName());
            List<TagKey> tags = info.getTags();
            for (TagKey tag : tags) {
                callback.associate(block, tag);
            }
        }
    }
}
