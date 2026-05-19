package edu.nicolasQuintero.matrixWeb;

import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MatrixTest {

    @Test
    void testValidateMatrixOk() throws InvalidMatrixException{
        int [][] data = {
            {1,2,3},
            {2,3,5}
        };
        try {
            Matrix m = new Matrix(data);
            assertNotNull(m);
        }catch(InvalidMatrixException e){
            fail("exception was not expected");
        }
    }
    @Test
    void testValidateMatrixNull() throws InvalidMatrixException {//
        try{
            new Matrix(null);
            fail ("expected InvalidMatrixexception");
        }catch(InvalidMatrixException e){
            assertEquals("Matrix can´t be null",e.getMessage());
        }
    };

    @Test
    void testValidateMatrixNotRectangular() throws InvalidMatrixException{
        int [][] data = {
                {1,2,3},
                {2,3}
        };
        try{
            Matrix m = new Matrix(data);
            fail ("expected InvalidMatrixException");
        }catch(InvalidMatrixException e){
            assertEquals("Matrix must have always the same number of columns and rows",e.getMessage());
        }
    }

    @Test
    void testValidateMatrixEmpty() throws InvalidMatrixException{
    int[][] data = {};
    try{
        Matrix m = new Matrix(data);
        fail ("expected InvalidMatrixException");
    }catch(InvalidMatrixException e){
        assertEquals("Matrix can't be empty", e.getMessage());
    }
    }

    @Test
    void TestGetRows() throws InvalidMatrixException {
        int [][] data = {
                {1,2,3},
                {2,3,5}
        };
        Matrix m = new Matrix(data);
        m.getRows();
        assertEquals(2,m.getRows());
    }

    @Test
    void TestGetColumns() throws InvalidMatrixException {
        int [][] data = {
                {1,2,3},
                {2,3,5}
        };
        Matrix m = new Matrix(data);
        m.getColumns();
        assertEquals(3,m.getColumns());
    }
}