package main.java.rendering;

import main.java.blocks.CGStone;
import static main.java.constants.BlockInformation.*;

import main.java.constants.BlockInformation;
import main.java.definers.Block;
import main.java.definers.CGBlock;
import main.java.definers.Chunk;

import java.util.Iterator;
import java.util.ListIterator;

public class RenderBlocks
{
    public static void AllBlocks()
    {
        int i = 0;
        Iterator it1 = ChunkInfo.iterator();
        while(it1.hasNext())
        {
            Chunk chunk1 = ChunkInfo.get(i);
            i++;
            for(int p = 0; p < 32768; p++)
            {
                Block block = BlockInfo.get(p);
                block.renderBase();
            }
        }

        /*
        for(int i = 0; i < 32768; i++)
        {
            Block block = BlockInfo.get(i);
            block.renderBase();


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
            **/

            /*
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
    **/
    }

    public static void PrepBlocks()
    {
        int i = 0;
        Chunk tempc = new Chunk();
        for(int x = 0; x < 16; x++)
        {
            for(int z = 0; z< 16; z++)
            {
                for(int y = 0; y < 128; y++)
                {
                    Block tempb = new Block();
                    tempb.useTexture(false);
                    tempb.colorIs( x/16f, y/128f, z/16f, 1.0f);
                    //block.colorIs(0.3f, 0.3f, 0.3f, 1.0f);
                    tempb.blockSetAt(x, y, z);
                    tempc.BlockInfo.add(tempb);
                    i++;
                }
            }
        }
        ChunkInfo.add(tempc);
        System.out.println("done");
    }


}
