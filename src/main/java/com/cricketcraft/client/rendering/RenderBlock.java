package com.cricketcraft.client.rendering;

import com.cricketcraft.CaveGame;
import com.cricketcraft.core.blocks.Block;
import com.cricketcraft.core.blocks.Material;
import org.lwjgl.input.Mouse;
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

    public static void renderWireFrame(int x, int y, int z)
    {
        GL11.glColor4f(0, 0, 0, 1);
        GL11.glLineWidth(0.05f);

        // X+ Side
        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex3f(x + 1.01f, y, z + 1.01f);
        GL11.glVertex3f(x + 1.01f, y + 1.01f, z + 1.01f);
        GL11.glVertex3f(x + 1.01f, y + 1.01f, z);
        GL11.glVertex3f(x + 1.01f, y, z);

        // X- Side
        GL11.glVertex3f(x, y, z + 1.01f);
        GL11.glVertex3f(x, y + 1.01f, z + 1.01f);
        GL11.glVertex3f(x, y + 1.01f, z);
        GL11.glVertex3f(x, y, z);

        // Y+ Side
        GL11.glVertex3f(x + 1.01f, y + 1.01f, z + 1.01f);
        GL11.glVertex3f(x, y + 1.01f, z + 1.01f);
        GL11.glVertex3f(x, y + 1.01f, z);
        GL11.glVertex3f(x + 1.01f, y + 1.01f, z);

        // Y- Side
        GL11.glVertex3f(x + 1.01f, y, z + 1.01f);
        GL11.glVertex3f(x, y, z + 1.01f);
        GL11.glVertex3f(x, y, z);
        GL11.glVertex3f(x + 1.01f, y, z);

        // Z+ Side
        GL11.glVertex3f(x + 1.01f, y + 1.01f, z + 1.01f);
        GL11.glVertex3f(x, y + 1.01f, z + 1.01f);
        GL11.glVertex3f(x, y, z + 1.01f);
        GL11.glVertex3f(x + 1.01f, y, z + 1.01f);

        // Z- Side
        GL11.glVertex3f(x + 1.01f, y + 1.01f, z);
        GL11.glVertex3f(x, y + 1.01f, z);
        GL11.glVertex3f(x, y, z);
        GL11.glVertex3f(x + 1.01f, y, z);
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

    public void renderXPWire(int x, int y, int z)
    {
        GL11.glColor4f(0, 0, 0, 1);
        GL11.glLineWidth(0.05f);
        // X+ Side
        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex3f(x + 1.01f, y, z + 1.01f);
        GL11.glVertex3f(x + 1.01f, y + 1.01f, z + 1.01f);
        GL11.glVertex3f(x + 1.01f, y + 1.01f, z);
        GL11.glVertex3f(x + 1.01f, y, z);
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

    public void renderXNWire(int x, int y, int z)
    {
        GL11.glColor4f(0, 0, 0, 1);
        GL11.glLineWidth(0.05f);
        // X- Side
        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex3f(x, y, z + 1.01f);
        GL11.glVertex3f(x, y + 1.01f, z + 1.01f);
        GL11.glVertex3f(x, y + 1.01f, z);
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

    public void renderYPWire(int x, int y, int z)
    {
        GL11.glColor4f(0, 0, 0, 1);
        GL11.glLineWidth(0.05f);
        // X+ Side
        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex3f(x + 1.01f, y + 1.01f, z + 1.01f);
        GL11.glVertex3f(x, y + 1.01f, z + 1.01f);
        GL11.glVertex3f(x, y + 1.01f, z);
        GL11.glVertex3f(x + 1.01f, y + 1.01f, z);
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

    public void renderYNWire(int x, int y, int z)
    {
        GL11.glColor4f(0, 0, 0, 1);
        GL11.glLineWidth(0.05f);
        // X+ Side
        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex3f(x + 1.01f, y, z + 1.01f);
        GL11.glVertex3f(x, y, z + 1.01f);
        GL11.glVertex3f(x, y, z);
        GL11.glVertex3f(x + 1.01f, y, z);
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

    public void renderZPWire(int x, int y, int z)
    {
        GL11.glColor4f(0, 0, 0, 1);
        GL11.glLineWidth(0.05f);
        // X+ Side
        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex3f(x + 1.01f, y + 1.01f, z + 1.01f);
        GL11.glVertex3f(x, y + 1.01f, z + 1.01f);
        GL11.glVertex3f(x, y, z + 1.01f);
        GL11.glVertex3f(x + 1.01f, y, z + 1.01f);
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

    public void renderZNWire(int x, int y, int z)
    {
        GL11.glColor4f(0, 0, 0, 1);
        GL11.glLineWidth(0.05f);
        // X+ Side
        GL11.glBegin(GL11.GL_LINE_LOOP);
        GL11.glVertex3f(x + 1.01f, y + 1.01f, z);
        GL11.glVertex3f(x, y + 1.01f, z);
        GL11.glVertex3f(x, y, z);
        GL11.glVertex3f(x + 1.01f, y, z);
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

    // Init in RenderWorld Class
    public static void wireFrame()
    {
        double smallX = CaveGame.getWorld().thePlayer.getxCoord() - CaveGame.getWorld().thePlayer.getEyeX();
        double smallY = CaveGame.getWorld().thePlayer.getyCoord() - CaveGame.getWorld().thePlayer.getEyeY();
        double smallZ = CaveGame.getWorld().thePlayer.getzCoord() - CaveGame.getWorld().thePlayer.getEyeZ();

        double xRad = Math.sqrt((smallX * smallX) + (smallZ * smallZ));
        double theta = (float) Math.atan(smallZ / smallX);
        double zAngle = (float) Math.asin(smallY / xRad);

        for(float r = 1; r <= 7; r += 0.01) {
            // ReCheck for trig accuracy: newY is Correct, newX idk, newZ idk
            double newY = r * ((float) (Math.cos(theta * Math.PI / 180)));
            double newX = r * ((float) (Math.sin(theta * Math.PI / 180) * Math.cos(zAngle * Math.PI / 180)));
            double newZ = r * ((float) (Math.sin(theta * Math.PI / 180) * Math.sin(zAngle * Math.PI / 180)));

            int cx = (int) newX / 16;
            int cz = (int) newZ / 16;
            System.out.println(newX);
            if(ChunkInfo[cx][cz] != null)
            {
                System.out.println(newY);
                if (ChunkInfo[cx][cz].BlockInfo[(int) newX][(int) newY][(int) newZ].getMaterial() != Material.AIR)
                {
                    renderWireFrame((int) newX, (int) newY, (int) newZ);
                    r = 100000;
                    System.out.println(newX);
                }
            }
        }
    }

}
