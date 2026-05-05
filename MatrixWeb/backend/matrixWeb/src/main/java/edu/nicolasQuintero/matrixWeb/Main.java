package edu.nicolasQuintero.matrixWeb;

public class Main {
    public static void main(String[] args) {

        int[][] values = {
                {1, 2},
                {3, 4}
        };

        Matrix m = new Matrix(values);

        System.out.println("Matrix created successfully");
    }
}
