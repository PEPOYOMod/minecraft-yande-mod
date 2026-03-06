package net.mcreator.yande.procedures;

import net.mcreator.yande.entity.YandeEntity;
import net.mcreator.yande.init.YandeModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

/* loaded from: YandeDangShiTiGengXinKeShiawProcedure.class */
public class YandeDangShiTiGengXinKeShiawProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity != null) {
            if ((entity instanceof LivingEntity ? ((LivingEntity) entity).m_21223_() : -1.0f) < 1.0f) {
                if ((entity instanceof YandeEntity) && ((Boolean) ((YandeEntity) entity).m_20088_().m_135370_(YandeEntity.DATA_action_allowed)).booleanValue()) {
                    if (entity instanceof YandeEntity) {
                        ((YandeEntity) entity).m_20088_().m_135381_(YandeEntity.DATA_if_death, Integer.valueOf(Mth.m_216271_(RandomSource.m_216327_(), 1, 60)));
                    }
                    if ((entity instanceof YandeEntity ? ((Integer) ((YandeEntity) entity).m_20088_().m_135370_(YandeEntity.DATA_if_death)).intValue() : 0) == 32) {
                        if (world instanceof ServerLevel) {
                            if (((EntityType) YandeModEntities.YANDEGODIE.get()).m_262496_((ServerLevel) world, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED) != null) {
                            }
                        }
                        entity.m_6021_(x, -200.0d, z);
                        if (entity instanceof ServerPlayer) {
                            ((ServerPlayer) entity).f_8906_.m_9774_(x, -200.0d, z, entity.m_146908_(), entity.m_146909_());
                        }
                    }
                }
            }
            if (!((entity instanceof YandeEntity) && ((Boolean) ((YandeEntity) entity).m_20088_().m_135370_(YandeEntity.DATA_withcar)).booleanValue())) {
                if ((entity instanceof YandeEntity) && ((Boolean) ((YandeEntity) entity).m_20088_().m_135370_(YandeEntity.DATA_action_allowed)).booleanValue()) {
                    if (entity instanceof YandeEntity) {
                        ((YandeEntity) entity).m_20088_().m_135381_(YandeEntity.DATA_action_allowed, false);
                    }
                    if (world instanceof ServerLevel) {
                        if (((EntityType) YandeModEntities.YANDELOSECAR.get()).m_262496_((ServerLevel) world, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED) != null) {
                        }
                    }
                    entity.m_6021_(x, y - 200.0d, z);
                    if (entity instanceof ServerPlayer) {
                        ((ServerPlayer) entity).f_8906_.m_9774_(x, y - 200.0d, z, entity.m_146908_(), entity.m_146909_());
                    }
                    if (!entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                    }
                }
            }
            if (!((entity instanceof YandeEntity) && ((Boolean) ((YandeEntity) entity).m_20088_().m_135370_(YandeEntity.DATA_withcar)).booleanValue())) {
                entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 5.0f);
            }
            if (world.m_8055_(BlockPos.m_274561_(x, y - 1.0d, z)).m_60734_() == Blocks.f_50332_) {
                if (entity instanceof YandeEntity) {
                    ((YandeEntity) entity).m_20088_().m_135381_(YandeEntity.DATA_withcar, false);
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level = (ServerLevel) world;
                    ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.f_42416_));
                    entityToSpawn.m_32010_(10);
                    _level.m_7967_(entityToSpawn);
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level2 = (ServerLevel) world;
                    ItemEntity entityToSpawn2 = new ItemEntity(_level2, x, y, z, new ItemStack(Items.f_42416_));
                    entityToSpawn2.m_32010_(10);
                    _level2.m_7967_(entityToSpawn2);
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level3 = (ServerLevel) world;
                    ItemEntity entityToSpawn3 = new ItemEntity(_level3, x, y, z, new ItemStack(Items.f_42416_));
                    entityToSpawn3.m_32010_(10);
                    _level3.m_7967_(entityToSpawn3);
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level4 = (ServerLevel) world;
                    ItemEntity entityToSpawn4 = new ItemEntity(_level4, x, y, z, new ItemStack(Items.f_42416_));
                    entityToSpawn4.m_32010_(10);
                    _level4.m_7967_(entityToSpawn4);
                }
                if (world instanceof ServerLevel) {
                    ServerLevel _level5 = (ServerLevel) world;
                    ItemEntity entityToSpawn5 = new ItemEntity(_level5, x, y, z, new ItemStack(Items.f_42416_));
                    entityToSpawn5.m_32010_(10);
                    _level5.m_7967_(entityToSpawn5);
                }
            }
        }
    }
}