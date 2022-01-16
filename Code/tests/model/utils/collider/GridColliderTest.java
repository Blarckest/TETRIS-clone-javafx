package model.utils.collider;

import model.entity.block.Block;
import model.entity.block.BlockAbs;
import model.entity.grid.Grid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GridColliderTest {
    private ICollider collider = new GridCollider(new Grid(new BlockAbs[][]{
            {new Block(), new Block(), new Block(), new Block()},
            {new Block(), new Block(), new Block(), new Block()},
            {null, null, null, null},
            {null, null, null, null}}));
    private BlockAbs[][] ezBlock = new BlockAbs[][]{{new Block()}};

    private BlockAbs[][] hardBlock = new BlockAbs[][]{{new Block(), new Block(), new Block()}, {new Block(), new Block(), new Block()}};

    @Test
    void intersect() {
        assertTrue(collider.intersect(ezBlock, 0, 0));//collision
        assertFalse(collider.intersect(ezBlock, 3, 3));//non collision
        assertTrue(collider.intersect(hardBlock, 0, 0));//collision
        assertFalse(collider.intersect(hardBlock, 0, 2));//non collision
        assertTrue(collider.intersect(hardBlock, 20, 80));//collision gros out of bound
        assertTrue(collider.intersect(hardBlock, 0, 3));//collision out of bound
    }
}