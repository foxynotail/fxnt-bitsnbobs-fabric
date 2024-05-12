package net.fxnt.bitsnbobs.blocks.layerBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class LayersBlock extends Block {

    // Array of all layers blocks
    public static final LayersInfo[] blocks = {
            new LayersInfo("grass", Blocks.GRASS_BLOCK, SoundType.GRASS, SoundEvents.GRASS_PLACE, List.of("grass_block_top", "dirt", "grass_block_side", "grass_block_side_overlay", "cutout")),
            new LayersInfo("dirt", Blocks.DIRT, SoundType.GRAVEL, SoundEvents.GRAVEL_PLACE, List.of()),
            new LayersInfo("coarse_dirt", Blocks.COARSE_DIRT, SoundType.GRAVEL, SoundEvents.GRAVEL_PLACE, List.of()),
            new LayersInfo("rooted_dirt", Blocks.ROOTED_DIRT, SoundType.GRAVEL, SoundEvents.ROOTED_DIRT_PLACE, List.of()),
            new LayersInfo("podzol", Blocks.PODZOL, SoundType.GRASS, SoundEvents.GRASS_PLACE, List.of("podzol_top", "dirt", "podzol_side")),
            new LayersInfo("mud", Blocks.MUD, SoundType.MUD, SoundEvents.MUD_PLACE, List.of()),
            new LayersInfo("muddy_mangrove_roots", Blocks.MUDDY_MANGROVE_ROOTS, SoundType.MUDDY_MANGROVE_ROOTS, SoundEvents.MUDDY_MANGROVE_ROOTS_PLACE, List.of("muddy_mangrove_roots_top", "muddy_mangrove_roots_top", "muddy_mangrove_roots_side")),
            new LayersInfo("gravel", Blocks.GRAVEL, SoundType.GRAVEL, SoundEvents.GRAVEL_PLACE, List.of()),
            new LayersInfo("clay", Blocks.CLAY, SoundType.GRAVEL, SoundEvents.GRAVEL_PLACE, List.of()),
            new LayersInfo("sand", Blocks.SAND, SoundType.SAND, SoundEvents.SAND_PLACE, List.of()),
            new LayersInfo("red_sand", Blocks.RED_SAND, SoundType.SAND, SoundEvents.SAND_PLACE, List.of()),
            new LayersInfo("cobblestone", Blocks.COBBLESTONE, SoundType.STONE, SoundEvents.STONE_PLACE, List.of()),
            new LayersInfo("mossy_cobblestone", Blocks.MOSSY_COBBLESTONE, SoundType.STONE, SoundEvents.STONE_PLACE, List.of()),
            new LayersInfo("stone", Blocks.STONE, SoundType.STONE, SoundEvents.STONE_PLACE, List.of()),
            new LayersInfo("stone_bricks", Blocks.STONE_BRICKS, SoundType.STONE, SoundEvents.STONE_PLACE, List.of()),
            new LayersInfo("smooth_sandstone", Blocks.SMOOTH_SANDSTONE, SoundType.STONE, SoundEvents.STONE_PLACE, List.of("sandstone_top")),
            new LayersInfo("smooth_red_sandstone", Blocks.SMOOTH_RED_SANDSTONE, SoundType.STONE, SoundEvents.STONE_PLACE, List.of("red_sandstone_top")),
            new LayersInfo("andesite", Blocks.ANDESITE, SoundType.STONE, SoundEvents.STONE_PLACE, List.of()),
            new LayersInfo("diorite", Blocks.DIORITE, SoundType.STONE, SoundEvents.STONE_PLACE, List.of()),
            new LayersInfo("granite", Blocks.GRANITE, SoundType.STONE, SoundEvents.STONE_PLACE, List.of()),
            new LayersInfo("tuff", Blocks.TUFF, SoundType.TUFF, SoundEvents.TUFF_PLACE, List.of()),
            new LayersInfo("calcite", Blocks.CALCITE, SoundType.CALCITE, SoundEvents.CALCITE_PLACE, List.of()),
            new LayersInfo("deepslate", Blocks.DEEPSLATE, SoundType.DEEPSLATE, SoundEvents.DEEPSLATE_PLACE, List.of()),
            new LayersInfo("cobbled_deepslate", Blocks.COBBLED_DEEPSLATE, SoundType.DEEPSLATE, SoundEvents.DEEPSLATE_PLACE, List.of()),
            new LayersInfo("prismarine", Blocks.PRISMARINE, SoundType.STONE, SoundEvents.STONE_PLACE, List.of()),
            new LayersInfo("blackstone", Blocks.BLACKSTONE, SoundType.STONE, SoundEvents.STONE_PLACE, List.of("blackstone_top", "blackstone")),
            new LayersInfo("end_stone", Blocks.END_STONE, SoundType.STONE, SoundEvents.STONE_PLACE, List.of()),
            new LayersInfo("netherrack", Blocks.NETHERRACK, SoundType.NETHERRACK, SoundEvents.NETHERRACK_PLACE, List.of()),
            new LayersInfo("crimson_nylium", Blocks.CRIMSON_NYLIUM, SoundType.NYLIUM, SoundEvents.NYLIUM_PLACE, List.of("crimson_nylium", "netherrack", "crimson_nylium_side")),
            new LayersInfo("warped_nylium", Blocks.WARPED_NYLIUM, SoundType.NYLIUM, SoundEvents.NYLIUM_PLACE, List.of("warped_nylium", "netherrack", "warped_nylium_side")),
            new LayersInfo("oak_planks", Blocks.OAK_PLANKS, SoundType.WOOD, SoundEvents.WOOD_PLACE, List.of()),
            new LayersInfo("spruce_planks", Blocks.SPRUCE_PLANKS, SoundType.WOOD, SoundEvents.WOOD_PLACE, List.of()),
            new LayersInfo("dark_oak_planks", Blocks.DARK_OAK_PLANKS, SoundType.WOOD, SoundEvents.WOOD_PLACE, List.of()),
            new LayersInfo("birch_planks", Blocks.BIRCH_PLANKS, SoundType.WOOD, SoundEvents.WOOD_PLACE, List.of()),
            new LayersInfo("jungle_planks", Blocks.JUNGLE_PLANKS, SoundType.WOOD, SoundEvents.WOOD_PLACE, List.of()),
            new LayersInfo("acacia_planks", Blocks.ACACIA_PLANKS, SoundType.WOOD, SoundEvents.WOOD_PLACE, List.of()),
            new LayersInfo("mangrove_planks", Blocks.MANGROVE_PLANKS, SoundType.WOOD, SoundEvents.WOOD_PLACE, List.of()),
            new LayersInfo("cherry_planks", Blocks.CHERRY_PLANKS, SoundType.CHERRY_WOOD, SoundEvents.CHERRY_WOOD_PLACE, List.of()),
            new LayersInfo("bamboo_planks", Blocks.BAMBOO_PLANKS, SoundType.BAMBOO_WOOD, SoundEvents.BAMBOO_WOOD_PLACE, List.of()),
            new LayersInfo("crimson_planks", Blocks.CRIMSON_PLANKS, SoundType.NETHER_WOOD, SoundEvents.NETHER_WOOD_PLACE, List.of()),
            new LayersInfo("warped_planks", Blocks.WARPED_PLANKS, SoundType.NETHER_WOOD, SoundEvents.NETHER_WOOD_PLACE, List.of())
    };


    public static final IntegerProperty LAYERS;

    static {
        LAYERS = IntegerProperty.create("layers", 1, 7);
    }

    private final Block vanillaBlock;
    private final SoundEvent placeSound;
    public static final VoxelShape SHAPE = Block.box(0f, 0f, 0f, 16f, 2f, 16f);

    public LayersBlock(FabricBlockSettings properties, Block vanillaBlock, SoundType soundType, SoundEvent placeSound) {
        super(properties.copyOf(vanillaBlock).sound(soundType));
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue(LAYERS, 1));
        this.vanillaBlock = vanillaBlock;
        this.placeSound = placeSound;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pBlockGetter, BlockPos pPos, CollisionContext pCollision) {
        int layers = pState.getValue(LAYERS);
        double YHeight = layers * 2;
        VoxelShape SHAPE = Block.box(0, 0, 0, 16, YHeight, 16);
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        int layers = pState.getValue(LAYERS);
        ItemStack held = pPlayer.getItemInHand(pHand);
        boolean addLayer = false;

        if (held.getItem() == this.asItem()) {

            if (layers < 7) {
                pState.setValue(LAYERS, layers + 1);
                pLevel.setBlock(pPos, (BlockState) pState.cycle(LAYERS), 2);
            } else {
                addLayer = true;
            }
            if (!pPlayer.isCreative()) {
                held.setCount(held.getCount() - 1);
            }
            if (addLayer == true) {
                pLevel.setBlock(pPos, vanillaBlock.defaultBlockState(), 3);
            }
            pLevel.playSound(pPlayer, pPos, placeSound, SoundSource.BLOCKS, 1f, 1f);

            return InteractionResult.SUCCESS;

        }

        return InteractionResult.PASS;

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(LAYERS);
    }
}
