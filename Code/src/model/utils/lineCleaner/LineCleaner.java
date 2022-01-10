package model.utils.lineCleaner;

import model.entity.block.BlockAbs;
import model.entity.grid.GridAbs;
import model.utils.Couple;
import model.utils.matrix.MatrixMerger;
import model.utils.matrix.matrixSlicer.MatrixSlicer;

public class LineCleaner implements ILineCleaner {
    private final GridAbs grid;
    public LineCleaner(GridAbs grid){
        this.grid=grid;
    }

    @Override
    public int removeLines() {
        var matrix=grid.matrix;
        int width = matrix.length;
        int lineWidth;
        int clearedRows=0;
        for (int ligne = 0; ligne < matrix.length; ligne++) {
            var rowToClear = true;
            for (int colonne = 0; colonne < matrix[0].length; colonne++) {
                if (matrix[ligne][colonne] == null) {
                    rowToClear = false;
                    break;
                }
            }
            if (rowToClear) {
                clearedRows++;
                for(int i=0;i<grid.lignes;i++){
                    System.out.println("Ligne "+i);
                    for (int j=0;j<grid.colonnes;j++) {
                        System.out.println(grid.matrix[i][j]);

                    }
                }
                System.out.println("Fin de la premiere matrice");
                new MatrixMerger().merge2(grid,ligne);
                //new MatrixMerger().merge(new MatrixSlicer(grid).subMat(new Couple(ligne-1,0),ligne-1, grid.colonnes), (BlockAbs[][]) (new MatrixSlicer(grid).subMat(new Couple(0,0),grid.lignes-ligne, grid.colonnes)).matrix,0,0);
                matrix=grid.matrix;

                for(int i=0;i<grid.lignes;i++){
                    System.out.println("Ligne "+i);
                    for (int j=0;j<grid.colonnes;j++) {
                        System.out.println(grid.matrix[i][j]);

                    }
                }
            }
        }
        return clearedRows;
    }
}
