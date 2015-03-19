package main.java.rendering;

import main.java.blocks.CGStone;
import static main.java.constants.BlockInformation.*;

import main.java.constants.BlockInformation;
import main.java.definers.Block;
import main.java.definers.CGBlock;

import java.util.ListIterator;

public class RenderBlocks
{
    public static void AllBlocks() {
        Block[] block = BlockInfo.get(0);

        for(int i = 0; i < 32768; i++)
        {
            block[i].renderBase();

        }
    }

    public static void PrepBlocks()
    {
        int i = 0;
        Block[] block = new Block[32768];
        for(int x = 0; x < 16; x++)
        {
            for(int z = 0; z< 16; z++)
            {
                for(int y = 0; y < 128; y++)
                {
                    block[i] = new Block();

                    i++;
                }
            }
        }
        BlockInfo.add(block);
        System.out.println("done");
    }


}
