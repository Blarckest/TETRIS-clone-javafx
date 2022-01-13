package model.utils.persistance;

import model.utils.Score;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ScoreSaver implements ISaver{
    public boolean save(ArrayList<Score> object, String fileLocation) {
        try(var os=new ObjectOutputStream(new FileOutputStream(fileLocation))) {
            os.writeObject(object.size());
            for (var score : object) {
                os.writeObject(score.getScore());
                os.writeObject(score.getDate());
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
