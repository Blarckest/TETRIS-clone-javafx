package model.utils.rotate;

import model.entity.tetrominos.Tetrominos;

public interface ITetroRotator {
    void rotateLeft(Tetrominos tetrominos);
    void rotateRight(Tetrominos tetrominos);
}
