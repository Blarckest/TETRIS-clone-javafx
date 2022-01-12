package model.utils.persistance;

import model.utils.Score;

import java.util.List;

public interface ILoader {
    List<Score> load(String fileLocation);
}
