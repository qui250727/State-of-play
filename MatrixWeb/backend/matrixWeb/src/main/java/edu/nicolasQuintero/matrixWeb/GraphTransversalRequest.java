package edu.nicolasQuintero.matrixWeb;

public class GraphTransversalRequest {
    private int[][] matrix;
    private int startNode;

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getStartNode() {
        return startNode;
    }

    public void setStartNode(int startNode) {
        this.startNode = startNode;
    }
}
