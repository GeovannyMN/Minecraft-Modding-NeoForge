package net.galak.vohasar.datagen;

import net.galak.vohasar.Vohasar;
import net.galak.vohasar.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Vohasar.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.VOHASARITE_BLOCK);
        blockWithItem(ModBlocks.RAW_VOHASARITE_BLOCK);

        blockWithItem(ModBlocks.VOHASARITE_ORE);
        blockWithItem(ModBlocks.VOHASARITE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.VOHASARITE_END_ORE);
        blockWithItem(ModBlocks.VOHASARITE_NETHER_ORE);

        blockWithItem(ModBlocks.MAGICAL_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
