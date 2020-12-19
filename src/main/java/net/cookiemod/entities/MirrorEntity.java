package net.cookiemod.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.util.math.Vector3d;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Vec3d;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import static net.cookiemod.setup.EntityRegistration.MIRROR_ENTITY;

public class MirrorEntity extends BlockEntity implements IAnimatable {

    private int yaw = 0;
    private int pitch = 0;



    private boolean rotating;


    public MirrorEntity() {
        super(MIRROR_ENTITY);
    }



    //Animation stuff
    //https://geckolib.com/en/latest/3.0.0/block_animations/

    private final AnimationFactory factory = new AnimationFactory(this);

    private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
//        event.getController().transitionLengthTicks = 0;
//        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.mirror.idle", true));
        return PlayState.CONTINUE;
    }



    //changes the yaw and pitch, so that they face the second position, relative to the first
    public void RotateTowards(Vec3d pos1, Vec3d pos2){

        yaw = (int) Math.toDegrees(Math.atan2(pos2.z - pos1.z, pos2.x - pos1.x));
        pitch = (int) Math.toDegrees(Math.atan2(pos2.y - pos1.y, pos1.distanceTo(pos2)));



    }







    @Override
    public void registerControllers(AnimationData data) {
        AnimationController controller = new AnimationController(this, "controller", 0, this::predicate);
        //controller.registerCustomInstructionListener(this :: );
        data.addAnimationController(controller);


    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }






    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);


        tag.putInt("yaw", yaw);
        tag.putInt("pitch", pitch);

    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {

        yaw = tag.getInt("yaw");
        pitch = tag.getInt("pitch");
        return tag;



    }

}
