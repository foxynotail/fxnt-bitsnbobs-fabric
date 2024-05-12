package net.fxnt.bitsnbobs.blocks.thatchBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.fxnt.bitsnbobs.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ThatchBlock extends RotatedPillarBlock {

    public static final ThatchInfo[] blocks = {
            // name, waxedversion, oldversion, tags
            new ThatchInfo("thatch_block", "unwaxed",
                    "waxed_thatch_block",
                    "aged_thatch_block",
                    List.of(ModTags.MINEABLE_HOE, ModTags.THATCH_BLOCKS, ModTags.FRAMEABLE)),

            new ThatchInfo("aged_thatch_block", "unwaxed",
                    "waxed_aged_thatch_block",
                    "old_thatch_block",
                    List.of(ModTags.MINEABLE_HOE, ModTags.THATCH_BLOCKS, ModTags.FRAMEABLE)),

            new ThatchInfo("old_thatch_block", "old",
                    "old_thatch_block",                 // Waxed Version N/A
                    "old_thatch_block",                             // Aged Version N/A
                    List.of(ModTags.MINEABLE_HOE, ModTags.THATCH_BLOCKS, ModTags.FRAMEABLE)),

            new ThatchInfo("waxed_thatch_block", "waxed",
                    "thatch_block",                     // Unwaxed Version
                    "waxed_thatch_block",                           // Aged Version N/A
                    List.of(ModTags.MINEABLE_HOE, ModTags.THATCH_BLOCKS, ModTags.FRAMEABLE)),

            new ThatchInfo("waxed_aged_thatch_block", "waxed",
                "aged_thatch_block",                    // Unwaxed Version
                    "waxed_aged_thatch_block",                      // Aged Version N/A
                    List.of(ModTags.MINEABLE_HOE, ModTags.THATCH_BLOCKS, ModTags.FRAMEABLE)),

    };
    public static final IntegerProperty DELAY;

    static {
        DELAY = IntegerProperty.create("delay", 0, 1000);
    }

    private final String waxedVersion;
    private final String agedVersion;

    public ThatchBlock(FabricBlockSettings properties, ThatchInfo info) {
        super(properties.copyOf(Blocks.HAY_BLOCK).ticksRandomly());
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue(DELAY, 0));
        this.registerDefaultState((BlockState)this.defaultBlockState().setValue(AXIS, Direction.Axis.Y));
        this.waxedVersion = info.getWaxedVersion();
        this.agedVersion = info.getAgedVersion();
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack held = pPlayer.getItemInHand(pHand);
        if (held.getItem() == Items.HONEYCOMB) {

            pLevel.setBlock(pPos, ModBlocks.getBlock(waxedVersion).defaultBlockState().setValue(AXIS, pState.getValue(AXIS)), 3);
            pLevel.addParticle(ParticleTypes.WAX_ON, pPos.getX()+0.5, pPos.getY()+1, pPos.getZ()+0.5, 1, 1, 1);
            if (!pPlayer.isCreative()) {
                held.setCount(held.getCount() - 1);
            }
            pLevel.playSound(pPlayer, pPos, SoundEvents.HONEYCOMB_WAX_ON, SoundSource.BLOCKS, 1f, 1f);
            return  InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {

        int blockAge = pState.getValue(DELAY);

        String thisBlockName = pState.getBlock().asItem().toString();

        int maxBlockAge = 500;
        if (Objects.equals(thisBlockName, "thatch_block")) {
            maxBlockAge = 50;
        }

        if(blockAge < maxBlockAge) {

            pState.setValue(DELAY, blockAge+1);
            pLevel.setBlock(pPos, (BlockState) pState.cycle(DELAY), 2);

        } else {

            double baseChance = 1.75;  // Adjust this value based on your desired base probability
            double multiplier = 3.5;

            int matchingNeighbors = 0;

            for (int xOffset = -1; xOffset <= 1; xOffset++) {
                for (int yOffset = -1; yOffset <= 1; yOffset++) {
                    for (int zOffset = -1; zOffset <= 1; zOffset++) {
                        if (xOffset == 0 && yOffset == 0 && zOffset == 0) continue; // Skip the current block

                        BlockPos neighborPos = pPos.offset(xOffset, yOffset, zOffset);
                        BlockState neighborState = pLevel.getBlockState(neighborPos);
                        String neighborName = neighborState.getBlock().asItem().toString();

                        if (neighborName.equals(thisBlockName)) {
                            matchingNeighbors++;
                        }
                    }
                }
            }

            double chance = baseChance / Math.pow(multiplier, matchingNeighbors);

            Random random = new Random();
            if (random.nextDouble() <= chance) {
                if (Objects.equals(thisBlockName, "thatch_block")) {
                    pLevel.setBlock(pPos, ModBlocks.getBlock(agedVersion).defaultBlockState()
                            .setValue(AXIS, pState.getValue(AXIS)).setValue(DELAY, 0), 3);
                } else {
                    pLevel.setBlock(pPos, ModBlocks.getBlock(agedVersion).defaultBlockState()
                            .setValue(AXIS, pState.getValue(AXIS)), 3);

                }
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder);
        pBuilder.add(DELAY);
    }

}
