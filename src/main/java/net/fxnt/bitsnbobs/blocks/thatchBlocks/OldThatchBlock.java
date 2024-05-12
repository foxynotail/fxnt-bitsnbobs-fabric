package net.fxnt.bitsnbobs.blocks.thatchBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
public class OldThatchBlock extends RotatedPillarBlock {

    public OldThatchBlock(FabricBlockSettings properties) {
        super(properties.copyOf(Blocks.HAY_BLOCK));
    }


}
