package model.interfaces;

import javafx.scene.image.Image;
import model.utils.Couple;

public interface Isclicer {
    Image getImageAt(Couple couple);
    Image getImageNumber(int index);
}
