package net.fxnt.bitsnbobs.blocks.slabBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.world.level.block.*;

public class SlabsBlock extends SlabBlock {

    // Array of all custom slabs
    public static final SlabInfo[] blocks = {
            // name, vanilla block, sound type, custom models, tags
            new SlabInfo("grass", Blocks.GRASS_BLOCK, SoundType.GRASS, true),
            new SlabInfo("dirt", Blocks.DIRT, SoundType.GRAVEL, false),
            new SlabInfo("coarse_dirt", Blocks.COARSE_DIRT, SoundType.GRAVEL, false),
            new SlabInfo("gravel", Blocks.GRAVEL, SoundType.GRAVEL, false),
            new SlabInfo("sand", Blocks.SAND, SoundType.SAND, false)
    };

    public SlabsBlock(FabricBlockSettings properties, Block vanillaBlock, SoundType placeSound) {

        super(properties.copyOf(vanillaBlock).sound(placeSound));

    }


}
