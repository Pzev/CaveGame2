package com.cricketcraft.cavegame.client.rendering;


import com.cricketcraft.cavegame.CaveGame;
import com.cricketcraft.cavegame.core.block.Block;
import com.cricketcraft.cavegame.core.block.Material;
import com.cricketcraft.cavegame.core.block.SelectedBlock;
import com.cricketcraft.cavegame.core.util.TextureLoader;
import org.lwjgl.opengl.GL11;

import java.io.IOException;

import static com.cricketcraft.cavegame.core.util.constants.BlockInformation.ChunkInfo;
import static com.cricketcraft.cavegame.core.util.constants.BlockInformation.TOTAL_CHUNKS;

public class RenderBlock
{
    private Block block;
    private TextureLoader textureLoader;

    public RenderBlock(Block block){
        this.block = block;
        textureLoader = new TextureLoader();
    }

    public void renderBase(int x, int y, int z, int cx, int cz)
    {
        try {
            textureLoader.getTexture(block.getResourceName()).bind();
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = x + (cx * 16);
        z = z + (cz * 16);

        // X+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x + 1, y + 1, z);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y, z);
        GL11.glEnd();

        // X- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x, y, z);
        GL11.glEnd();

        // Y+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y + 1, z);
        GL11.glEnd();

        // Y- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y, z);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y, z);
        GL11.glEnd();

        // Z+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y, z + 1);
        GL11.glEnd();

        // Z- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y + 1, z);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y, z);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y, z);
        GL11.glEnd();
    }

    public void renderBase(int x, int y, int z)
    {
        try {
            textureLoader.getTexture(block.getResourceName()).bind();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // X+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x + 1, y + 1, z);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y, z);
        GL11.glEnd();

        // X- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x, y, z);
        GL11.glEnd();

        // Y+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y + 1, z);
        GL11.glEnd();

        // Y- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y, z);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y, z);
        GL11.glEnd();

        // Z+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y, z + 1);
        GL11.glEnd();

        // Z- Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y + 1, z);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y, z);
        GL11.glTexCoord2f(1, 0);
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

        // X+ Side
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x + 1, y + 1, z);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y, z);
    }

    public void renderXN(int x, int y, int z)
    {

        // X- Side
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x, y, z);
    }

    public void renderYP(int x, int y, int z)
    {

        // Y+ Side
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y + 1, z);
    }

    public void renderYN(int x, int y, int z)
    {

        // Y- Side
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y, z);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y, z);
    }

    public void renderZP(int x, int y, int z)
    {

        // Z+ Side
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y + 1, z + 1);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y + 1, z + 1);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y, z + 1);
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y, z + 1);
    }

    public void renderZN(int x, int y, int z)
    {

        // Z- Side
        GL11.glTexCoord2f(0, 0);
        GL11.glVertex3f(x + 1, y + 1, z);
        GL11.glTexCoord2f(0, 1);
        GL11.glVertex3f(x, y + 1, z);
        GL11.glTexCoord2f(1, 1);
        GL11.glVertex3f(x, y, z);
        GL11.glTexCoord2f(1, 0);
        GL11.glVertex3f(x + 1, y, z);
    }

    public void laglessRender(int x, int y, int z, int cx, int cz)
    {
        int blockX = x + (cx * 16);
        int blockZ = z + (cz * 16);

        // X+ Side
        GL11.glBegin(GL11.GL_QUADS);
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
        GL11.glEnd();
    }

    // Init in RenderWorld Class
    public static void wireFrame()
    {
        double newX, newY, newZ, newRad1;
        int cx, cz, wireX, wireY, wireZ;

        double xDist = CaveGame.getWorld().thePlayer.getEyeX();
        double yDist = CaveGame.getWorld().thePlayer.getEyeY();
        double zDist = CaveGame.getWorld().thePlayer.getEyeZ();

        double angleXZ = Math.atan(xDist / zDist);
        double radiusXZ = Math.sqrt((xDist * xDist) + (zDist * zDist));
        double angleY = Math.atan(yDist / radiusXZ);

        int q = 0;
        if(zDist < 0) q = -1;
        if(zDist >= 0) q = 1;

        for(double r = 0; r <= 10; r += 0.1) {
            newRad1 = q * r * Math.cos(angleY);

            newY = (r * Math.sin(angleY)) + CaveGame.getWorld().thePlayer.getyCoord() + 1.8;

            newX = (newRad1 * Math.sin(angleXZ)) + CaveGame.getWorld().thePlayer.getxCoord();
            newZ = (newRad1 * Math.cos(angleXZ)) + CaveGame.getWorld().thePlayer.getzCoord();

            cx = (int) (CaveGame.getWorld().thePlayer.getxCoord() / 16f);
            cz = (int) (CaveGame.getWorld().thePlayer.getzCoord() / 16f);

            wireX = (int) newX;
            wireY = (int) newY;
            wireZ = (int) newZ;

            while(newX >= 16)
                newX -= 16;
            while(newY >= 16)
                newY -= 16;
            while(newZ >= 16)
                newZ -= 16;

            try {
                if (ChunkInfo[cx][cz].BlockInfo[(int) newX][(int) newY][(int) newZ].getMaterial() != Material.AIR) {
                    renderWireFrame(wireX, wireY, wireZ);

                    SelectedBlock.lookBlock = ChunkInfo[cx][cz].BlockInfo[(int) newX][(int) newY][(int) newZ].getMaterial();
                    SelectedBlock.xPos = (int) newX;
                    SelectedBlock.yPos = (int) newY;
                    SelectedBlock.zPos = (int) newZ;
                    SelectedBlock.cx = cx;
                    SelectedBlock.cz = cz;

                    r += 0.2;

                    newRad1 = q * r * Math.cos(angleY);

                    newY = (r * Math.sin(angleY)) + CaveGame.getWorld().thePlayer.getyCoord() + 1.8;

                    newX = (newRad1 * Math.sin(angleXZ)) + CaveGame.getWorld().thePlayer.getxCoord();
                    newZ = (newRad1 * Math.cos(angleXZ)) + CaveGame.getWorld().thePlayer.getzCoord();

                    wireX = (int) newX;
                    wireY = (int) newY;
                    wireZ = (int) newZ;

                    SelectedBlock.lookX = wireX;
                    SelectedBlock.lookY = wireY;
                    SelectedBlock.lookZ = wireZ;
                    SelectedBlock.lookcx = cx;
                    SelectedBlock.lookcz = cz;

                    while(newX >= 16)
                        newX -= 16;
                    while(newY >= 16)
                        newY -= 16;
                    while(newZ >= 16)
                        newZ -= 16;

                    SelectedBlock.heldBlock = ChunkInfo[cx][cz].BlockInfo[(int) newX][(int) newY][(int) newZ].getMaterial();

                    r = 1000;
                }
            }
            catch (ArrayIndexOutOfBoundsException e){}

        }
    }

}
