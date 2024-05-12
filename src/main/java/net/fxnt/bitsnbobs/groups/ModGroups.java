package net.fxnt.bitsnbobs.groups;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.blocks.ModBlocks;
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
import net.fxnt.bitsnbobs.blocks.thatchBlocks.ThatchBlock;
import net.fxnt.bitsnbobs.blocks.thatchBlocks.ThatchInfo;
import net.fxnt.bitsnbobs.items.ModItems;
import net.fxnt.bitsnbobs.util.DyeColors;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModGroups {
    public static final CreativeModeTab BITSNBOBS_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            new ResourceLocation(BitsNBobs.MOD_ID, "bitsnbobs"),
            FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup.bitsnbobs.main"))
                    .icon(() -> new ItemStack(ModBlocks.getBlock("industrial_iron_grate_block")))
                    .displayItems((pParameters, entries) -> {

                        // Items
                        entries.accept(ModItems.ROUGH_DIAMOND);
                        entries.accept(ModItems.NETHERITE_DUST);
                        entries.accept(ModItems.UNPROCESSED_NETHERITE_DUST);

                        // Blocks
                        for (GrateInfo info : GrateBlock.blocks) {
                            entries.accept(ModBlocks.getBlock(info.getName() + "_grate_block"));
                        }

                        for (SimpleInfo info : SimpleBlock.blocks) {
                            entries.accept(ModBlocks.getBlock(info.getName()));
                        }

                        for (LightInfo info : LightBlock.blocks) {
                            entries.accept(ModBlocks.getBlock(info.getName() + "_light_block"));
                        }

                        for (GlassLightInfo info : GlassLightBlock.blocks) {
                            entries.accept(ModBlocks.getBlock(info.getName() + "_glass_light_block"));
                        }

                        for (SlabInfo info : SlabsBlock.blocks) {
                            entries.accept(ModBlocks.getBlock(info.getName() + "_slab"));
                        }

                        for (LayersInfo info : LayersBlock.blocks) {
                            entries.accept(ModBlocks.getBlock(info.getName() + "_layers_block"));
                        }

                        for (ThatchInfo info : ThatchBlock.blocks) {
                            entries.accept(ModBlocks.getBlock(info.getName()));
                        }
                    }).build());
    public static void registerItemGroups(){
        BitsNBobs.LOGGER.info("Registering Creative Tab Group for " + BitsNBobs.NAME);
    }

}
