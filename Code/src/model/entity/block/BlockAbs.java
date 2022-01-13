package model.entity.block;

import javafx.scene.paint.Color;


/**
 * representation abstraite d'un block
 */
public abstract class BlockAbs {
    private Color color;

    BlockAbs(Color color) {
        this.color = color;
    }

    /**
     * permet d'obtenir la couleur du block
     *
     * @return couleur du block
     */
    public Color getColor() {
        return color;
    }

    /**
     * permet de donner une couleur au bloc
     *
     * @param newColor couleur a donner au block
     */
    public void setColor(Color newColor) {
        color = newColor;
    }
}
