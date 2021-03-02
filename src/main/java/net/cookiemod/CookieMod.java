package net.cookiemod;

import net.cookiemod.registry.*;
import net.cookiemod.renderer.DiceRenderer;
import net.cookiemod.renderer.MirrorEntityRenderer;
import net.cookiemod.renderer.PortalEntityRenderer;
import net.cookiemod.socket.PacketBuffer;
import net.cookiemod.socket.Server;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import software.bernie.geckolib3.renderer.geo.GeoItemRenderer;

import java.net.InetSocketAddress;

import static net.cookiemod.registry.Entities.MIRROR_ENTITY;
import static net.cookiemod.registry.Entities.PORTAL_ENTITY;
import static net.cookiemod.registry.Items.DICE;


public class CookieMod implements ModInitializer {

    public static final String MODID = "cookiemod";

    static String host = "localhost";
    static int port = 8080;
    public static Server SERVER;
    public static PacketBuffer PACKET_BUFFER;


    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        //Initializing and starting server.
        SERVER = new Server(new InetSocketAddress(host, port));
        SERVER.start();
        //Initializing Packet Buffer.
        PACKET_BUFFER = new PacketBuffer();

        //Basic registration
        ItemTags.init();
        Blocks.init();
        Items.init();
        Entities.init();
        Sounds.init();

        //GeckoLib Registration
        BlockEntityRendererRegistry.INSTANCE.register(MIRROR_ENTITY, MirrorEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(PORTAL_ENTITY, PortalEntityRenderer::new);
        GeoItemRenderer.registerItemRenderer(DICE,  new DiceRenderer());
    }



}
