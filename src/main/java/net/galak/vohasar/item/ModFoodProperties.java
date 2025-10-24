package net.galak.vohasar.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties{
    public static final FoodProperties GUARANA = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 800), 0.75f)
            .build();

    public static final FoodProperties CHOCOLATED_MILK = new FoodProperties.Builder().nutrition(5).saturationModifier(0.9f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200), 0.5f).build();
}
