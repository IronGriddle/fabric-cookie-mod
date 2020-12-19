package net.cookiemod.entities;


import net.cookiemod.CookieMod;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MirrorModel extends AnimatedGeoModel{


    @Override
    public Identifier getAnimationFileLocation(Object entity) {
        return new Identifier(CookieMod.MODID,  "animations/mirror_gears.animation.json");
    }

    @Override
    public Identifier getModelLocation(Object entity) {
        return new Identifier(CookieMod.MODID, "geo/mirror.geo.json");
    }

    @Override
    public Identifier getTextureLocation(Object entity) {
        return new Identifier(CookieMod.MODID, "textures/block/mirror_texture.png");
    }




}
