package net.mcreator.yande.procedures;

import net.mcreator.yande.entity.YandelosecarEntity;
import net.minecraft.world.entity.Entity;

/* loaded from: YandelosecarDangShiTiChuShiShengChengShiProcedure.class */
public class YandelosecarDangShiTiChuShiShengChengShiProcedure {
    public static void execute(Entity entity) {
        if (entity != null && (entity instanceof YandelosecarEntity)) {
            ((YandelosecarEntity) entity).setAnimation("animation.yande_lose.lose_car");
        }
    }
}
