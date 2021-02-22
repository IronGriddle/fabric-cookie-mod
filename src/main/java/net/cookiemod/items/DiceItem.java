package net.cookiemod.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.concurrent.ThreadLocalRandom;

public class DiceItem extends Item implements IAnimatable {


    //Logic Stuff
    private static final Vec3d ONE = new Vec3d(90, 1, 0);
    private static final Vec3d TWO = new Vec3d(1, 0, 90);
    private static final Vec3d THREE = new Vec3d(0, 1, 180);
    private static final Vec3d FOUR = new Vec3d(0, 1, 0);
    private static final Vec3d FIVE = new Vec3d(1, 0, -90);
    private static final Vec3d SIX = new Vec3d(-90, 1 , 0);
    private final Vec3d[] DiceFaces = {ONE, TWO, THREE, FOUR, FIVE, SIX};
    private int chosenFace = 1;
    private Vec3d chosenRotation = null;
    private int finalYawRotation = 0;

    private boolean rolling = false;

    public DiceItem(Settings settings) {
        super(settings);
    }



    //Animation Stuff
    private static final String ROLL = "animation.dice.roll";
    public AnimationFactory factory = new AnimationFactory(this);

    private static final String controllerName = "controller";



    public void setChosenSolution(){
        chosenFace = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        chosenRotation = DiceFaces[chosenFace];
    }

    public void setFinalYawRotation(){
        finalYawRotation = ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            return super.use(world, user, hand);
        }

        RollDice();
        ItemStack stack = user.getStackInHand(hand);
        AnimationController controller = GeckoLibUtil.getControllerForStack(this.factory, stack, controllerName);




        return super.use(world, user, hand);
    }

    public void RollDice(){
        setChosenSolution();
        setFinalYawRotation();
        rolling = true;
    }

    private <P extends Item & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        //event.getController().setAnimation(new AnimationBuilder().addAnimation(IDLE, true));

        if (rolling){
            event.getController().setAnimation(new AnimationBuilder().addAnimation(ROLL, false));;
            rolling = false;
        }

        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData data) {
        AnimationController controller = new AnimationController(this, controllerName, 20, this::predicate);
        data.addAnimationController(controller);

    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }



}
