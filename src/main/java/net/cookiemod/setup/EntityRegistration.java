package net.cookiemod.setup;

import net.cookiemod.CookieMod;
import net.cookiemod.entities.CookieJarEntity;
import net.cookiemod.entities.MirrorEntity;
import net.cookiemod.entities.MirrorEntityRenderer;
import net.cookiemod.entities.OvenEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import software.bernie.example.registry.TileRegistry;

import static net.cookiemod.setup.BlockRegistration.*;

public class EntityRegistration  {


    public static BlockEntityType<CookieJarEntity> COOKIE_JAR_ENTITY;
    public static BlockEntityType<OvenEntity> OVEN_BLOCK_ENTITY;
    public static BlockEntityType<MirrorEntity> MIRROR_ENTITY;



    public static void init() {
        COOKIE_JAR_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "jar_entity", BlockEntityType.Builder.create(CookieJarEntity::new, COOKIE_JAR_BLOCK).build(null));
        MIRROR_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "mirror_entity", BlockEntityType.Builder.create(MirrorEntity::new, MIRROR_BLOCK).build(null));
        OVEN_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "oven_entity", BlockEntityType.Builder.create(OvenEntity::new, OVEN_BLOCK).build(null));
    }

}

