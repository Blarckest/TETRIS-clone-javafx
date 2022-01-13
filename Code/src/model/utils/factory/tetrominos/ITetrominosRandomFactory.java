package model.utils.factory.tetrominos;

import model.entity.tetrominos.Tetrominos;

/**
 * interface definissant une factory de tetro aleatoire
 */
public interface ITetrominosRandomFactory {
    /**
     * @return un tetro de type aleatoire
     */
    Tetrominos create();
}
