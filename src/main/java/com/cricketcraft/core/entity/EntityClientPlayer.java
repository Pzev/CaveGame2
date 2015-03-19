package com.cricketcraft.core.entity;

public class EntityClientPlayer {
    protected float xCoord;
    protected float yCoord;
    protected float zCoord;

    protected float eyeX;
    protected float eyeY;
    protected float eyeZ;

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
        return xCoord;
    }

    public float getyCoord() {
        return yCoord;
    }

    public float getzCoord() {
        return zCoord;
    }

    public float getEyeX() {
        return eyeX;
    }

    public float getEyeY() {
        return eyeY;
    }

    public float getEyeZ() {
        return eyeZ;
    }
}
