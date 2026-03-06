package net.mcreator.yande.item;

import net.mcreator.yande.client.renderer.YandeclothArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

/* loaded from: YandeclothItem$2.class */
class YandeclothItem$2 implements IClientItemExtensions {
    private GeoArmorRenderer<?> renderer;
    final /* synthetic */ YandeclothItem this$0;

    YandeclothItem$2(YandeclothItem this$0) {
        this.this$0 = this$0;
    }

    public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
        if (this.renderer == null) {
            this.renderer = new YandeclothArmorRenderer();
        }
        this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
        return this.renderer;
    }
}