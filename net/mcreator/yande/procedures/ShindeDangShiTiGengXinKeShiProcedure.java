package net.mcreator.yande.procedures;

import net.mcreator.yande.entity.ShindeEntity;
import net.mcreator.yande.init.YandeModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

/* loaded from: ShindeDangShiTiGengXinKeShiProcedure.class */
public class ShindeDangShiTiGengXinKeShiProcedure {
    public static void execute(LevelAccessor world, Entity entity) {
        if (entity != null) {
            if ((entity instanceof ShindeEntity ? ((Integer) ((ShindeEntity) entity).m_20088_().m_135370_(ShindeEntity.DATA_trigger)).intValue() : 0) == 6 && (entity instanceof LivingEntity)) {
                LivingEntity _entity = (LivingEntity) entity;
                if (!_entity.m_9236_().m_5776_()) {
                    _entity.m_7292_(new MobEffectInstance((MobEffect) YandeModMobEffects.BING.get(), 60, 1, false, false));
                }
            }
            if ((entity instanceof LivingEntity) && ((LivingEntity) entity).m_21023_((MobEffect) YandeModMobEffects.BING.get())) {
                entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 1.0f);
                if (entity instanceof ShindeEntity) {
                    ((ShindeEntity) entity).setAnimation("animation.model.being");
                }
            }
        }
    }
}