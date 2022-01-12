package model.utils.persistance;

import model.utils.Score;

import java.util.ArrayList;
import java.util.List;

public interface ISaver {
    boolean save(ArrayList<Score> object, String fileLocation);
}
