package model.utils.collider;

import model.entity.block.BlockAbs;
import model.entity.grid.GridAbs;
import model.entity.tetrominos.Tetrominos;

public interface ICollider {
    boolean intersect(BlockAbs[][] t, int xOffset, int yOffSet);

}
