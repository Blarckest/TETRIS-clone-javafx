package model.entity.Factory;

import model.entity.Tetrominos.*;
import model.interfaces.ITetrominosFactory;

public class TetrominosFactory implements ITetrominosFactory {

    @Override
    public Tetrominos create(TetroType type) {
        switch (type) {
            case NaT -> {
                return null;
            }
            case I -> {
                return new TetroI();
            }
            case J -> {
                return new TetroJ();
            }
            case L -> {
                return new TetroL();
            }
            case O -> {
                return new TetroO();
            }
            case S -> {
                return new TetroS();
            }
            case T -> {
                return new TetroT();
            }
            case Z -> {
                return new TetroZ();
            }
        }
        return null;
    }
}
