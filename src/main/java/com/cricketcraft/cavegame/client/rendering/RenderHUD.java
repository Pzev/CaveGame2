package com.cricketcraft.cavegame.client.rendering;

import com.cricketcraft.cavegame.core.util.TextureLoader;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

public class RenderHUD
{
    public static void renderHUD()
    {
        basicOverlay();
    }

    private static void basicOverlay()
    {
        TextureLoader textureLoader = new TextureLoader();
        try {
            textureLoader.getTexture("assets/textures/hud/hud1.png").bind();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int width = PrepDisplay.displayWidth/2;
        int height = PrepDisplay.displayHeight/2;

        /*
        GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f(width-22, height-22);
            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2f(width-22, height+22);
            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2f(width+22, height+22);
            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2f(width+22, height-22);
        GL11.glEnd();
        **/

        GL11.glColor4f(0, 0, 0, 1);

        GL11.glBegin(GL11.GL_QUADS);
            GL11.glVertex2f(width-5, height-5);
            GL11.glVertex2f(width-5, height+5);
            GL11.glVertex2f(width+5, height+5);
            GL11.glVertex2f(width+5, height-5);
        GL11.glEnd();

    }
}
