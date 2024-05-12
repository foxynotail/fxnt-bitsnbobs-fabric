package net.fxnt.bitsnbobs.tags;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class ModTags {

    // BitsNBobs Tags
    public static final TagKey<Block> GLASS_BLOCKS = forgeBlockTag("glass_blocks");
    public static final TagKey<Block> LIGHT_BLOCKS = forgeBlockTag("light_blocks");
    public static final TagKey<Block> SLABS = forgeBlockTag("slabs");
    public static final TagKey<Block> LAYER_BLOCKS = forgeBlockTag("layer_blocks");
    public static final TagKey<Block> GRATE_BLOCKS = forgeBlockTag("grate_blocks");
    public static final TagKey<Block> GRASS_BLOCKS = forgeBlockTag("grass_blocks");
    public static final TagKey<Block> THATCH_BLOCKS = forgeBlockTag("thatch_blocks");
    public static final TagKey<Block> PLANTABLE_BLOCKS = forgeBlockTag("plantable_blocks");

    // Minecraft Tags
    public static final TagKey<Block> MINEABLE_PICKAXE = minecraftBlockTag("mineable/pickaxe");
    public static final TagKey<Block> MINEABLE_SHOVEL = minecraftBlockTag("mineable/shovel");
    public static final TagKey<Block> MINEABLE_AXE = minecraftBlockTag("mineable/axe");
    public static final TagKey<Block> MINEABLE_HOE = minecraftBlockTag("mineable/hoe");

    // Create Tags
    public static final TagKey<Block> WRENCH_PICKUP = createBlockTag("wrench_pickup");


    // FramedBlocks Tags
    public static final TagKey<Block> FRAMEABLE = framedBlocksBlockTag("frameable");

    public static <T> TagKey<T> optionalTag(Registry<T> registry, ResourceLocation id) {
        return TagKey.create(registry.key(), id);
    }

    public static <T> TagKey<T> forgeTag(Registry<T> registry, String path) {
        return optionalTag(registry, new ResourceLocation("bitsnbobs", path));
    }

    public static TagKey<Block> forgeBlockTag(String path) {
        return forgeTag(BuiltInRegistries.BLOCK, path);
    }

    public static TagKey<Item> forgeItemTag(String path) {
        return forgeTag(BuiltInRegistries.ITEM, path);
    }

    public static TagKey<Fluid> forgeFluidTag(String path) {
        return forgeTag(BuiltInRegistries.FLUID, path);
    }

    public static <T> TagKey<T> minecraftTag(Registry<T> registry, String path) {
        return optionalTag(registry, new ResourceLocation("minecraft", path));
    }
    public static TagKey<Block> minecraftBlockTag(String path) {
        return minecraftTag(BuiltInRegistries.BLOCK, path);
    }
    public static TagKey<Item> minecraftItemTag(String path) {
        return minecraftTag(BuiltInRegistries.ITEM, path);
    }
    public static TagKey<Fluid> minecraftFluidTag(String path) {
        return minecraftTag(BuiltInRegistries.FLUID, path);
    }
    public static <T> TagKey<T> createTag(Registry<T> registry, String path) {
        return optionalTag(registry, new ResourceLocation("create", path));
    }
    public static TagKey<Block> createBlockTag(String path) {
        return createTag(BuiltInRegistries.BLOCK, path);
    }
    public static TagKey<Item> createItemTag(String path) {
        return createTag(BuiltInRegistries.ITEM, path);
    }
    public static TagKey<Fluid> createFluidTag(String path) {
        return createTag(BuiltInRegistries.FLUID, path);
    }
    public static <T> TagKey<T> framedBlocksTag(Registry<T> registry, String path) {
        return optionalTag(registry, new ResourceLocation("framedblocks", path));
    }
    public static TagKey<Block> framedBlocksBlockTag(String path) {
        return framedBlocksTag(BuiltInRegistries.BLOCK, path);
    }
}
