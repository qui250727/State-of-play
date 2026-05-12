package edu.nicolasQuintero.matrixWeb;

public class Matrix {
    private int[][] data;

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

    public void validateMatrix(int[][] data) {//Gultigkeit des Matrixes
        if (data == null) {
            throw new InvalidMatrixException("Matrix can´t be null");
        }
        if (data.length == 0) {
            throw new InvalidMatrixException("Matrix can't be empty");
        }
        int columns = data[0].length;

        for (int i = 0; i < data.length; i++) {
            if (data[i].length != columns) {
                throw new InvalidMatrixException("Matrix must have always the same number of columns and rows");
            }
        }
    };

    public int getRows(){
        return data.length;
    };

    public int getColumns(){
        return data[0].length;
    };

    public void printMatrix(){
        for(int i = 0; i < data.length; i++){ // er checkt die Zeilen(filas)
            for(int j = 0; j < data[i].length;j++) { //checkt die Spalten der Zeile
                System.out.print(data[i][j]+" "); //druckt jeder nummer von der selben Linien
            }
            System.out.println();//Springt zur der nächsten Linie
        }
    }
}
