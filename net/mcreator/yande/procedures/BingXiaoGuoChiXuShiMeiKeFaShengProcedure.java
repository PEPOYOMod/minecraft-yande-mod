package net.mcreator.yande.procedures;

import net.mcreator.yande.init.YandeModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

/* loaded from: BingXiaoGuoChiXuShiMeiKeFaShengProcedure.class */
public class BingXiaoGuoChiXuShiMeiKeFaShengProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel) {
            if (((EntityType) YandeModEntities.YANDE.get()).m_262496_((ServerLevel) world, BlockPos.m_274561_(x + 2.0d, y, z), MobSpawnType.MOB_SUMMONED) != null) {
            }
        }
        if (world instanceof ServerLevel) {
            if (((EntityType) YandeModEntities.YANDE.get()).m_262496_((ServerLevel) world, BlockPos.m_274561_(x, y, z + 2.0d), MobSpawnType.MOB_SUMMONED) != null) {
            }
        }
    }
}