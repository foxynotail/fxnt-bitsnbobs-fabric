package net.fxnt.bitsnbobs.blocks.glassLightBlocks;

import net.minecraft.world.level.block.Block;

public class GlassLightInfo {
    private final String name;
    private final Block vanillaBlock;

    public GlassLightInfo(String name, Block vanillaBlock) {
        this.name = name;
        this.vanillaBlock = vanillaBlock;
    }

    public String getName() {
        return name;
    }

    public Block getVanillaBlock() {
        return vanillaBlock;
    }
}
