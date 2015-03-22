package com.cricketcraft.core.init;

import com.cricketcraft.core.blocks.Block;
import com.cricketcraft.core.blocks.Material;
import com.cricketcraft.core.utils.constants.TexturePrefix;

public class Blocks {
    public static Block air;
    public static Block stone;
    public static Block dirt;
    public static Block grass;
    public static Block glass;
    public static Block wood;

    public Blocks(){

    }

    public void preInit(){
        air = new Block(Material.AIR);
        stone = new Block(Material.STONE);
        dirt = new Block(Material.DIRT);
        grass = new Block(Material.GRASS);
        glass = new Block(Material.GLASS);
        wood = new Block(Material.WOOD);
    }

    public void init(){
        air.setResourceName(TexturePrefix.block + "null.png");
        stone.setResourceName(TexturePrefix.block + "stone.png");
        dirt.setResourceName(TexturePrefix.block + "dirt.png");
        grass.setResourceName(TexturePrefix.block + "grass.png");
    }
}
