package net.fxnt.bitsnbobs.blocks.glassLightBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.world.level.block.Block;

public class GlassLightLoot {

    public interface associationCallback {
        void associate(Block block);
    }

    public void get(associationCallback callback) {
        for (GlassLightInfo info : GlassLightBlock.blocks) {
            callback.associate(ModBlocks.getBlock(info.getName() + "_glass_light_block"));
        }
    }
}
