package com.cricketcraft.cavegame.core.util;

import org.lwjgl.input.Mouse;

import java.awt.event.InputEvent;

public class MouseUtil
{
    public static final MouseUtil INSTANCE = new MouseUtil();
    private boolean prevState = true;

    public boolean isClicked(int button)
    {
        //if(InputEvent.MOUSE_EVENT_MASK == MOUSE_)
        if(Mouse.isButtonDown(button) && !prevState)
        {
            prevState = true;
            return true;
        }
        else
        {
            prevState = false;
            return false;
        }
    }

    public boolean isReleased(int button)
    {
        if(Mouse.isButtonDown(button) && prevState)
        {
            prevState = false;
            return true;
        }
        else
        {
            prevState = true;
            return false;
        }
    }
}
