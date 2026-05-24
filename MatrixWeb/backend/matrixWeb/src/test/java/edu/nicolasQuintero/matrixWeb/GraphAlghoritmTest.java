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
}
