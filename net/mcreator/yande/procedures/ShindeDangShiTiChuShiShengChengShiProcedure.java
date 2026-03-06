package net.mcreator.yande.procedures;

import net.mcreator.yande.entity.ShindeEntity;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;

/* loaded from: ShindeDangShiTiChuShiShengChengShiProcedure.class */
public class ShindeDangShiTiChuShiShengChengShiProcedure {
    public static void execute(Entity entity) {
        if (entity != null && (entity instanceof ShindeEntity)) {
            ((ShindeEntity) entity).m_20088_().m_135381_(ShindeEntity.DATA_trigger, Integer.valueOf(Mth.m_216271_(RandomSource.m_216327_(), 1, 20)));
        }
    }
}