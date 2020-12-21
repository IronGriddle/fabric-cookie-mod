package net.cookiemod.helpers;

import net.minecraft.client.util.math.Vector3d;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.lwjgl.system.CallbackI;

public abstract class VectorUtils {

    public static Vec3d blockPosToVector (BlockPos blockPos){
        return new Vec3d(blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }


    public static float pitchTowards(Vec3d origin, Vec3d target){
        origin.subtract(target);
        return (float) Math.toDegrees(Math.atan2(target.lengthSquared(), target.getX() * target.getX()));
    }

    public static float yawTowards(Vec3d target, Vec3d origin){
        origin.subtract(target);
        return (float) Math.toDegrees(Math.atan2(origin.getY(), origin.getX()) );
    }


}
