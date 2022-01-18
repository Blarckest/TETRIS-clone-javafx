package model.entity.gameBoard;

import model.entity.block.BlockAbs;
import model.entity.grid.Grid;
import model.entity.grid.GridAbs;
import model.entity.tetrominos.Tetrominos;
import model.utils.Couple;
import model.utils.Score;
import model.utils.collider.GridCollider;
import model.utils.collider.ICollider;
import model.utils.factory.tetrominos.ITetrominosRandomFactory;
import model.utils.factory.tetrominos.TetrominosRandomFactory;
import model.utils.lineCleaner.LineCleaner;
import model.utils.matrixOperator;
import model.utils.rotate.ITetroRotator;
import model.utils.rotate.TetroRotator;

import java.util.Random;

public class GameBoard implements IGameBoard {
    private final ITetrominosRandomFactory tetrominosRandomFactory;
    private GridAbs grid;
    private ICollider collider;
    private Tetrominos tetrominos;
    private Tetrominos nextTetrominos;
    private Couple currentOffset;
    private final Score score;
    private ITetroRotator rotator;

    public GameBoard(int lines, int columns) {
        grid = new Grid(lines, columns);
        tetrominosRandomFactory = new TetrominosRandomFactory();
        collider = new GridCollider(grid);
        rotator = new TetroRotator(tetrominos);
        nextTetrominos = tetrominosRandomFactory.create();
        score = new Score();
    }

    @Override
    public boolean moveTetroDown() {
        Couple p = new Couple(currentOffset);
        p.second += 1;
        boolean conflict = collider.intersect(tetrominos.getCurrentShape(), p.first, p.second);
        if (conflict) {
            return false;
        } else {
            cleanCurrentTetro();
            currentOffset = p;
            mergeTetroToMatrix();
            return true;
        }
    }


    /**
     * efface le tetro actuel pour pouvoir le deplacer une case plus bas
     */
    private void cleanCurrentTetro() {
        //efface le tetro actuel pour ensuite pouvoir le redessiner au bon endroit
        var shape = tetrominos.getCurrentShape();
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (shape[i][j] != null)
                    grid.setAt(currentOffset.second + i, currentOffset.first + j, null);
            }
        }
    }

    @Override
    public boolean moveTetroLeft() {
        Couple p = new Couple(currentOffset);
        p.first-=1;
        boolean conflict = collider.intersect(tetrominos.getCurrentShape(), p.first, p.second);
        if (conflict) {
            return false;
        } else {
            cleanCurrentTetro();
            currentOffset = p;
            mergeTetroToMatrix();
            return true;
        }
    }

    @Override
    public boolean moveTetroRight() {
        Couple p = new Couple(currentOffset);
        p.first+=1;
        boolean conflict = collider.intersect(tetrominos.getCurrentShape(), p.first, p.second);
        if (conflict) {
            return false;
        } else {
            cleanCurrentTetro();
            currentOffset = p;
            mergeTetroToMatrix();
            return true;
        }
    }

    @Override
    public boolean rotateLeftTetro() {
        var nextShape = tetrominos.getNextShape();
        boolean conflict = collider.intersect(nextShape, currentOffset.first, currentOffset.second);
        if (conflict) {
            return false;
        } else {
            cleanCurrentTetro();
            rotator.rotateLeft();
            mergeTetroToMatrix();
            return true;
        }
    }

    @Override
    public boolean rotateRightTetro() {
        var precedentShape = tetrominos.getPrecedentShape();
        boolean conflict = collider.intersect(precedentShape, currentOffset.first, currentOffset.second);
        if (conflict) {
            return false;
        } else {
            cleanCurrentTetro();
            rotator.rotateRight();
            mergeTetroToMatrix();
            return true;
        }
    }

    @Override
    public boolean createNewTetro() {
        tetrominos = nextTetrominos;
        nextTetrominos = tetrominosRandomFactory.create();
        rotator = new TetroRotator(tetrominos);
        for (int i = 0; i < new Random().nextInt(3); i++) {
            rotator.rotateLeft();
        }
        currentOffset = new Couple((Math.abs(new Random().nextInt()) % (grid.columns - tetrominos.getCurrentShape().length - 1)), 0);
        var collision = collider.intersect(tetrominos.getCurrentShape(), currentOffset.first, currentOffset.second);
        if (!collision) {
            mergeTetroToMatrix();
        }
        return collision;
    }

    @Override
    public BlockAbs[][] getBoardMatrix() {
        return grid.matrix;
    }

    @Override
    public GridAbs getGrid() {
        return grid;
    }

    @Override
    public void mergeTetroToBackground() {
        new matrixOperator().merge(grid, tetrominos.getCurrentShape(), currentOffset.first, currentOffset.second);
    }

    @Override
    public void mergeTetroToMatrix() {
        new matrixOperator().merge(grid, tetrominos.getCurrentShape(), currentOffset.first, currentOffset.second);
    }

    @Override
    public int clearRows() {
        return new LineCleaner(grid).removeLines();
    }

    @Override
    public Score getScore() {
        return score;
    }

    @Override
    public void newGame() {
        grid = new Grid(grid.lines, grid.columns);
        collider = new GridCollider(grid);
        score.reset();
        createNewTetro();
    }

    @Override
    public Tetrominos getNextTetro() {
        return nextTetrominos;
    }
}