package edu.nicolasQuintero.matrixWeb;

public class Matrix {
    private int [][] data;

    public Matrix(int[][] data) {
        validateMatrix(data);//Wichtig bei der Konstruktor zu validieren.
        this.data = data;
    }

    public int[][] getData() {
        ;
        return data;
    }

    public void setData(int[][] data) {
        validateMatrix(data);//Methode validation
        this.data = data;
    }

    public void validateMatrix (int[][] data){//Gultigkeit des Matrixes
        if (data == null){
            throw new InvalidMatrixException("Matrix can´t be null");
        }
        if (data.length == 0){
            throw new InvalidMatrixException("Matrix can't be empty");
        }
        int columns = data[0].length;

        for (int i = 0; i < data.length; i++){
            if (data[i].length != columns){
                throw new InvalidMatrixException("Matrix must have always the same number of columns and rows");
            }
        }
    }
}
