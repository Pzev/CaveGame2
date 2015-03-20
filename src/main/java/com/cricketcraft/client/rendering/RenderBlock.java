package com.cricketcraft.client.rendering;

import com.cricketcraft.core.blocks.Block;
import org.lwjgl.opengl.GL11;

public class RenderBlock
{
    private Block block;

    public RenderBlock(Block block){
        this.block = block;
    }

    public void renderBase()
    {
        block.getMaterial().color();

        // X+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord + 1, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord + 1, block.zCoord);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord, block.zCoord);

        // X- Side
        GL11.glVertex3f(block.xCoord, block.yCoord, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord + 1, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord + 1, block.zCoord);
        GL11.glVertex3f(block.xCoord, block.yCoord, block.zCoord);

        // Y+ Side
        GL11.glVertex3f(block.xCoord + 1, block.yCoord + 1, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord + 1, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord + 1, block.zCoord);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord + 1, block.zCoord);

        // Y- Side
        GL11.glVertex3f(block.xCoord + 1, block.yCoord, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord, block.zCoord);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord, block.zCoord);

        // Z+ Side
        GL11.glVertex3f(block.xCoord + 1, block.yCoord + 1, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord + 1, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord, block.zCoord + 1);

        // Z- Side
        GL11.glVertex3f(block.xCoord + 1, block.yCoord + 1, block.zCoord);
        GL11.glVertex3f(block.xCoord, block.yCoord + 1, block.zCoord);
        GL11.glVertex3f(block.xCoord, block.yCoord, block.zCoord);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord, block.zCoord);
        GL11.glEnd();
    }

    public void renderXP()
    {
        block.getMaterial().color();
        // X+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord + 1, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord + 1, block.zCoord);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord, block.zCoord);
        GL11.glEnd();
    }

    public void renderXN()
    {
        block.getMaterial().color();
        // X- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(block.xCoord, block.yCoord, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord + 1, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord + 1, block.zCoord);
        GL11.glVertex3f(block.xCoord, block.yCoord, block.zCoord);
        GL11.glEnd();
    }

    public void renderYP()
    {
        block.getMaterial().color();
        // Y+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord + 1, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord + 1, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord + 1, block.zCoord);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord + 1, block.zCoord);
        GL11.glEnd();
    }

    public void renderYN()
    {
        block.getMaterial().color();
        // Y- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord, block.zCoord);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord, block.zCoord);
        GL11.glEnd();
    }

    public void renderZP()
    {
        block.getMaterial().color();
        // Z+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord + 1, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord + 1, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord, block.yCoord, block.zCoord + 1);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord, block.zCoord + 1);
        GL11.glEnd();
    }

    public void renderZN()
    {
        block.getMaterial().color();
        // Z- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord + 1, block.zCoord);
        GL11.glVertex3f(block.xCoord, block.yCoord + 1, block.zCoord);
        GL11.glVertex3f(block.xCoord, block.yCoord, block.zCoord);
        GL11.glVertex3f(block.xCoord + 1, block.yCoord, block.zCoord);
        GL11.glEnd();
    }

}
