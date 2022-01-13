package model.utils.collider;

import model.entity.block.BlockAbs;
import model.entity.grid.GridAbs;

public record GridCollider(GridAbs grid) implements ICollider {

    public boolean intersect(BlockAbs[][] tetro, int xOffset, int yOffSet) {
        for (int i = 0; i < tetro.length; i++) {
            for (int j = 0; j < tetro[i].length; j++) {
                int column = xOffset + i;
                int line = yOffSet + j;
                if ((tetro[i][j] != null && checkOutOfBound(line, column)) || ((tetro[i][j] != null && grid.at(line, column) != null && !isSelfColliding(tetro, tetro[i][j])))) {
                    return true;
                } else if (tetro[i][j] != null && grid.at(line, column) != null && !isSelfColliding(tetro, (BlockAbs) grid.at(line, column))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkOutOfBound(int line, int column) {
        return line < 0 || column < 0 || line >= grid.lines || column >= grid.columns;
    }

    private boolean isSelfColliding(BlockAbs[][] tetro, BlockAbs object) {
        for (var blockAbs : tetro) {
            for (var blockAb : blockAbs) {
                if (blockAb == object)
                    return true;
            }
        }
        return false;
    }
}
