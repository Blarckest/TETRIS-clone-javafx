package model.entity.gameBoard;

import model.entity.block.BlockAbs;
import model.entity.grid.GridAbs;
import model.entity.tetrominos.Tetrominos;
import model.utils.Score;

/**
 * Interface pour creer un game board representant et modifiant le jeu
 */
public interface IGameBoard {
    /**
     * essaye de deplacer le tetro vers le bas
     *
     * @return si le mouvement a pu s'effectuer true sinon false
     */
    boolean moveTetroDown();

    /**
     * essaye de deplacer le tetro vers la gauche
     *
     * @return si le mouvement a pu s'effectuer true sinon false
     */
    boolean moveTetroLeft();

    /**
     * essaye de deplacer le tetro vers la droite
     *
     * @return si le mouvement a pu s'effectuer true sinon false
     */
    boolean moveTetroRight();

    /**
     * essaye de tourner le tetro vers la gauche
     *
     * @return si le mouvement a pu s'effectuer true sinon false
     */
    boolean rotateLeftTetro();

    /**
     * essaye de tourner le tetro vers la droite
     *
     * @return si le mouvement a pu s'effectuer true sinon false
     */
    boolean rotateRightTetro();

    /**
     * essaye de creer un nouveau tetro
     *
     * @return si la creation a pu s'effectuer true sinon false (si plus de place renvera false par exemple)
     */
    boolean createNewTetro();


    /**
     * retourne la matrice de jeu
     *
     * @return matrice representant le plateau de jeu
     */
    BlockAbs[][] getBoardMatrix();

    /**
     * retourne l'objet contenant les infos de la matrice de jeu
     *
     * @return l'objet contenant la matrice du plateau de jeu
     */
    GridAbs getGrid();

    /**
     * ajoute le tetro a la matrice le rendant immuable par la suite
     */
    void mergeTetroToBackground();


    /**
     * ajoute le tetro a la matrice sans le rendre immuable
     */
    void mergeTetroToMatrix();

    /**
     * nettoie la matrice pour enlever les lignes completes
     *
     * @return nombre de lignes supprim&eacute;s
     */
    int clearRows();

    /**
     * retourne le score du joueur
     *
     * @return score actuel du joueur
     */
    Score getScore();

    /**
     * met en place une nouvelle partie
     */
    void newGame();

    /**
     * permet de recuperer le prochain tetro a apparaitre
     *
     * @return prochain tetro a apparaitre
     */
    Tetrominos getNextTetro();
}
