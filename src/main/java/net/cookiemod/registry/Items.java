package net.cookiemod.registry;

import net.cookiemod.items.DiceItem;
import net.cookiemod.items.QuickEats;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.lwjgl.system.CallbackI;

import static net.cookiemod.CookieMod.MODID;
import static net.cookiemod.registry.Blocks.*;
import static net.cookiemod.setup.ModSetup.COOKIE_GROUP;

public class Items {



    public static final BlockItem BIGCOOKIE_ITEM = new BlockItem(BIG_COOKIE, new FabricItemSettings()
                .maxCount(4)
                .food(new FoodComponent.Builder().hunger(10).saturationModifier(10).build())
            .group(COOKIE_GROUP)
        );

    public static final BlockItem OVEN_ITEM = new BlockItem(OVEN_BLOCK, new FabricItemSettings()
            .group(COOKIE_GROUP)
    );

    public static final BlockItem COOKIE_JAR_ITEM = new BlockItem(COOKIE_JAR_BLOCK, new FabricItemSettings()
            .group(COOKIE_GROUP)
    );


    public static final BlockItem MIRROR_ITEM = new BlockItem(MIRROR_BLOCK, new FabricItemSettings()
            .group(COOKIE_GROUP)
    );


    public static final Item CRUMBLED_COOKIE = new AliasedBlockItem(COOKIE_CROP, (new FabricItemSettings().group(COOKIE_GROUP).food(new FoodComponent.Builder().snack().hunger(1).saturationModifier(1).alwaysEdible().build())));


    //TODO: Update Model and texture
    //TODO: Allow for smaller food increments
    public static final Item DUSTED_COOKIE = new QuickEats(new FabricItemSettings().group(COOKIE_GROUP).food(new FoodComponent.Builder().snack().hunger(1).saturationModifier(0).build()));



    public static final Item DICE = new DiceItem(new FabricItemSettings().group(COOKIE_GROUP));


    public static void init() {

        Registry.register(Registry.ITEM, new Identifier(MODID, "crumbled_cookie" ), CRUMBLED_COOKIE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "dusted_cookie" ), DUSTED_COOKIE);
        Registry.register(Registry.ITEM, new Identifier(MODID, "big_cookie" ), BIGCOOKIE_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "oven" ), OVEN_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "cookie_jar" ), COOKIE_JAR_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "mirror" ), MIRROR_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MODID, "dice.item.json" ), DICE);
    }

}
