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
    private Color color;

    BlockAbs(Color color)
    {
        this.color=color;
    }

    public Color getColor(){
        return color;
    }
    public void setColor(Color newColor){
        color=newColor;
    }
}
