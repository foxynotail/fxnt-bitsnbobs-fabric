package net.fxnt.bitsnbobs.blocks.thatchBlocks;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fxnt.bitsnbobs.BitsNBobs;
import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.block.model.BlockElement;
import net.minecraft.client.renderer.block.model.BlockElementFace;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.data.DataProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ModelProvider;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.level.block.Block;
import org.joml.Vector3f;

import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ThatchModel {
    public static void generate(BlockModelGenerators blockStateModelGenerator) {
        BitsNBobs.LOGGER.info("Generating Block States and Models for Thatch Blocks");
        for (ThatchInfo info : ThatchBlock.blocks) {
            Block block = ModBlocks.getBlock(info.getName());

            // This creates a RotatedPillarBlock BlockState Only, it does not produce the model
            blockStateModelGenerator.blockStateOutput.accept(
                    BlockModelGenerators.createAxisAlignedPillarBlock(block,
                            new ResourceLocation(BitsNBobs.MOD_ID, "block/" + info.getName())));

            // This creates a RotatedPillarBlock Model Only
            JsonObject modelJson = new JsonObject();
            modelJson.addProperty("parent", "minecraft:block/cube_column");
            JsonObject textures = new JsonObject();
            // Waxed variants need to use the same texture as non waxed!
            textures.addProperty("end", "bitsnbobs:block/" + info.getName().replace("waxed_", "") + "_top");
            textures.addProperty("side", "bitsnbobs:block/" + info.getName().replace("waxed_", "") + "_side");
            modelJson.add("textures", textures);
            Supplier<JsonElement> jsonSupplier = () -> modelJson;

            blockStateModelGenerator.modelOutput.accept(new ResourceLocation("bitsnbobs", "block/" + info.getName()), jsonSupplier);

        }
    }
}
