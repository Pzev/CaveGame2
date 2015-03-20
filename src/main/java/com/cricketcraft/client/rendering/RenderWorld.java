package com.cricketcraft.client.rendering;

import com.cricketcraft.CaveGame;
import com.cricketcraft.core.blocks.Block;
import com.cricketcraft.core.blocks.Material;
import com.cricketcraft.core.core.Chunk;

import static com.cricketcraft.core.utils.constants.BlockInformation.*;

import java.util.ArrayList;

public class RenderWorld {
    public static void AllBlocks() {
        int xMin = 0;
        int zMin = 0;

        if(CaveGame.getWorld().thePlayer.inChunkX() <= CaveGame.getWorld().thePlayer.getRenderDistance())
        {
            xMin = 0;
        }
        else if(CaveGame.getWorld().thePlayer.inChunkX() >= TOTAL_CHUNKS + CaveGame.getWorld().thePlayer.getRenderDistance())
        {
            xMin = TOTAL_CHUNKS - 1;
        }
        else
        {
            xMin = CaveGame.getWorld().thePlayer.inChunkX() - CaveGame.getWorld().thePlayer.getRenderDistance() - 1;
        }

        if(CaveGame.getWorld().thePlayer.inChunkZ() <= CaveGame.getWorld().thePlayer.getRenderDistance())
        {
            zMin = 0;
        }
        else if(CaveGame.getWorld().thePlayer.inChunkZ() >= TOTAL_CHUNKS + CaveGame.getWorld().thePlayer.getRenderDistance())
        {
            zMin = TOTAL_CHUNKS - 1;
        }
        else
        {
            zMin = CaveGame.getWorld().thePlayer.inChunkZ() - CaveGame.getWorld().thePlayer.getRenderDistance() - 1;
        }

        for (int cx = xMin; cx < (xMin + (CaveGame.getWorld().thePlayer.getRenderDistance() * 2) + 2); cx++)
        {
            for (int cz = zMin; cz < (zMin + (CaveGame.getWorld().thePlayer.getRenderDistance() * 2) + 2); cz++)
            {
                if(CaveGame.getWorld().thePlayer.isWithinRenderDistance(cx, cz))
                {
                    Chunk chunk = ChunkInfo[cx][cz];
                    for (int blok = 0; blok < chunk.BlockInfo.size(); blok++)
                    {
                        RenderBlock block = new RenderBlock(chunk.BlockInfo.get(blok));
                        block.renderBase();
                    }
                }
            }
        }
    }

    public static void PrepBlocks()
    {

        for (int cx = 0; cx < TOTAL_CHUNKS; cx++)
        {
            for (int cz = 0; cz < TOTAL_CHUNKS; cz++)
            {
                if(CaveGame.getWorld().thePlayer.isWithinRenderDistance(cx, cz))
                {
                    Chunk chunk = new Chunk();
                    for(int x = 0; x < 16; x++)
                    {
                        for(int z = 0; z< 16; z++)
                        {
                            for(int y = 0; y < 7; y++)
                            {
                                if(y == 0 || y == 1 || y == 2)
                                {
                                    Block tempBlock = new Block(Material.STONE);
                                    tempBlock.setPosition(x, y, z);
                                    chunk.addBlock(tempBlock);
                                }
                                else if(y == 3 || y == 4 || y == 5)
                                {
                                    Block tempBlock = new Block(Material.DIRT);
                                    tempBlock.setPosition(x, y, z);
                                    chunk.addBlock(tempBlock);
                                }
                                else if(y == 6)
                                {
                                    Block tempBlock = new Block(Material.GRASS);
                                    tempBlock.setPosition(x, y, z);
                                    chunk.addBlock(tempBlock);
                                }

                            }
                        }
                    }
                    ChunkInfo[cx][cz] = chunk;
                }
            }
        }
    }

}
