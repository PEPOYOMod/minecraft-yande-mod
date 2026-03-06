package net.mcreator.yande.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/* loaded from: TaijiDangYouJiShiTiShiProcedure.class */
public class TaijiDangYouJiShiTiShiProcedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if (!(entity instanceof TamableAnimal) || !((TamableAnimal) entity).m_21824_()) {
                if ((sourceentity instanceof LivingEntity ? ((LivingEntity) sourceentity).m_21205_() : ItemStack.f_41583_).m_41720_() == Items.f_42579_ && (entity instanceof TamableAnimal)) {
                    TamableAnimal _toTame = (TamableAnimal) entity;
                    if (sourceentity instanceof Player) {
                        _toTame.m_21828_((Player) sourceentity);
                        return;
                    }
                    return;
                }
                return;
            }
            sourceentity.m_20329_(entity);
        }
    }
}