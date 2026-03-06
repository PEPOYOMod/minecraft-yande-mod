package net.mcreator.yande.item.model;

import net.mcreator.yande.item.YandeclothItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

/* loaded from: YandeclothModel.class */
public class YandeclothModel extends GeoModel<YandeclothItem> {
    public ResourceLocation getAnimationResource(YandeclothItem object) {
        return new ResourceLocation("yande", "animations/clothes.animation.json");
    }

    public ResourceLocation getModelResource(YandeclothItem object) {
        return new ResourceLocation("yande", "geo/clothes.geo.json");
    }

    public ResourceLocation getTextureResource(YandeclothItem object) {
        return new ResourceLocation("yande", "textures/item/yande_clothes.png");
    }
}
