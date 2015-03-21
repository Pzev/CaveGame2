package com.cricketcraft.client.rendering;

import com.cricketcraft.core.blocks.Block;
import com.cricketcraft.core.blocks.Material;
import org.lwjgl.opengl.GL11;
import static com.cricketcraft.core.utils.constants.BlockInformation.*;

public class RenderBlock
{
    private Block block;

    public RenderBlock(Block block){
        this.block = block;
    }

    public void renderBase(int x, int y, int z, int cx, int cz)
    {
        block.getMaterial().color();

        x = x + (cx * 16);
        z = z + (cz * 16);

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

    public void laglessRender(int x, int y, int z, int cx, int cz)
    {
        int blockX = x + (cx * 16);
        int blockZ = z + (cz * 16);

        // X+ Side
        if(x < 15 && ChunkInfo[cx][cz].BlockInfo[x + 1][y][z].getMaterial() == Material.AIR)
            renderXP(blockX, y, blockZ);
        else if(x == 15)
            if (cx == TOTAL_CHUNKS)
                renderXP(blockX, y, blockZ);
            else if (ChunkInfo[cx + 1][cz].BlockInfo[x - 15][y][z].getMaterial() == Material.AIR)
                renderXP(blockX, y, blockZ);

        // X- Side
        if(x > 0 && ChunkInfo[cx][cz].BlockInfo[x - 1][y][z].getMaterial() == Material.AIR)
            renderXN(blockX, y, blockZ);
        else if(x == 0)
            if (cx == 0)
                renderXN(blockX, y, blockZ);
            else if (ChunkInfo[cx - 1][cz].BlockInfo[x + 15][y][z].getMaterial() == Material.AIR)
                renderXN(blockX, y, blockZ);

        // Y+ Side
        if(y < 128 && ChunkInfo[cx][cz].BlockInfo[x][y + 1][z].getMaterial() == Material.AIR)
            renderYP(blockX, y, blockZ);
        else if(y == 128)
            renderYP(blockX, y, blockZ);

        // Y- Side
        if(y > 0 && ChunkInfo[cx][cz].BlockInfo[x][y - 1][z].getMaterial() == Material.AIR)
            renderYN(blockX, y, blockZ);
        else if(y == 0)
            renderYN(blockX, y, blockZ);

        // Z+ Side
        if(z < 15 && ChunkInfo[cx][cz].BlockInfo[x][y][z + 1].getMaterial() == Material.AIR)
            renderZP(blockX, y, blockZ);
        else if(z == 15)
            if (cz == TOTAL_CHUNKS)
                renderZP(blockX, y, blockZ);
            else if (ChunkInfo[cx][cz + 1].BlockInfo[x][y][z - 15].getMaterial() == Material.AIR)
                renderZP(blockX, y, blockZ);

        // Z- Side
        if(z > 0 && ChunkInfo[cx][cz].BlockInfo[x][y][z - 1].getMaterial() == Material.AIR)
            renderZN(blockX, y, blockZ);
        else if(z == 0)
            if (cz == 0)
                renderZN(blockX, y, blockZ);
            else if (ChunkInfo[cx][cz - 1].BlockInfo[x][y][z + 15].getMaterial() == Material.AIR)
                renderZN(blockX, y, blockZ);
    }

}
