package net.cookiemod.renderer;
import net.cookiemod.items.CookieItem;
import net.cookiemod.model.CookieModel;
import software.bernie.geckolib3.renderer.geo.GeoItemRenderer;

public class CookieRenderer extends GeoItemRenderer<CookieItem> {
    public CookieRenderer() {
        super(new CookieModel());
    }
}
