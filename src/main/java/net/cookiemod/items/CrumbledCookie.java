package net.cookiemod.items;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CrumbledCookie extends Item {



    @Override
    public int getMaxUseTime(ItemStack stack) {
        if (stack.getItem().isFood()) {
            return this.getFoodComponent().isSnack() ? 2 : 2;
        } else {
            return 0;
        }
    }


    public CrumbledCookie(Settings settings) {
        super(settings);


    }
}
