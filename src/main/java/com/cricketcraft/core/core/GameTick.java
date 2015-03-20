package com.cricketcraft.core.core;

import static com.cricketcraft.core.utils.constants.TimeInformation.*;

public class GameTick
{

    private void Milliseconds50()
    {
        if(System.nanoTime() / MILLION > Milliseconds50 + 50)
        {
            while(System.nanoTime() / MILLION > Milliseconds50 + 50)
            {
                Milliseconds50 += 50;
                // Add commands to be executed 20 times a second here


            }
            Milliseconds50 = System.nanoTime() / MILLION;
        }
    }

    private void Milliseconds200()
    {
        if(System.nanoTime() / MILLION > Milliseconds200 + 200)
        {
            while(System.nanoTime() / MILLION > Milliseconds200 + 200)
            {
                Milliseconds200 += 200;
                // Add commands to be executed 5 times a second here


            }
            Milliseconds200 = System.nanoTime() / MILLION;
        }
    }

    private void Seconds1()
    {
        if(System.nanoTime() / BILLION > Seconds1 + 1)
        {
            while(System.nanoTime() / BILLION > Seconds1 + 1)
            {
                Seconds1 += 1;
                // Add commands to be executed 5 times a second here


            }
            Seconds1 = System.nanoTime()/BILLION;
        }
    }

    private void Seconds3()
    {
        if(System.nanoTime()/BILLION > Seconds3 + 3)
        {
            while(System.nanoTime()/BILLION > Seconds3 + 3)
            {
                Seconds3 += 3;
                // Add commands to be executed 5 times a second here


            }
            Seconds3 = System.nanoTime()/BILLION;
        }
    }

}
