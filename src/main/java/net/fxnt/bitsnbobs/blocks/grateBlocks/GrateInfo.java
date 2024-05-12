package net.fxnt.bitsnbobs.blocks.grateBlocks;

import net.minecraft.world.item.Item;

public class GrateInfo {
    private final String name;

    private final Item recipeIngredient;

    public GrateInfo(String name, Item recipeIngredient) {
        this.name = name;
        this.recipeIngredient = recipeIngredient;
    }

    public String getName() {
        return name;
    }

    public Item getIngredient() {
        return recipeIngredient;
    }
}
