package net.galak.vohasar.item.custom;

import net.galak.vohasar.block.ModBlocks;
import net.galak.vohasar.particle.ModParticles;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.NETHERRACK, Blocks.NETHER_BRICKS,
                    Blocks.MOSSY_COBBLESTONE, Blocks.MOSSY_STONE_BRICKS,
                    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
                    Blocks.IRON_BLOCK, ModBlocks.VOHASARITE_BLOCK.get()
            );


    public ChiselItem(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos clicked = context.getClickedPos();
        Block block = level.getBlockState(clicked).getBlock();

        if (CHISEL_MAP.containsKey(block))
        {
            if (!level.isClientSide())
            {
                level.setBlockAndUpdate(context.getClickedPos(),
                        CHISEL_MAP.get(block).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item->context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.SMITHING_TABLE_USE, SoundSource.BLOCKS);

                ((ServerLevel) level).sendParticles(
                        ModParticles.VOHASAR_PARTICLES.get(),
                        context.getClickedPos().getX() + 0.5,
                        context.getClickedPos().getY() + 1.0,
                        context.getClickedPos().getZ() + 0.5,
                        5, 0 , 0, 0, 3
                );

            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.vohasarpro.chisel.shift_down"));
        }else{
            tooltipComponents.add(Component.translatable("tooltip.vohasarpro.chisel"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
