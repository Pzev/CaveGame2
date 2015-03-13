package main.java.rendering;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import static main.java.constants.LocationVars.*;

public class RenderUtils
{

    public static void updateView()
    {
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GLU.gluLookAt(xCord, yCord + 1.8f, zCord, xCord + xLook, yCord + 1.8f + yLook, zCord + zLook, 0, 1, 0);
    }
}