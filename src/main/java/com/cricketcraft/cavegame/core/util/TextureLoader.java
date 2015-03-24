package com.cricketcraft.cavegame.core.util;

import com.cricketcraft.cavegame.CaveGame;
import org.lwjgl.opengl.GL11;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Hashtable;

public class TextureLoader {
    private HashMap table = new HashMap();
    private ColorModel glAlphaColorModel;
    private ColorModel glColorModel;

    public TextureLoader(){
        glAlphaColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[] {8, 8, 8, 8}, true, false, ComponentColorModel.TRANSLUCENT, DataBuffer.TYPE_BYTE);
        glColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[] {8, 8, 8, 0}, false, false, ComponentColorModel.OPAQUE, DataBuffer.TYPE_BYTE);
    }

    private int createTextureID(){
        IntBuffer intBuffer = createIntBuffer(1);
        GL11.glGenTextures(intBuffer);
        return intBuffer.get(0);
    }

    public Texture getTexture(String resourceName) throws IOException{
        Texture texture = (Texture) table.get(resourceName);

        if(texture != null){
            return texture;
        }

        texture = getTexture(resourceName, GL11.GL_TEXTURE_2D, GL11.GL_RGBA, GL11.GL_LINEAR, GL11.GL_LINEAR);
        table.put(resourceName, texture);
        return texture;
    }

    public Texture getTexture(String resourceName, int target, int dstPixelFormat, int minFilter, int magFilter) throws IOException{
        int srcPixelFormat = 0;
        int textureID = createTextureID();
        Texture texture = new Texture(target, textureID);
        GL11.glBindTexture(target, textureID);
        BufferedImage bufferedImage = loadImage(resourceName);
        texture.setWidth(bufferedImage.getWidth());
        texture.setHeight(bufferedImage.getHeight());

        if(bufferedImage.getColorModel().hasAlpha()){
            srcPixelFormat = GL11.GL_RGBA;
        } else {
            srcPixelFormat = GL11.GL_RGB;
        }

        ByteBuffer byteBuffer = convertImageData(bufferedImage, texture);

        if(target == GL11.GL_TEXTURE_2D) {
            GL11.glTexParameteri(target, GL11.GL_TEXTURE_MIN_FILTER, minFilter);
            GL11.glTexParameteri(target, GL11.GL_TEXTURE_MAG_FILTER, magFilter);
        }
        GL11.glTexImage2D(target, 0, dstPixelFormat, get2Fold(bufferedImage.getWidth()), get2Fold(bufferedImage.getHeight()), 0, srcPixelFormat, GL11.GL_UNSIGNED_BYTE, byteBuffer);
        return texture;
    }

    private int get2Fold(int fold){
        int ret = 2;
        while (ret < fold){
            ret *= 2;
        }
        return  ret;
    }

    private ByteBuffer convertImageData(BufferedImage bufferedImage, Texture texture){
        ByteBuffer imageBuffer = null;
        WritableRaster raster;
        BufferedImage texImage;

        int texWidth = 2;
        int texHeight = 2;

        while(texWidth < bufferedImage.getWidth()){
            texWidth *= 2;
        }

        while(texHeight < bufferedImage.getHeight()){
            texHeight *= 2;
        }

        texture.setTextureHeight(texHeight);
        texture.setTextureWidth(texWidth);

        if(bufferedImage.getColorModel().hasAlpha()){
            raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE, texWidth, texHeight, 4, null);
            texImage = new BufferedImage(glAlphaColorModel, raster, false, new Hashtable());
        } else {
            raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE, texWidth, texHeight, 3, null);
            texImage = new BufferedImage(glColorModel, raster, false, new Hashtable());
        }

        Graphics g = texImage.getGraphics();
        g.setColor(new Color(0F, 0F, 0F, 0F));
        g.fillRect(0, 0, texWidth, texHeight);
        g.drawImage(bufferedImage, 0, 0, null);

        byte[] data = ((DataBufferByte) texImage.getRaster().getDataBuffer()).getData();

        imageBuffer = ByteBuffer.allocateDirect(data.length);
        imageBuffer.order(ByteOrder.nativeOrder());
        imageBuffer.put(data, 0, data.length);
        imageBuffer.flip();

        return imageBuffer;
    }

    private BufferedImage loadImage(String ref) throws IOException{
        URL url = CaveGame.class.getClassLoader().getResource(ref);

        if(url == null){
            throw new IOException("Cannot find: " + ref);
        }

        BufferedImage bufferedImage = ImageIO.read(new BufferedInputStream(CaveGame.class.getClassLoader().getResourceAsStream(ref)));
        return bufferedImage;
    }

    protected IntBuffer createIntBuffer(int size){
        ByteBuffer temp = ByteBuffer.allocateDirect(4 * size);
        temp.order(ByteOrder.nativeOrder());

        return temp.asIntBuffer();
    }
}
