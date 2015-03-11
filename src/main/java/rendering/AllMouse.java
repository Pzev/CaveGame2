package main.java.rendering;

import main.java.CaveGame;
import main.java.constants.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class AllMouse
{

    static double tempx1 = PrepDisplay.displayWidth, tempy1 = PrepDisplay.displayHeight;
    static float yAngle = 90, zAngle = 0;

    public static void look() {
        if(Mouse.isGrabbed()) {

            double tempx = Mouse.getX();
            double tempy = Mouse.getY();

            zAngle -= 0.2f * (int) (tempx1-tempx);
            yAngle += 0.2f * (int) (tempy1-tempy);

            if(yAngle < 0.1) yAngle = 0.1f;
            if(yAngle > 179.9) yAngle = 179.9f;

            Mouse.setCursorPosition((int) tempx1,(int) tempy1);


            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glRotatef( yAngle, 0, 1, 0);
            GL11.glTranslatef(-X.is(), -Y.is()-1.8f, -Z.is());


            YLook.set((float) (Math.cos(yAngle*Math.PI/180)));
            XLook.set((float) (Math.sin(yAngle*Math.PI/180)*Math.cos(zAngle*Math.PI/180)));
            ZLook.set((float) (Math.sin(yAngle*Math.PI/180)*Math.sin(zAngle*Math.PI/180)));


            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GLU.gluLookAt(X.is(), Y.is() + 1.8f, Z.is(), X.is() + XLook.is(), Y.is() + 1.8f + YLook.is(), Z.is() + ZLook.is(), 0, 1, 0);

        }
    }



    static float sprint = 1;
    static int g1 = 0;
    static long temp3=0;
    static int moveLength = 0;
    static int space = 0;
    static int escDown = 0, space2 = 0;

    public static void move() {


        moveLength = (int) (System.nanoTime()/10000000 - temp3);

        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            X.set((float) (X.is() + Math.cos(zAngle*Math.PI/180)*sprint*moveLength));
            Z.set((float) (Z.is() + Math.sin(zAngle*Math.PI/180)*sprint*moveLength));
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glRotatef(zAngle, 0, 1, 0);
            GL11.glTranslatef(-X.is(), -Y.is()-1.8f, -Z.is());
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            X.set((float) (X.is() - Math.cos(zAngle*Math.PI/180)*sprint*moveLength));
            Z.set((float) (Z.is() - Math.sin(zAngle*Math.PI/180)*sprint*moveLength));
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glRotatef(zAngle, 0, 1, 0);
            GL11.glTranslatef(-X.is(), -Y.is()-1.8f, -Z.is());
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            X.set((float) (X.is() + Math.sin(zAngle*Math.PI/180)*sprint*moveLength));
            Z.set((float) (Z.is() - Math.cos(zAngle*Math.PI/180)*sprint*moveLength));
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glRotatef(zAngle, 0, 1, 0);
            GL11.glTranslatef(-X.is(), -Y.is()-1.8f, -Z.is());
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            X.set((float) (X.is() - Math.sin(zAngle*Math.PI/180)*sprint*moveLength));
            Z.set((float) (Z.is() + Math.cos(zAngle*Math.PI/180)*sprint*moveLength));
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glRotatef(zAngle, 0, 1, 0);
            GL11.glTranslatef(-X.is(), -Y.is()-1.8f, -Z.is());
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE) && space==0) {
            Y.set((float) (Y.is() + 0.01));
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glRotatef(zAngle, 0, 1, 0);
            GL11.glTranslatef(-X.is(), -Y.is()-1.8f, -Z.is());
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            Y.set((float) (Y.is() - 0.01));
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glRotatef(zAngle, 0, 1, 0);
            GL11.glTranslatef(-X.is(), -Y.is()-1.8f, -Z.is());
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL)) {
            sprint = 0.02f;
        } else {
            sprint = 0.4f;
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
        short r = (short) (dist*16);

        float thexp = X.is() + r;
        float theyp = Y.is() + 256;
        float thezp = Z.is() + r;
        float thexn = X.is() - r;
        float theyn = Y.is() - 256;
        float thezn = Z.is() - r;

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
}
