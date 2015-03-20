package com.cricketcraft.core.blocks;

public class Block
{
    private boolean renderSidesSame = true;
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
