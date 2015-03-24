package com.cricketcraft.cavegame;

import com.cricketcraft.cavegame.client.rendering.PrepDisplay;
import com.cricketcraft.cavegame.core.init.Blocks;
import com.cricketcraft.cavegame.core.world.World;

public class CaveGame
{
    protected static World theWorld = new World();

    public static void main(String args[])
    {
        preInit();
        init();
        postInit();
    }

    public static void preInit()
    {
        theWorld.World();

        PrepDisplay displayPrep = new PrepDisplay();
        displayPrep.prepDisplay();

        Blocks.preInit();
    }

    public static void init()
    {
        Blocks.init();

    }

    public static void postInit()
    {


    }

    public static World getWorld(){
        return theWorld;
    }
}
