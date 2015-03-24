package com.cricketcraft.cavegame.core.world;

import com.cricketcraft.cavegame.core.entity.EntityClientPlayer;
import static com.cricketcraft.cavegame.core.util.constants.BlockInformation.*;

public class World {

    public EntityClientPlayer thePlayer;

    public void World()
    {
        thePlayer = new EntityClientPlayer(0.0F + TOTAL_CHUNKS, 8.0F, 0.0F + TOTAL_CHUNKS, 1.0F, 0.0F, 0.0F);
    }

}
