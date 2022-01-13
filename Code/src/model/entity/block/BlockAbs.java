package model.entity.block;

import javafx.scene.paint.Color;
import model.entity.Entity;


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
