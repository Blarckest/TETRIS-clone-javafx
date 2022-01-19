package model.utils.mover;

import model.entity.tetrominos.Tetrominos;

/**
 * implementation d'une classe permettant le deplacement d'un tetro
 */
public class TetroMover extends AbsTetroMover {
    /**
     * @param tetrominos tetrominos sur lequel effectuer les deplacements
     */
    public TetroMover(Tetrominos tetrominos) {
        this.tetro = tetrominos;
    }

    @Override
    public void moveDown() {
        var pos = tetro.getPosition();
        pos.second += 1;
        tetro.setPosition(pos);
    }

    @Override
    public void moveLeft() {
        var pos = tetro.getPosition();
        pos.first -= 1;
        tetro.setPosition(pos);
    }

    @Override
    public void moveRigth() {
        var pos = tetro.getPosition();
        pos.first += 1;
        tetro.setPosition(pos);
    }
}
