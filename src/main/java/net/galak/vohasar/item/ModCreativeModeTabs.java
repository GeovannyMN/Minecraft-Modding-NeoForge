package net.galak.vohasar.item;


import net.galak.vohasar.Vohasar;
import net.galak.vohasar.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Vohasar.MOD_ID);
    
    public static final Supplier<CreativeModeTab> VOHASAR_ITEMS_TAB = CREATIVE_MODE_TAB.register("vohasar_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.VOHASARITE.get()))
                    .title(Component.translatable("creativetab.vohasarpro.vohasar_items"))
                    .displayItems(
                            (itemDisplayParameters, output) -> {
                                output.accept(ModItems.VOHASARITE);
                                output.accept(ModItems.RAW_VOHASARITE);
                                output.accept(ModItems.CHISEL);
                                output.accept(ModItems.GUARANA);
                                output.accept(ModItems.CHOCOLATED_MILK);
                                output.accept(ModItems.VOHASAR_CHARCOAL);
                                output.accept(ModItems.VOHASAR_ASHES);
                            }
                    )
                    .build());

    public static final Supplier<CreativeModeTab> VOHASAR_BLOCKS_TAB = CREATIVE_MODE_TAB.register("vohasar_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.VOHASARITE_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Vohasar.MOD_ID, "vohasar_items_tab"))
                    .title(Component.translatable("creativetab.vohasarpro.vohasar_blocks"))
                    .displayItems(
                            (itemDisplayParameters, output) -> {
                                output.accept(ModBlocks.VOHASARITE_BLOCK);
                                output.accept(ModBlocks.RAW_VOHASARITE_BLOCK);
                                output.accept(ModBlocks.VOHASARITE_ORE);
                                output.accept(ModBlocks.VOHASARITE_DEEPSLATE_ORE);
                                output.accept(ModBlocks.VOHASARITE_NETHER_ORE);
                                output.accept(ModBlocks.VOHASARITE_END_ORE);
                                output.accept(ModBlocks.MAGICAL_BLOCK);

                                output.accept(ModBlocks.VOHASARITE_STAIR);
                                output.accept(ModBlocks.VOHASARITE_SLAB);
                                output.accept(ModBlocks.VOHASARITE_PRESSURE_PLATE);
                                output.accept(ModBlocks.VOHASARITE_BUTTON);
                                output.accept(ModBlocks.VOHASARITE_FENCE);
                                output.accept(ModBlocks.VOHASARITE_FENCE_GATE);
                                output.accept(ModBlocks.VOHASARITE_WALL);
                                output.accept(ModBlocks.VOHASARITE_DOOR);
                                output.accept(ModBlocks.VOHASARITE_TRAPDOOR);

                            }
                    )
                    .build());
    
    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
