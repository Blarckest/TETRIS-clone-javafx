package model.utils.event;

public interface IEventListener {
    void onDownEvent(EventSrc src);

    void onLeftEvent(EventSrc src);

    void onRightEvent(EventSrc src);

    void onRotateLeftEvent(EventSrc src);

    void onRotateRightEvent(EventSrc src);

    void createNewGame();
}
