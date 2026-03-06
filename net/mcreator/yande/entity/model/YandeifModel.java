package net.mcreator.yande.entity.model;

import net.mcreator.yande.entity.YandeifEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
/* loaded from: YandeifModel.class */
public class YandeifModel extends GeoModel<YandeifEntity> {
    public ResourceLocation getAnimationResource(YandeifEntity entity) {
        return new ResourceLocation("yande", "animations/yande_if.animation.json");
    }

    public ResourceLocation getModelResource(YandeifEntity entity) {
        return new ResourceLocation("yande", "geo/yande_if.geo.json");
    }

    public ResourceLocation getTextureResource(YandeifEntity entity) {
        return new ResourceLocation("yande", "textures/entities/" + entity.getTexture() + ".png");
    }
}