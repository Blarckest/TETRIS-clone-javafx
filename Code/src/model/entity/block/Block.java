package model.entity.block;

import javafx.scene.paint.Color;

/**
 * represente d'un block
 */
public class Block extends BlockAbs {
    /**
     * constructeur par defaut d'un block (couleur transparent)
     */
    public Block() {
        super(Color.TRANSPARENT);
    }

    /**
     * conctructeur du block
     *
     * @param color couleur du block
     */
    public Block(Color color) {
        super(color);
    }
}
