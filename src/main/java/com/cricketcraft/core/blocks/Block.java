package com.cricketcraft.core.blocks;

public class Block
{
    private Material material;
    private String resourceName;

    public Block(Material material){
        this.material = material;
    }

    public Material getMaterial(){
        return this.material;
    }

    public String getResourceName(){
        return this.resourceName;
    }

    public void setResourceName(String name){
        this.resourceName = name;
    }

}
