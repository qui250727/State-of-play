package edu.nicolasQuintero.matrixWeb;

public class Main {
    public static void main(String[] args) {

        int[][] a = {
                {1, 2, 3, 4},
                {3, 4, 5, 6}
        };
        int[][] b = {
                {1, 5, 6, 7},
                {3, 5, 5, 8}
        };
        Matrix m1 = new Matrix(a);
        Matrix m2 = new Matrix(b);
        m1.printMatrix();
        System.out.println("Matrix 1");
        System.out.println("Rows: "+ m1.getRows());//getRows
        System.out.println("Columns: "+ m1.getColumns());//getColumns

        m2.printMatrix();
        System.out.println("Matrix 2");
        System.out.println("Rows: "+ m2.getRows());//getRows
        System.out.println("Columns: "+ m2.getColumns());//getColumns

        Matrix resultAddition = m1.addition(m2);
        System.out.println("Result Addition Matrix:");
        resultAddition.printMatrix();
    }
}
