package net.mcreator.yande.entity.model;

import net.mcreator.yande.entity.ShindeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
/* loaded from: ShindeModel.class */
public class ShindeModel extends GeoModel<ShindeEntity> {
    public ResourceLocation getAnimationResource(ShindeEntity entity) {
        return new ResourceLocation("yande", "animations/shinde.animation.json");
    }

    public ResourceLocation getModelResource(ShindeEntity entity) {
        return new ResourceLocation("yande", "geo/shinde.geo.json");
    }

    public ResourceLocation getTextureResource(ShindeEntity entity) {
        return new ResourceLocation("yande", "textures/entities/" + entity.getTexture() + ".png");
    }
}
