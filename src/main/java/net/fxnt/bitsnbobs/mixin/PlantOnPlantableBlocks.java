package net.fxnt.bitsnbobs.mixin;

import net.fxnt.bitsnbobs.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({DeadBushBlock.class, BushBlock.class})
public class PlantOnPlantableBlocks {

    @Inject(at = @At("TAIL"), method = "mayPlaceOn", cancellable = true)
    private void canPlantOnPlantableBlocks(BlockState state, BlockGetter level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        boolean canPlant = false;
        if (state.is(ModTags.PLANTABLE_BLOCKS)) {
            if (state.is(ModTags.SLABS)) {
                SlabType slabType = state.getValue(SlabBlock.TYPE);
                if (slabType != SlabType.BOTTOM) {
                    canPlant = true;
                }
            } else {
                canPlant = true;
            }
        }
        cir.setReturnValue(cir.getReturnValue() || canPlant);
    }

}
