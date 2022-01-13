package model.utils.collider;

import model.entity.block.BlockAbs;
import model.entity.grid.GridAbs;

public record GridCollider(GridAbs grid) implements ICollider {

    public boolean intersect(BlockAbs[][] tetro, int xOffset, int yOffSet) {
        for (int i = 0; i < tetro.length; i++) {
            for (int j = 0; j < tetro[i].length; j++) {
                int targetX = xOffset + i;
                int targetY = yOffSet + j;
                if ((tetro[i][j] != null && checkOutOfBound(targetX, targetY)) || ((tetro[i][j] != null && grid.at(targetY, targetX) != null && !isSelfColliding(tetro, tetro[i][j])))) {
                    return true;
                } else if (tetro[i][j] != null && grid.at(targetY, targetX) != null && !isSelfColliding(tetro, (BlockAbs) grid.at(targetY, targetX))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkOutOfBound(int targetX, int targetY) {
        return targetX < 0 || targetY < 0 || targetY >= grid.lignes || targetX >= grid.colonnes;
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
