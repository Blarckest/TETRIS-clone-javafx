package model.utils.collider;

import model.entity.block.BlockAbs;
import model.entity.grid.GridAbs;

/**
 * implementation d'un collider intervenant sur une grid
 */
public record GridCollider(GridAbs grid) implements ICollider {

    @Override
    public boolean intersect(BlockAbs[][] tetro, int columnOffset, int lineOffset) {
        for (int i = 0; i < tetro.length; i++) {
            for (int j = 0; j < tetro[i].length; j++) {
                int column = columnOffset + j;
                int line = lineOffset + i;
                if ((tetro[i][j] != null && checkOutOfBound(line, column)) || ((tetro[i][j] != null && grid.at(line, column) != null && !isSelfColliding(tetro, tetro[i][j])))) {
                    return true;
                } else if (tetro[i][j] != null && grid.at(line, column) != null && !isSelfColliding(tetro, grid.at(line, column))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * permet de tester si une coordonner est hors de la matrice de la grid
     *
     * @param line   ligne a tester
     * @param column colonne a tester
     * @return si le point tester est hors de la grid
     */
    private boolean checkOutOfBound(int line, int column) {
        return line < 0 || column < 0 || line >= grid.lines || column >= grid.columns;
    }

    /**
     * permet de tester si la collision detecter est le tetro qui collisionne avec un de ses blocks
     *
     * @param tetro  tetro a tester
     * @param object block avec qui il y a collision
     * @return si le bloc appartient au tetro donc si le tetro s'est collisionné avec lui meme alors revoit true
     */
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
