package net.cookiemod.renderer;

import net.cookiemod.entities.MirrorEntity;
import net.cookiemod.model.MirrorModel;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import software.bernie.geckolib3.renderer.geo.GeoBlockRenderer;

public class MirrorEntityRenderer extends GeoBlockRenderer<MirrorEntity> {

    public MirrorEntityRenderer(BlockEntityRenderDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn, new MirrorModel());
    }

}

