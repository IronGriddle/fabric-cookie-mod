package net.cookiemod.entities;

import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import software.bernie.example.client.model.tile.BotariumModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderer.geo.GeoBlockRenderer;

public class MirrorEntityRenderer extends GeoBlockRenderer<MirrorEntity> {

    public MirrorEntityRenderer(BlockEntityRenderDispatcher rendererDispatcherIn) {


        super(rendererDispatcherIn, new MirrorModel());
    }


}
