package main.java.rendering;

import main.java.blocks.CGStone;
import main.java.constants.BlockInformation;
import main.java.definers.Block;
import main.java.definers.CGBlock;

import java.util.ListIterator;

public class RenderBlocks
{
    public static void AllBlocks() {
        for (ListIterator<Block> iter = BlockInformation.BlockInfo.listIterator(); iter.hasNext(); )
        {
            Block block = iter.next();
            block.renderBase();
        }
    }

    public static void PrepBlocks()
    {
        ListIterator<Block> iter = BlockInformation.BlockInfo.listIterator();
        for(int x = 0; x < 16; x++)
        {
            for(int z = 0; z < 16; z++)
            {
                for(int y = 0; y < 128; y++)
                {
                    CGStone block = new CGStone();
                    block.setColor(x / 16, z / 16, y / 128, 1f);
                    block.blockSetAt(x, y, z);

                    iter.add(block);
                }
            }
        }
    }
}
