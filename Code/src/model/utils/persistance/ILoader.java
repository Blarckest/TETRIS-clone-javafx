package model.utils.persistance;

import model.utils.Score;

public interface ILoader {
    Score[] load(String fileLocation);
}
