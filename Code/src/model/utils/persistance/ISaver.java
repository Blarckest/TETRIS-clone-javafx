package model.utils.persistance;

import model.utils.Score;

import java.util.ArrayList;

/**
 * interface de classe capable de sauvegarder l'etat de l'historique de score
 */
public interface ISaver {
    /**
     * sauvegarde dans le fichier passer en parametre les scores passer en parametre
     *
     * @param scores       endroit ou est sauvegarder le fichier
     * @param fileLocation endroit ou est sauvegarder le fichier
     * @return si la sauvegarde a reussi
     */
    boolean save(ArrayList<Score> scores, String fileLocation);
}

