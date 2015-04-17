package com.cricketcraft.cavegame.client.rendering;

import com.cricketcraft.cavegame.CaveGame;
import com.cricketcraft.cavegame.core.block.Block;
import com.cricketcraft.cavegame.core.block.Material;
import com.cricketcraft.cavegame.core.world.Chunk;
import com.cricketcraft.cavegame.core.init.Blocks;
import org.lwjgl.opengl.GL11;

import static com.cricketcraft.cavegame.core.util.constants.BlockInformation.*;

public class RenderWorld {
    public static void AllBlocks()
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        setRenderMins();

        for (int cx = xMin; cx < (xMin + (CaveGame.getWorld().thePlayer.getRenderDistance() * 2) + 4); cx++)
        {
            for (int cz = zMin; cz < (zMin + (CaveGame.getWorld().thePlayer.getRenderDistance() * 2) + 4); cz++)
            {
                if(CaveGame.getWorld().thePlayer.isWithinRenderDistance(cx, cz))
                {
                    if(ChunkInfo[cx][cz] != null)
                    {
                        Chunk chunk = ChunkInfo[cx][cz];
                        chunk.renderChunkLagTest(cx, cz);
                        //RenderBlock.wireFrame();
                    }
                }
            }
        }
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

    public static void PrepBlocks()
    {
        setRenderMins();
        if (CaveGame.getWorld().thePlayer.getChunkX() != CaveGame.getWorld().thePlayer.getChunkXPrevious() || CaveGame.getWorld().thePlayer.getChunkZ() != CaveGame.getWorld().thePlayer.getChunkZPrevious())
        {
            for (int cx = xMin; cx < (xMin + (CaveGame.getWorld().thePlayer.getRenderDistance() * 2) + 4); cx++)
            {
                for (int cz = zMin; cz < (zMin + (CaveGame.getWorld().thePlayer.getRenderDistance() * 2) + 4); cz++)
                {
                        if(ChunkInfo[cx][cz] == null)
                        {
                            Chunk chunk = new Chunk();
                            for (int x = 0; x < 16; x++)
                            {
                                for (int z = 0; z < 16; z++)
                                {
                                    for (int y = 0; y < 128; y++)
                                    {
                                        if ((y == 0 || y == 1 || y == 2) && chunk.BlockInfo[x][y][z] == null)
                                        {
                                            chunk.addBlock(x, y, z, Blocks.stone);
                                        }
                                        else if ((y == 3 || y == 4 || y == 5) && chunk.BlockInfo[x][y][z] == null)
                                        {
                                            chunk.addBlock(x, y, z, Blocks.dirt);
                                        }
                                        else if ((y == 6) && chunk.BlockInfo[x][y][z] == null)
                                        {
                                            chunk.addBlock(x, y, z, Blocks.grass);
                                        }
                                        else if ( chunk.BlockInfo[x][y][z] == null )
                                        {
                                            chunk.addBlock(x, y, z, Blocks.air);
                                        }
                                    }
                                }
                            }
                            ChunkInfo[cx][cz] = chunk;
                        }
                }
            }
            CaveGame.getWorld().thePlayer.setChunkPrevious(CaveGame.getWorld().thePlayer.getChunkX(), CaveGame.getWorld().thePlayer.getChunkZ());
        }
    }

    private static int xMin = 0;
    private static int zMin = 0;

    private static void setRenderMins()
    {

        if(CaveGame.getWorld().thePlayer.getChunkX() <= CaveGame.getWorld().thePlayer.getRenderDistance() + 1)
        {
            xMin = 0;
        }
        else if(CaveGame.getWorld().thePlayer.getChunkX() >= TOTAL_CHUNKS + CaveGame.getWorld().thePlayer.getRenderDistance())
        {
            xMin = TOTAL_CHUNKS - 2;
        }
        else
        {
            xMin = CaveGame.getWorld().thePlayer.getChunkX() - CaveGame.getWorld().thePlayer.getRenderDistance() - 2;
        }

        if(CaveGame.getWorld().thePlayer.getChunkZ() <= CaveGame.getWorld().thePlayer.getRenderDistance() + 1)
        {
            zMin = 0;
        }
        else if(CaveGame.getWorld().thePlayer.getChunkZ() >= TOTAL_CHUNKS + CaveGame.getWorld().thePlayer.getRenderDistance())
        {
            zMin = TOTAL_CHUNKS - 2;
        }
        else
        {
            zMin = CaveGame.getWorld().thePlayer.getChunkZ() - CaveGame.getWorld().thePlayer.getRenderDistance() - 2;
        }
    }

    public static void renderTest()
    {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        RenderBlock blockNul = new RenderBlock(Blocks.nul);
        RenderBlock blockAir = new RenderBlock(Blocks.air);
        RenderBlock blockStone = new RenderBlock(Blocks.stone);
        RenderBlock blockDirt = new RenderBlock(Blocks.dirt);
        RenderBlock blockGrass = new RenderBlock(Blocks.grass);

        blockNul.renderBase(5, 8, -3);
        blockStone.renderBase(5, 8, -1);
        blockDirt.renderBase(5, 8, 1);
        blockGrass.renderBase(5, 8, 3);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

}
