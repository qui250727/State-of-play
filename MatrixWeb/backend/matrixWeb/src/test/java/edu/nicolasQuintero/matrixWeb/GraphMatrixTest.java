package edu.nicolasQuintero.matrixWeb;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GraphMatrixTest {

    @Test
    void testValidateGraphMatrixNotQuadratisch() throws InvalidMatrixException{
        int [][] data = {
                {1,2,3},
                {2,3,3}
        };
        try{
            GraphMatrix gm = new GraphMatrix(data,true );
            fail ("expected InvalidMatrixException");
        }catch(InvalidMatrixException e){
            assertEquals("The matrices must have the same dimentions(same number of rows and columns)",e.getMessage());
        }
    }

    @Test
    void testValidateGraphMatrixNegativeValues() throws InvalidMatrixException{
        int [][] data = {
                {1,2,3},
                {2,3,3},
                {2,3,-2}
        };
        try{
            GraphMatrix gm = new GraphMatrix(data, true);
            fail ("expected InvalidMatrixException");
        }catch(InvalidMatrixException e){
            assertEquals("The values should not be negatives in a GrapMatrix",e.getMessage());
        }
    }

    @Test
    void testValidateGraphMatrixOk() throws InvalidMatrixException {
        int[][] data = {
                {1, 2, 3},
                {2, 3, 5},
                {2, 5, 4}
        };
        try {
            GraphMatrix gm = new GraphMatrix(data, true);
            assertNotNull(gm);
        } catch (InvalidMatrixException e) {
            fail("exception was not expected");
        }
    }

    @Test
    public void testExtractNodes() throws InvalidMatrixException {
        int[][] data = {
                {1, 2, 3},
                {2, 3, 5},
                {2, 5, 4}
        };
        GraphMatrix gm = new GraphMatrix(data, true);
        ArrayList<Integer> nodes = gm.extractNodes();
        assertEquals(3, nodes.size());
        assertEquals(0, nodes.get(0));
        assertEquals(1, nodes.get(1));
        assertEquals(2, nodes.get(2));
    }

    @Test
    public void testHasSelfLoopsTrue() throws InvalidMatrixException {
        int[][] data = {
                {1, 2, 3},
                {2, 3, 5},
                {2, 5, 4}
        };
        GraphMatrix gm = new GraphMatrix(data, true);
        assertEquals(true, gm.hasSelfloops());
    }

    @Test
    public void testHasSelfLoopsFalse() throws InvalidMatrixException {
        int[][] data = {
                {0, 2, 3},
                {2, 0, 5},
                {2, 5, 0}
        };
        GraphMatrix gm = new GraphMatrix(data, true);
        assertEquals(false, gm.hasSelfloops());
    }

    @Test
    public void testExtractEdges() throws InvalidMatrixException {
        int[][] data = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data, true);
        ArrayList<String> edges = gm.extractEdges();
        assertEquals(12, edges.size());
        assertEquals("0 -> 1", edges.get(0));
        assertEquals("0 -> 2", edges.get(1));
        assertEquals("0 -> 3", edges.get(2));
        assertEquals("1 -> 0", edges.get(3));
        assertEquals("1 -> 2", edges.get(4));
        assertEquals("1 -> 3", edges.get(5));
        assertEquals("2 -> 0", edges.get(6));
        assertEquals("2 -> 1", edges.get(7));
        assertEquals("2 -> 3", edges.get(8));
        assertEquals("3 -> 0", edges.get(9));
        assertEquals("3 -> 1", edges.get(10));
        assertEquals("3 -> 2", edges.get(11));
    }

    @Test
    public void testIsDirectTrue() throws InvalidMatrixException {
        int[][] data = {
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {0, 1, 0, 1},
                {0, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data, true);
        assertEquals(true, gm.isDirected());
    }

    @Test
    public void testIsDirectFalse() throws InvalidMatrixException {
        int[][] data = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data, true);
        assertEquals(false, gm.isDirected());
    }

    @Test
    public void testNodeDegree() throws InvalidMatrixException{
        int[][] data = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data, true);
        assertEquals(3, gm.nodeDegree(0));
        assertEquals(3, gm.nodeDegree(1));
        assertEquals(3, gm.nodeDegree(2));
        assertEquals(3, gm.nodeDegree(3));
    }

    @Test
    public void testToStringWeight() throws InvalidMatrixException {
        int[][] data = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data, true);
        String expected =
                "0 1 1 1 \n" +
                "1 0 1 1 \n" +
                "1 1 0 1 \n" +
                "1 1 1 0 \n" +
                "It is a weight graph.";
        assertEquals(expected, gm.toString());
    }

    @Test
    public void testToStringNotWeight() throws InvalidMatrixException {
        int[][] data = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data, false);
        String expected =
                "0 1 1 1 \n" +
                "1 0 1 1 \n" +
                "1 1 0 1 \n" +
                "1 1 1 0 \n" +
                "It is NOT a weight graph.";
        assertEquals(expected, gm.toString());
    }

    @Test
    public void testGetNeighbors() throws InvalidMatrixException{
        int[][] data = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data, false);
        ArrayList<Integer> neighbors0 = gm.getNeighbors(0);
        assertEquals("[1, 2, 3]",neighbors0.toString());
        ArrayList<Integer> neighbors1 = gm.getNeighbors(1);
        assertEquals("[0, 2, 3]",neighbors1.toString());
        ArrayList<Integer> neighbors2 = gm.getNeighbors(2);
        assertEquals("[0, 1, 3]",neighbors2.toString());
        ArrayList<Integer> neighbors3 = gm.getNeighbors(3);
        assertEquals("[0, 1, 2]",neighbors3.toString());
    }

    @Test
    public void testRemoveNode() throws InvalidMatrixException {
        int[][] data = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data, false);
        gm=gm.removeNode(1);
        String expected =
                "0 1 1 \n" +
                "1 0 1 \n" +
                "1 1 0 \n" +
                "It is NOT a weight graph.";
        assertEquals(expected, gm.toString());
    }
}