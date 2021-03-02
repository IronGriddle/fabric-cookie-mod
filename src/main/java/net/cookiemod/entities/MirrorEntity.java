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

import static net.cookiemod.registry.Entities.MIRROR_ENTITY;

public class MirrorEntity extends BlockEntity implements IAnimatable {


    private final Vec3d VoxelOffsetFromBaseToCenterOfMirror = new Vec3d(-0.5, 9.5, -0.5);

    public float currentYaw = 0 ;
    public float currentPitch = 0;
    public float nextYaw = 0 ;
    public float nextPitch = 0;
    private boolean reachedTarget = true;

    private AnimationController controller;
    private final AnimationFactory factory = new AnimationFactory(this);

    public MirrorEntity() {
        super(MIRROR_ENTITY);
    }

    private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        controller = event.getController();
        controller.transitionLengthTicks = 0;

        if (!this.reachedTarget){
            System.out.println("Changing Targets  Pitch:" + (this.nextPitch) +  "Yaw" + this.nextPitch);
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.mirror.rotate", false));
            this.reachedTarget = true;
        }

        else if (controller.getAnimationState() == AnimationState.Stopped || controller.getCurrentAnimation() == null) {

            this.currentPitch = this.nextPitch;
            this.currentYaw = this.nextYaw;
            markDirty();
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.mirror.idle", true));
        }
        return PlayState.CONTINUE;
    }

    public void setNextRotation(Vec3d origin, Vec3d target){
        if (this.reachedTarget = true){
            this.reachedTarget = false;
            this.nextYaw = (float) VectorUtils.yawTowards(origin, target);
            this.nextPitch = (float) VectorUtils.pitchTowards(origin , target);
        }
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
        currentYaw = tag.getFloat("yaw");
        currentPitch = tag.getFloat("pitch");
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putFloat("yaw", this.currentYaw);
        tag.putFloat("pitch", this.currentPitch);
        return tag;
    }


}
