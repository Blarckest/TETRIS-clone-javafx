package model.utils;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import model.interfaces.Isclicer;

import java.nio.IntBuffer;

/*CETTE CLASSE VA ETRE UNE HORREUR*/
public class Slicer implements Isclicer {
    Couple objectSize;
    Couple imageSize;
    int spaceBetweenObj;
    Image image;
    PixelReader reader;
    public Slicer(String uri, int widthOfObj, int heightOfObj, int spaceBetweenObj){
        image=new Image(uri);
        imageSize=new Couple(image.getWidth(),image.getHeight());
        objectSize=new Couple(widthOfObj,heightOfObj);
        this.spaceBetweenObj=spaceBetweenObj;
        reader= image.getPixelReader();
    }
    @Override
    public Image getImageAt(Couple couple) {
        //c dla merde
        final int i = objectSize.first * objectSize.second;
        int[] buffer=new int[i];
        //reader.getPixels(couple.first, couple.second, objectSize.first,objectSize.second, new WritablePixelFormat<IntBuffer>(),buffer,0,0);
        return null;
    }

    @Override
    public Image getImageNumber(int index) {
        return null;
    }
}
