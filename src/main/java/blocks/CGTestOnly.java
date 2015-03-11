package main.java.blocks;

import main.java.CaveGame;
import org.lwjgl.opengl.GL11;

public class CGTestOnly
{

    public static void RenderTest(int xCord, int yCord, int zCord)
    {
        GL11.glColor4f(.9f, .7f, .9f, 1.0f);

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
