package com.cricketcraft.core.core;

import com.cricketcraft.core.entity.EntityClientPlayer;

public class World {

    public EntityClientPlayer thePlayer;

    public World(){
        thePlayer = new EntityClientPlayer(0.5001F, 64.0001F, 0.5001F, 1.5001F, 63.0901F, 0.5001F);
    }

    public void setBlock(int x, int y, int z){

    }
}
