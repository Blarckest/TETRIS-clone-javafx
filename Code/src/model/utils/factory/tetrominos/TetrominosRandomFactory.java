package model.utils.factory.tetrominos;

import model.entity.tetrominos.TetroType;
import model.entity.tetrominos.Tetrominos;

import java.util.Random;

public class TetrominosRandomFactory implements ITetrominosRandomFactory {
    @Override
    public Tetrominos create() {
        int nbGen = new Random().nextInt()%TetroType.values().length;
        return new TetrominosFactory().create(TetroType.values()[nbGen]);
    }
}
