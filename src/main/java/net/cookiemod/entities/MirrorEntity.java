package net.cookiemod.entities;

import net.cookiemod.helpers.VectorUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.util.math.Vector3d;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.Animation;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.CustomInstructionKeyframeEvent;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.Random;

import static net.cookiemod.setup.EntityRegistration.MIRROR_ENTITY;

public class MirrorEntity extends BlockEntity implements IAnimatable, Tickable {

    public float currentYaw = 0 ;
    public float currentPitch = 0;

    public float nextYaw = 0 ;
    public float nextPitch = 0;


    public boolean reachedTarget = false;


    public MirrorEntity() {
        super(MIRROR_ENTITY);
    }



    //Animation stuff
    //https://geckolib.com/en/latest/3.0.0/block_animations/

//    private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
//        AnimationController controller = event.getController();
//        controller.transitionLengthTicks = 0;
//        if (event.getAnimatable().getWorld().isRaining()) {
//            controller.setAnimation(new AnimationBuilder().addAnimation("fertilizer.animation.deploy", true).addAnimation("fertilizer.animation.idle", true));
//        } else {
//            controller.setAnimation(new AnimationBuilder().addAnimation("Botarium.anim.deploy", true).addAnimation("Botarium.anim.idle", true));
//        }
//        return PlayState.CONTINUE;
//    }


    private final AnimationFactory factory = new AnimationFactory(this);

    private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {

        AnimationController controller = event.getController();
        controller.transitionLengthTicks = 0;

        if (!this.reachedTarget){
            System.out.println("Changing Targets  Pitch:" + (this.nextPitch) +  "Yaw" + this.nextPitch);
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.mirror.rotate", false));
            this.reachedTarget = true;
        }

        else if (controller.getAnimationState() == AnimationState.Stopped) {
            //set pitch and yaw, now that the rotation has been made.
            this.currentPitch = nextPitch;
            this.currentYaw = nextYaw;

            System.out.println("Idling");
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.mirror.idle", true));
        }



        return PlayState.CONTINUE;
    }

    public void randomRotation(){
        this.reachedTarget = false;
        this.nextYaw = (float) (Math.random() * (360 + 1) + -180);
        this.nextPitch = (float) (Math.random() * (360 + 1) + -180);
    }

    public void setNextRotation(Vec3d position, Vec3d target){
        this.nextYaw = VectorUtils.yawTowards((position), (target));
        this.nextPitch = VectorUtils.pitchTowards((position), (target));
        reachedTarget = false;
    }


    @Override
    public void registerControllers(AnimationData data) {
        AnimationController controller = new AnimationController(this, "controller", 0, this::predicate);
        data.addAnimationController(controller);
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }






    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        tag.putFloat("yaw", currentYaw);
        tag.putFloat("pitch", currentPitch);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {

        currentYaw = tag.getFloat("yaw");
        currentPitch = tag.getFloat("pitch");
        return tag;



    }

    @Override
    public void tick() {


    }



}
