package net.cookiemod.registry;

import net.cookiemod.entities.CookieJarEntity;
import net.cookiemod.entities.MirrorEntity;
import net.cookiemod.entities.OvenEntity;
import net.cookiemod.socket.PortalEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

import static net.cookiemod.registry.Blocks.*;

public class Entities {


    public static BlockEntityType<CookieJarEntity> COOKIE_JAR_ENTITY;
    public static BlockEntityType<PortalEntity> PORTAL_ENTITY;
    public static BlockEntityType<OvenEntity> OVEN_BLOCK_ENTITY;
    public static BlockEntityType<MirrorEntity> MIRROR_ENTITY;



    public static void init() {
        COOKIE_JAR_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "jar_entity", BlockEntityType.Builder.create(CookieJarEntity::new, COOKIE_JAR_BLOCK).build(null));
        PORTAL_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "portal_entity", BlockEntityType.Builder.create(PortalEntity::new, PORTAL_BLOCK).build(null));
        MIRROR_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "mirror_entity", BlockEntityType.Builder.create(MirrorEntity::new, MIRROR_BLOCK).build(null));
        OVEN_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "oven_entity", BlockEntityType.Builder.create(OvenEntity::new, OVEN_BLOCK).build(null));
    }

}

