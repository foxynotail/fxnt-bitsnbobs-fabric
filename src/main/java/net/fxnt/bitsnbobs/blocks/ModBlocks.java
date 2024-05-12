package net.fxnt.bitsnbobs.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.blocks.glassLightBlocks.GlassLightBlock;
import net.fxnt.bitsnbobs.blocks.glassLightBlocks.GlassLightInfo;
import net.fxnt.bitsnbobs.blocks.grateBlocks.GrateBlock;
import net.fxnt.bitsnbobs.blocks.grateBlocks.GrateInfo;
import net.fxnt.bitsnbobs.blocks.layerBlocks.LayersBlock;
import net.fxnt.bitsnbobs.blocks.layerBlocks.LayersInfo;
import net.fxnt.bitsnbobs.blocks.lightBlocks.LightBlock;
import net.fxnt.bitsnbobs.blocks.lightBlocks.LightInfo;
import net.fxnt.bitsnbobs.blocks.simpleBlocks.SimpleBlock;
import net.fxnt.bitsnbobs.blocks.simpleBlocks.SimpleInfo;
import net.fxnt.bitsnbobs.blocks.slabBlocks.SlabInfo;
import net.fxnt.bitsnbobs.blocks.slabBlocks.SlabsBlock;
import net.fxnt.bitsnbobs.blocks.thatchBlocks.OldThatchBlock;
import net.fxnt.bitsnbobs.blocks.thatchBlocks.ThatchBlock;
import net.fxnt.bitsnbobs.blocks.thatchBlocks.ThatchInfo;
import net.fxnt.bitsnbobs.blocks.thatchBlocks.WaxedThatchBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {

    private static final Map<String, Block> blocksMap = new HashMap<>();
    private static void createGrateBlocks() {
        for (GrateInfo info : GrateBlock.blocks) {
            registerBlock(info.getName() + "_grate_block",
                    new GrateBlock(FabricBlockSettings.create()));
        }
    }
    private static void createLightBlocks() {
        for (LightInfo info : LightBlock.blocks) {
            registerBlock(info.getName() + "_light_block",
                    new LightBlock(FabricBlockSettings.create(),
                            info.getVanillaBlock()
                    ));
        }
    }
    private static void createGlassLightBlocks() {
        for (GlassLightInfo info : GlassLightBlock.blocks) {
            registerBlock(info.getName() + "_glass_light_block",
                    new GlassLightBlock(FabricBlockSettings.create(),
                            info.getVanillaBlock()
                    ));
        }
    }
    private static void createSlabBlocks() {
        for (SlabInfo info : SlabsBlock.blocks) {
            registerBlock(info.getName() + "_slab",
                    new SlabsBlock(FabricBlockSettings.create(),
                            info.getVanillaBlock(),
                            info.getPlaceSound()
                    ));
        }
    }
    private static void createLayerBlocks() {
        for (LayersInfo info : LayersBlock.blocks) {
            registerBlock(info.getName() + "_layers_block",
                    new LayersBlock(FabricBlockSettings.create(),
                            info.getVanillaBlock(),
                            info.getSoundType(),
                            info.getPlaceSound()
                    ));
        }
    }
    private static void createSimpleBlocks() {
        for (SimpleInfo info : SimpleBlock.blocks) {
            registerBlock(info.getName(),
                    new SimpleBlock(FabricBlockSettings.create(),
                            info.getVanillaBlock(),
                            info.getSound()
                    ));
        }
    }
    private static void createThatchBlocks() {
        for (ThatchInfo info : ThatchBlock.blocks) {
            switch (info.getType()) {
                case "unwaxed" :
                    registerBlock(info.getName(), new ThatchBlock(FabricBlockSettings.create(), info));
                    break;
                case "waxed" :
                    registerBlock(info.getName(), new WaxedThatchBlock(FabricBlockSettings.create(), info));
                    break;
                case "old" :
                    registerBlock(info.getName(), new OldThatchBlock(FabricBlockSettings.create()));
                    break;
            }
        }
    }


    private static Block registerBlock(String name, Block block) {
        blocksMap.put(name, block);
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(BitsNBobs.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(BitsNBobs.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        BitsNBobs.LOGGER.info("Registering Blocks for " + BitsNBobs.NAME);
        createGrateBlocks();
        createSimpleBlocks();
        createLightBlocks();
        createGlassLightBlocks();
        createSlabBlocks();
        createLayerBlocks();
        createThatchBlocks();
    }

    // You can access your blocks using their names from the map
    public static Block getBlock(String name) {
        return blocksMap.get(name);
    }
}
