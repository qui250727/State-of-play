package edu.nicolasQuintero.matrixWeb;

public class Main {
    public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,1,1,1},
                {1,0,1,0},
                {1,1,0,1},
                {1,1,1,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, true);


        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("nodes: " + gm0.extractNodes());
        System.out.println("node 0 degree:"+gm0.nodeDegree(0));
        System.out.println("node 1 degree:"+gm0.nodeDegree(1));
        System.out.println("node 2 degree:"+gm0.nodeDegree(2));
        System.out.println("node 3 degree:"+gm0.nodeDegree(3));
        System.out.println("edges: " + gm0.extractEdges());
        System.out.println("Has it a selfloop? " + gm0.hasSelfloops());
        System.out.println("Is it directed? " + gm0.isDirected());
    }
}
