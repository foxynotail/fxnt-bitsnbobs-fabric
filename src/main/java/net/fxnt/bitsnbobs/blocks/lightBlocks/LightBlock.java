package net.fxnt.bitsnbobs.blocks.lightBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.util.DyeColors;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.ToIntFunction;

public class LightBlock extends Block {

    public static LightInfo[] blocks = {};

    static {
        createBlocks();
    }
    private static void createBlocks() {
        blocks = new LightInfo[DyeColors.DyeColors.size()];
        int index = 0;
        for (String color : DyeColors.DyeColors) {
            Block vanillaBlock = getVanillaBlock(color);
            blocks[index] = new LightInfo(color, vanillaBlock);
            index++;
        }
    }
    private static Block getVanillaBlock(String color) {
        // Construct the ResourceLocation for the block
        ResourceLocation blockId = new ResourceLocation("minecraft", color + "_concrete");
        // Retrieve the block from the registry
        Block block = BuiltInRegistries.BLOCK.get(blockId);
        return block;
    }

    private static final ToIntFunction<BlockState> lightLevel = BlockState -> 15;

    public LightBlock(FabricBlockSettings properties, Block vanillaBlock) {
        super(properties.copyOf(vanillaBlock).sound(SoundType.STONE).lightLevel(lightLevel).destroyTime(1.0f));
    }
}
