package com.cricketcraft;

import com.cricketcraft.client.rendering.PrepDisplay;
import com.cricketcraft.core.core.World;
import com.cricketcraft.core.entity.EntityClientPlayer;

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

        
    }

    public static void init()
    {


    }

    public static void postInit()
    {


    }

    public static World getWorld(){
        return theWorld;
    }
}
