package net.mcreator.yande.init;

import net.mcreator.yande.entity.ShindeEntity;
import net.mcreator.yande.entity.TaijiEntity;
import net.mcreator.yande.entity.YandeEntity;
import net.mcreator.yande.entity.YandegodieEntity;
import net.mcreator.yande.entity.YandeifEntity;
import net.mcreator.yande.entity.YandekeepEntity;
import net.mcreator.yande.entity.YandelosecarEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber
/* loaded from: EntityAnimationFactory.class */
public class EntityAnimationFactory {
    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingTickEvent event) {
        if (event != null && event.getEntity() != null) {
            YandeEntity entity = event.getEntity();
            if (entity instanceof YandeEntity) {
                YandeEntity syncable = entity;
                String animation = syncable.getSyncedAnimation();
                if (!animation.equals("undefined")) {
                    syncable.setAnimation("undefined");
                    syncable.animationprocedure = animation;
                }
            }
            YandegodieEntity entity2 = event.getEntity();
            if (entity2 instanceof YandegodieEntity) {
                YandegodieEntity syncable2 = entity2;
                String animation2 = syncable2.getSyncedAnimation();
                if (!animation2.equals("undefined")) {
                    syncable2.setAnimation("undefined");
                    syncable2.animationprocedure = animation2;
                }
            }
            TaijiEntity entity3 = event.getEntity();
            if (entity3 instanceof TaijiEntity) {
                TaijiEntity syncable3 = entity3;
                String animation3 = syncable3.getSyncedAnimation();
                if (!animation3.equals("undefined")) {
                    syncable3.setAnimation("undefined");
                    syncable3.animationprocedure = animation3;
                }
            }
            YandelosecarEntity entity4 = event.getEntity();
            if (entity4 instanceof YandelosecarEntity) {
                YandelosecarEntity syncable4 = entity4;
                String animation4 = syncable4.getSyncedAnimation();
                if (!animation4.equals("undefined")) {
                    syncable4.setAnimation("undefined");
                    syncable4.animationprocedure = animation4;
                }
            }
            YandekeepEntity entity5 = event.getEntity();
            if (entity5 instanceof YandekeepEntity) {
                YandekeepEntity syncable5 = entity5;
                String animation5 = syncable5.getSyncedAnimation();
                if (!animation5.equals("undefined")) {
                    syncable5.setAnimation("undefined");
                    syncable5.animationprocedure = animation5;
                }
            }
            YandeifEntity entity6 = event.getEntity();
            if (entity6 instanceof YandeifEntity) {
                YandeifEntity syncable6 = entity6;
                String animation6 = syncable6.getSyncedAnimation();
                if (!animation6.equals("undefined")) {
                    syncable6.setAnimation("undefined");
                    syncable6.animationprocedure = animation6;
                }
            }
            ShindeEntity entity7 = event.getEntity();
            if (entity7 instanceof ShindeEntity) {
                ShindeEntity syncable7 = entity7;
                String animation7 = syncable7.getSyncedAnimation();
                if (!animation7.equals("undefined")) {
                    syncable7.setAnimation("undefined");
                    syncable7.animationprocedure = animation7;
                }
            }
        }
    }
}