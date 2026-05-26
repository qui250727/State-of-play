package edu.nicolasQuintero.matrixWeb;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InvalidMatrixException, IOException {
        int[][] a = {
                {0,1,0,1,0,0,0,0,0,0},
                {1,0,1,0,0,0,0,0,0,0},
                {0,1,0,1,0,0,0,0,0,0},
                {1,0,1,0,1,0,0,0,0,0},

                {0,0,0,1,0,1,0,0,0,0},

                {0,0,0,0,1,0,1,0,0,0},
                {0,0,0,0,0,1,0,1,0,0},
                {0,0,0,0,0,0,1,0,0,0},

                {0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,1,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        MatrixWorkspace mw = new MatrixWorkspace();
        mw.addMatrix(gm0);
        mw.exportCSV(gm0, "matrixTest.csv");
        Matrix imported = mw.importCSV("matrixTest.csv");
        System.out.println(imported.toString());
        
    }
}
