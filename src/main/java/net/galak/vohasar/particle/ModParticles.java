package net.galak.vohasar.particle;

import net.galak.vohasar.Vohasar;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, Vohasar.MOD_ID);

    public static final Supplier<SimpleParticleType> VOHASAR_PARTICLES =
            PARTICLE_TYPES.register("vohasar_particles", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus)
    {
        PARTICLE_TYPES.register(eventBus);
    }

}
