package model.utils.rotate;

import model.entity.tetrominos.Tetrominos;

public record TetroRotator(Tetrominos tetrominos) implements ITetroRotator {

    @Override
    public void rotateLeft() {
        tetrominos.rotateLeft();
    }

    @Override
    public void rotateRight() {
        tetrominos.rotateRight();
    }
}
