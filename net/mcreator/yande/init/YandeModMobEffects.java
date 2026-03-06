package net.mcreator.yande.init;

import net.mcreator.yande.potion.BingMobEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
/* loaded from: YandeModMobEffects.class */
public class YandeModMobEffects {
    public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, "yande");
    public static final RegistryObject<MobEffect> BING = REGISTRY.register("bing", () -> {
        return new BingMobEffect();
    });
}