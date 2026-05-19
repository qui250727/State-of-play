package edu.nicolasQuintero.matrixWeb;

import java.util.ArrayList;

public class MatrixWorkspace {
    public ArrayList<Matrix> matrices;

    public MatrixWorkspace() {
        matrices = new ArrayList<>(2);
    }

    public int matrixCount(){
        return matrices.size();
    }

    public void addMatrix(Matrix m){
            matrices.add(m);
    }

    public void removeMatrix(Matrix m){
        matrices.remove(m);
    }

    public Matrix getMatrix(int index){
        return matrices.get(index);
    }

    public Matrix matrixAddition(Matrix a, Matrix b)throws InvalidMatrixException{
        if ((a.getRows() != b.getRows()) || (a.getColumns() != b.getColumns())){
            throw new InvalidMatrixException("The matrices must have the same dimentions");
        }
        int [][] result = new int [a.getRows()][a.getColumns()];
        for (int i = 0; i < a.getRows(); i++){
            for (int j = 0; j < a.getColumns(); j++){
                result [i][j]= a.getData()[i][j]+ b.getData()[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix matrixSubstraction(Matrix a, Matrix b)throws InvalidMatrixException{
        if ((a.getRows() != b.getRows()) || (a.getColumns() != b.getColumns())){
            throw new InvalidMatrixException("The matrices must have the same dimentions");
        }
        int [][] result = new int [a.getRows()][a.getColumns()];
        for (int i = 0; i < a.getRows(); i++){
            for (int j = 0; j < a.getColumns(); j++){
                result [i][j]= a.getData()[i][j]- b.getData()[i][j];
            }
        }
        return new Matrix(result);
    }

    public Matrix matrixMultiplication(Matrix a, Matrix b)throws InvalidMatrixException {
        if (a.getColumns() != b.getRows()) {
            throw new InvalidMatrixException("Matrix multiplication not possible");
        }
        int[][] result = new int[a.getRows()][b.getColumns()];
        for (int i = 0; i < a.getRows(); i++) { //it records the rows
            for (int j = 0; j < b.getColumns(); j++) {//it records the columns
                for (int k = 0; k < a.getColumns(); k++) { //it create the result of the next operation in the correct position
                    result[i][j] = result[i][j] + (a.getData()[i][k] * b.getData()[k][j]);
                }
            }
        }
        return new Matrix(result);
    }

}
