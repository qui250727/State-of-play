package edu.nicolasQuintero.matrixWeb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixWorkspaceTest {

    @Test
    public void testRemoveMatrix() throws InvalidMatrixException {
        MatrixWorkspace mw = new MatrixWorkspace();
        int [][] data = {
                {1,2,3},
                {2,3,5}
        };
        Matrix m = new Matrix(data);
        mw.addMatrix(m);
        assertEquals(1, mw.matrixCount());
        mw.removeMatrix(m);
        assertEquals(0,mw.matrixCount());
    }

    @Test
    public void testMatrixAddition() throws InvalidMatrixException {
        MatrixWorkspace mw = new MatrixWorkspace();
        int [][] a = {
                {1,2,3},
                {2,3,5}
        };
        Matrix m0 = new Matrix(a);
        mw.addMatrix(m0);
        int [][] b = {
                {5,6,7},
                {8,2,1}
        };
        Matrix m1 = new Matrix(b);
        mw.addMatrix(m1);
        Matrix result = mw.matrixAddition(m0,m1);
        assertEquals(6, result.getData()[0][0]);
        assertEquals(8, result.getData()[0][1]);
        assertEquals(10, result.getData()[0][2]);
        assertEquals(10, result.getData()[1][0]);
        assertEquals(5, result.getData()[1][1]);
        assertEquals(6, result.getData()[1][2]);
    }

    @Test
    public void testMatrixSubstraction() throws InvalidMatrixException {
        MatrixWorkspace mw = new MatrixWorkspace();
        int [][] a = {
                {1,2,3},
                {2,3,5}
        };
        Matrix m0 = new Matrix(a);
        mw.addMatrix(m0);
        int [][] b = {
                {5,6,7},
                {8,2,1}
        };
        Matrix m1 = new Matrix(b);
        mw.addMatrix(m1);
        Matrix result = mw.matrixSubstraction(m0,m1);
        assertEquals(-4, result.getData()[0][0]);
        assertEquals(-4, result.getData()[0][1]);
        assertEquals(-4, result.getData()[0][2]);
        assertEquals(-6, result.getData()[1][0]);
        assertEquals(1, result.getData()[1][1]);
        assertEquals(4, result.getData()[1][2]);
    }

    @Test
    public void testMatrixMultiplication() throws InvalidMatrixException {
        MatrixWorkspace mw = new MatrixWorkspace();
        int [][] a = {
                {1,2,3,4},
                {3,4,5,6},
                {1,5,3,4},
                {3,4,3,6}
        };
        Matrix m0 = new Matrix(a);
        mw.addMatrix(m0);
        int [][] b = {
                {1,5,6,7},
                {5,4,5,6},
                {8,5,6,7},
                {5,4,7,6}
        };
        Matrix m1 = new Matrix(b);
        mw.addMatrix(m1);
        Matrix result = mw.matrixMultiplication(m0,m1);
        assertEquals(55, result.getData()[0][0]);
        assertEquals(44, result.getData()[0][1]);
        assertEquals(62, result.getData()[0][2]);
        assertEquals(64, result.getData()[0][3]);
        assertEquals(93, result.getData()[1][0]);
        assertEquals(80, result.getData()[1][1]);
        assertEquals(110, result.getData()[1][2]);
        assertEquals(116, result.getData()[1][3]);
        assertEquals(70, result.getData()[2][0]);
        assertEquals(56, result.getData()[2][1]);
        assertEquals(77, result.getData()[2][2]);
        assertEquals(82, result.getData()[2][3]);
        assertEquals(77, result.getData()[3][0]);
        assertEquals(70, result.getData()[3][1]);
        assertEquals(98, result.getData()[3][2]);
        assertEquals(102, result.getData()[3][3]);

    }
}