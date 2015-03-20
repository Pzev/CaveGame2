package com.cricketcraft.core.core;

import com.cricketcraft.core.entity.EntityClientPlayer;
import static com.cricketcraft.core.utils.constants.BlockInformation.*;

public class World {

    public EntityClientPlayer thePlayer;

    public void World()
    {
        thePlayer = new EntityClientPlayer(0.5F + TOTAL_CHUNKS * 8, 64.0F, 0.5F + TOTAL_CHUNKS * 8, 0.0001F + TOTAL_CHUNKS * 8, -0.9001F, 0.0000F + TOTAL_CHUNKS * 8);
    }

    public void setBlock(int x, int y, int z){

    }
}
