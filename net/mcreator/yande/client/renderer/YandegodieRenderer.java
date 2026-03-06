package net.mcreator.yande.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.yande.entity.YandegodieEntity;
import net.mcreator.yande.entity.model.YandegodieModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
/* loaded from: YandegodieRenderer.class */
public class YandegodieRenderer extends GeoEntityRenderer<YandegodieEntity> {
    public YandegodieRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new YandegodieModel());
        this.f_114477_ = 0.5f;
    }

    public RenderType getRenderType(YandegodieEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.m_110473_(m_5478_(animatable));
    }

    public void preRender(PoseStack poseStack, YandegodieEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.scaleHeight = 0.8f;
        this.scaleWidth = 0.8f;
        super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getDeathMaxRotation(YandegodieEntity entityLivingBaseIn) {
        return 0.0f;
    }
}