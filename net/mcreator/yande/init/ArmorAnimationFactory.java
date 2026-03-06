package net.mcreator.yande.init;

import net.mcreator.yande.item.YandeclothItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib.animatable.GeoItem;
@Mod.EventBusSubscriber
/* loaded from: ArmorAnimationFactory.class */
public class ArmorAnimationFactory {
    @SubscribeEvent
    public static void animatedArmors(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (event.player.m_6844_(EquipmentSlot.HEAD).m_41720_() != ItemStack.f_41583_.m_41720_() && (event.player.m_6844_(EquipmentSlot.HEAD).m_41720_() instanceof GeoItem) && !event.player.m_6844_(EquipmentSlot.HEAD).m_41784_().m_128461_("geckoAnim").equals("")) {
                String animation = event.player.m_6844_(EquipmentSlot.HEAD).m_41784_().m_128461_("geckoAnim");
                event.player.m_6844_(EquipmentSlot.HEAD).m_41784_().m_128359_("geckoAnim", "");
                YandeclothItem m_41720_ = event.player.m_6844_(EquipmentSlot.HEAD).m_41720_();
                if (m_41720_ instanceof YandeclothItem) {
                    YandeclothItem animatable = m_41720_;
                    if (event.player.m_9236_().m_5776_()) {
                        animatable.animationprocedure = animation;
                    }
                }
            }
            if (event.player.m_6844_(EquipmentSlot.CHEST).m_41720_() != ItemStack.f_41583_.m_41720_() && (event.player.m_6844_(EquipmentSlot.CHEST).m_41720_() instanceof GeoItem) && !event.player.m_6844_(EquipmentSlot.CHEST).m_41784_().m_128461_("geckoAnim").equals("")) {
                String animation2 = event.player.m_6844_(EquipmentSlot.CHEST).m_41784_().m_128461_("geckoAnim");
                event.player.m_6844_(EquipmentSlot.CHEST).m_41784_().m_128359_("geckoAnim", "");
                YandeclothItem m_41720_2 = event.player.m_6844_(EquipmentSlot.CHEST).m_41720_();
                if (m_41720_2 instanceof YandeclothItem) {
                    YandeclothItem animatable2 = m_41720_2;
                    if (event.player.m_9236_().m_5776_()) {
                        animatable2.animationprocedure = animation2;
                    }
                }
            }
            if (event.player.m_6844_(EquipmentSlot.LEGS).m_41720_() != ItemStack.f_41583_.m_41720_() && (event.player.m_6844_(EquipmentSlot.LEGS).m_41720_() instanceof GeoItem) && !event.player.m_6844_(EquipmentSlot.LEGS).m_41784_().m_128461_("geckoAnim").equals("")) {
                String animation3 = event.player.m_6844_(EquipmentSlot.LEGS).m_41784_().m_128461_("geckoAnim");
                event.player.m_6844_(EquipmentSlot.LEGS).m_41784_().m_128359_("geckoAnim", "");
                YandeclothItem m_41720_3 = event.player.m_6844_(EquipmentSlot.LEGS).m_41720_();
                if (m_41720_3 instanceof YandeclothItem) {
                    YandeclothItem animatable3 = m_41720_3;
                    if (event.player.m_9236_().m_5776_()) {
                        animatable3.animationprocedure = animation3;
                    }
                }
            }
            if (event.player.m_6844_(EquipmentSlot.FEET).m_41720_() != ItemStack.f_41583_.m_41720_() && (event.player.m_6844_(EquipmentSlot.FEET).m_41720_() instanceof GeoItem) && !event.player.m_6844_(EquipmentSlot.FEET).m_41784_().m_128461_("geckoAnim").equals("")) {
                String animation4 = event.player.m_6844_(EquipmentSlot.FEET).m_41784_().m_128461_("geckoAnim");
                event.player.m_6844_(EquipmentSlot.FEET).m_41784_().m_128359_("geckoAnim", "");
                YandeclothItem m_41720_4 = event.player.m_6844_(EquipmentSlot.FEET).m_41720_();
                if (m_41720_4 instanceof YandeclothItem) {
                    YandeclothItem animatable4 = m_41720_4;
                    if (event.player.m_9236_().m_5776_()) {
                        animatable4.animationprocedure = animation4;
                    }
                }
            }
        }
    }
}