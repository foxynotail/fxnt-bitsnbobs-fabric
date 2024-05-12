package net.fxnt.bitsnbobs.blocks.simpleBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fxnt.bitsnbobs.tags.ModTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

import java.util.List;

public class SimpleBlock extends Block {

    public static final SimpleInfo[] blocks = {
            // name, recipe ingredient
            new SimpleInfo("iron_plating_block", Blocks.IRON_BLOCK, SoundType.METAL,
                    "stonecutter", Items.IRON_INGOT, 2,
                    List.of(ModTags.MINEABLE_PICKAXE, ModTags.WRENCH_PICKUP, ModTags.FRAMEABLE)),

            new SimpleInfo("mulch_block", Blocks.DIRT, SoundType.GRAVEL,
                    "CUSTOM", Items.IRON_INGOT, 1,
                    List.of(ModTags.MINEABLE_SHOVEL, ModTags.PLANTABLE_BLOCKS, ModTags.FRAMEABLE)),
            new SimpleInfo("compressed_mulch_block", Blocks.DIRT, SoundType.GRAVEL,
                    "CUSTOM", Items.IRON_INGOT, 1,
                    List.of(ModTags.MINEABLE_SHOVEL, ModTags.FRAMEABLE)),
            new SimpleInfo("aged_compressed_mulch_block", Blocks.DIRT, SoundType.GRAVEL,
                    "CUSTOM", Items.IRON_INGOT, 1,
                    List.of(ModTags.MINEABLE_SHOVEL, ModTags.FRAMEABLE)),
            new SimpleInfo("hot_aged_compressed_mulch_block", Blocks.DIRT, SoundType.GRAVEL,
                    "CUSTOM", Items.IRON_INGOT, 1,
                    List.of(ModTags.MINEABLE_SHOVEL, ModTags.FRAMEABLE)),

            new SimpleInfo("hot_coal_block", Blocks.COAL_BLOCK, SoundType.STONE,
                    "CUSTOM", Items.IRON_INGOT, 1,
                    List.of(ModTags.MINEABLE_PICKAXE, ModTags.FRAMEABLE)),
            new SimpleInfo("compressed_coal_block", Blocks.COAL_BLOCK, SoundType.STONE,
                    "CUSTOM", Items.IRON_INGOT, 1,
                    List.of(ModTags.MINEABLE_PICKAXE, ModTags.FRAMEABLE)),
            new SimpleInfo("hot_compressed_coal_block", Blocks.COAL_BLOCK, SoundType.STONE,
                    "CUSTOM", Items.IRON_INGOT, 1,
                    List.of(ModTags.MINEABLE_PICKAXE, ModTags.FRAMEABLE))

    };

    public SimpleBlock(FabricBlockSettings properties, Block vanillaBlock, SoundType sound) {
        super(properties.copyOf(vanillaBlock).sound(sound).destroyTime(1.0f).noOcclusion());
    }
}
