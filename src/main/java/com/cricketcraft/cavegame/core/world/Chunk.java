package com.cricketcraft.cavegame.core.world;

import com.cricketcraft.cavegame.client.rendering.RenderBlock;
import com.cricketcraft.cavegame.core.block.Block;
import com.cricketcraft.cavegame.core.block.Material;
import com.cricketcraft.cavegame.core.util.TextureLoader;

import java.io.IOException;

public class Chunk
{
    public Block[][][] BlockInfo = new Block[16][128][16];

    public boolean isRendered;

    public int blockAmount;

    public int blockAmount()
    {
        return blockAmount;
    }

    public void setBlockAmount(int amt)
    {
        blockAmount = amt;
    }

    public Block[][][] blockInfo()
    {
        return BlockInfo;
    }

    public void addBlock(int x, int y, int z, Block block)
    {
        BlockInfo[x][y][z] = block;
    }

    public boolean isRendered()
    {
        if(this.BlockInfo != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void renderChunk(int cx, int cz)
    {
        RenderBlock tempblock;
        for (int x = 0; x < 16; x++)
        {
            for (int z = 0; z < 16; z++)
            {
                for (int y = 0; y < 128; y++)
                {
                    if (this.BlockInfo[x][y][z].getMaterial() != Material.AIR)
                    {
                        tempblock = new RenderBlock(this.BlockInfo[x][y][z]);
                        tempblock.laglessRender(x, y, z, cx, cz);
                    }
                }
            }
        }
    }

    public void renderChunkLagTest(int cx, int cz)
    {
        RenderBlock tempblock;
        TextureLoader textureLoader = new TextureLoader();

        try {
            textureLoader.getTexture("assets/textures/blocks/stone.png").bind();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int x = 0; x < 16; x++)
        {
            for (int z = 0; z < 16; z++)
            {
                for (int y = 0; y < 128; y++)
                {
                    if (this.BlockInfo[x][y][z].getMaterial() == Material.STONE)
                    {
                        tempblock = new RenderBlock(this.BlockInfo[x][y][z]);
                        tempblock.laglessRender(x, y, z, cx, cz);
                    }
                }
            }
        }

        try {
            textureLoader.getTexture("assets/textures/blocks/dirt.png").bind();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int x = 0; x < 16; x++)
        {
            for (int z = 0; z < 16; z++)
            {
                for (int y = 0; y < 128; y++)
                {
                    if (this.BlockInfo[x][y][z].getMaterial() == Material.DIRT)
                    {
                        tempblock = new RenderBlock(this.BlockInfo[x][y][z]);
                        tempblock.laglessRender(x, y, z, cx, cz);
                    }
                }
            }
        }

        try {
            textureLoader.getTexture("assets/textures/blocks/grass.png").bind();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int x = 0; x < 16; x++)
        {
            for (int z = 0; z < 16; z++)
            {
                for (int y = 0; y < 128; y++)
                {
                    if (this.BlockInfo[x][y][z].getMaterial() == Material.GRASS)
                    {
                        tempblock = new RenderBlock(this.BlockInfo[x][y][z]);
                        tempblock.laglessRender(x, y, z, cx, cz);
                    }
                }
            }
        }
    }
}
