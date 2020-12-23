package net.cookiemod.entities;

import net.cookiemod.helpers.VectorUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.math.Vec3d;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.core.snapshot.BoneSnapshot;

import java.util.HashMap;

import static net.cookiemod.registry.Entities.MIRROR_ENTITY;

public class MirrorEntity extends BlockEntity implements IAnimatable {


    private final Vec3d VoxelOffsetFromBaseToCenterOfMirror = new Vec3d(-0.5, 9.5, -0.5);

    public float currentYaw = 0 ;
    public float currentPitch = 0;
    public float nextYaw = 0 ;
    public float nextPitch = 0;

    public boolean reachedTarget = true;
    private HashMap<IBone, BoneSnapshot> bones;


    public MirrorEntity() {
        super(MIRROR_ENTITY);
    }



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
            //set the bones?
            this.currentPitch = nextPitch;
            this.currentYaw = nextYaw;

            System.out.println("Idling");
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.mirror.idle", true));
        }
        return PlayState.CONTINUE;
    }


    //set yaw and pitch randomly
    public void randomRotation(){
        this.reachedTarget = false;
        this.nextYaw = (float) (Math.random() * (360 + 1) + -180);
        this.nextPitch = (float) (Math.random() * (360 + 1) + -180);
        markDirty();
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
        bones = data.getBoneSnapshotCollection();
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        tag.putFloat("yaw", this.currentYaw);
        tag.putFloat("pitch", this.currentPitch);
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        this.currentYaw = tag.getFloat("yaw");
        this.currentPitch = tag.getFloat("pitch");
        return tag;
    }


}
