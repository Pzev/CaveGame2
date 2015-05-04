package com.cricketcraft.cavegame.core.util;

import com.cricketcraft.cavegame.core.block.SelectedBlock;
import org.lwjgl.input.Mouse;

public class MouseUtil
{
    public static final MouseUtil INSTANCE = new MouseUtil();
    private static boolean prevState = true;

    public static void isClicked()
    {
        while(Mouse.next()) {
            if (Mouse.getEventButtonState())
            {
                if(Mouse.getEventButton() == 0)
                {
                    SelectedBlock.deleteLookBlock();
                }
                else if(Mouse.getEventButton() == 1)
                {
                    SelectedBlock.placeBlock();
                }
            }
        }
    }

    public static boolean isReleased(int button)
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
