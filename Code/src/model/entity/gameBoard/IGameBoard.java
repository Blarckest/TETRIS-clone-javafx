package model.entity.gameBoard;

import model.entity.block.BlockAbs;
import model.entity.grid.GridAbs;
import model.entity.tetrominos.Tetrominos;
import model.utils.Score;

public interface IGameBoard {
    boolean moveTetroDown();

    boolean moveTetroLeft();

    boolean moveTetroRight();

    boolean rotateLeftTetro();

    boolean rotateRightTetro();

    boolean createNewTetro();

    BlockAbs[][] getBoardMatrix();

    GridAbs getGrid();

    void mergeTetroToBackground();

    void mergeTetroToMatrix();

    int clearRows();

    Score getScore();

    void newGame();

    Tetrominos getNextTetro();
}
