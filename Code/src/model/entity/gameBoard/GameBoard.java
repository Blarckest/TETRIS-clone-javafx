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
import model.utils.matrix.MatrixMerger;
import model.utils.rotate.ITetroRotator;
import model.utils.rotate.TetroRotator;

import java.util.Random;

public class GameBoard implements IGameBoard{
    private final int width;
    private final int height;
    private final ITetrominosRandomFactory tetrominosRandomFactory=new TetrominosRandomFactory();
    private GridAbs grid = new Grid(20,12);
    private final ICollider collider=new GridCollider(grid);
    private Tetrominos tetrominos;
    private Tetrominos nextTetrominos;
    private Couple currentOffset;
    private Score score;
    private ITetroRotator rotator=new TetroRotator(tetrominos);

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean moveTetroDown() {
        Couple p = new Couple(currentOffset);
        p.second+=1;
        boolean conflict = collider.intersect(tetrominos.getCurrentShape(), p.first, p.second);
        if (conflict) {
            return false;
        } else {
            currentOffset = p;
            return true;
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
            currentOffset = p;
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
            currentOffset = p;
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
            rotator.rotateLeft(tetrominos);
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
            rotator.rotateRight(tetrominos);
            return true;
        }
    }

    @Override
    public boolean createNewTetro() {
        tetrominos=nextTetrominos;
        nextTetrominos = tetrominosRandomFactory.create();
        rotator=new TetroRotator(tetrominos);
        currentOffset = new Couple((new Random().nextInt()%(width-4))+4, 0);
        return collider.intersect(tetrominos.getCurrentShape(), currentOffset.first, currentOffset.second);
    }

    @Override
    public BlockAbs[][] getBoardMatrix() {
        return (BlockAbs[][]) grid.matrix;
    }

    @Override
    public GridAbs getGrid() {
        return grid;
    }

    @Override
    public void mergeTetroToBackground() {
        new MatrixMerger().merge(grid, new Grid(tetrominos.getCurrentShape()), currentOffset.first, currentOffset.second);
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
        grid=new Grid(20,12);
        score.reset();
        createNewTetro();
    }
}