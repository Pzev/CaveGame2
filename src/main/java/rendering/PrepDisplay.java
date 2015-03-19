package main.java.rendering;

import static main.java.constants.LocationVars.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class PrepDisplay
{
    public static int displayWidth = 800;
    public static int displayHeight = 600;

    public static void prepDisplay()
    {
        try {
            DisplayMode prepMode = Display.getDisplayMode();
            displayHeight = prepMode.getHeight() - 20;
            displayWidth = prepMode.getWidth() - 20;
            Display.setDisplayMode(new DisplayMode(displayWidth, displayHeight));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluPerspective(60, (displayWidth/displayHeight)*1.7f, .1f, 10000);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GLU.gluLookAt(xCord, yCord + 1.8f, zCord, xCord + xLook, yCord + 1.8f + yLook, zCord + zLook, 0, 1, 0);

        AllMouse.sky(100);
        RenderBlocks.PrepBlocks();

        while (!Display.isCloseRequested()) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

            RenderBlocks.AllBlocks();

            AllMouse.sky(100);

            AllMouse.move();
            AllMouse.look();



            Display.update();
        }

        Display.destroy();
    }

}
