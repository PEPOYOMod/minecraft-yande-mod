package net.mcreator.yande.client.renderer;

import net.mcreator.yande.item.YandeclothItem;
import net.mcreator.yande.item.model.YandeclothModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
/* loaded from: YandeclothArmorRenderer.class */
public class YandeclothArmorRenderer extends GeoArmorRenderer<YandeclothItem> {
    public YandeclothArmorRenderer() {
        super(new YandeclothModel());
        this.head = new GeoBone((GeoBone) null, "armorHead", false, Double.valueOf(0.0d), false, false);
        this.body = new GeoBone((GeoBone) null, "armorBody", false, Double.valueOf(0.0d), false, false);
        this.rightArm = new GeoBone((GeoBone) null, "armorRightArm", false, Double.valueOf(0.0d), false, false);
        this.leftArm = new GeoBone((GeoBone) null, "armorLeftArm", false, Double.valueOf(0.0d), false, false);
        this.rightLeg = new GeoBone((GeoBone) null, "armorRightLeg", false, Double.valueOf(0.0d), false, false);
        this.leftLeg = new GeoBone((GeoBone) null, "armorLeftLeg", false, Double.valueOf(0.0d), false, false);
        this.rightBoot = new GeoBone((GeoBone) null, "armorRightBoot", false, Double.valueOf(0.0d), false, false);
        this.leftBoot = new GeoBone((GeoBone) null, "armorLeftBoot", false, Double.valueOf(0.0d), false, false);
    }

    public RenderType getRenderType(YandeclothItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.m_110473_(getTextureLocation(animatable));
    }
}