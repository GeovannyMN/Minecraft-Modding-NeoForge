package net.galak.vohasar.block;


import net.galak.vohasar.Vohasar;
import net.galak.vohasar.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Vohasar.MOD_ID);

    public static final DeferredBlock<Block> VOHASARITE_BLOCK = registerBlock("vohasarite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> VOHASARITE_ORE = registerBlock("vohasarite_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,5),
                    BlockBehaviour.Properties.of()
                            .strength(2f).requiresCorrectToolForDrops()
                            .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> VOHASARITE_NETHER_ORE = registerBlock("vohasarite_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,6),
                    BlockBehaviour.Properties.of()
                            .strength(1f).requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERRACK)));

    public static final DeferredBlock<Block> VOHASARITE_END_ORE = registerBlock("vohasarite_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,7),
                    BlockBehaviour.Properties.of()
                            .strength(1f).requiresCorrectToolForDrops()
                            .sound(SoundType.GLOW_LICHEN)));

    public static final DeferredBlock<Block> RAW_VOHASARITE_BLOCK = registerBlock("raw_vohasarite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST_CLUSTER)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
