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
        GL11.glEnable(GL11.GL_TEXTURE_2D);

        TextureLoader textureLoader = new TextureLoader();
        try {
            textureLoader.getTexture("assets/textures/hud/hud1.png").bind();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int width = PrepDisplay.displayWidth/2 + 20;
        int height = PrepDisplay.displayHeight/2;

        GL11.glColor4f(1f, 1f, 1f, 1.0F);

        GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f(width-50, height-50);
            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2f(width-50, height+50);
            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2f(width+50, height+50);
            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2f(width+50, height-50);
        GL11.glEnd();

        try {
            textureLoader.getTexture("assets/textures/hud/hud2.png").bind();
        } catch (IOException e) {
            e.printStackTrace();
        }

        width = (PrepDisplay.displayWidth/2) + 90;
        height = (PrepDisplay.displayHeight/2) + 350;

        GL11.glColor4f(1f, 1f, 1f, 1.0F);

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex2f(width-400, height-50);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex2f(width-400, height+50);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex2f(width+400, height+50);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex2f(width+400, height-50);
        GL11.glEnd();

        GL11.glDisable(GL11.GL_TEXTURE_2D);

    }
}
