package net.cookiemod.setup;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

import static net.cookiemod.CookieMod.MODID;
import static net.cookiemod.setup.ItemRegistration.CRUMBLED_COOKIE;

public class ModSetup {



    public static final Tag<Item> SUPER_SNACK = TagRegistry.item(new Identifier("cookiemod", "super_snack"));


    public static final ItemGroup COOKIE_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MODID, "general"),
            () -> new ItemStack(Items.COOKIE));

}
