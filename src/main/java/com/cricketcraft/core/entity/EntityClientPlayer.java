package com.cricketcraft.core.entity;

import com.cricketcraft.CaveGame;
import com.cricketcraft.core.core.Chunk;

import static com.cricketcraft.core.utils.constants.BlockInformation.*;

public class EntityClientPlayer {
    protected float xCoord;
    protected float yCoord;
    protected float zCoord;

    protected float eyeX;
    protected float eyeY;
    protected float eyeZ;

    protected int renderDistance = 4;

    protected int chunkXPrevious;
    protected int chunkZPrevious;

    protected int chunkX;
    protected int chunkZ;

    public EntityClientPlayer(float x, float y, float z, float eyeX, float eyeY, float eyeZ){
        this.xCoord = x;
        this.yCoord = y;
        this.zCoord = z;

        this.eyeX = eyeX;
        this.eyeY = eyeY;
        this.eyeZ = eyeZ;
    }

    public void setxCoord(float xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(float yCoord) {
        this.yCoord = yCoord;
    }

    public void setzCoord(float zCoord) {
        this.zCoord = zCoord;
    }

    public void setEyeX(float eyeX) {
        this.eyeX = eyeX;
    }

    public void setEyeY(float eyeY) {
        this.eyeY = eyeY;
    }

    public void setEyeZ(float eyeZ) {
        this.eyeZ = eyeZ;
    }

    public float getxCoord() {
        return this.xCoord;
    }

    public float getyCoord() {
        return this.yCoord;
    }

    public float getzCoord() {
        return this.zCoord;
    }

    public float getEyeX() {
        return this.eyeX;
    }

    public float getEyeY() {
        return this.eyeY;
    }

    public float getEyeZ() {
        return this.eyeZ;
    }

    public void setRenderDistance(int rendDist) {
        this.renderDistance = rendDist;
    }

    public int getRenderDistance() {
        return this.renderDistance;
    }

    public boolean isWithinRenderDistance(int cx, int cz)
    {
        int xLocation = (int) CaveGame.getWorld().thePlayer.xCoord/16;
        int zLocation = (int) CaveGame.getWorld().thePlayer.zCoord/16;
        if((cx < xLocation + renderDistance && cx > xLocation - renderDistance) && (cz < zLocation + renderDistance && cz > zLocation - renderDistance))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void prepChunkData()
    {
        CaveGame.getWorld().thePlayer.chunkX = (int) CaveGame.getWorld().thePlayer.xCoord/16;
        CaveGame.getWorld().thePlayer.chunkZ = (int) CaveGame.getWorld().thePlayer.zCoord/16;
        CaveGame.getWorld().thePlayer.chunkXPrevious = -1;
        CaveGame.getWorld().thePlayer.chunkZPrevious = -1;
    }

    public int getChunkX()
    {
        CaveGame.getWorld().thePlayer.chunkX = (int) CaveGame.getWorld().thePlayer.xCoord/16;
        return CaveGame.getWorld().thePlayer.chunkX;
    }

    public int getChunkZ()
    {
        CaveGame.getWorld().thePlayer.chunkZ = (int) CaveGame.getWorld().thePlayer.zCoord/16;
        return CaveGame.getWorld().thePlayer.chunkZ;
    }

    public int getChunkXPrevious()
    {
        return CaveGame.getWorld().thePlayer.chunkXPrevious;
    }

    public int getChunkZPrevious()
    {
        return CaveGame.getWorld().thePlayer.chunkZPrevious;
    }

    public void setChunkPrevious(int xPrev, int zPrev)
    {
        CaveGame.getWorld().thePlayer.chunkXPrevious = xPrev;
        CaveGame.getWorld().thePlayer.chunkZPrevious = zPrev;
    }

}
