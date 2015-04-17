package com.cricketcraft.cavegame.core.init;

import com.cricketcraft.cavegame.core.block.Block;
import com.cricketcraft.cavegame.core.block.Material;
import com.cricketcraft.cavegame.core.util.constants.TexturePrefix;

public class Blocks {
    public static Block air;
    public static Block stone;
    public static Block dirt;
    public static Block grass;
    public static Block glass;
    public static Block wood;
    public static Block nul;

    public Blocks(){

    }

    public static void preInit(){
        air = new Block(Material.AIR);
        stone = new Block(Material.STONE);
        dirt = new Block(Material.DIRT);
        grass = new Block(Material.GRASS);
        glass = new Block(Material.GLASS);
        wood = new Block(Material.WOOD);
        nul = new Block(Material.STONE);
    }

    public static void init(){
        nul.setResourceName(TexturePrefix.block + "null.png");
        stone.setResourceName(TexturePrefix.block + "stone.png");
        dirt.setResourceName(TexturePrefix.block + "dirt.png");
        grass.setResourceName(TexturePrefix.block + "grass.png");
    }
}
