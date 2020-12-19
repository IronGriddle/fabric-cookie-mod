package net.cookiemod;

import net.cookiemod.entities.MirrorEntityRenderer;
import net.cookiemod.items.CrumbledCookie;
import net.cookiemod.setup.BlockRegistration;
import net.cookiemod.setup.EntityRegistration;
import net.cookiemod.setup.ItemRegistration;
import net.cookiemod.setup.SoundRegistration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import software.bernie.example.client.renderer.entity.ExampleGeoRenderer;
import software.bernie.example.client.renderer.tile.FertilizerTileRenderer;
import software.bernie.example.registry.EntityRegistry;
import software.bernie.example.registry.TileRegistry;

import static net.cookiemod.setup.EntityRegistration.MIRROR_ENTITY;


public class CookieMod implements ModInitializer {

    public static final String MODID = "cookiemod";


    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        BlockRegistration.init();
        ItemRegistration.init();
        EntityRegistration.init();
        SoundRegistration.init();

        BlockEntityRendererRegistry.INSTANCE.register(MIRROR_ENTITY, MirrorEntityRenderer::new);

        System.out.println("Hello Fabric world!");
    }



}
