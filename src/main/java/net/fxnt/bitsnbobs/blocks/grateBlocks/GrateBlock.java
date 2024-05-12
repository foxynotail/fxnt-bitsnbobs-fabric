package net.fxnt.bitsnbobs.blocks.grateBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;

public class GrateBlock extends Block {

    public static final GrateInfo[] blocks = {
            // name, recipe ingredient
            new GrateInfo("iron", Items.IRON_INGOT),
            new GrateInfo("industrial_iron", Items.IRON_INGOT),
            new GrateInfo("andesite", Items.IRON_INGOT)

            // Andesite requires Create Item so cannot have recipes automatically generated here
            // See GrateRecipe.class
    };

    public GrateBlock(FabricBlockSettings properties) {
        super(properties.copyOf(Blocks.IRON_BLOCK).sound(SoundType.METAL).destroyTime(1.0f).noOcclusion());
    }
}
