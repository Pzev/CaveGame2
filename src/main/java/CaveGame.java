package main.java;

import main.java.rendering.PrepDisplay;

public class CaveGame
{
    public static float xLook = 1.0001f, yLook=0.0001f, zLook=0.0001f;


    public static void main(String args[])
    {
        preInit();
        init();
        postInit();
    }

    public static void preInit()
    {
        PrepDisplay displayPrep = new PrepDisplay();
        displayPrep.prepDisplay();


    }

    public static void init()
    {


    }

    public static void postInit()
    {


    }
}
