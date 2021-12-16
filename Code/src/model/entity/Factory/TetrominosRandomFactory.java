package model.entity.Factory;

import model.entity.Tetrominos.TetroType;
import model.entity.Tetrominos.Tetrominos;
import model.interfaces.ITetrominosRandomFactory;

import java.util.Random;
import java.util.stream.IntStream;

public class TetrominosRandomFactory implements ITetrominosRandomFactory {
    @Override
    public Tetrominos create() {
        int nbGen = new Random().nextInt()%TetroType.values().length;
        return new TetrominosFactory().create(TetroType.values()[nbGen]);
    }
}
