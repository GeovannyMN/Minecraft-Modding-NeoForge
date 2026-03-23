package net.galak.vohasar.enchantment;

import net.galak.vohasar.Vohasar;
import net.galak.vohasar.enchantment.custom.CustomEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> CUSTOM = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(Vohasar.MOD_ID, "custom"));

    public static void bootstrap (BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        register(context, CUSTOM, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                5,
                2,
                Enchantment.dynamicCost(3,5),
                Enchantment.dynamicCost(8, 4),
                2,
                EquipmentSlotGroup.MAINHAND
        ))
                        .exclusiveWith(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE))
                        .withEffect(EnchantmentEffectComponents.POST_ATTACK,
                                EnchantmentTarget.ATTACKER, EnchantmentTarget.VICTIM,
                                new CustomEnchantmentEffect())
        );
    }


    public static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key,
                                Enchantment.Builder builder)
    {
        registry.register(key, builder.build(key.location()));
    }
}
