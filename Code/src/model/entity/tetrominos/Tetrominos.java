package model.entity.tetrominos;

import javafx.scene.paint.Color;
import model.entity.block.BlockAbs;
import model.utils.CircularList;
import model.utils.Couple;


/**
 * representation d'un tetro
 */
public abstract class Tetrominos {
    /**
     * position actuel du tetro (ligne,colonne)
     */
    private Couple position;
    /**
     * forme actuel du tetro
     */
    private BlockAbs[][] matrix;
    /**
     * liste des formes que peux avoir le tetro
     */
    private CircularList<BlockAbs[][]> shapeMatrix;

    /**
     * type du tetro
     */
    protected TetroType type = TetroType.NaT;
    /**
     * liste de block du tetro
     */
    protected BlockAbs[] blocks;

    /**
     * permet de savoir le type du tetro manipule
     *
     * @return type du tetro
     */
    public TetroType getType() {
        return type;
    }

    /**
     * permet de changer la couleur du tetro
     *
     * @param color nouvelle couleur du tetro
     */
    public void changeColor(Color color) {
        for (var blockLine : matrix)
            for (var block : blockLine) block.setColor(color);
    }

    /**
     * permet de choisir la forme que doit prendre le tetro
     *
     * @param matrix forme que doit prendre le tetro
     */
    protected void setMatrix(BlockAbs[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * permet de definir la liste forme que peux prendre le tetro
     *
     * @param shapeMatrix liste de forme que peux prendre le tetro
     */
    protected void setShapeMatrix(CircularList<BlockAbs[][]> shapeMatrix) {
        this.shapeMatrix = shapeMatrix;
    }

    /**
     * permet de recuperer la forme actuel du tetro
     *
     * @return representation de la forme actuel du tetro
     */
    public BlockAbs[][] getCurrentShape() {
        return matrix;
    }

    /**
     * permet de savoir quelle sera la prochaine forme du tetro
     *
     * @return la forme prochaine du tetro
     */
    public BlockAbs[][] getNextShape() {
        return shapeMatrix.getNextShape();
    }

    /**
     * permet de savoir quelle est la precedente forme du tetro
     *
     * @return la forme precedente du tetro
     */
    public BlockAbs[][] getPrecedentShape() {
        return shapeMatrix.getPrecedentShape();
    }


    /**
     * permet au tetro de passer a sa prochaine forme
     */
    public void goToNextShape() {
        setMatrix(shapeMatrix.next());
    }

    /**
     * permet au tetro de passer a sa precedente forme
     */
    public void goToPrecedentShape() {
        setMatrix(shapeMatrix.precedent());
    }

    /**
     * permet de recuperer la position actuelle du tetro
     *
     * @param position couple(ligne,colonne)
     */
    public void setPosition(Couple position) {
        this.position = position;
    }

    /**
     * permet de modifier la position actuelle du tetro
     *
     * @return couple(ligne, colonne) representant la position actuelle du tetro
     */
    public Couple getPosition() {
        return position;
    }
}
