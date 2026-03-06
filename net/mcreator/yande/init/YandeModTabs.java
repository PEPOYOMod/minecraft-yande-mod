package net.mcreator.yande.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
/* loaded from: YandeModTabs.class */
public class YandeModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.f_279569_, "yande");
    public static final RegistryObject<CreativeModeTab> YANDEGREAT = REGISTRY.register("yandegreat", () -> {
        return CreativeModeTab.builder().m_257941_(Component.m_237115_("item_group.yande.yandegreat")).m_257737_(() -> {
            return new ItemStack((ItemLike) YandeModItems.YANDEKSFLS.get());
        }).m_257501_(parameters, tabData -> {
            tabData.m_246326_((ItemLike) YandeModItems.YANDE_SPAWN_EGG.get());
            tabData.m_246326_((ItemLike) YandeModItems.TAIJISPAWNER.get());
            tabData.m_246326_((ItemLike) YandeModItems.SONGRECORD.get());
            tabData.m_246326_((ItemLike) YandeModItems.YANDECLOTH_HELMET.get());
        }).m_257652_();
    });

    @SubscribeEvent
    public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
        if (tabData.getTabKey() == CreativeModeTabs.f_256869_) {
            tabData.m_246326_((ItemLike) YandeModItems.YANDEKSFLS.get());
        }
    }
}
