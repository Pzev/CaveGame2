package com.cricketcraft.client.rendering;

import com.cricketcraft.CaveGame;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class RenderUtils
{

    public static void updateView()
    {
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GLU.gluLookAt(CaveGame.getWorld().thePlayer.getxCoord(), CaveGame.getWorld().thePlayer.getyCoord() + 1.8f, CaveGame.getWorld().thePlayer.getzCoord(), CaveGame.getWorld().thePlayer.getxCoord() + CaveGame.getWorld().thePlayer.getEyeX(), CaveGame.getWorld().thePlayer.getyCoord() + 1.8f + CaveGame.getWorld().thePlayer.getEyeY(), CaveGame.getWorld().thePlayer.getzCoord() + CaveGame.getWorld().thePlayer.getEyeZ(), 0, 1, 0);
    }
}