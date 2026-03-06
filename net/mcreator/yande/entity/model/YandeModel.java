package net.mcreator.yande.entity.model;

import net.mcreator.yande.entity.YandeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
/* loaded from: YandeModel.class */
public class YandeModel extends GeoModel<YandeEntity> {
    public ResourceLocation getAnimationResource(YandeEntity entity) {
        return new ResourceLocation("yande", "animations/yande.animation.json");
    }

    public ResourceLocation getModelResource(YandeEntity entity) {
        return new ResourceLocation("yande", "geo/yande.geo.json");
    }

    public ResourceLocation getTextureResource(YandeEntity entity) {
        return new ResourceLocation("yande", "textures/entities/" + entity.getTexture() + ".png");
    }

    public void setCustomAnimations(YandeEntity animatable, long instanceId, AnimationState animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * 0.017453292f);
            head.setRotY(entityData.netHeadYaw() * 0.017453292f);
        }
    }
}