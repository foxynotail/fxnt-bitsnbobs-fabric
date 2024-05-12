package net.fxnt.bitsnbobs.blocks.layerBlocks;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

import java.util.List;

public class LayersInfo {
    private final String name;
    private final Block vanillaBlock;
    private final SoundType soundType;
    private final SoundEvent placeSound;
    private final List<String> textures;

    public LayersInfo(String name, Block vanillaBlock, SoundType soundType, SoundEvent placeSound, List<String> textures) {
        this.name = name;
        this.vanillaBlock = vanillaBlock;
        this.soundType = soundType;
        this.placeSound = placeSound;
        this.textures = textures;
    }

    public String getName() {
        return name;
    }

    public Block getVanillaBlock() {
        return vanillaBlock;
    }

    public SoundType getSoundType() {
        return soundType;
    }

    public SoundEvent getPlaceSound() {
        return placeSound;
    }

    public List<String> getTextures() {
        return textures;
    }
}
