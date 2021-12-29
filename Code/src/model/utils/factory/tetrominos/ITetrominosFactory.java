package model.utils.factory.tetrominos;

import model.entity.tetrominos.TetroType;
import model.entity.tetrominos.Tetrominos;

public interface ITetrominosFactory {
    Tetrominos create(TetroType type);
}
