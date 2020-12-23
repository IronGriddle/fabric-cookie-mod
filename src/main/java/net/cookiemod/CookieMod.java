package net.cookiemod;

import net.cookiemod.entities.MirrorEntityRenderer;
import net.cookiemod.registry.Blocks;
import net.cookiemod.registry.Entities;
import net.cookiemod.registry.Items;
import net.cookiemod.registry.Sounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;

import static net.cookiemod.registry.Entities.MIRROR_ENTITY;


public class CookieMod implements ModInitializer {

    public static final String MODID = "cookiemod";







    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        Blocks.init();
        Items.init();
        Entities.init();
        Sounds.init();

        BlockEntityRendererRegistry.INSTANCE.register(MIRROR_ENTITY, MirrorEntityRenderer::new);

        System.out.println("Hello Fabric world!");
    }



}
