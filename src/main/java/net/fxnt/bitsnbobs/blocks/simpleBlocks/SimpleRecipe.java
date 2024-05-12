package net.fxnt.bitsnbobs.blocks.simpleBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class SimpleRecipe {

    public interface associationCallback {
        void associate(String type, Block toBlock, Item recipeIngredient, int recipeCount);
    }

    public void get(associationCallback callback) {
        for (SimpleInfo info : SimpleBlock.blocks) {

            Block toBlock = ModBlocks.getBlock(info.getName());

            String recipeType = info.getRecipeType();
            Item ingredient = info.getRecipeIngredient();
            int count = info.getRecipeCount();

            switch(recipeType) {
                case "stonecutter" :
                    callback.associate("stonecutter", toBlock, ingredient, count);
                    break;
                case "CUSTOM" :
                    break;
            }
        }
    }
}
