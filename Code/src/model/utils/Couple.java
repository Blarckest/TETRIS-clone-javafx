package model.utils;

public class Couple {
    public int first;
    public int second;
    public Couple(){
        this.first=0;
        this.second=0;
    }
    public Couple(int first, int second){
        this.first=first;
        this.second=second;
    }
    public Couple(Number first, Number second){
        this.first=first.intValue();
        this.second=second.intValue();
    }
}
