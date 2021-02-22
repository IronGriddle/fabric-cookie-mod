package net.cookiemod.helpers;

import net.minecraft.client.util.math.Vector3d;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import org.lwjgl.system.CallbackI;

public abstract class VectorUtils {
    //I think my stuff here is completely broken.

    public static Vec3d blockPosToVector (BlockPos blockPos){
        return new Vec3d(blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }


    public static double pitchTowards(Vec3d origin, Vec3d target){
        origin.subtract(target);
        return  Math.toDegrees(Math.atan2(target.lengthSquared(), target.getX() * target.getX()));
    }

    public static double yawTowards(Vec3d origin, Vec3d target){
        origin.subtract(target);
        return Math.toDegrees(Math.atan2(origin.getY(), origin.getX()) );
    }


}
