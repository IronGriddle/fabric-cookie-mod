package net.cookiemod.items;

import net.cookiemod.registry.Sounds;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;

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
        return Sounds.NONE;
    }



}
