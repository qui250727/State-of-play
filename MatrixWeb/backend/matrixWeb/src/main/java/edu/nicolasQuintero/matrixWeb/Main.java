package edu.nicolasQuintero.matrixWeb;

public class Main {
    public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {1,2,3,4},
                {3,4,5,6},
                {1,5,3,4},
                {3,4,3,6}
        };
        int[][] b = {
                {1,5,6,7},
                {5,4,5,6},
                {8,5,6,7},
                {5,4,7,6}
        };
        MatrixWorkspace mw = new MatrixWorkspace();
        Matrix m0 = new Matrix(a);
        Matrix m1 = new Matrix(b);
        mw.addMatrix(m0);
        mw.addMatrix(m1);
        Matrix result= mw.matrixMultiplication(m0, m1);
        System.out.println("Matrix m0:");
        m0.printMatrix();//Druckmethode probieren
        System.out.println("Rows: "+ m0.getRows());//getRows
        System.out.println("Columns: "+ m0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("Matrix m1:");
        m1.printMatrix();
        System.out.println("Rows: "+ m1.getRows());
        System.out.println("Columns: "+ m1.getColumns());
        System.out.println("-------------------");
        System.out.println("Matrix Result:");
        result.printMatrix();
        System.out.println("Rows: "+ result.getRows());
        System.out.println("Columns: "+ result.getColumns());
    }
}
