package com.cricketcraft.cavegame.core.world;

import com.cricketcraft.cavegame.core.entity.EntityClientPlayer;

public class World {

    public EntityClientPlayer thePlayer;

    public void World()
    {
        thePlayer = new EntityClientPlayer(0.0F, 64.0F, 0.0F, 1.0F, -0.0F, 0.0000F);
    }

}
