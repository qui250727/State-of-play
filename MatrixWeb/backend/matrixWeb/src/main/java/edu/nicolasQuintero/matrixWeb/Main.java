package edu.nicolasQuintero.matrixWeb;

public class Main {
    public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,1,0,1,0,0,0,0,0,0},
                {1,0,1,0,0,0,0,0,0,0},
                {0,1,0,1,0,0,0,0,0,0},
                {1,0,1,0,1,0,0,0,0,0},

                {0,0,0,1,0,1,0,0,0,0},

                {0,0,0,0,1,0,1,0,0,0},
                {0,0,0,0,0,1,0,1,0,0},
                {0,0,0,0,0,0,1,0,0,0},

                {0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,1,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);

        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("Distance Matrix:");
        System.out.println(ga.distanceMatrix());
        System.out.println("Components:");
        System.out.println(ga.components());
        System.out.println("Radius: "+ ga.radiuses());
        System.out.println("Diameter: "+ ga.diameters());
        System.out.println("Center: "+ ga.center());
        System.out.println("Articulations: "+ga.articulations());
        System.out.println("Bridges: "+ga.bridges() );

    }
}
