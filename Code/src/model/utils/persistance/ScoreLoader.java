package model.utils.persistance;

import model.utils.Score;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreLoader implements ILoader {
    @Override
    public ArrayList<Score> load(String fileLocation) {
        try (var is = new ObjectInputStream(new FileInputStream(fileLocation))) {
            return (ArrayList<Score>)is.readObject();
        } catch (Exception e) {
            return null;
        }
    }
}
