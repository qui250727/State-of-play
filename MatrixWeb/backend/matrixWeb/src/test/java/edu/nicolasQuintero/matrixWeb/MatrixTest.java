package edu.nicolasQuintero.matrixWeb;

import  org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MatrixTest {

    @Test
    void testValidateMatrixOk() {
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
    void testValidateMatrixNull() {//
        try{
            new Matrix(null);
            fail ("expected InvalidMatrixexception");
        }catch(InvalidMatrixException e){
            assertEquals("Matrix can´t be null",e.getMessage());
        }
    };

    @Test
    void testValidateMatrixNotRectangular() {
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
    void testValidateMatrixEmpty(){
    int[][] data = {};
    try{
        Matrix m = new Matrix(data);
        fail ("expected InvalidMatrixException");
    }catch(InvalidMatrixException e){
        assertEquals("Matrix can't be empty", e.getMessage());
    }
    }

    @Test
    void TestGetRows() {
        int [][] data = {
                {1,2,3},
                {2,3,5}
        };
        Matrix m = new Matrix(data);
        m.getRows();
        assertEquals(2,m.getRows());
    }

    @Test
    void TestGetColumns() {
        int [][] data = {
                {1,2,3},
                {2,3,5}
        };
        Matrix m = new Matrix(data);
        m.getColumns();
        assertEquals(3,m.getColumns());
    }

    @Test
    void TestAdditionOK() {
        
    }
}