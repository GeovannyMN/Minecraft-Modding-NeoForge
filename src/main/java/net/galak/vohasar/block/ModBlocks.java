package net.galak.vohasar.block;


import net.galak.vohasar.Vohasar;
import net.galak.vohasar.block.custom.MagicalBlock;
import net.galak.vohasar.block.custom.VohasarLampBlock;
import net.galak.vohasar.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
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
                            .strength(1f).requiresCorrectToolForDrops()
                            .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> VOHASARITE_DEEPSLATE_ORE = registerBlock("vohasarite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,5),
                    BlockBehaviour.Properties.of()
                            .strength(2f).requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> VOHASARITE_NETHER_ORE = registerBlock("vohasarite_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,6),
                    BlockBehaviour.Properties.of()
                            .strength(1f).requiresCorrectToolForDrops()
                            .sound(SoundType.NETHERRACK)));

    public static final DeferredBlock<Block> VOHASARITE_END_ORE = registerBlock("vohasarite_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,7),
                    BlockBehaviour.Properties.of()
                            .strength(1f).requiresCorrectToolForDrops()
                            .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> RAW_VOHASARITE_BLOCK = registerBlock("raw_vohasarite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST_CLUSTER)));

    public static final DeferredBlock<MagicalBlock> MAGICAL_BLOCK = registerBlock("magical_block",
            () -> new MagicalBlock(BlockBehaviour.Properties.of()
                    .strength(0f).requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_BRICKS)
            ));

    public static final DeferredBlock<StairBlock> VOHASARITE_STAIR = registerBlock("vohasarite_stair",
            () -> new StairBlock(ModBlocks.VOHASARITE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(1f)
                            .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<SlabBlock> VOHASARITE_SLAB = registerBlock("vohasarite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                            .strength(1f)
                            .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<PressurePlateBlock> VOHASARITE_PRESSURE_PLATE = registerBlock("vohasarite_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.GOLD,
                    BlockBehaviour.Properties.of()
                            .strength(1f)
                            .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<ButtonBlock> VOHASARITE_BUTTON = registerBlock("vohasarite_button",
            () -> new ButtonBlock(BlockSetType.GOLD, 40,
                    BlockBehaviour.Properties.of()
                            .strength(1f)
                            .requiresCorrectToolForDrops()
                            .noCollission()
            ));

    public static final DeferredBlock<FenceBlock> VOHASARITE_FENCE = registerBlock("vohasarite_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of()
                            .strength(1f)
                            .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<FenceGateBlock> VOHASARITE_FENCE_GATE = registerBlock("vohasarite_fence_gate",
            () -> new FenceGateBlock(WoodType.MANGROVE,
                    BlockBehaviour.Properties.of()
                            .strength(1f)
                            .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<WallBlock> VOHASARITE_WALL = registerBlock("vohasarite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                            .strength(1f)
                            .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<DoorBlock> VOHASARITE_DOOR = registerBlock("vohasarite_door",
            () -> new DoorBlock(BlockSetType.GOLD,
                    BlockBehaviour.Properties.of()
                            .strength(1f)
                            .requiresCorrectToolForDrops()
                            .noOcclusion()
            ));

    public static final DeferredBlock<TrapDoorBlock> VOHASARITE_TRAPDOOR = registerBlock("vohasarite_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.GOLD,
                    BlockBehaviour.Properties.of()
                            .strength(1f)
                            .requiresCorrectToolForDrops()
                            .noOcclusion()
            ));

    public static final DeferredBlock<Block> VOHASARITE_LAMP = registerBlock("vohasarite_lamp",
            () -> new VohasarLampBlock(BlockBehaviour.Properties.of().strength(1f)
                    .requiresCorrectToolForDrops().lightLevel(
                            state -> state.getValue(VohasarLampBlock.CHANGED) ? 13 : 0)
            ));

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
