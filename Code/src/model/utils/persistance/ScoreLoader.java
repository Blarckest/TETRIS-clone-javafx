package model.utils.persistance;

import model.utils.Score;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;

/**
 * implementation d'une classe capable de charger l'etat de l'historique de score
 */
public class ScoreLoader implements ILoader {
    @Override
    public Score[] load(String fileLocation) {
        try (var is = new ObjectInputStream(new FileInputStream(fileLocation))) {
            int nbScore = (int) is.readObject();
            Score[] arr = new Score[nbScore];
            for (int i = 0; i < nbScore; i++) {
                arr[i] = new Score((Integer) is.readObject(), (LocalDateTime) is.readObject());
            }
            return arr;
        } catch (Exception e) {
            return null;
        }
    }
}
