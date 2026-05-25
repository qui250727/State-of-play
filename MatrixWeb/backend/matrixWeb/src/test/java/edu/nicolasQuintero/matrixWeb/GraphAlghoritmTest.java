package edu.nicolasQuintero.matrixWeb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphAlghoritmTest {

    @Test
    void testbfs() throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,0,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[1, 4, 2, 3, 6, 7, 8, 9, 0, 5]", ga.bfs(1).toString());
    }

    @Test
    void testdfs() throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,0,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[1, 4, 7, 6, 3, 5, 0, 2, 9, 8]", ga.dfs(1).toString());
    }

    @Test
    void testShortestPath() throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,0,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[1, 4, 2, 9]", ga.shortestPath(1,9).toString());
    }

    @Test
    void testDistanceMatrx()throws InvalidMatrixException{
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,1,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        String expected =
                "0 3 3 1 2 2 2 3 4 4 \n" +
                "3 0 2 2 1 3 2 2 3 3 \n" +
                "3 2 0 2 1 3 2 2 1 1 \n" +
                "1 2 2 0 1 1 1 2 3 3 \n" +
                "2 1 1 1 0 2 1 1 2 2 \n" +
                "2 3 3 1 2 0 2 3 4 4 \n" +
                "2 2 2 1 1 2 0 2 3 3 \n" +
                "3 2 2 2 1 3 2 0 3 3 \n" +
                "4 3 1 3 2 4 3 3 0 2 \n" +
                "4 3 1 3 2 4 3 3 2 0 \n";
        assertEquals(expected, ga.distanceMatrix().toString());
    }

    @Test
    void testEccentricity()throws InvalidMatrixException {
        int[][] a = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals(4, ga.eccentricity(5));
    }

    @Test
    void testRadius()throws InvalidMatrixException {
        int[][] a = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals(2, ga.radius());
    }

    @Test
    void testCenter()throws InvalidMatrixException {
        int[][] a = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[4]", ga.center().toString());
    }

    @Test
    void testDiameter()throws InvalidMatrixException {
        int[][] a = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals(4, ga.diameter());
    }
}
