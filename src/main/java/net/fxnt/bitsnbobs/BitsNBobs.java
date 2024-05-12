package net.fxnt.bitsnbobs;

import net.fabricmc.api.ModInitializer;
import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.fxnt.bitsnbobs.groups.ModGroups;
import net.fxnt.bitsnbobs.items.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BitsNBobs implements ModInitializer {
    public static final String MOD_ID = "bitsnbobs";
    public static final String NAME = "FXNT BitsNBobs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}
