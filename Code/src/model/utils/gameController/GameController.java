package model.utils.gameController;

import model.entity.gameBoard.GameBoard;
import model.entity.gameBoard.IGameBoard;
import model.utils.event.EventSrc;
import view.GameView;

public class GameController implements IGameController {
    private IGameBoard board = new GameBoard(20, 12);

    private final GameView gameView;

    public GameController(GameView c) {
        gameView = c;
        board.createNewTetro();
        gameView.addListener(this);
        gameView.initGameView(board.getGrid(),board.getNextTetro());
        gameView.bindScore(board.getScore().scoreProperty());
        gameView.refreshGameBackground(board.getGrid());
    }

    @Override
    public void onDownEvent(EventSrc src) {
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
    public void onLeftEvent(EventSrc src) {
        board.moveTetroLeft();
    }

    @Override
    public void onRightEvent(EventSrc src) {
        board.moveTetroRight();
    }

    @Override
    public void onRotateLeftEvent(EventSrc src) {
        board.rotateLeftTetro();
    }

    @Override
    public void onRotateRightEvent(EventSrc src) {
        board.rotateRightTetro();
    }

    @Override
    public void createNewGame() {
        board.newGame();
        gameView.refreshGameBackground(board.getGrid());
    }
}
