package net.galak.vohasar.enchantment;

import com.mojang.serialization.MapCodec;
import net.galak.vohasar.Vohasar;
import net.galak.vohasar.enchantment.custom.CustomEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Vohasar.MOD_ID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> CUSTOM =
            ENTITY_ENCHANTMENT_EFFECTS.register("custom", () -> CustomEnchantmentEffect.CODEC);

    public static void register(IEventBus eventBus) {
        ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);
    }
}
