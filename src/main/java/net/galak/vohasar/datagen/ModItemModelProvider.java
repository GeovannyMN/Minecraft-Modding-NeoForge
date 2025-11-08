package net.galak.vohasar.datagen;

import net.galak.vohasar.Vohasar;
import net.galak.vohasar.block.ModBlocks;
import net.galak.vohasar.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Vohasar.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.VOHASARITE.get());
        basicItem(ModItems.RAW_VOHASARITE.get());
        basicItem(ModItems.CHISEL.get());

        basicItem(ModItems.GUARANA.get());
        basicItem(ModItems.CHOCOLATED_MILK.get());
        basicItem(ModItems.VOHASAR_ASHES.get());
        basicItem(ModItems.VOHASAR_CHARCOAL.get());

        buttonItem(ModBlocks.VOHASARITE_BUTTON, ModBlocks.VOHASARITE_BLOCK);
        fenceItem(ModBlocks.VOHASARITE_FENCE, ModBlocks.VOHASARITE_BLOCK);
        wallItem(ModBlocks.VOHASARITE_WALL, ModBlocks.VOHASARITE_BLOCK);

        basicItem(ModBlocks.VOHASARITE_DOOR.asItem());
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Vohasar.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Vohasar.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(Vohasar.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
