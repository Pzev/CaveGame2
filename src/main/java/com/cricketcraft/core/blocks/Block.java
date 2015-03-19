package com.cricketcraft.core.blocks;

public class Block
{
    private static boolean renderSidesSame = true;
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
}
