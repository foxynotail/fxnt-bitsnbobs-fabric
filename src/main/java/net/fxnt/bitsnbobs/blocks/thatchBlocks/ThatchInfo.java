package net.fxnt.bitsnbobs.blocks.thatchBlocks;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

import java.util.List;

public class ThatchInfo {
    private final String name;
    private final String type;
    private final String waxedVersion;
    private final String agedVersion;
    private final List<TagKey> tags;

    public ThatchInfo(String name, String type, String waxedVersion, String agedVersion, List<TagKey> tags) {
        this.name = name;
        this.type = type;
        this.waxedVersion = waxedVersion;
        this.agedVersion = agedVersion;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getWaxedVersion() {
        return waxedVersion;
    }
    public String getAgedVersion() {
        return agedVersion;
    }

    public List<TagKey> getTags() {
        return tags;
    }
}
