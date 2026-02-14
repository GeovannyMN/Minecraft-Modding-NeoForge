package net.galak.vohasar.datagen;

import net.galak.vohasar.Vohasar;
import net.galak.vohasar.item.ModItems;
import net.galak.vohasar.loot.AddLootModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Vohasar.MOD_ID);
    }

    @Override
    protected void start() {
        this.add("vohasar_charcoal_to_coal_ore",
                new AddLootModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COAL_ORE).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build()
                }, ModItems.VOHASAR_CHARCOAL.get()));

        this.add("vohasar_ashes_to_coal_block",
                new AddLootModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.COAL_BLOCK).build(),
                        LootItemRandomChanceCondition.randomChance(0.75f).build()
                }, ModItems.VOHASAR_ASHES.get()));

        this.add("vohasarite_from_jungle_temple",
                new AddLootModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple")).build()
                }, ModItems.VOHASARITE.get()));

        this.add("guarana_from_creeper",
                new AddLootModifier(new LootItemCondition[]{
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/creeper")).build()
                }, ModItems.GUARANA.get()));
    }
}
