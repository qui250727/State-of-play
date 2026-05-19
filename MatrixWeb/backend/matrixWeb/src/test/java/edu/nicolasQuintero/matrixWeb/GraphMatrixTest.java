package edu.nicolasQuintero.matrixWeb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphMatrixTest {

    @Test
    void testValidateGraphMatrixNotQuadratisch() throws InvalidMatrixException{
        int [][] data = {
                {1,2,3},
                {2,3,3}
        };
        try{
            GraphMatrix gm = new GraphMatrix(data);
            fail ("expected InvalidMatrixException");
        }catch(InvalidMatrixException e){
            assertEquals("The matrices must have the same dimentions(same number of rows and columns)",e.getMessage());
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
            GraphMatrix gm = new GraphMatrix(data);
            assertNotNull(gm);
        } catch (InvalidMatrixException e) {
            fail("exception was not expected");
        }
    }
}