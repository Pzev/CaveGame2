package com.cricketcraft.cavegame.core.block;

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

    public static Material lookBlock;
    public static Material heldBlock;

    public static void deleteLookBlock()
    {
        Block blockTemp = new Block(Material.AIR);
        ChunkInfo[cx][cz].BlockInfo[xPos][yPos][zPos] = blockTemp;
    }

}
