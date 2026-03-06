package net.mcreator.yande.procedures;

import net.mcreator.yande.entity.YandeEntity;
import net.mcreator.yande.init.YandeModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.items.ItemHandlerHelper;

/* loaded from: YandeDangYouJiShiTiShiProcedure.class */
public class YandeDangYouJiShiTiShiProcedure {
    public static void execute(Entity entity, Entity sourceentity) {
        if (entity != null && sourceentity != null) {
            if ((sourceentity instanceof LivingEntity ? ((LivingEntity) sourceentity).m_21205_() : ItemStack.f_41583_).m_41720_() == Items.f_42574_) {
                if (entity instanceof YandeEntity) {
                    ((YandeEntity) entity).m_20088_().m_135381_(YandeEntity.DATA_withcar, false);
                }
                if (((entity instanceof YandeEntity) && ((Boolean) ((YandeEntity) entity).m_20088_().m_135370_(YandeEntity.DATA_action_allowed)).booleanValue()) && (sourceentity instanceof Player)) {
                    ItemStack _setstack = new ItemStack((ItemLike) YandeModItems.TAIJISPAWNER.get()).m_41777_();
                    _setstack.m_41764_(1);
                    ItemHandlerHelper.giveItemToPlayer((Player) sourceentity, _setstack);
                }
            }
        }
    }
}