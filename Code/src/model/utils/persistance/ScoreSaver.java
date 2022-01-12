package model.utils.persistance;

import model.utils.Score;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreSaver implements ISaver{
    public boolean save(ArrayList<Score> object, String fileLocation) {
        try(var os=new ObjectOutputStream(new FileOutputStream(fileLocation))){
            os.writeObject(object);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
