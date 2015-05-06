package com.cricketcraft.cavegame.client.rendering;
import com.cricketcraft.cavegame.CaveGame;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class Views
{
    public static void make2D()
    {
        glPopAttrib();
        glPushAttrib(GL_ENABLE_BIT);

        glViewport(0, 0, PrepDisplay.displayWidth, PrepDisplay.displayHeight);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, PrepDisplay.displayWidth, PrepDisplay.displayHeight, 0, -1, 1);

        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
    }

    public static void make3D()
    {
        glPopAttrib();
        glPushAttrib(GL_ENABLE_BIT);

        glViewport(0, 0, PrepDisplay.displayWidth, PrepDisplay.displayHeight);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluPerspective(70, (float) (PrepDisplay.displayWidth / PrepDisplay.displayHeight) * 1.7f, .1f, 10000);

        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        GLU.gluLookAt(CaveGame.getWorld().thePlayer.getxCoord(), CaveGame.getWorld().thePlayer.getyCoord() + 1.8f, CaveGame.getWorld().thePlayer.getzCoord(), CaveGame.getWorld().thePlayer.getxCoord() + CaveGame.getWorld().thePlayer.getEyeX(), CaveGame.getWorld().thePlayer.getyCoord() + 1.8f + CaveGame.getWorld().thePlayer.getEyeY(), CaveGame.getWorld().thePlayer.getzCoord() + CaveGame.getWorld().thePlayer.getEyeZ(), 0, 1, 0);
    }
}
