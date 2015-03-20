package com.cricketcraft.core.core;

import com.cricketcraft.core.entity.EntityClientPlayer;
import static com.cricketcraft.core.utils.constants.BlockInformation.*;

public class World {

    public EntityClientPlayer thePlayer;

    public void World()
    {
        thePlayer = new EntityClientPlayer(0.0F, 64.0F, 0.0F, 1.0F, -0.0F, 0.0000F);
    }

}
