package model.utils.rotate;

import model.entity.tetrominos.Tetrominos;

public class TetroRotator implements ITetroRotator{

    @Override
    public void rotateLeft(Tetrominos tetrominos) {
        tetrominos.rotateLeft();
    }

    @Override
    public void rotateRight(Tetrominos tetrominos) {
        tetrominos.rotateRight();
    }
}
