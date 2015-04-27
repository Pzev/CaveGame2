package com.cricketcraft.cavegame.core.util;

import com.cricketcraft.cavegame.core.block.SelectedBlock;
import org.lwjgl.input.Mouse;

import java.applet.Applet;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseUtil extends Applet implements MouseListener
{
    public static final MouseUtil INSTANCE = new MouseUtil();

    public void initListener()
    {
        addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(Mouse.isButtonDown(0))
        {
            SelectedBlock.deleteLookBlock();
        }
        if(Mouse.isButtonDown(0))
        {
            SelectedBlock.placeStone();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
