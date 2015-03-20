package com.cricketcraft.core.core;

import com.cricketcraft.core.blocks.Block;

import java.util.ArrayList;

public class Chunk
{
    public ArrayList<Block> BlockInfo = new ArrayList<Block>();

    public int blockAmount;

    public int blockAmount()
    {
        return blockAmount;
    }

    public void setBlockAmount(int amt)
    {
        blockAmount = amt;
    }

    public ArrayList<Block> blockInfo()
    {
        return this.BlockInfo;
    }

    public void addBlock(Block blockInfo)
    {
        BlockInfo.add(blockInfo);
    }
}
