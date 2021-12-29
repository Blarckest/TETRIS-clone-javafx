package model.entity.block;

import javafx.geometry.Rectangle2D;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import model.entity.Entity;
import model.utils.Couple;

public abstract class BlockAbs extends Entity {
    private final Image image;
    private Color color;
    private final Couple size;
    BlockAbs(String path,Color color, Couple size)
    {
        image=new Image(path);
        this.color=color;
        this.size=size;
    }

    public Color getColor(){
        return color;
    }
    public void setColor(Color newColor){
        color=newColor;
    }

    public Couple getSize() {return size;}

    public Rectangle2D getBoundingRectangle() {
        return new Rectangle2D(getX(),getY(),size.first, size.second);
    }

    //A faire dans un rendu avec une ImageView pour l'image
    public void setFilter(){
        ImageView image1 = new ImageView();
        ColorAdjust filter=new ColorAdjust();
        Blend blend = new Blend(
                BlendMode.MULTIPLY,
                filter,
                new ColorInput(0,0, image1.getFitWidth(), image1.getFitHeight(), color)
        );
        image1.setEffect(blend);

    }
}
