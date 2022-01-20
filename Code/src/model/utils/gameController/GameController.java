package model.utils.gameController;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import launch.Launcher;
import model.entity.gameBoard.GameBoard;
import model.entity.gameBoard.IGameBoard;
import model.utils.event.EventSrc;
import model.utils.looper.IObserver;
import view.GameView;

/**
 * implementation d'un game controller
 */
public class GameController implements IGameController, IObserver {
    private final IGameBoard board = new GameBoard(20, 12);
    private final BooleanProperty isGameOver = new SimpleBooleanProperty(false);
    private final GameView gameView;

    /**
     * construit un GameController interagissant avec la vue passer en parametre
     *
     * @param c controlleur de la vue
     */
    public GameController(GameView c) {
        gameView = c;
        board.createNewTetro();
        gameView.addListener(this);
        gameView.initGameView(board.getGrid(), board.getNextTetro());
        gameView.bindScore(board.getScore().getScoreProperty());
        gameView.bindGameOver(isGameOver);
        refresh();
    }

    @Override
    public void onDownEvent(EventSrc src) {
        boolean canMove = board.moveTetroDown();
        if (!canMove) {
            board.mergeTetroToBackground();
            int clearedRow = board.clearRows();
            if (clearedRow>0) {
                board.getScore().add(clearedRow * 100 * clearedRow);
            }
            if (board.createNewTetro()) {
                Platform.runLater(() -> Launcher.scoreHistoryManager.add(board.getScore()));
                isGameOver.setValue(true);
            } else {
                Platform.runLater(() -> gameView.setNextTetro(board.getNextTetro()));
            }
            refresh();
        }
        if (src == EventSrc.USER) {
            board.getScore().add(1);
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
