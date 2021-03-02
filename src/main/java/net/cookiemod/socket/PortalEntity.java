package net.cookiemod.socket;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.shape.VoxelShape;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.Animation;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import static net.cookiemod.registry.Entities.PORTAL_ENTITY;

public class PortalEntity extends BlockEntity implements IAnimatable {
    public PortalEntity() {
        super(PORTAL_ENTITY);
    }

    public float scale = 1;
    public float speed = 3;

    private final AnimationFactory factory = new AnimationFactory(this);



    public VoxelShape getCollisionShape(){
        return Block.createCuboidShape(0.0D - scale *2, 0.0D - scale * 2, 0.0D - scale * 2, 16.0D + scale * 2, 16.0D + scale * 2, 16.0D + scale * 2);
    }


    public static class PortalAnimations{
        public static final String ON_PLACE = "animation.portal.on_place";
        public static final String TELEPORT = "animation.portal.teleport";
        public static final String IDLE = "animation.portal.idle";

    }

    public String queuedAnimation = PortalAnimations.IDLE;

    //Play teleport animation when onTeleport is called.
    public void onTeleport(){
        queuedAnimation = PortalAnimations.TELEPORT;
    }

    //Play placement animation when onTeleport is called.
    public void onPlace(){
        queuedAnimation = PortalAnimations.ON_PLACE;
    }

    public void growPortal(){
        if (this.scale < 10){
            this.scale += 0.1f;
            markDirty();
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

    private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        AnimationController controller = event.getController();
        Animation currentAnimation = controller.getCurrentAnimation();

//        if (currentAnimation != null) {
//            //Avoid interrupt by idle loop if an animation is running
//            if (!currentAnimation.animationName.equals(PortalAnimations.IDLE) && controller.getAnimationState().equals(AnimationState.Running)) {
//                return PlayState.CONTINUE;
//            }
//        }

        //Set current animation depending on animation to be played.

        switch (queuedAnimation){
            case PortalAnimations.IDLE:
                break;
            case PortalAnimations.ON_PLACE:
                controller.setAnimation(new AnimationBuilder().addAnimation(queuedAnimation, false));
                break;
            case PortalAnimations.TELEPORT:
                controller.setAnimation(new AnimationBuilder().addAnimation(queuedAnimation, false));
                break;
        }

        return PlayState.CONTINUE;
    }


    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        this.scale = tag.getFloat("scale");
        this.speed = tag.getFloat("speed");
    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        tag.putFloat("scale", this.scale);
        tag.putFloat("speed", this.speed);
        return super.toTag(tag);
    }


}
