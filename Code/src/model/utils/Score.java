package model.utils;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Score implements Serializable {
    private static final  long serialVersionUID =-728081640044068203L;

    //LES PROPERTY SONT PAS SERIALIZABLE

    private int score=0;
    private transient IntegerProperty scoreProperty = new SimpleIntegerProperty(score);

    public int getScoreProperty(){
        scoreProperty();//si jamais l'objet viens d'une serialisation il pourra pas recevoir sa propriete donc on le fait la(voir ci-dessous)
        return scoreProperty.getValue();
    }
    public IntegerProperty scoreProperty() {
        scoreProperty = scoreProperty==null?new SimpleIntegerProperty(score):scoreProperty;//si jamais l'objet viens d'une serialisation il pourra pas recevoir sa propriete donc on le fait la
        return scoreProperty;
    }

    private LocalDateTime date =LocalDateTime.now();
    private transient SimpleObjectProperty<LocalDateTime> dateProperty = new SimpleObjectProperty<>(date);

    public LocalDateTime getDate() {
        dateProperty();//si jamais l'objet viens d'une serialisation il pourra pas recevoir sa propriete donc on le fait la(voir ci-dessous)
        return dateProperty.getValue();
    }
    public ObjectProperty<LocalDateTime> dateProperty() {
        dateProperty= dateProperty==null?new SimpleObjectProperty<>(date):dateProperty;//si jamais l'objet viens d'une serialisation il pourra pas recevoir sa propriete donc on le fait la
        return dateProperty;
    }


    public void add(int i){
        scoreProperty.setValue(scoreProperty.getValue() + i);
    }

    public void reset() {
        scoreProperty.setValue(0);
    }
}
