package model.utils.factory.tetrominos;

import model.entity.tetrominos.TetroType;
import model.entity.tetrominos.Tetrominos;

/**
 * interface definissant une factory de tetro
 */
public interface ITetrominosFactory {
    /**
     * creer un tetro de type voulu
     *
     * @param type type du tetro a creer
     * @return le tetro nouvellement creer
     */
    Tetrominos create(TetroType type);
}
