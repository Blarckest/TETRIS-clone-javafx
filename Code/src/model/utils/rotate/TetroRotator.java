package model.utils.rotate;

import model.entity.tetrominos.Tetrominos;

public class TetroRotator implements ITetroRotator{
    private final Tetrominos tetrominos;
    public TetroRotator(Tetrominos tetrominos) {
        this.tetrominos = tetrominos;
    }

    @Override
    public void rotateLeft() {
        tetrominos.rotateLeft();
    }

    @Override
    public void rotateRight() {
        tetrominos.rotateRight();
    }
}
