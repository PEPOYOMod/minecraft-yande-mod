package net.mcreator.yande.procedures;

import net.mcreator.yande.init.YandeModEntities;
import net.mcreator.yande.init.YandeModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

/* loaded from: TaijispawnerDangYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure.class */
public class TaijispawnerDangYouJiFangKuaiShiFangKuaiDeWeiZhiProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if (!(entity instanceof Player) || !((Player) entity).m_150110_().f_35937_) {
                if (world instanceof ServerLevel) {
                    if (((EntityType) YandeModEntities.TAIJI.get()).m_262496_((ServerLevel) world, BlockPos.m_274561_(x, y + 1.0d, z), MobSpawnType.MOB_SUMMONED) != null) {
                    }
                }
                if (entity instanceof Player) {
                    Player _player = (Player) entity;
                    ItemStack _stktoremove = new ItemStack((ItemLike) YandeModItems.TAIJISPAWNER.get());
                    _player.m_150109_().m_36022_(p -> {
                        return _stktoremove.m_41720_() == p.m_41720_();
                    }, 1, _player.f_36095_.m_39730_());
                }
            } else if (world instanceof ServerLevel) {
                if (((EntityType) YandeModEntities.TAIJI.get()).m_262496_((ServerLevel) world, BlockPos.m_274561_(x, y + 1.0d, z), MobSpawnType.MOB_SUMMONED) != null) {
                }
            }
        }
    }
}