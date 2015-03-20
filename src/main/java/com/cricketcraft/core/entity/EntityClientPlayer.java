package com.cricketcraft.core.entity;

import com.cricketcraft.CaveGame;
import com.cricketcraft.core.core.Chunk;

public class EntityClientPlayer {
    protected float xCoord;
    protected float yCoord;
    protected float zCoord;

    protected float eyeX;
    protected float eyeY;
    protected float eyeZ;

    protected int renderDistance = 4;

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

    public int inChunkX()
    {
        return (int) CaveGame.getWorld().thePlayer.xCoord/16;
    }

    public int inChunkZ()
    {
        return (int) CaveGame.getWorld().thePlayer.zCoord/16;
    }

}
