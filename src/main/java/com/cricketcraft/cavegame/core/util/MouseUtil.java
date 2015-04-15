package com.cricketcraft.cavegame.core.util;

import org.lwjgl.input.Mouse;

public class MouseUtil
{
    static boolean q = true;
    public boolean isClicked(int button)
    {
        if(Mouse.isButtonDown(button) && q == true)
        {
            q = false;
            return true;
        }
        else
        {
            return false;
        }
    }
}
