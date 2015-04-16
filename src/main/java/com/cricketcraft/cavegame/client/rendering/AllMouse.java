package com.cricketcraft.cavegame.client.rendering;

import com.cricketcraft.cavegame.CaveGame;
import com.cricketcraft.cavegame.core.util.MouseUtil;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import com.cricketcraft.cavegame.core.block.SelectedBlock;

import static com.cricketcraft.cavegame.core.util.constants.BlockInformation.*;

public class AllMouse
{
    static double tempx1 = PrepDisplay.displayWidth/2, tempy1 = PrepDisplay.displayHeight/2;
    static float yAngle = 90, zAngle = 0;

    public static void look() {
        if(Mouse.isGrabbed()) {

            double tempx = (Mouse.getX());
            double tempy = (Mouse.getY());

            zAngle -= 0.2f * (tempx1-tempx);
            yAngle += 0.2f * (tempy1-tempy);

            if(yAngle < 0.1) yAngle = 0.1f;
            if(yAngle > 179.9) yAngle = 179.9f;

            Mouse.setCursorPosition(PrepDisplay.displayWidth/2, PrepDisplay.displayHeight/2);

            CaveGame.getWorld().thePlayer.setEyeY((float) (Math.cos(yAngle * Math.PI / 180)));
            CaveGame.getWorld().thePlayer.setEyeX((float) (Math.sin(yAngle * Math.PI / 180) * Math.cos(zAngle * Math.PI / 180)));
            CaveGame.getWorld().thePlayer.setEyeZ((float) (Math.sin(yAngle * Math.PI / 180) * Math.sin(zAngle * Math.PI / 180)));

            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GLU.gluLookAt(CaveGame.getWorld().thePlayer.getxCoord(), CaveGame.getWorld().thePlayer.getyCoord() + 1.8f, CaveGame.getWorld().thePlayer.getzCoord(), CaveGame.getWorld().thePlayer.getxCoord() + CaveGame.getWorld().thePlayer.getEyeX(), CaveGame.getWorld().thePlayer.getyCoord() + 1.8f + CaveGame.getWorld().thePlayer.getEyeY(), CaveGame.getWorld().thePlayer.getzCoord() + CaveGame.getWorld().thePlayer.getEyeZ(), 0, 1, 0);

        }
    }



    static float sprint = 1;
    static long temp3=0;
    static int moveLength = 0;
    static int space = 0;
    static int escDown = 0, space2 = 0;

