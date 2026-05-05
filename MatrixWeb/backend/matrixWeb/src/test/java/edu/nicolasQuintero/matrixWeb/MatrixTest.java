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
        Matrix m = new Matrix(data);
        assertNotNull(m);//Alles ist ok
    }
    @Test
    void testValidateMatrixNull() {//
        assertThrows(InvalidMatrixException.class, () -> {
            new Matrix(null);
                });
    }

    @Test
    void testValidateMatrixNotRectangular() {
        int [][] data = {
                {1,2,3},
                {2,3}
        };
        assertThrows(InvalidMatrixException.class, () -> {
            new Matrix(data);
        });
    }

    @Test
    void testValidateMatrixEmpty(){
    int[][] data = {};

    assertThrows(InvalidMatrixException.class, () -> {
    new Matrix(data);
    });
    }
}