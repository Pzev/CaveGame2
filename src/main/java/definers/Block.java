package main.java.definers;

import org.lwjgl.opengl.GL11;

public class Block
{
    private static boolean renderSidesSame = true;
    private static int blockX, blockY, blockZ;

    public static void setColor(float r, float g, float b, float a)
    {
        GL11.glColor4f(r, g, b, a);
    }

    public static void renderSidesSame(boolean renderSides)
    {
        renderSidesSame = renderSides;
    }

    public static void blockSetAt(int x, int y, int z)
    {
        blockX = x;
        blockY = y;
        blockZ = z;
    }

    public static int blockX()
    {
        return blockX;
    }

    public static int blockY()
    {
        return blockY;
    }

    public static int blockZ()
    {
        return blockZ;
    }

    public static void renderBase()
    {
        // X+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(blockX+1, blockY, blockZ+1);
        GL11.glVertex3f(blockX+1, blockY+1, blockZ+1);
        GL11.glVertex3f(blockX+1, blockY+1, blockZ);
        GL11.glVertex3f(blockX+1, blockY, blockZ);

        // X- Side
        GL11.glVertex3f(blockX, blockY, blockZ+1);
        GL11.glVertex3f(blockX, blockY+1, blockZ+1);
        GL11.glVertex3f(blockX, blockY+1, blockZ);
        GL11.glVertex3f(blockX, blockY, blockZ);

        // Y+ Side
        GL11.glVertex3f(blockX+1, blockY+1, blockZ+1);
        GL11.glVertex3f(blockX, blockY+1, blockZ+1);
        GL11.glVertex3f(blockX, blockY+1, blockZ);
        GL11.glVertex3f(blockX+1, blockY+1, blockZ);

        // Y- Side
        GL11.glVertex3f(blockX+1, blockY, blockZ+1);
        GL11.glVertex3f(blockX, blockY, blockZ+1);
        GL11.glVertex3f(blockX, blockY, blockZ);
        GL11.glVertex3f(blockX+1, blockY, blockZ);

        // Z+ Side
        GL11.glVertex3f(blockX+1, blockY+1, blockZ+1);
        GL11.glVertex3f(blockX, blockY+1, blockZ+1);
        GL11.glVertex3f(blockX, blockY, blockZ+1);
        GL11.glVertex3f(blockX+1, blockY, blockZ+1);

        // Z- Side
        GL11.glVertex3f(blockX+1, blockY+1, blockZ);
        GL11.glVertex3f(blockX, blockY+1, blockZ);
        GL11.glVertex3f(blockX, blockY, blockZ);
        GL11.glVertex3f(blockX+1, blockY, blockZ);
        GL11.glEnd();

    }
}
