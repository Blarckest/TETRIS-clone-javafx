package model.utils.matrix.matrixSlicer;

import model.entity.grid.GridAbs;
import model.utils.Couple;

public interface IMatrixSlicer {
    GridAbs subMat(Couple startPoint, int height, int width);
}
