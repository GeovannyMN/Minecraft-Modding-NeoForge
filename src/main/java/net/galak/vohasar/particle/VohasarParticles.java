package net.galak.vohasar.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class VohasarParticles extends TextureSheetParticle {
    protected VohasarParticles(ClientLevel level, double x, double y, double z,
                               SpriteSet spriteSet, double xSpeed, double ySpeed, double zSpeed) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);

        this.lifetime = 60;
        this.setSpriteFromAge(spriteSet);

    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet spriteSet;

        public Provider(SpriteSet spriteSet){
            this.spriteSet = spriteSet;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel,
                                                 double partX, double partY, double partZ,
                                                 double partXSpeed, double partYSpeed, double partZSpeed) {
            return new VohasarParticles(clientLevel, partX, partY, partZ, this.spriteSet, partXSpeed, partYSpeed, partZSpeed);
        }
    }
}
