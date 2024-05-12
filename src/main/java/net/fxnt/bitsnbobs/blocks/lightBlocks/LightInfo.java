package net.fxnt.bitsnbobs.blocks.lightBlocks;

import net.minecraft.world.level.block.Block;

public class LightInfo {
    private final String name;
    private final Block vanillaBlock;

    public LightInfo(String name, Block vanillaBlock) {
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
