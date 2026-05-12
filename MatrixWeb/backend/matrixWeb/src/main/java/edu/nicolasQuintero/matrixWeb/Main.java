package edu.nicolasQuintero.matrixWeb;

public class Main {
    public static void main(String[] args) {

        int[][] values = {
                {1, 2, 3, 4},
                {3, 4, 5, 6}
        };

        Matrix m = new Matrix(values);
        m.printMatrix();//Druckmethode probieren
        System.out.println("Rows: "+ m.getRows());//getRows
        System.out.println("Columns: "+ m.getColumns());//getColumns
    }
}
