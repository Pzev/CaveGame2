package main.java.definers;

import org.lwjgl.opengl.GL11;
import static main.java.constants.LocationVars.*;

public class Block {

    private static boolean renderSidesSame = true;
    private static boolean useTexture = false;
    private static int blockX, blockY, blockZ;

    public static void renderSidesSame(boolean renderSides) {
        renderSidesSame = renderSides;
    }

    public static void useTexture(boolean use)
    {
        useTexture = use;
    }

    public static void colorIs(float r, float g, float b, float a)
    {
        GL11.glColor4f(r, g, b, a);
    }

    public static void textureIs(String path)
    {
        GL11.glColor4f(0, 0, 0, 0);

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

    public static void renderBase() {
        // X+ Side
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex3f(blockX + 1, blockY, blockZ + 1);
        GL11.glVertex3f(blockX + 1, blockY + 1, blockZ + 1);
        GL11.glVertex3f(blockX + 1, blockY + 1, blockZ);
        GL11.glVertex3f(blockX + 1, blockY, blockZ);

        // X- Side
        GL11.glVertex3f(blockX, blockY, blockZ + 1);
        GL11.glVertex3f(blockX, blockY + 1, blockZ + 1);
        GL11.glVertex3f(blockX, blockY + 1, blockZ);
        GL11.glVertex3f(blockX, blockY, blockZ);

        // Y+ Side
        GL11.glVertex3f(blockX + 1, blockY + 1, blockZ + 1);
        GL11.glVertex3f(blockX, blockY + 1, blockZ + 1);
        GL11.glVertex3f(blockX, blockY + 1, blockZ);
        GL11.glVertex3f(blockX + 1, blockY + 1, blockZ);

        // Y- Side
        GL11.glVertex3f(blockX + 1, blockY, blockZ + 1);
        GL11.glVertex3f(blockX, blockY, blockZ + 1);
        GL11.glVertex3f(blockX, blockY, blockZ);
        GL11.glVertex3f(blockX + 1, blockY, blockZ);

        // Z+ Side
        GL11.glVertex3f(blockX + 1, blockY + 1, blockZ + 1);
        GL11.glVertex3f(blockX, blockY + 1, blockZ + 1);
        GL11.glVertex3f(blockX, blockY, blockZ + 1);
        GL11.glVertex3f(blockX + 1, blockY, blockZ + 1);

        // Z- Side
        GL11.glVertex3f(blockX + 1, blockY + 1, blockZ);
        GL11.glVertex3f(blockX, blockY + 1, blockZ);
        GL11.glVertex3f(blockX, blockY, blockZ);
        GL11.glVertex3f(blockX + 1, blockY, blockZ);
        GL11.glEnd();

    }

    public static void laglessRender()
    {

        // Redo ALL of the lagless render except basic side checking logic

        /*
        for(int cx = 0; cx < 16; cx++)
        {
            if(cx <= xCord + renderDistance && cx >= xCord - renderDistance)
            {
                for(int cz = 0; cz < 16; cz++)
                {
                    if(cz <= zCord + renderDistance && cz >= zCord - renderDistance)
                    {
                        for(int y = 0; y < 128; y++)
                        {
                            for(int x = 0; x < 16; x++)
                            {
                                for(int z = 0; z < 16; z++)
                                {

                                    if(blockspp[cx][cz][x][z][y] == 1 || blockspp[cx][cz][x][z][y] == 2 || blockspp[cx][cz][x][z][y] == 3)
                                    {

                                        if(blockspp[cx][cz][x][z][y] == 1)
                                        {
                                            GL11.glColor4f(0.2f, 0.2f, 0.2f, 1.0f);
                                        }
                                        else if(blockspp[cx][cz][x][z][y] == 2)
                                        {
                                            GL11.glColor4f(0.5f, 0.5f, 0.5f, 1.0f);
                                        }
                                        else if(blockspp[cx][cz][x][z][y] == 3)
                                        {
                                            GL11.glColor4f(0.0f, 0.6f, 0.0f, 1.0f);
                                        }


                                        int x1 = x + cx*16;
                                        int y1 = y;
                                        int z1 = z + cz*16;

                                        //x+ side
                                        if(x < 15)
                                        {
                                            if(blockspp[cx][cz][x+1][z][y] == 0)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1+1, y1-1, z1+1);
                                                GL11.glVertex3f(x1+1, y1, z1+1);
                                                GL11.glVertex3f(x1+1, y1, z1);
                                                GL11.glVertex3f(x1+1, y1-1, z1);
                                                GL11.glEnd();
                                            }
                                        }
                                        else if(x == 15)
                                        {
                                            if(cx==15)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1+1, y1-1, z1+1);
                                                GL11.glVertex3f(x1+1, y1, z1+1);
                                                GL11.glVertex3f(x1+1, y1, z1);
                                                GL11.glVertex3f(x1+1, y1-1, z1);
                                                GL11.glEnd();
                                            }
                                            else if(blockspp[cx+1][cz][x-15][z][y] == 0)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1+1, y1-1, z1+1);
                                                GL11.glVertex3f(x1+1, y1, z1+1);
                                                GL11.glVertex3f(x1+1, y1, z1);
                                                GL11.glVertex3f(x1+1, y1-1, z1);
                                                GL11.glEnd();
                                            }
                                        }

                                        //x- side
                                        if(x > 0)
                                        {
                                            if(blockspp[cx][cz][x-1][z][y] == 0)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1, y1-1, z1+1);
                                                GL11.glVertex3f(x1, y1, z1+1);
                                                GL11.glVertex3f(x1, y1, z1);
                                                GL11.glVertex3f(x1, y1-1, z1);
                                                GL11.glEnd();
                                            }
                                        }
                                        else if(x == 0)
                                        {
                                            if(cx==0)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1, y1-1, z1+1);
                                                GL11.glVertex3f(x1, y1, z1+1);
                                                GL11.glVertex3f(x1, y1, z1);
                                                GL11.glVertex3f(x1, y1-1, z1);
                                                GL11.glEnd();
                                            }
                                            else if(blockspp[cx-1][cz][x+15][z][y] == 0)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1, y1-1, z1+1);
                                                GL11.glVertex3f(x1, y1, z1+1);
                                                GL11.glVertex3f(x1, y1, z1);
                                                GL11.glVertex3f(x1, y1-1, z1);
                                                GL11.glEnd();
                                            }
                                        }

                                        //y+ side
                                        if(y < 127)
                                        {
                                            if(blockspp[cx][cz][x][z][y+1] == 0)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1+1, y1, z1+1);
                                                GL11.glVertex3f(x1, y1, z1+1);
                                                GL11.glVertex3f(x1, y1, z1);
                                                GL11.glVertex3f(x1+1, y1, z1);
                                                GL11.glEnd();
                                            }
                                        }
                                        else if(y == 127)
                                        {
                                            GL11.glBegin(GL11.GL_QUADS);
                                            GL11.glVertex3f(x1+1, y1, z1+1);
                                            GL11.glVertex3f(x1, y1, z1+1);
                                            GL11.glVertex3f(x1, y1, z1);
                                            GL11.glVertex3f(x1+1, y1, z1);
                                            GL11.glEnd();
                                        }

                                        //y- side
                                        if(y > 0)
                                        {
                                            if(blockspp[cx][cz][x][z][y-1] == 0)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1+1, y1-1, z1+1);
                                                GL11.glVertex3f(x1, y1-1, z1+1);
                                                GL11.glVertex3f(x1, y1-1, z1);
                                                GL11.glVertex3f(x1+1, y1-1, z1);
                                                GL11.glEnd();
                                            }
                                        }
                                        else if(y == 0)
                                        {
                                            GL11.glBegin(GL11.GL_QUADS);
                                            GL11.glVertex3f(x1+1, y1-1, z1+1);
                                            GL11.glVertex3f(x1, y1-1, z1+1);
                                            GL11.glVertex3f(x1, y1-1, z1);
                                            GL11.glVertex3f(x1+1, y1-1, z1);
                                            GL11.glEnd();
                                        }

                                        //z+ side
                                        if(z < 15)
                                        {
                                            if(blockspp[cx][cz][x][z+1][y] == 0)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1+1, y1, z1+1);
                                                GL11.glVertex3f(x1, y1, z1+1);
                                                GL11.glVertex3f(x1, y1-1, z1+1);
                                                GL11.glVertex3f(x1+1, y1-1, z1+1);
                                                GL11.glEnd();
                                            }
                                        }
                                        else if(z == 15)
                                        {
                                            if(cz==15)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1+1, y1, z1+1);
                                                GL11.glVertex3f(x1, y1, z1+1);
                                                GL11.glVertex3f(x1, y1-1, z1+1);
                                                GL11.glVertex3f(x1+1, y1-1, z1+1);
                                                GL11.glEnd();
                                            }
                                            else if(blockspp[cx][cz+1][x][z-15][y] == 0)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1+1, y1, z1+1);
                                                GL11.glVertex3f(x1, y1, z1+1);
                                                GL11.glVertex3f(x1, y1-1, z1+1);
                                                GL11.glVertex3f(x1+1, y1-1, z1+1);
                                                GL11.glEnd();
                                            }
                                        }

                                        //z- side
                                        if(z > 0)
                                        {
                                            if(blockspp[cx][cz][x][z-1][y] == 0)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1+1, y1, z1);
                                                GL11.glVertex3f(x1, y1, z1);
                                                GL11.glVertex3f(x1, y1-1, z1);
                                                GL11.glVertex3f(x1+1, y1-1, z1);
                                                GL11.glEnd();
                                            }
                                        }
                                        else if(z == 0)
                                        {
                                            if(cz==0)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1+1, y1, z1);
                                                GL11.glVertex3f(x1, y1, z1);
                                                GL11.glVertex3f(x1, y1-1, z1);
                                                GL11.glVertex3f(x1+1, y1-1, z1);
                                                GL11.glEnd();
                                            }
                                            else if(blockspp[cx][cz-1][x][z+15][y] == 0)
                                            {
                                                GL11.glBegin(GL11.GL_QUADS);
                                                GL11.glVertex3f(x1+1, y1, z1);
                                                GL11.glVertex3f(x1, y1, z1);
                                                GL11.glVertex3f(x1, y1-1, z1);
                                                GL11.glVertex3f(x1+1, y1-1, z1);
                                                GL11.glEnd();

                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    **/
    }
}
