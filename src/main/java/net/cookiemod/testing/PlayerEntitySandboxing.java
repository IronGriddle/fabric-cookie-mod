package net.cookiemod.testing;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class PlayerEntitySandboxing extends PlayerEntity {
    public PlayerEntitySandboxing(World world, BlockPos pos, float yaw, GameProfile profile) {

        super(world, pos, yaw, profile);}


}
