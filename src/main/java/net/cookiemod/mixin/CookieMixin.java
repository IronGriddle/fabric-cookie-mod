package net.cookiemod.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stat;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.cookiemod.registry.Items.DUSTED_COOKIE;
import static net.cookiemod.registry.Sounds.SNIFF;

//Important link:
//https://fabricmc.net/wiki/tutorial:mixin_examples

@Mixin(PlayerEntity.class)
public abstract class CookieMixin extends LivingEntity {


	protected CookieMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Shadow public abstract HungerManager getHungerManager();

	@Shadow public abstract void incrementStat(Stat<?> stat);


	@Shadow public abstract ItemStack eatFood(World world, ItemStack stack);

	@Inject(method = "eatFood", at = @At("HEAD"), cancellable = true)
	private void eat(World world, ItemStack stack, CallbackInfoReturnable<ItemStack> info) {


		//TODO: Change this to a tag
		if(stack.getItem() == DUSTED_COOKIE ) {

			getHungerManager().eat(stack.getItem(), stack);
			world.playSound((PlayerEntity)null, this.getX(), this.getY(), this.getZ(), SNIFF, SoundCategory.PLAYERS, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);

			this.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));

			info.setReturnValue(super.eatFood(world, stack));

		}



	}


}


