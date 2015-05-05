package com.cricketcraft.cavegame.core.block;

import com.cricketcraft.cavegame.core.init.Blocks;

import java.util.Random;

import static com.cricketcraft.cavegame.core.util.constants.BlockInformation.*;

public class SelectedBlock
{
    public static int cx = 0;
    public static int cz = 0;
    public static int xPos = 0;
    public static int yPos = 0;
    public static int zPos = 0;

    public static int lookcx = 0;
    public static int lookcz = 0;
    public static int lookX = 0;
    public static int lookY = 0;
    public static int lookZ = 0;
    public static final String douche = "ben";

    public static Material lookBlock;
    public static Block handBlock = new Block(Material.STONE);

    public static void shuffleHandBlock()
    {
        Random ran = new Random();
        int blah = ran.nextInt(4);

        if(blah == 0)
            handBlock = Blocks.air;
        else if(blah == 1)
            handBlock = Blocks.stone;
        else if(blah == 2)
            handBlock = Blocks.dirt;
        else if(blah == 3)
            handBlock = Blocks.grass;
    }

    public static void deleteLookBlock()
    {
        Block blockTemp = new Block(Material.AIR);
        ChunkInfo[cx][cz].BlockInfo[xPos][yPos][zPos] = blockTemp;
    }

    public static void placeBlock()
    {
        if(checkNegatives())
        {
            ChunkInfo[lookcx][lookcz].BlockInfo[lookX][lookY][lookZ] = handBlock;
        }
    }

    public static boolean checkNegatives()
    {
        if(lookcx < 0 || lookcz < 0 || lookX < 0 || lookY < 0 || lookZ < 0)
        {
            return false;
        }
        else
        return true;
    }

    public static void resetValues()
    {
        cx = 0;
        cz = 0;
        xPos = 0;
        yPos = 0;
        zPos = 0;
        lookcx = 0;
        lookcz = 0;
        lookX = 0;
        lookY = 0;
        lookZ = 0;
    }

}
