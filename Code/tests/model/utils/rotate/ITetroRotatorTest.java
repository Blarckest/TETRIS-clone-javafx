package model.utils.rotate;

import model.entity.tetrominos.TetroI;
import model.entity.tetrominos.Tetrominos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ITetroRotatorTest {
    private Tetrominos tetro = new TetroI();
    private ITetroRotator rotator = new TetroRotator(tetro);

    @Test
    void rotateLeft() {
        var nextShape = tetro.getNextShape();
        rotator.rotateLeft();
        assertArrayEquals(nextShape, tetro.getCurrentShape());
    }

    @Test
    void rotateRight() {
        var precedentShape = tetro.getPrecedentShape();
        rotator.rotateRight();
        assertArrayEquals(precedentShape, tetro.getCurrentShape());
    }
}