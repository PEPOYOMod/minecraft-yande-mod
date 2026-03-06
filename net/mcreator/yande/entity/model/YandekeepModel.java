package net.mcreator.yande.entity.model;

import net.mcreator.yande.entity.YandekeepEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
/* loaded from: YandekeepModel.class */
public class YandekeepModel extends GeoModel<YandekeepEntity> {
    public ResourceLocation getAnimationResource(YandekeepEntity entity) {
        return new ResourceLocation("yande", "animations/yande.animation.json");
    }

    public ResourceLocation getModelResource(YandekeepEntity entity) {
        return new ResourceLocation("yande", "geo/yande.geo.json");
    }

    public ResourceLocation getTextureResource(YandekeepEntity entity) {
        return new ResourceLocation("yande", "textures/entities/" + entity.getTexture() + ".png");
    }
}