package net.mcreator.yande.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.yande.entity.YandeEntity;
import net.mcreator.yande.entity.model.YandeModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
/* loaded from: YandeRenderer.class */
public class YandeRenderer extends GeoEntityRenderer<YandeEntity> {
    public YandeRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new YandeModel());
        this.f_114477_ = 0.5f;
    }

    public RenderType getRenderType(YandeEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.m_110473_(m_5478_(animatable));
    }

    public void preRender(PoseStack poseStack, YandeEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.scaleHeight = 0.8f;
        this.scaleWidth = 0.8f;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getDeathMaxRotation(YandeEntity entityLivingBaseIn) {
        return 0.0f;
    }
}