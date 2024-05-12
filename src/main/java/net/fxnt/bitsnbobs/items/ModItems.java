package net.fxnt.bitsnbobs.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fxnt.bitsnbobs.BitsNBobs;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item ROUGH_DIAMOND = registerItem("rough_diamond", new Item(new FabricItemSettings()));
    public static final Item NETHERITE_DUST = registerItem("netherite_dust", new Item(new FabricItemSettings()));
    public static final Item UNPROCESSED_NETHERITE_DUST = registerItem("unprocessed_netherite_dust", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(BitsNBobs.MOD_ID, name), item);
    }
    public static void registerModItems() {
        BitsNBobs.LOGGER.info("Registering Mod Items for " + BitsNBobs.MOD_ID);
    }
}
