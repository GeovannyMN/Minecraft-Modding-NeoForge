package net.galak.vohasar.datagen;

import net.galak.vohasar.block.ModBlocks;
import net.galak.vohasar.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class MobBlockLootTableProvider extends BlockLootSubProvider {
    protected MobBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.VOHASARITE_BLOCK.get());
        dropSelf(ModBlocks.MAGICAL_BLOCK.get());
        dropSelf(ModBlocks.RAW_VOHASARITE_BLOCK.get());

        dropSelf(ModBlocks.VOHASARITE_STAIR.get());

        add(ModBlocks.VOHASARITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.VOHASARITE_SLAB.get()));

        dropSelf(ModBlocks.VOHASARITE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.VOHASARITE_BUTTON.get());

        dropSelf(ModBlocks.VOHASARITE_FENCE.get());
        dropSelf(ModBlocks.VOHASARITE_FENCE_GATE.get());
        dropSelf(ModBlocks.VOHASARITE_WALL.get());
        dropSelf(ModBlocks.VOHASARITE_TRAPDOOR.get());

        add(ModBlocks.VOHASARITE_ORE.get(),
                block -> createOreDrop(ModBlocks.VOHASARITE_ORE.get(),
                        ModItems.RAW_VOHASARITE.get()));

        add(ModBlocks.VOHASARITE_DOOR.get()
        , block -> createDoorTable(ModBlocks.VOHASARITE_DOOR.get()));

        add(ModBlocks.VOHASARITE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrop(ModBlocks.VOHASARITE_DEEPSLATE_ORE.get(),
                        ModItems.RAW_VOHASARITE.get(), 3, 6));

        add(ModBlocks.VOHASARITE_NETHER_ORE.get(),
                block -> createMultipleOreDrop(ModBlocks.VOHASARITE_NETHER_ORE.get(),
                        ModItems.RAW_VOHASARITE.get(), 5, 9));

        add(ModBlocks.VOHASARITE_END_ORE.get(),
                block -> createMultipleOreDrop(ModBlocks.VOHASARITE_END_ORE.get(),
                        ModItems.RAW_VOHASARITE.get(), 8, 12));
    }

    protected LootTable.Builder createMultipleOreDrop(Block block, Item item, float minDrops, float maxDrops){
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        return this.createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
