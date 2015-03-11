package main.java.rendering;

import main.java.CaveGame;
import main.java.constants.*;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class RenderUtils
{

    public static void updateView()
    {
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GLU.gluLookAt(X.is(), Y.is() + 1.8f, Z.is(), X.is() + XLook.is(), Y.is() + 1.8f + YLook.is(), Z.is() + ZLook.is(), 0, 1, 0);
    }
}