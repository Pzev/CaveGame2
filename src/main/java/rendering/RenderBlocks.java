package main.java.rendering;

import main.java.blocks.CGStone;
import static main.java.constants.BlockInformation.*;

import main.java.constants.BlockInformation;
import main.java.definers.Block;
import main.java.definers.CGBlock;

import java.util.ListIterator;

public class RenderBlocks
{
    public static void AllBlocks()
    {
        for(int i = 0; i < 32768; i++)
        {
            Block block = BlockInfo.get(i);
            int xCo = block.blockX();
            int yCo = block.blockY();
            int zCo = block.blockZ();

            Block block2 = BlockInfo.get((xCo*2048 + zCo*128 + yCo));

            // For now, 1 will represent the block being air
            if(xCo < 15)
            {
                if (BlockInfo.get(i + 2048).blockX() == 1)
                {
                    block.renderXP();
                }
            }
            else if(xCo == 15)
            {
                // Change to check block in next X+ chunk
                if (BlockInfo.get(i + 2048).blockX() == 1)
                {
                    block.renderXP();
                }
            }

            else if(BlockInfo.get(i-2048).blockX() == 1)
            {
                block.renderXN();
            }
            else if(BlockInfo.get(i+1).blockY() == 1)
            {
                block.renderYP();
            }
            else if(BlockInfo.get(i-1).blockY() == 1)
            {
                block.renderYN();
            }
            else if(BlockInfo.get(i+128).blockZ() == 1)
            {
                block.renderZP();
            }
            else if(BlockInfo.get(i-128).blockZ() == 1)
            {
                block.renderZN();
            }




        }
    }

    public static void PrepBlocks()
    {
        int i = 0;
        for(int x = 0; x < 16; x++)
        {
            for(int z = 0; z< 16; z++)
            {
                for(int y = 0; y < 128; y++)
                {
                    Block block = new Block();
                    block.useTexture(false);
                    block.colorIs( x/16f, y/128f, z/16f, 1.0f);
                    block.blockSetAt(x, y, z);
                    BlockInfo.add(block);

                    i++;
                }
            }
        }
        System.out.println("done");
    }


}
