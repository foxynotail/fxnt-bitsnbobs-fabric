package net.fxnt.bitsnbobs.blocks.slabBlocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class SlabInfo {
    private final String name;
    private final Block vanillaBlock;
    private final SoundType placeSound;
    private final Boolean customModel;

    public SlabInfo(String name, Block vanillaBlock, SoundType placeSound, Boolean customModel) {
        this.name = name;
        this.vanillaBlock = vanillaBlock;
        this.placeSound = placeSound;
        this.customModel = customModel;
    }

    public String getName() {
        return name;
    }

    public Block getVanillaBlock() {
        return vanillaBlock;
    }

    public SoundType getPlaceSound() {
        return placeSound;
    }

    public Boolean customModel() {
        return customModel;
    }
}
