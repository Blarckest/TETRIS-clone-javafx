package model.utils.event;

/**
 * interface determinant les fonctions a implementer si la classe ecoutent les evenement de l'appli
 */
public interface IEventListener {
    /**
     * effectuer lors d'une demande de descendre le tetro
     *
     * @param src source de l'event
     */
    void onDownEvent(EventSrc src);

    /**
     * effectuer lors d'une demande de deplacer vers la gauche le tetro
     *
     * @param src source de l'event
     */
    void onLeftEvent(EventSrc src);

    /**
     * effectuer lors d'une demande de deplacer vers la droite le tetro
     *
     * @param src source de l'event
     */
    void onRightEvent(EventSrc src);

    /**
     * effectuer lors d'une demande de tourner vers la gauche le tetro
     *
     * @param src source de l'event
     */
    void onRotateLeftEvent(EventSrc src);

    /**
     * effectuer lors d'une demande de tourner vers la droite le tetro
     *
     * @param src source de l'event
     */
    void onRotateRightEvent(EventSrc src);

    /**
     * effectuer lors d'une demande de recommencer le tetro
     */
    void createNewGame();
}
