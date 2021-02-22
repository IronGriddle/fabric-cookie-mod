package net.cookiemod.renderer;

import net.cookiemod.items.CookieItem;
import net.cookiemod.items.DiceItem;
import net.cookiemod.model.CookieModel;
import net.cookiemod.model.DiceModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderer.geo.GeoItemRenderer;

public class DiceRenderer extends GeoItemRenderer<DiceItem> {

    public DiceRenderer() {
            super(new DiceModel());
        }

}
