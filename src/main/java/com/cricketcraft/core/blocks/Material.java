package com.cricketcraft.core.blocks;

import org.lwjgl.opengl.GL11;

public enum Material {
    AIR(0), STONE(2), DIRT(3), GRASS(4), WOOD(5);

    private int id;

    private Material(int id){
        this.id = id;
    }

    public int getID(){
        return id;
    }

    public void color()
    {
        if(this.getID() == 0)
        {
            GL11.glColor4f(0, 0, 0, 0);
        }
        else if(this.getID() == 1)
        {
            GL11.glColor4f(0, 0, 0, 0);
        }
        else if(this.getID() == 2)
        {
            GL11.glColor4f(0.69f, 0.69f, 0.7f, 1.0f);
        }
        else if(this.getID() == 3)
        {
            GL11.glColor4f(0.3f, 0.2f, 0.2f, 1.0f);
        }
        else if(this.getID() == 4)
        {
            GL11.glColor4f(0.4f, 0.8f, 0.4f, 1.0f);
        }
        else if(this.getID() == 5)
        {
            GL11.glColor4f(0.4f, 0.28f, 0.4f, 1.0f);
        }

    }
}
