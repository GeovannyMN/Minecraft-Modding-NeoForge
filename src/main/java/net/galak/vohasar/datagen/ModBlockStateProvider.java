package net.galak.vohasar.datagen;

import net.galak.vohasar.Vohasar;
import net.galak.vohasar.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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

        stairsBlock(ModBlocks.VOHASARITE_STAIR.get(), blockTexture(ModBlocks.VOHASARITE_BLOCK.get()));
        slabBlock(ModBlocks.VOHASARITE_SLAB.get(), blockTexture(ModBlocks.VOHASARITE_BLOCK.get()), blockTexture(ModBlocks.VOHASARITE_BLOCK.get()));
        buttonBlock(ModBlocks.VOHASARITE_BUTTON.get(), blockTexture(ModBlocks.VOHASARITE_BLOCK.get()));
        pressurePlateBlock(ModBlocks.VOHASARITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.VOHASARITE_BLOCK.get()));

        fenceBlock(ModBlocks.VOHASARITE_FENCE.get(), blockTexture(ModBlocks.VOHASARITE_BLOCK.get()));
        fenceGateBlock(ModBlocks.VOHASARITE_FENCE_GATE.get(), blockTexture(ModBlocks.VOHASARITE_BLOCK.get()));
        wallBlock(ModBlocks.VOHASARITE_WALL.get(), blockTexture(ModBlocks.VOHASARITE_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.VOHASARITE_DOOR.get(),
                modLoc("block/vohasarite_door_bottom"), modLoc("block/vohasarite_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.VOHASARITE_TRAPDOOR.get(),
                modLoc("block/vohasarite_trapdoor"), true, "cutout");

        blockItem(ModBlocks.VOHASARITE_STAIR);
        blockItem(ModBlocks.VOHASARITE_SLAB);
        blockItem(ModBlocks.VOHASARITE_PRESSURE_PLATE);
        blockItem(ModBlocks.VOHASARITE_FENCE_GATE);
        blockItem(ModBlocks.VOHASARITE_TRAPDOOR, "_bottom");
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("vohasarpro:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("vohasarpro:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
