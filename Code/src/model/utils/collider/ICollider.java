package model.utils.collider;

import model.entity.block.BlockAbs;

/**
 * interface permettant de specifier les action possible d'un collider
 */
public interface ICollider {
    /**
     * check si le tetro passer en parametre intersecte avec quelque chose
     *
     * @param t       matrice du tetro a tester
     * @param xOffset position du tetro (colonne)
     * @param yOffSet position du tetro (ligne)
     * @return true si la tetro intersecte avec quelque chose
     */
    boolean intersect(BlockAbs[][] t, int xOffset, int yOffSet);

}
