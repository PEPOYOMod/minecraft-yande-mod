package net.mcreator.yande.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
/* loaded from: YandeModSounds.class */
public class YandeModSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "yande");
    public static final RegistryObject<SoundEvent> YANDE_DEATH = REGISTRY.register("yande.death", () -> {
        return SoundEvent.m_262824_(new ResourceLocation("yande", "yande.death"));
    });
    public static final RegistryObject<SoundEvent> YANDE_SONG = REGISTRY.register("yande.song", () -> {
        return SoundEvent.m_262824_(new ResourceLocation("yande", "yande.song"));
    });
    public static final RegistryObject<SoundEvent> HARLEY_FIRST = REGISTRY.register("harley.first", () -> {
        return SoundEvent.m_262824_(new ResourceLocation("yande", "harley.first"));
    });
    public static final RegistryObject<SoundEvent> HARLEY_SECOND = REGISTRY.register("harley.second", () -> {
        return SoundEvent.m_262824_(new ResourceLocation("yande", "harley.second"));
    });
    public static final RegistryObject<SoundEvent> HARLEY_DEATH = REGISTRY.register("harley.death", () -> {
        return SoundEvent.m_262824_(new ResourceLocation("yande", "harley.death"));
    });
    public static final RegistryObject<SoundEvent> HARLEY_DEATH2 = REGISTRY.register("harley.death2", () -> {
        return SoundEvent.m_262824_(new ResourceLocation("yande", "harley.death2"));
    });
    public static final RegistryObject<SoundEvent> HARLEY_BGM = REGISTRY.register("harley.bgm", () -> {
        return SoundEvent.m_262824_(new ResourceLocation("yande", "harley.bgm"));
    });
}