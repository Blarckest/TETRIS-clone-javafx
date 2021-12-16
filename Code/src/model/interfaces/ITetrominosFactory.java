package model.interfaces;

import model.entity.Tetrominos.TetroType;
import model.entity.Tetrominos.Tetrominos;

public interface ITetrominosFactory {
    public Tetrominos create(TetroType type);
}
