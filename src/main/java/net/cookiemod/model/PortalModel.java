package net.cookiemod.model;

import net.cookiemod.CookieMod;
import net.cookiemod.socket.PortalEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.resource.GeckoLibCache;

public class PortalModel extends AnimatedGeoModel<PortalEntity> {

    @Override
    public void setLivingAnimations(PortalEntity portalEntity, Integer uniqueID, AnimationEvent customPredicate) {

        GeckoLibCache.getInstance().parser.setValue("speed", portalEntity.speed);
        GeckoLibCache.getInstance().parser.setValue("scale", portalEntity.scale);

        super.setLivingAnimations(portalEntity, uniqueID, customPredicate);
    }

    @Override
    public Identifier getModelLocation(PortalEntity portalEntity) {
        return new Identifier(CookieMod.MODID, "geo/portal.geo.json");
    }

    @Override
    public Identifier getTextureLocation(PortalEntity portalEntity) {
        return new Identifier(CookieMod.MODID, "textures/block/portal.png");

    }

    @Override
    public Identifier getAnimationFileLocation(PortalEntity entity) {
        return new Identifier(CookieMod.MODID,  "animations/portal.animation.json");
    }
}
