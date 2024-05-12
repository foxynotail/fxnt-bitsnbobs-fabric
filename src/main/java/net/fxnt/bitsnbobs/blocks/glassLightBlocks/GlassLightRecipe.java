package net.fxnt.bitsnbobs.blocks.glassLightBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

import static net.minecraft.data.recipes.RecipeProvider.has;

public class GlassLightRecipe {

    public interface associationCallback {
        void associate(GlassLightInfo info);
    }

    public void get(associationCallback callback) {
        for (GlassLightInfo info : GlassLightBlock.blocks) {
            callback.associate(info);
        }
    }

    public static void buildRecipe(GlassLightInfo info, Consumer<FinishedRecipe> exporter) {
        String blockName = info.getName();
        Block toBlock = ModBlocks.getBlock(blockName + "_glass_light_block");
        Block fromBlock = info.getVanillaBlock();
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, toBlock, 1)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', Items.GLOW_INK_SAC)
                .define('B', fromBlock.asItem())
                .unlockedBy("has_glow_ink_sac", has(Items.GLOW_INK_SAC))
                .unlockedBy("has_stained_glass", has(fromBlock.asItem()))
                .save(exporter, toBlock.getLootTable());

    }
}
