package model.utils.persistance;

import model.utils.Score;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * implementation d'une classe capable de sauvegarder l'etat de l'historique de score
 */
public class ScoreSaver implements ISaver {
    @Override
    public boolean save(ArrayList<Score> scores, String fileLocation) {
        try (var os = new ObjectOutputStream(new FileOutputStream(fileLocation))) {
            os.writeObject(scores.size());
            for (var score : scores) {
                os.writeObject(score.getScore());
                os.writeObject(score.getDate());
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
