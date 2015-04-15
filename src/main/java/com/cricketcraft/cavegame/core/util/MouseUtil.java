package com.cricketcraft.cavegame.core.util;

import org.lwjgl.input.Mouse;

public class MouseUtil
{
    private static boolean prevState;

    public static boolean isClicked(int button)
    {
        if(Mouse.isButtonDown(button) && !prevState)
        {
            prevState = Mouse.isButtonDown(button);
            return true;
        }
        else
        {
            prevState = Mouse.isButtonDown(button);
            return false;
        }
    }

    public static boolean isReleased(int button)
    {
        if(Mouse.isButtonDown(button) && prevState)
        {
            prevState = Mouse.isButtonDown(button);
            return true;
        }
        else
        {
            prevState = Mouse.isButtonDown(button);
            return false;
        }
    }
}
