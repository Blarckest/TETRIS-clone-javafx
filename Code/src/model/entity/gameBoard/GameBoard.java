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
    private final Score score;
    private ITetroRotator rotator=new TetroRotator(tetrominos);

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        nextTetrominos=tetrominosRandomFactory.create();
        score=new Score();
    }

    @Override
    public boolean moveTetroDown() {
        Couple p = new Couple(currentOffset);
        p.second+=1;
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

    private void cleanCurrentTetro() {
        //efface le tetro actuel pour ensuite pouvoir le redessiner au bon endroit
        var shape=tetrominos.getCurrentShape();
        for (int i=0;i< shape.length;i++){
            for (int j=0; j<shape[0].length;j++){
                if(shape[j][i]!=null)
                    grid.setAt(currentOffset.second+i,currentOffset.first+j,null);
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
        //currentOffset = new Couple((Math.abs(new Random().nextInt())%(width-4))+4, 0);
        currentOffset = new Couple(5, 0);
        var collision=collider.intersect(tetrominos.getCurrentShape(), currentOffset.first, currentOffset.second);
        if (!collision) {
            mergeTetroToMatrix();
        }
        return collision;
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
        tetrominos.setBlocked();
        new MatrixMerger().merge(grid, tetrominos.getCurrentShape(), currentOffset.first, currentOffset.second);
    }

    @Override
    public void mergeTetroToMatrix() {
        new MatrixMerger().merge(grid, tetrominos.getCurrentShape(), currentOffset.first, currentOffset.second);
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

    @Override
    public Tetrominos getNextTetro() {
        return nextTetrominos;
    }
}