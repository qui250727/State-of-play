package edu.nicolasQuintero.matrixWeb;

public class GraphMatrix extends Matrix{
    public GraphMatrix(int[][] data) throws InvalidMatrixException {
        super(data);
    }

    @Override
    public int[][] getData() {
        return super.getData();
    }

    @Override
    public void setData(int[][] data) throws InvalidMatrixException {
        super.setData(data);
    }

    @Override
    public int getRows() {
        return super.getRows();
    }

    @Override
    public int getColumns() {
        return super.getColumns();
    }

    @Override
    public void printMatrix() {
        super.printMatrix();
    }

    @Override
    public void validateMatrix(int[][] data) throws InvalidMatrixException {
        super.validateMatrix(data);
        if (data.length != data[0].length) {
            throw new InvalidMatrixException("The matrices must have the same dimentions(same number of rows and columns)");
        }
    }
}
