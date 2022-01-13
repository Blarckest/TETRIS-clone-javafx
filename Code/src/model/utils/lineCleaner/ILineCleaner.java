package model.utils.lineCleaner;

/**
 * interface definissant une classe capable de gerer le nettoyage des lignes a enlever
 */
public interface ILineCleaner {
    /**
     * lance la suppression des lignes a supprimer
     *
     * @return nombre de ligne supprimé
     */
    int removeLines();
}
