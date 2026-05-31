package edu.nicolasQuintero.matrixWeb;

import java.io.*;
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

    public void exportCSV(Matrix m, String path) throws IOException{
        PrintWriter pw = new PrintWriter(new FileWriter(path));
        for (int i = 0; i<m.getRows();i++){
            for(int j = 0; j<m.getColumns();j++){
                pw.print(m.getData()[i][j]);
                if (j<m.getColumns()-1){
                    pw.print(";");
                }
            }
            pw.println();
        }
        pw.close();
    }

    public Matrix importCSV(String path)throws InvalidMatrixException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<int[]> rows = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null){
            String[] values = line.split(";");
            int[] row = new int[values.length];
            for(int i =0;i< values.length;i++){
                try{
                    row[i]= Integer.parseInt(values[i]);
                }
                catch(NumberFormatException e){
                    throw new InvalidMatrixException("CSV contains invalid values");
                }
            }
            rows.add(row);
        }
        br.close();
        if(rows.isEmpty()){
            throw new InvalidMatrixException("CSV file is emty");
        }
        int[][] data= new int [rows.size()][rows.get(0).length];
        for (int i = 0;i <rows.size();i++){
            data[i]= rows.get(i);
        }
        return new Matrix(data);
    }

    public GraphMatrix matrixToGraph(Matrix m, boolean isWeightGraph) throws InvalidMatrixException{
        return new GraphMatrix(m.getData(), isWeightGraph);
    }

    public Matrix GraphToMatrix(GraphMatrix gm) throws InvalidMatrixException{
        return new Matrix(gm.getData());
    }

}
