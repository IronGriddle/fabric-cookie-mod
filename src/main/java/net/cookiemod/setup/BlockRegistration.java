package net.cookiemod.setup;

import net.cookiemod.blocks.*;
import net.cookiemod.items.CrumbledCookie;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.cookiemod.CookieMod.MODID;

public class BlockRegistration  {

    public static final Block BIG_COOKIE = new BigCookie(FabricBlockSettings.of(Material.CAKE).hardness(0.5f));
    public static final Block OVEN_BLOCK = new Oven(FabricBlockSettings.of(Material.METAL));
    public static final Block COOKIE_JAR_BLOCK = new CookieJar(FabricBlockSettings.of(Material.METAL));
    public static final Block MIRROR_BLOCK = new Mirror(FabricBlockSettings.of(Material.METAL));
    public static final Block COOKIE_CROP = new CookieCrop();



    public static void init() {



        Registry.register(Registry.BLOCK, new Identifier(MODID, "big_cookie" ), BIG_COOKIE);

        Registry.register(Registry.BLOCK, new Identifier(MODID, "mirror" ), MIRROR_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(MODID, "oven" ), OVEN_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(MODID, "cookie_jar" ), COOKIE_JAR_BLOCK);

        Registry.register(Registry.BLOCK, new Identifier(MODID, "cookie_crop" ), COOKIE_CROP);



    }
}
