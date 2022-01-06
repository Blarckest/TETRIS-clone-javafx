package model.utils.matrixSlicer;

import model.entity.grid.Grid;
import model.utils.Couple;

public interface IMatrixSlicer {
    IGrid subMat(Couple startPoint, int height, int width);
}
