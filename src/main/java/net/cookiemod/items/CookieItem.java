package net.cookiemod.items;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import software.bernie.example.GeckoLibMod;
import software.bernie.example.registry.SoundRegistry;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.SoundKeyframeEvent;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.resource.GeckoLibCache;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class CookieItem extends Item implements IAnimatable {

    //TODO: Finish this.

    public AnimationFactory factory = new AnimationFactory(this);
    private String controllerName = "controller";

    public final static String IDLE  = "animation.model.idle";
    public final static String GENERATE  = "animation.model.generate";
    public final static String DESTROY  = "animation.model.destroy_cookie";


    public CookieItem(Settings properties) {
        super(properties);
    }

    private <P extends Item & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation(IDLE, true));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        AnimationController controller = new AnimationController(this, controllerName, 20, this::predicate);
        data.addAnimationController(controller);
    }


    //Might possibly use.
    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            return super.use(world, user, hand);
        }

        //get the user stack and controller.
        ItemStack stack = user.getStackInHand(hand);
        AnimationController controller = GeckoLibUtil.getControllerForStack(this.factory, stack, controllerName);

        if (controller.getAnimationState() == AnimationState.Stopped || controller.getCurrentAnimation().animationName == IDLE) {
            user.sendMessage(new LiteralText("!-Stabilizing Cookie-!"), true);
            controller.markNeedsReload();
            controller.setAnimation(new AnimationBuilder().addAnimation(DESTROY, false));
        }
        return super.use(world, user, hand);
    }
}
