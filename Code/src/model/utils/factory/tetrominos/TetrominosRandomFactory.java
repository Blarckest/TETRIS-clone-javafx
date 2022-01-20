package model.utils.factory.tetrominos;

import model.entity.tetrominos.TetroType;
import model.entity.tetrominos.Tetrominos;

import java.util.Random;

/**
 * implementation d'une factory de tetro aleatoire
 */
public class TetrominosRandomFactory implements ITetrominosRandomFactory {
    @Override
    public Tetrominos create() {
        int nbGen = Math.abs(new Random().nextInt()) % (TetroType.values().length - 1);
        return new TetrominosFactory().create(TetroType.values()[nbGen + 1]); //+1 pour eviter de tirer un NaT
    }
}