    public static void move() {

        moveLength = (int) (System.nanoTime()/10000000 - temp3);

        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            CaveGame.getWorld().thePlayer.setxCoord((float) (CaveGame.getWorld().thePlayer.getxCoord() + Math.cos(zAngle * Math.PI / 180) * sprint * moveLength));
            CaveGame.getWorld().thePlayer.setzCoord((float) (CaveGame.getWorld().thePlayer.getzCoord() + Math.sin(zAngle * Math.PI / 180) * sprint * moveLength));
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glRotatef(zAngle, 0, 1, 0);
            GL11.glTranslatef(-CaveGame.getWorld().thePlayer.getxCoord(), -CaveGame.getWorld().thePlayer.getyCoord() -1.8F, -CaveGame.getWorld().thePlayer.getzCoord());
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            CaveGame.getWorld().thePlayer.setxCoord((float) (CaveGame.getWorld().thePlayer.getxCoord() - Math.cos(zAngle * Math.PI / 180) * sprint * moveLength));
            CaveGame.getWorld().thePlayer.setzCoord((float) (CaveGame.getWorld().thePlayer.getzCoord() - Math.sin(zAngle * Math.PI / 180) * sprint * moveLength));
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glRotatef(zAngle, 0, 1, 0);
            GL11.glTranslatef(-CaveGame.getWorld().thePlayer.getxCoord(), -CaveGame.getWorld().thePlayer.getyCoord()-1.8f, -CaveGame.getWorld().thePlayer.getzCoord());
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            CaveGame.getWorld().thePlayer.setxCoord((float) (CaveGame.getWorld().thePlayer.getxCoord() + Math.sin(zAngle * Math.PI / 180) * sprint * moveLength));
            CaveGame.getWorld().thePlayer.setzCoord((float) (CaveGame.getWorld().thePlayer.getzCoord() - Math.cos(zAngle * Math.PI / 180) * sprint * moveLength));
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glRotatef(zAngle, 0, 1, 0);
            GL11.glTranslatef(-CaveGame.getWorld().thePlayer.getxCoord(), -CaveGame.getWorld().thePlayer.getyCoord()-1.8f, -CaveGame.getWorld().thePlayer.getzCoord());
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            CaveGame.getWorld().thePlayer.setxCoord((float) (CaveGame.getWorld().thePlayer.getxCoord() - Math.sin(zAngle * Math.PI / 180) * sprint * moveLength));
            CaveGame.getWorld().thePlayer.setzCoord((float) (CaveGame.getWorld().thePlayer.getzCoord() + Math.cos(zAngle * Math.PI / 180) * sprint * moveLength));
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glRotatef(zAngle, 0, 1, 0);
            GL11.glTranslatef(-CaveGame.getWorld().thePlayer.getxCoord(), -CaveGame.getWorld().thePlayer.getyCoord()-1.8f, -CaveGame.getWorld().thePlayer.getzCoord());
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && space==0) {
            CaveGame.getWorld().thePlayer.setyCoord((float) (CaveGame.getWorld().thePlayer.getyCoord() + 0.3 * sprint * moveLength));
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glRotatef(zAngle, 0, 1, 0);
            GL11.glTranslatef(-CaveGame.getWorld().thePlayer.getxCoord(), -CaveGame.getWorld().thePlayer.getyCoord()-1.8f, -CaveGame.getWorld().thePlayer.getzCoord());
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            CaveGame.getWorld().thePlayer.setyCoord((float) (CaveGame.getWorld().thePlayer.getyCoord() - 0.3 * sprint * moveLength));
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glRotatef(zAngle, 0, 1, 0);
            GL11.glTranslatef(-CaveGame.getWorld().thePlayer.getxCoord(), -CaveGame.getWorld().thePlayer.getyCoord()-1.8f, -CaveGame.getWorld().thePlayer.getzCoord());
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
            sprint = 0.02f;
        } else {
            sprint = 0.3f;
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) && escDown == 0) {
            escDown = 1;
            if(space2 == 0) {
                Mouse.setCursorPosition(PrepDisplay.displayWidth/2, PrepDisplay.displayHeight/2);
                Mouse.setGrabbed(true);
                space2 = 1;
            } else if(space2 == 1) {
                Mouse.setGrabbed(false);
                Mouse.setCursorPosition(PrepDisplay.displayWidth/2, PrepDisplay.displayHeight/2);
                space2 = 0;
            }
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE) == false) {
            escDown = 0;
        }


        temp3 = System.nanoTime()/10000000;
    }



    public static void sky(int dist) {

        GL11.glColor4f(0.196f, 0.6f, 0.8f, 1.0f); // blue
        short r = (short) ((CaveGame.getWorld().thePlayer.getRenderDistance() * 16) + 16);

        float thexp = CaveGame.getWorld().thePlayer.getxCoord() + r;
        float theyp = CaveGame.getWorld().thePlayer.getyCoord() + 256;
        float thezp = CaveGame.getWorld().thePlayer.getzCoord() + r;
        float thexn = CaveGame.getWorld().thePlayer.getxCoord() - r;
        float theyn = CaveGame.getWorld().thePlayer.getyCoord() - 256;
        float thezn = CaveGame.getWorld().thePlayer.getzCoord() - r;

        GL11.glBegin(GL11.GL_QUADS); // of the color cube

        // Top-face
        GL11.glVertex3f(thexp, theyp, thezp);
        GL11.glVertex3f(thexn, theyp, thezp);
        GL11.glVertex3f(thexn, theyp, thezn);
        GL11.glVertex3f(thexp, theyp, thezn);

        // Bottom-face
        GL11.glVertex3f(thexp, theyn, thezp);
        GL11.glVertex3f(thexn, theyn, thezp);
        GL11.glVertex3f(thexn, theyn, thezn);
        GL11.glVertex3f(thexp, theyn, thezn);

        // Left-face
        GL11.glVertex3f(thexn, theyn, thezp);
        GL11.glVertex3f(thexn, theyp, thezp);
        GL11.glVertex3f(thexn, theyp, thezn);
        GL11.glVertex3f(thexn, theyn, thezn);

        // Right-face
        GL11.glVertex3f(thexp, theyn, thezp);
        GL11.glVertex3f(thexp, theyp, thezp);
        GL11.glVertex3f(thexp, theyp, thezn);
        GL11.glVertex3f(thexp, theyn, thezn);

        // Front-face
        GL11.glVertex3f(thexp,theyp, thezn);
        GL11.glVertex3f(thexn,theyp, thezn);
        GL11.glVertex3f(thexn, theyn, thezn);
        GL11.glVertex3f(thexp, theyn, thezn);

        // Back-face
        GL11.glVertex3f(thexp, theyp, thezp);
        GL11.glVertex3f(thexn, theyp, thezp);
        GL11.glVertex3f(thexn, theyn, thezp);
        GL11.glVertex3f(thexp, theyn, thezp);

        GL11.glEnd();
    }

    public static void placeBlocks()
    {
        //Deletes blocks left clicked
        if(MouseUtil.INSTANCE.isClicked(0))
        {
            SelectedBlock.deleteLookBlock();
        }

        //Places blocks when right clicked (currently just places stone)
        if(MouseUtil.INSTANCE.isClicked(1))
        {
            SelectedBlock.placeStone();
        }
    }
}
