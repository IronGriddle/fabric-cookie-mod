package net.cookiemod.setup;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderPhase;

import static net.cookiemod.setup.BlockRegistration.COOKIE_CROP;
import static net.cookiemod.setup.BlockRegistration.COOKIE_JAR_BLOCK;

public class ClientSetup implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(COOKIE_JAR_BLOCK, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(COOKIE_CROP, RenderLayer.getTranslucent());

    }
}
