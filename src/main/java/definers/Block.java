package main.java.definers;

import org.lwjgl.opengl.GL11;

public class Block
{
    private static boolean renderSidesSame = true;

    public static void setColor(float r, float g, float b, float a)
    {
        GL11.glColor4f(r, g, b, a);
    }

    public static void renderSidesSame(boolean renderSides)
    {
        renderSidesSame = renderSides;
    }

    public static void renderBase(int xCord, int yCord, int zCord)
    {
        // X+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(xCord+1, yCord, zCord+1);
        GL11.glVertex3f(xCord+1, yCord+1, zCord+1);
        GL11.glVertex3f(xCord+1, yCord+1, zCord);
        GL11.glVertex3f(xCord+1, yCord, zCord);
        GL11.glEnd();

        // X- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(xCord, yCord, zCord+1);
        GL11.glVertex3f(xCord, yCord+1, zCord+1);
        GL11.glVertex3f(xCord, yCord+1, zCord);
        GL11.glVertex3f(xCord, yCord, zCord);
        GL11.glEnd();

        // Y+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(xCord+1, yCord+1, zCord+1);
        GL11.glVertex3f(xCord, yCord+1, zCord+1);
        GL11.glVertex3f(xCord, yCord+1, zCord);
        GL11.glVertex3f(xCord+1, yCord+1, zCord);
        GL11.glEnd();

        // Y- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(xCord+1, yCord, zCord+1);
        GL11.glVertex3f(xCord, yCord, zCord+1);
        GL11.glVertex3f(xCord, yCord, zCord);
        GL11.glVertex3f(xCord+1, yCord, zCord);
        GL11.glEnd();

        // Z+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(xCord+1, yCord+1, zCord+1);
        GL11.glVertex3f(xCord, yCord+1, zCord+1);
        GL11.glVertex3f(xCord, yCord, zCord+1);
        GL11.glVertex3f(xCord+1, yCord, zCord+1);
        GL11.glEnd();

        // Z- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(xCord+1, yCord+1, zCord);
        GL11.glVertex3f(xCord, yCord+1, zCord);
        GL11.glVertex3f(xCord, yCord, zCord);
        GL11.glVertex3f(xCord+1, yCord, zCord);
        GL11.glEnd();

    }
}
