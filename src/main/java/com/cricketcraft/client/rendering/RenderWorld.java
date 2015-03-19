package com.cricketcraft.client.rendering;

import com.cricketcraft.core.blocks.Block;
import com.cricketcraft.core.blocks.Material;
import com.cricketcraft.core.utils.constants.BlockInformation;

import java.util.ListIterator;

public class RenderWorld {
    public static void AllBlocks() {
        for (ListIterator<Block> iter = BlockInformation.BlockInfo.listIterator(); iter.hasNext(); )
        {
            Block block = iter.next();
            RenderBlock renderBlock = new RenderBlock(block);
            renderBlock.renderBase();
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
                    Block block = new Block(Material.STONE);
                    block.setColor(x / 16, z / 16, y / 128, 1f);
                    block.blockSetAt(x, y, z);

                    iter.add(block);
                }
            }
        }
    }
}
