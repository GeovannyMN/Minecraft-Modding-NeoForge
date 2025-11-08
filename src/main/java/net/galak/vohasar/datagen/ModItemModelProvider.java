package net.galak.vohasar.datagen;

import net.galak.vohasar.Vohasar;
import net.galak.vohasar.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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
    }
}
