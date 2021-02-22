package net.cookiemod;

import net.cookiemod.items.DiceItem;
import net.cookiemod.model.DiceModel;
import net.cookiemod.renderer.DiceRenderer;
import net.cookiemod.renderer.MirrorEntityRenderer;
import net.cookiemod.registry.Blocks;
import net.cookiemod.registry.Entities;
import net.cookiemod.registry.Items;
import net.cookiemod.registry.Sounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import software.bernie.example.client.renderer.item.JackInTheBoxRenderer;
import software.bernie.example.registry.ItemRegistry;
import software.bernie.geckolib3.renderer.geo.GeoItemRenderer;

import static net.cookiemod.registry.Entities.MIRROR_ENTITY;
import static net.cookiemod.registry.Items.DICE;


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
        GeoItemRenderer.registerItemRenderer(DICE,  new DiceRenderer());


        System.out.println("Hello Fabric world!");
    }



}
