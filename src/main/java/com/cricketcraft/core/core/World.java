package com.cricketcraft.core.core;

import com.cricketcraft.core.entity.EntityClientPlayer;
import static com.cricketcraft.core.utils.constants.BlockInformation.*;

public class World {

    public EntityClientPlayer thePlayer;

    public void World()
    {
        thePlayer = new EntityClientPlayer(0.0F + TOTAL_CHUNKS * 8, 8.0F, 0.0F + TOTAL_CHUNKS * 8, 1.0F, 0.0F, 0.0F);
    }

}
