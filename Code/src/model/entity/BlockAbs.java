package model.entity;

import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.ColorInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import model.utils.Couple;

public abstract class BlockAbs {
    private Image image;
    private Color color;
    private Couple center;
    BlockAbs(String path,Color color)
    {
        image=new Image(path);
        this.color=color;
    }



    public Color getColor(){
        return color;
    }
    public void setColor(Color newColor){
        color=newColor;
    }

    public Couple getCenter() {
        return center;
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
