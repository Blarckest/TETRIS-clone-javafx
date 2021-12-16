package model.entity;

import javafx.scene.image.Image;

public abstract class BlockAbs {
    Image image;
    BlockAbs(String path)
    {
        image=new Image(path);
    }
}
