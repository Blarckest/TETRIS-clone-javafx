package model.utils.collider;

import model.entity.block.BlockAbs;

public interface ICollider {
    boolean intersect(BlockAbs[][] t, int xOffset, int yOffSet);

}
