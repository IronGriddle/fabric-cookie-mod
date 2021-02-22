package net.cookiemod.model;

import net.cookiemod.items.CookieItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import java.util.List;

public class CookieModel extends AnimatedGeoModel<CookieItem> {


    public CookieModel() {
    }


    public Identifier getModelLocation(CookieItem object) {
        return new Identifier("geckolib3", "geo/lucky_cookie.geo.json");
    }

    public Identifier getTextureLocation(CookieItem object) {
        return new Identifier("geckolib3", "textures/item/lucky_cookie.png");
    }

    public Identifier getAnimationFileLocation(CookieItem animatable) {
        return new Identifier("geckolib3", "animations/luck_cookie.animation.json");
    }
}
