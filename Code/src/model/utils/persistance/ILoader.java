package model.utils.persistance;

import model.utils.Score;

/**
 * interface de classe capable de charger l'etat de l'historique de score
 */
public interface ILoader {
    /**
     * lit dans le fichier passer en parametre l'historique des scores est le renvoie
     *
     * @param fileLocation endroit ou est sauvegarder le fichier
     * @return les scores lu dans le fichier
     */
    Score[] load(String fileLocation);
}
