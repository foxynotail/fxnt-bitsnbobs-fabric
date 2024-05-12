package net.fxnt.bitsnbobs.blocks.grateBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class GrateRecipe {

    public interface associationCallback {
        void associate(Block toBlock, Item recipeIngredient);
    }

    public void get(associationCallback callback) {
        for (GrateInfo info : GrateBlock.blocks) {
            String blockName = info.getName();

            // Andesite requires Create Item so cannot have recipes automatically generated here
            if (blockName != "andesite") {
                Block toBlock = ModBlocks.getBlock(blockName + "_grate_block");
                Item ingredient = info.getIngredient();
                callback.associate(toBlock, ingredient);
            }
        }
    }
}
