package main.java.blocks;

import main.java.definers.Block;
import main.java.definers.CGBlock;

public class CGStone extends CGBlock
{
    public CGStone()
    {
        renderSidesSame(true);
        useTexture(false);
        colorIs(0.5f, 0.5f, 0.5f, 1f);
    }

}
