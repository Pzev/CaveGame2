package com.cricketcraft.core.blocks;

public enum Material {
    AIR(0), STONE(2), DIRT(3), GRASS(4), WOOD(5);

    private int id;

    private Material(int id){
        this.id = id;
    }

    public int getID(){
        return id;
    }
}
