package com.cricketcraft.core.core;

import com.cricketcraft.core.blocks.Block;
import com.cricketcraft.core.blocks.Material;

import java.util.ArrayList;

public class Chunk
{
    public Block[][][] BlockInfo = new Block[16][128][16];

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

    public void addBlock(int x, int y, int z, Material material)
    {
        BlockInfo[x][y][z] = new Block(material);
    }
}
