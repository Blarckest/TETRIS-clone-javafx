package model.utils.gameController;

import model.entity.gameBoard.GameBoard;
import model.entity.gameBoard.IGameBoard;
import view.GameView;

public class GameController implements IGameController {
    private IGameBoard board = new GameBoard(20, 12);

    private final GameView gameView;

    public GameController(GameView c) {
        gameView = c;
        board.createNewTetro();
        gameView.initGameView(board.getGrid());
        gameView.bindScore(board.getScore().scoreProperty());
    }

    @Override
    public void onDownEvent() {
        boolean canMove = board.moveTetroDown();
        if (!canMove) {
            board.mergeTetroToBackground();
            int clearedRow = board.clearRows();
            if (clearedRow>0) {
                board.getScore().add(clearedRow*50*clearedRow);
            }
            if (board.createNewTetro()) {
                gameView.gameOver();
            }
            gameView.refreshGameBackground(board.getGrid());
        }
    }

    @Override
    public void onLeftEvent() {
        board.moveTetroLeft();
    }

    @Override
    public void onRightEvent() {
        board.moveTetroRight();
    }

    @Override
    public void onRotateLeftEvent() {
        board.rotateLeftTetro();
    }

    @Override
    public void onRotateRightEvent() {
        board.rotateRightTetro();
    }

    @Override
    public void createNewGame() {
        board.newGame();
        gameView.refreshGameBackground(board.getGrid());
    }
}
