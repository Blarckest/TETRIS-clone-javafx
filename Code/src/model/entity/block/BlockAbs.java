package model.entity.block;

import javafx.scene.paint.Color;


public abstract class BlockAbs {
    private Color color;

    BlockAbs(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color newColor){
        color=newColor;
    }
}
