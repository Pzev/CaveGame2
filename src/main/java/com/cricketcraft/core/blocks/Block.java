package com.cricketcraft.core.blocks;

public class Block
{
    private boolean renderSidesSame = true;
    public int xCoord, yCoord, zCoord;
    private Material material;

    public Block(Material material){
        this.material = material;
    }

    public Material getMaterial(){
        return this.material;
    }

    public void renderSidesSame(boolean renderSides)
    {
        renderSidesSame = renderSides;
    }

    public void setPosition(int x, int y, int z)
    {
        xCoord = x;
        yCoord = y;
        zCoord = z;
    }
}
