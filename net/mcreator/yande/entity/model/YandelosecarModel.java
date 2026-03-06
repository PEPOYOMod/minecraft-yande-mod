package net.mcreator.yande.entity.model;

import net.mcreator.yande.entity.YandelosecarEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
/* loaded from: YandelosecarModel.class */
public class YandelosecarModel extends GeoModel<YandelosecarEntity> {
    public ResourceLocation getAnimationResource(YandelosecarEntity entity) {
        return new ResourceLocation("yande", "animations/yande.animation.json");
    }

    public ResourceLocation getModelResource(YandelosecarEntity entity) {
        return new ResourceLocation("yande", "geo/yande.geo.json");
    }

    public ResourceLocation getTextureResource(YandelosecarEntity entity) {
        return new ResourceLocation("yande", "textures/entities/" + entity.getTexture() + ".png");
    }
}