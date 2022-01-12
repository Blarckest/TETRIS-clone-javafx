package model.utils.persistance;

import model.utils.Score;

import java.io.*;
import java.util.ArrayList;

public class ScoreSaver implements ISaver{
    public boolean save(ArrayList<Score> object, String fileLocation) {
        try(var os=new ObjectOutputStream(new FileOutputStream(fileLocation))){
            os.writeObject(object.size());
            for (int i=0;i< object.size();i++){
                os.writeObject(object.get(i).getScore());
                os.writeObject(object.get(i).getDate());
            }
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
