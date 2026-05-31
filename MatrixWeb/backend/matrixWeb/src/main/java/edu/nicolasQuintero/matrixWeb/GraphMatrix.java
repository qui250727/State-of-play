package edu.nicolasQuintero.matrixWeb;

import java.util.ArrayList;

public class GraphMatrix extends Matrix{
    public boolean isaWeightGraph;

    public GraphMatrix(int[][] data, boolean isaWeightGraph) throws InvalidMatrixException {
        super(data);
        this.isaWeightGraph = isaWeightGraph;
    }

    @Override
    public void validateMatrix(int[][] data) throws InvalidMatrixException {
        super.validateMatrix(data);
        if (data.length != data[0].length) {
            throw new InvalidMatrixException("The matrices must have the same dimentions(same number of rows and columns)");
        }
        for (int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                if(data[i][j]<0){
                    throw new InvalidMatrixException("The values should not be negatives in a GrapMatrix");
                }
            }
        }
    }

    public ArrayList<Integer> extractNodes(){//Integer is an object
        ArrayList<Integer> nodes = new ArrayList<>();
        for(int i = 0; i < getRows();i++){//every row of the graph is a node(it could also work with getColumns because the graph already validate himself)
            nodes.add(i);
        }
        return nodes;
    }

    public boolean hasSelfloops(){
        for(int i = 0;i < getRows();i++){
            if (getData()[i][i]!= 0){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> extractEdges(){//this object list has Strings in
        ArrayList<String> edges = new ArrayList<>();
        for(int i = 0;i < getRows();i++){ //check the rows
            for(int j = 0; j < getColumns();j++){ //check the columns
                if (getData()[i][j]!=0) { //when the columns and the rows hit each other and the result is not 0
                    edges.add(i + " -> " + j); //it prints witch node have a connection with another node(a node could also conect with himself)
                }
            }
        }
        return edges;
    }

    public boolean isDirected(){
        for(int i = 0; i < getRows();i++){
            for(int j = 0; j < getColumns();j++){
                if(getData()[i][j]!=getData()[j][i]){ //if has a connection between a and b but not between b and a is directed.
                    return true;
                }
            }
        }
        return false;
    }

    public int nodeDegree(int node){
        int degree = 0;
        for (int i = 0; i < getRows(); i++){
            if (getData()[i][node]!=0){
                degree ++;
            }
        }
        return degree;
    }

    public ArrayList<Integer> getNeighbors(int node){
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        for (int i = 0; i < getRows(); i++){
            if (getData()[node][i]!=0){
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    public GraphMatrix removeNode(int node) throws InvalidMatrixException{
       int[][] newMatrix = new int[getRows()-1][getColumns()-1];
       int newRow = 0;
       for(int i = 0; i<getRows();i++){
           if(i == node){
               continue;
           }
           int newColumn = 0;
           for (int j = 0;j<getColumns();j++){
               if(j==node){
                   continue;
               }
               newMatrix[newRow][newColumn] = getData()[i][j];
               newColumn++;
           }
           newRow++;
       }
       return new GraphMatrix(newMatrix,false);
    }

    public GraphMatrix removeEdge(int node1, int node2) throws InvalidMatrixException{
        int[][] newMatrix = new int[getRows()][getColumns()];
        for(int i = 0; i<getRows();i++){
            for(int j = 0;j<getColumns();j++){
                newMatrix[i][j]=getData()[i][j];
            }
        }
        newMatrix[node1][node2]=0;
        if(isaWeightGraph==false){
            newMatrix[node2][node1]=0;
        }
        return new GraphMatrix(newMatrix,false);
    }

    public boolean isWeighted(){
        for(int i = 0; i<getRows();i++){
            for (int j = 0;j<getColumns();j++){
                if(getData()[i][j]>1){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (isaWeightGraph){
            return super.toString()+"It is a weight graph.";
        }
        else {
            return super.toString()+"It is NOT a weight graph.";
        }
    }
}
