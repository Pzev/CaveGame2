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

        for(int i = 0; i < BlockInfo.size(); i++)
        {
            BlockInfo.get(i).renderBase();

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
                    Block block;
                    Block.colorIs(0.5f, 0.5f, 0.5f, 1f);
                    Block.blockSetAt(x, y, z);
                    block = new Block();

                    BlockInfo.add(block);
                    i++;
                }
            }
        }
        System.out.println("done");
    }


}
