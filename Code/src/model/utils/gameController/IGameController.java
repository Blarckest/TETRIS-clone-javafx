package model.utils.gameController;

public interface IGameController {
    void onDownEvent();

    void onLeftEvent();

    void onRightEvent();

    void onRotateLeftEvent();

    void onRotateRightEvent();

    void createNewGame();
}
