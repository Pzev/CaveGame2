
package main.java.definers;

import main.java.definers.Block;
import main.java.definers.CGBlock;

import java.util.ArrayList;
import java.util.List;

public class Chunk
{
    public ArrayList<Block> BlockInfo = new ArrayList<Block>();

    public int blockAmount;
    public int chunkX;
    public int chunkZ;

    public int blockAmount()
        {
            return blockAmount;
        }

    public void setBlockAmount(int amt)
        {
            blockAmount = amt;
        }

    public int chunkX()
        {
            return blockAmount;
        }

    public void getChunkX(int x)
        {
            chunkX = x;
        }

    public int chunkZ()
        {
            return chunkZ;
        }

    public void getChunkZ(int z)
        {
            chunkZ = z;
        }
}


