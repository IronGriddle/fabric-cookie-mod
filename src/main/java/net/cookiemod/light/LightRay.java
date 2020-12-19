package net.cookiemod.light;

import net.fabricmc.fabric.api.renderer.v1.Renderer;
import net.fabricmc.fabric.api.renderer.v1.RendererAccess;
import net.minecraft.client.render.Tessellator;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

import java.util.Vector;

import static org.lwjgl.opengl.GL11.GL_LINES;

public class LightRay {

    public static final int NORMAL_LIGHT = 0;
    public static final int RAINBOW_LIGHT = 1;
    public static final int COOKIE_LIGHT = 2;

    private void drawLine(Vec3d c1, Vec3d c2, float width) {

        int x = 10;
        int y = 10;


        GL11.glPushMatrix();
        GL11.glColor3f(0F, 1F, 0F);
        GL11.glVertex2f(x, y);
        GL11.glVertex2f(x+10F, y);
        GL11.glVertex2f(x+10F, y+10F);
        GL11.glVertex2f(x, y+10F);
        GL11.glPopMatrix();



//        Renderer renderer = RendererAccess.INSTANCE.getRenderer();
//
//
//
//
//
//        GL11.glEnable(GL11.GL_BLEND);
//        GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
//
//        // Calculate the start point of the laser
//
//        float mx1 = (float) (c1.x + .5f);
//        float my1 = (float) (c1.y + .5f);
//        float mz1 = (float) (c1.z + .5f);
//
//        Vector start = new Vector(mx1, my1, mz1);
//
//        // Calculate the end point of the laser
//        float mx2 = (float) (c2.x + .5f);
//        float my2 = (float) (c2.y + .5f);
//        float mz2 = (float) (c2.z + .5f);
//        Vector end = new Vector(mx2, my2, mz2);
//
//        // Given the two points above I would like to render a quad that
//        // always faces the camera. i guess I need to use things like
//        // this.renderManager.playerViewY
//
//
//        Vector p1 = ...;
//        Vector p2 = ...;
//        Vector p3 = ...;
//        Vector p4 = ...;
//
//        drawQuad(tessellator, p1, p2, p5, p6);
//        drawQuad(tessellator, p2, p1, p6, p5);
//        drawQuad(tessellator, p8, p7, p4, p3);
//        drawQuad(tessellator, p7, p8, p3, p4);
//
//        tessellator.draw();
    }




}
