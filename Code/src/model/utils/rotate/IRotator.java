package model.utils.rotate;

import model.entity.tetrominos.Tetrominos;

public interface IRotator {
   void rotateBy(int angle);
   void rotateTo(int angle);
   void rotateLeft(IRotable rotable);
   void rotateRight(IRotable rotable);
}
