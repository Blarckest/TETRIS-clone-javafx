package model.utils.rotate;

import model.entity.tetrominos.Tetrominos;

/**
 * implementation d'une classe capable de faire tourner un tetro
 */
public record TetroRotator(Tetrominos tetrominos) implements ITetroRotator {

    @Override
    public void rotateLeft() {
        tetrominos.goToNextShape();
    }

    @Override
    public void rotateRight() {
        tetrominos.goToPrecdentShape();
    }
}
