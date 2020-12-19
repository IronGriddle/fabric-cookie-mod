package net.cookiemod.items;

import net.cookiemod.setup.SoundRegistration;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import static net.cookiemod.setup.SoundRegistration.SNIFF;

public class QuickEats extends Item {


    //TODO:
    public QuickEats(Settings settings) {
        super(settings);
    }


    @Override
    public int getMaxUseTime(ItemStack stack) {
        if (stack.getItem().isFood()) {
            return 8;
        } else {
            return 0;
        }
    }

    @Override
    public SoundEvent getEatSound() {
        return SoundRegistration.NONE;
    }



}
