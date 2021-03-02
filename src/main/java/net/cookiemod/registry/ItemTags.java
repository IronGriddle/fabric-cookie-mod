package net.cookiemod.registry;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.util.Identifier;

import static net.fabricmc.fabric.impl.networking.NetworkingImpl.MOD_ID;

public class ItemTags {

    public static final Identifier COOKIE_TAG = new Identifier(MOD_ID, "items/cookies");

    public static void init(){
        TagRegistry.item(COOKIE_TAG);
    }

}
