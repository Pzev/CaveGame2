package com.cricketcraft.cavegame.core.tick;

import com.cricketcraft.cavegame.client.rendering.RenderWorld;

public class GameTick
{
    public static long startTime = System.currentTimeMillis();
    public static long endTime;


    protected static long milliTick = 0;

   // protected static long millisecond50Tick = 0;
    protected static long millisecond200Tick = 0;
    //protected static float second1Tick = 0;
    //protected static float second3Tick = 0;
    //protected static float second10Tick = 0;
    //protected static float second30Tick = 0;
    //protected static float minute1Tick = 0;

    public static void tick()
    {
        endTime = System.currentTimeMillis();
        milliTick = endTime - startTime;
        startTime = System.currentTimeMillis();

        //millisecond50Tick += milliTick;
        millisecond200Tick += milliTick;
        //second1Tick += (milliTick / 1000f);
        //second3Tick += (milliTick / 1000f);
        //second10Tick += (milliTick / 1000f);
        //second30Tick += (milliTick / 1000f);
        //minute1Tick += (milliTick / 60000f);

        /*
        while(millisecond50Tick >= 50)
        {
            millisecond50Tick -= 50;
            Milliseconds50();
        }
        **/

        while(millisecond200Tick >= 200)
        {
            millisecond200Tick -= 200;
            Milliseconds200();
        }

        /*
        while(second1Tick >= 1)
        {
            second1Tick -= 1;
            Seconds1();
        }

        while(second3Tick >= 3)
        {
            second3Tick -= 3;
            Seconds3();
        }

        while(second10Tick >= 10)
        {
            second10Tick -= 10;
            Seconds10();
        }

        while(second30Tick >= 30)
        {
            second30Tick -= 30;
            Seconds30();
        }

        while(minute1Tick >= 1)
        {
            minute1Tick -= 1;
            Minutes1();
        }
        **/
    }


    private static void Milliseconds50()
    {

    }

    private static void Milliseconds200()
    {
        RenderWorld.PrepBlocks();
    }

    private static void Seconds1()
    {

    }

    private static void Seconds3()
    {

    }

    private static void Seconds10()
    {

    }

    private static void Seconds30()
    {

    }

    private static void Minutes1()
    {

    }
}
