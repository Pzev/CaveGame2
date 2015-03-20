package com.cricketcraft.client.rendering;

import com.cricketcraft.core.blocks.Block;
import org.lwjgl.opengl.GL11;

public class RenderBlock
{
    private Block block;

    public RenderBlock(Block block){
        this.block = block;
    }

    public void renderBase(int x, int y, int z)
    {
        block.getMaterial().color();

        // X+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(x + 1, y, z + 1);
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glVertex3f(x + 1, y + 1, z);
        GL11.glVertex3f(x + 1, y, z);

        // X- Side
        GL11.glVertex3f(x, y, z + 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glVertex3f(x, y, z);

        // Y+ Side
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glVertex3f(x + 1, y + 1, z);

        // Y- Side
        GL11.glVertex3f(x + 1, y, z + 1);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glVertex3f(x, y, z);
        GL11.glVertex3f(x + 1, y, z);

        // Z+ Side
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glVertex3f(x + 1, y, z + 1);

        // Z- Side
        GL11.glVertex3f(x + 1, y + 1, z);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glVertex3f(x, y, z);
        GL11.glVertex3f(x + 1, y, z);
        GL11.glEnd();
    }

    public void renderXP(int x, int y, int z)
    {
        block.getMaterial().color();
        // X+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(x + 1, y, z + 1);
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glVertex3f(x + 1, y + 1, z);
        GL11.glVertex3f(x + 1, y, z);
        GL11.glEnd();
    }

    public void renderXN(int x, int y, int z)
    {
        block.getMaterial().color();
        // X- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glVertex3f(x, y, z);
        GL11.glEnd();
    }

    public void renderYP(int x, int y, int z)
    {
        block.getMaterial().color();
        // Y+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glVertex3f(x + 1, y + 1, z);
        GL11.glEnd();
    }

    public void renderYN(int x, int y, int z)
    {
        block.getMaterial().color();
        // Y- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(x + 1, y, z + 1);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glVertex3f(x, y, z);
        GL11.glVertex3f(x + 1, y, z);
        GL11.glEnd();
    }

    public void renderZP(int x, int y, int z)
    {
        block.getMaterial().color();
        // Z+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glVertex3f(x + 1, y, z + 1);
        GL11.glEnd();
    }

    public void renderZN(int x, int y, int z)
    {
        block.getMaterial().color();
        // Z- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(x + 1, y + 1, z);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glVertex3f(x, y, z);
        GL11.glVertex3f(x + 1, y, z);
        GL11.glEnd();
    }

}
