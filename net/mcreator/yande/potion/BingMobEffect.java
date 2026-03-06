package net.mcreator.yande.potion;

import net.mcreator.yande.procedures.BingXiaoGuoChiXuShiMeiKeFaShengProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
/* loaded from: BingMobEffect.class */
public class BingMobEffect extends MobEffect {
    public BingMobEffect() {
        super(MobEffectCategory.NEUTRAL, -1);
    }

    public void m_6742_(LivingEntity entity, int amplifier) {
        BingXiaoGuoChiXuShiMeiKeFaShengProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
    }

    public boolean m_6584_(int duration, int amplifier) {
        return true;
    }
}
