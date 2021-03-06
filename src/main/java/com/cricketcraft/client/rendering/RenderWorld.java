package com.cricketcraft.client.rendering;

import com.cricketcraft.CaveGame;
import com.cricketcraft.core.blocks.Block;
import com.cricketcraft.core.blocks.Material;
import com.cricketcraft.core.core.Chunk;
import com.cricketcraft.core.init.Blocks;

import static com.cricketcraft.core.utils.constants.BlockInformation.*;

import java.util.ArrayList;

public class RenderWorld {
    public static void AllBlocks()
    {
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
                        chunk.renderChunk(cx, cz);
                    }
                }
            }
        }
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
                                        else if (chunk.BlockInfo[x][y][z] == null)
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

}
