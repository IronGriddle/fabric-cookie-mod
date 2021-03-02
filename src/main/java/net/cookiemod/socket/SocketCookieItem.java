package net.cookiemod.socket;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import static net.cookiemod.CookieMod.SERVER;


//Purpose of this item is to debug send packets from the packet buffer.
public class SocketCookieItem extends Item {

    public SocketCookieItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            return super.use(world, user, hand);
        }

        if (user.isSneaking()){
            user.sendMessage(Text.of("[SERVER] Located at:" + SERVER.getAddress().toString()), true);
        }

        SERVER.sendPacketBuffer();

        return super.use(world, user, hand);
    }
}
