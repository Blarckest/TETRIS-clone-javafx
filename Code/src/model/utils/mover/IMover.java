package model.utils.mover;

/**
 * interface definissant un deplaceur
 */
public interface IMover {
    /**
     * descent le tetro
     */
    void moveDown();

    /**
     * deplace vers la gauche le tetro
     */
    void moveLeft();

    /**
     * deplace vers la gauche le tetro
     */
    void moveRigth();
}
