package net.fxnt.bitsnbobs.blocks.simpleBlocks;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

import java.util.List;

public class SimpleInfo {
    private final String name;
    private final Block vanillaBlock;
    private final SoundType sound;
    private final String recipeType;
    private final Item recipeIngredient;
    private final int recipeCount;
    private final List<TagKey> tags;

    public SimpleInfo(String name, Block vanillaBlock, SoundType sound, String recipeType, Item recipeIngredient, int recipeCount, List<TagKey> tags) {
        this.name = name;
        this.vanillaBlock = vanillaBlock;
        this.sound = sound;
        this.recipeType = recipeType;
        this.recipeIngredient = recipeIngredient;
        this.recipeCount = recipeCount;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }
    public Block getVanillaBlock() {
        return vanillaBlock;
    }
    public SoundType getSound() {
        return sound;
    }
    public String getRecipeType() {
        return recipeType;
    }
    public Item getRecipeIngredient() {
        return recipeIngredient;
    }
    public int getRecipeCount() {
        return recipeCount;
    }
    public List<TagKey> getTags() {
        return tags;
    }
}
