package net.cookiemod.model;


import net.cookiemod.items.DiceItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import static net.cookiemod.CookieMod.MODID;

public class DiceModel extends AnimatedGeoModel<DiceItem>{


    @Override
    public Identifier getModelLocation(DiceItem diceItem) {
        return new Identifier(MODID, "geo/dice.geo.json");
    }

    @Override
    public Identifier getTextureLocation(DiceItem diceItem) {
        return new Identifier(MODID, "textures/item/dice.png");
    }

    @Override
    public Identifier getAnimationFileLocation(DiceItem diceItem) {
        return new Identifier(MODID, "animations/dice.animation.json");
    }
}
