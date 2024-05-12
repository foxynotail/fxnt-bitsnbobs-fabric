package net.fxnt.bitsnbobs;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.fxnt.bitsnbobs.blocks.glassLightBlocks.GlassLightBlock;
import net.fxnt.bitsnbobs.blocks.glassLightBlocks.GlassLightInfo;
import net.fxnt.bitsnbobs.blocks.grateBlocks.GrateBlock;
import net.fxnt.bitsnbobs.blocks.grateBlocks.GrateInfo;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.GrassColor;


@Environment(EnvType.CLIENT)
public class BitsNBobsClient implements ClientModInitializer {

    public void onInitializeClient() {

        //Block
        RenderType translucent = RenderType.translucent();
        for (GlassLightInfo info : GlassLightBlock.blocks) {
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.getBlock(info.getName() + "_glass_light_block"), translucent);
        }
        for (GrateInfo info : GrateBlock.blocks) {
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.getBlock(info.getName() + "_grate_block"), translucent);
        }

        RenderType cutout = RenderType.cutout();
        BlockRenderLayerMap.INSTANCE.putBlocks(cutout,
                ModBlocks.getBlock("grass_slab"),
                ModBlocks.getBlock("grass_layers_block")
        );

        // Grass Colors
        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return GrassColor.getDefaultColor();
            }
            return BiomeColors.getAverageGrassColor(world, pos);
        }), ModBlocks.getBlock("grass_slab"));

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> {
            return GrassColor.getDefaultColor();
        }), ModBlocks.getBlock("grass_slab"));

        ColorProviderRegistry.BLOCK.register(((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return GrassColor.getDefaultColor();
            }
            return BiomeColors.getAverageGrassColor(world, pos);
        }), ModBlocks.getBlock("grass_layers_block"));

        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> {
            return GrassColor.getDefaultColor();
        }), ModBlocks.getBlock("grass_layers_block"));


    }
}
