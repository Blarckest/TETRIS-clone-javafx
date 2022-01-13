package model.utils.gameController;

import model.utils.event.IEventListener;


/**
 * interface definnissant un game controller
 */
public interface IGameController extends IEventListener {
    /**
     * fait la demande a la vue de se rafraichir pour prendre en compte de nouveau changement
     */
    void refresh();
}
