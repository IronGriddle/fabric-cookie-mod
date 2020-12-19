package net.cookiemod.setup;


import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SoundRegistration {


    //Kinda weird that you have to make ID?
    public static final Identifier SNIFF_ID = new Identifier("cookiemod:sniff");
    public static final Identifier NONE_ID = new Identifier("cookiemod:this_file_does_not_exist");

    public static SoundEvent SNIFF = new SoundEvent(SNIFF_ID);


    public static SoundEvent NONE = new SoundEvent(NONE_ID);



    public static void init(){

        Registry.register(Registry.SOUND_EVENT, SNIFF_ID, SNIFF);
        Registry.register(Registry.SOUND_EVENT, NONE_ID, NONE);

    }




}
