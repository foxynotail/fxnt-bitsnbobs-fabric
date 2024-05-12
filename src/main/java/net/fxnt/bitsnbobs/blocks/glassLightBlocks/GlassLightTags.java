package net.fxnt.bitsnbobs.blocks.glassLightBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.fxnt.bitsnbobs.tags.ModTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class GlassLightTags {
    public interface associationCallback {
        void associate(Block block, TagKey tag);
    }

    public void get(associationCallback callback) {
        for (GlassLightInfo info : GlassLightBlock.blocks) {
            Block block = ModBlocks.getBlock(info.getName() + "_glass_light_block");
            callback.associate(block, ModTags.LIGHT_BLOCKS);
            callback.associate(block, ModTags.GLASS_BLOCKS);
            callback.associate(block, ModTags.MINEABLE_PICKAXE);
            callback.associate(block, ModTags.WRENCH_PICKUP);
            callback.associate(block, ModTags.FRAMEABLE);
        }
    }
}
