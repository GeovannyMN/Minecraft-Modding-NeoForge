package net.galak.vohasar.datagen;

import net.galak.vohasar.Vohasar;
import net.galak.vohasar.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Vohasar.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.VOHASARITE_BLOCK.get())
                .add(ModBlocks.VOHASARITE_ORE.get())
                .add(ModBlocks.VOHASARITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.VOHASARITE_NETHER_ORE.get())
                .add(ModBlocks.VOHASARITE_END_ORE.get())
                .add(ModBlocks.MAGICAL_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.VOHASARITE_ORE.get())
                .add(ModBlocks.RAW_VOHASARITE_BLOCK.get())
                .add(ModBlocks.VOHASARITE_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.VOHASARITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.VOHASARITE_NETHER_ORE.get())
                .add(ModBlocks.VOHASARITE_END_ORE.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.VOHASARITE_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.VOHASARITE_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.VOHASARITE_WALL.get());
    }
}
