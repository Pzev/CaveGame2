package com.cricketcraft.core.core;

import com.cricketcraft.core.entity.EntityClientPlayer;

public class World {

    public EntityClientPlayer thePlayer;

    public void World()
    {
        thePlayer = new EntityClientPlayer(0.5F, 64.0F, 0.5F, 0.0001F, -0.9001F, 0.0000F);
    }

    public void setBlock(int x, int y, int z){

    }
}
