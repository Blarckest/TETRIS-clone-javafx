package model.utils.scoreHistory;

import javafx.beans.property.ListProperty;
import javafx.collections.ObservableList;
import model.utils.Score;

import java.util.List;

/**
 * interface definissant une classe permettant de gerer un historique de score
 */
public interface IScoreHistoryManager {
    /**
     * recharge la sauvegarde
     */
    void reload();

    /**
     * sauvegarde l'historique de score
     *
     * @return true si la sauvegarde a reussi false sinon
     */
    boolean save();

    /**
     * permet de recuperer l'historique sous forme de score
     *
     * @return l'historique de score sous forme de list
     */
    List<Score> getScores();

    /**
     * permet de recuperer la propriete javafx contenant l'historique de score
     *
     * @return la propriete javafx contenant l'historique de score
     */
    ListProperty<Score> getScoresProperty();

    /**
     * @param order specifie l'ordre dans lequel trier les scores
     * @return une observableList contenant l'historique de score
     */
    ObservableList<Score> getByOrder(OrderBy order);

    /**
     * permet l'ajout d'un score a l'historique
     *
     * @param score score a ajouter a l'historique
     */
    void add(Score score);
}
