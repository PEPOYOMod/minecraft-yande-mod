package net.mcreator.yande.entity.model;

import net.mcreator.yande.entity.YandegodieEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
/* loaded from: YandegodieModel.class */
public class YandegodieModel extends GeoModel<YandegodieEntity> {
    public ResourceLocation getAnimationResource(YandegodieEntity entity) {
        return new ResourceLocation("yande", "animations/yande.animation.json");
    }

    public ResourceLocation getModelResource(YandegodieEntity entity) {
        return new ResourceLocation("yande", "geo/yande.geo.json");
    }

    public ResourceLocation getTextureResource(YandegodieEntity entity) {
        return new ResourceLocation("yande", "textures/entities/" + entity.getTexture() + ".png");
    }
}