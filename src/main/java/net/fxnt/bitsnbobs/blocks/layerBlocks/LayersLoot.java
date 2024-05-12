package net.fxnt.bitsnbobs.blocks.layerBlocks;

import net.fxnt.bitsnbobs.blocks.ModBlocks;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;

public class LayersLoot {

    public interface associationCallback {
        void associate(Block block, LootTable.Builder lootTable);
    }

    public void get(associationCallback callback) {

        for (LayersInfo info : LayersBlock.blocks) {
            Block block = ModBlocks.getBlock(info.getName() + "_layers_block");
            callback.associate(block, getLayersBlockLootTableBuilder(block));
        }
    }

    @NotNull
    private LootTable.Builder getLayersBlockLootTableBuilder(Block block) {

        int maxLayers = 7;
        LootPool.Builder layersTable = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .setBonusRolls(ConstantValue.exactly(0));

        for (int i = 1; i <= 7; i++) {
            layersTable.add(LootItem.lootTableItem(block)
                    .apply(SetItemCountFunction.setCount(ConstantValue.exactly(i)))
                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LayersBlock.LAYERS, i))
                    )
            );
        }
        return LootTable.lootTable().withPool(layersTable);
    }
}
