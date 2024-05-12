package net.fxnt.bitsnbobs.blocks.thatchBlocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class WaxedThatchBlock extends RotatedPillarBlock {


    private final String unwaxedVersion;
    public WaxedThatchBlock(FabricBlockSettings properties, ThatchInfo info) {
        super(properties.copyOf(Blocks.HAY_BLOCK));
        this.unwaxedVersion = info.getWaxedVersion();
    }


    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        ItemStack held = pPlayer.getItemInHand(pHand);


        if (held.getItem().getDefaultInstance().is(ItemTags.AXES)) {
            pLevel.setBlock(pPos, ModBlocks.getBlock(unwaxedVersion).defaultBlockState().setValue(AXIS, pState.getValue(AXIS)), 3);
            pLevel.addParticle(ParticleTypes.WAX_OFF, pPos.getX()+0.5, pPos.getY()+1, pPos.getZ()+0.5, 1, 1, 1);
            pLevel.playSound(pPlayer, pPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1f, 1f);
            return  InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS ;
    }

}
