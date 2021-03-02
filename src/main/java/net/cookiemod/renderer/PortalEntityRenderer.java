package net.cookiemod.renderer;

import net.cookiemod.model.PortalModel;
import net.cookiemod.socket.PortalEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import software.bernie.geckolib3.renderer.geo.GeoBlockRenderer;

public class PortalEntityRenderer extends GeoBlockRenderer<PortalEntity> {

    public PortalEntityRenderer(BlockEntityRenderDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn, new PortalModel());
    }

}

