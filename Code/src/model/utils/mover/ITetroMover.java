package model.utils.mover;

import model.entity.tetrominos.Tetrominos;

/**
 * classe definissant un deplaceur de tetro
 */
public abstract class ITetroMover implements IMover {
    /**
     * tetro sur lequel effectuer les actions
     */
    protected Tetrominos tetro = null;
}
