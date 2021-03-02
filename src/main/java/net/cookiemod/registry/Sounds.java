package net.cookiemod.registry;


import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Sounds {

    public static final Identifier SNIFF_ID = new Identifier("cookiemod:sniff");
    public static final Identifier GENERAL_FADE_ID = new Identifier("cookiemod:general_fade");
    public static final Identifier VILLAGER_FADE_ID = new Identifier("cookiemod:villager_fade");
    public static final Identifier NONE_ID = new Identifier("cookiemod:this_file_does_not_exist");

    public static SoundEvent SNIFF = new SoundEvent(SNIFF_ID);
    public static SoundEvent NONE = new SoundEvent(NONE_ID);
    public static SoundEvent VILLAGER_FADE = new SoundEvent(VILLAGER_FADE_ID);
    public static SoundEvent GENERAL_FADE = new SoundEvent(GENERAL_FADE_ID);

    public static void init(){
        Registry.register(Registry.SOUND_EVENT, SNIFF_ID, SNIFF);
        Registry.register(Registry.SOUND_EVENT, NONE_ID, NONE);
        Registry.register(Registry.SOUND_EVENT, GENERAL_FADE_ID, GENERAL_FADE);
        Registry.register(Registry.SOUND_EVENT, VILLAGER_FADE_ID, VILLAGER_FADE);
    }

}
