package model.utils.gameController;

import javafx.application.Platform;
import model.entity.gameBoard.GameBoard;
import model.entity.gameBoard.IGameBoard;
import model.utils.event.EventSrc;
import model.utils.looper.IObserver;
import view.GameView;

public class GameController implements IGameController, IObserver {
    private IGameBoard board = new GameBoard(20, 12);

    private final GameView gameView;

    public GameController(GameView c) {
        gameView = c;
        board.createNewTetro();
        gameView.addListener(this);
        gameView.initGameView(board.getGrid(),board.getNextTetro());
        gameView.bindScore(board.getScore().scoreProperty());
        refresh();
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
            else{
                Platform.runLater(() -> gameView.setNextTetro(board.getNextTetro()));
            }
            refresh();
        }
        refresh();
    }

    @Override
    public void onLeftEvent(EventSrc src) {
        board.moveTetroLeft();
        refresh();
    }

    @Override
    public void onRightEvent(EventSrc src) {
        board.moveTetroRight();
        refresh();
    }

    @Override
    public void onRotateLeftEvent(EventSrc src) {
        board.rotateLeftTetro();
        refresh();
    }

    @Override
    public void onRotateRightEvent(EventSrc src) {
        board.rotateRightTetro();
        refresh();
    }

    @Override
    public void createNewGame() {
        board.newGame();
        refresh();
    }

    @Override
    public void refresh(){
        gameView.refreshGameBackground(board.getGrid());
    }

    @Override
    public void doAction() {
        onDownEvent(EventSrc.CLOCK);
    }
}
