package com.cricketcraft.core.blocks;

public class Block
{
    private Material material;

    public Block(Material material){
        this.material = material;
    }

    public Material getMaterial(){
        return this.material;
    }

}
