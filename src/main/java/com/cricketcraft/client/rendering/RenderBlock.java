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
}
