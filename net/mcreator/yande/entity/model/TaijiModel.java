package net.mcreator.yande.entity.model;

import net.mcreator.yande.entity.TaijiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
/* loaded from: TaijiModel.class */
public class TaijiModel extends GeoModel<TaijiEntity> {
    public ResourceLocation getAnimationResource(TaijiEntity entity) {
        return new ResourceLocation("yande", "animations/taiji.animation.json");
    }

    public ResourceLocation getModelResource(TaijiEntity entity) {
        return new ResourceLocation("yande", "geo/taiji.geo.json");
    }

    public ResourceLocation getTextureResource(TaijiEntity entity) {
        return new ResourceLocation("yande", "textures/entities/" + entity.getTexture() + ".png");
    }
}