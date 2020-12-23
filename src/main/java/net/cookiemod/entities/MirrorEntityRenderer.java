package net.cookiemod.entities;

import net.cookiemod.blocks.Mirror;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import software.bernie.example.client.model.tile.BotariumModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderer.geo.GeoBlockRenderer;

public class MirrorEntityRenderer extends GeoBlockRenderer<MirrorEntity> {

    public MirrorEntityRenderer(BlockEntityRenderDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn, new MirrorModel());
    }

    @Override
    public void renderLate(MirrorEntity entity, MatrixStack stackIn, float ticks, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float partialTicks) {
//         this.getGeoModelProvider().getBone("current_y_rotation").setRotationZ(entity.currentPitch);
//         this.getGeoModelProvider().getBone("current_z_rotation").setRotationY(entity.currentYaw);
    }
}
