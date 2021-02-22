package net.cookiemod.model;


import net.cookiemod.CookieMod;
import net.cookiemod.entities.MirrorEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.resource.GeckoLibCache;

public class MirrorModel extends AnimatedGeoModel<MirrorEntity>{


    @Override
    public void setLivingAnimations(MirrorEntity entity, Integer uniqueID, AnimationEvent customPredicate) {

        float currentPitch = entity.currentPitch;
        float currentYaw = entity.currentYaw;

        float nextPitch = entity.nextPitch;
        float nextYaw = entity.nextYaw;



        GeckoLibCache.getInstance().parser.setValue("current_z_rotation", currentPitch);
        GeckoLibCache.getInstance().parser.setValue("current_y_rotation", currentYaw);
        GeckoLibCache.getInstance().parser.setValue("next_z_rotation", nextPitch);
        GeckoLibCache.getInstance().parser.setValue("next_y_rotation", nextYaw);



        super.setLivingAnimations(entity, uniqueID, customPredicate);
    }


    @Override
    public Identifier getAnimationFileLocation(MirrorEntity entity) {
        return new Identifier(CookieMod.MODID,  "animations/mirror_gears.animation.json");
    }

    @Override
    public Identifier getModelLocation(MirrorEntity entity) {
        return new Identifier(CookieMod.MODID, "geo/mirror.geo.json");
    }

    @Override
    public Identifier getTextureLocation(MirrorEntity entity) {
        return new Identifier(CookieMod.MODID, "textures/block/mirror_texture.png");
    }







}
