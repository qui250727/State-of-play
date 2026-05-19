# Block 1 – Java Matrices

## Description
This block focuses on implementing matrix operations in Java.

## Technologies
- Java
- JUnit

## Learning Goals
- Represent matrices
- Implement operations
- Write tests

---

## Activities

### Activity 1 – Create Java project

#### Objective
Build a clean worksurface for the java project.
#### Glossary
Maven = forma profesional para crear el proyecto
GroupId = quién hizo el proyecto
ArtifactId = cómo se llama el proyecto
Main Class = donde java empieza a correr el codigo
Static = Se puede ejecutar sin crear objetos
#### Explanation
GroupId:

com = commercial
org = organization
net = network
edu = education

#### Code
```java

package edu.nicolasQuintero.matrixWeb;

public class Main {
    public static void main(String[] args) {
        System.out.println("MatrixWeb started");
    }
}

```
#### Example
GroupId = edu.nicolasQuintero
ArtifactId = matrixWeb

### Activity 2 – Matrix class

#### Objective
To create a jJava class that is going to include all the methodes that would be show in the website (frontend).
#### Explanation
This class is the one that allow us to set the data that we will get for the matrix operations and methodes.
#### Code
```java

package edu.nicolasQuintero.matrixWeb;

public class Matrix {
    private int [][] data;

    public Matrix(int[][] data) {
        validateMatrix(data);
        this.data = data;
    }

    public int[][] getData() {
        ;
        return data;
    }

    public void setData(int[][] data) {
        validateMatrix(data);//Methode validation
        this.data = data;
    }

    public void validateMatrix (int[][] data){//Gultigkeit des Matrixes
        if (data == null){
            throw new InvalidMatrixException("Matrix can´t be null");
        }
        if (data.length == 0){
            throw new InvalidMatrixException("Matrix can't be empty");
        }
        int columns = data[0].length;

        for (int i = 0; i < data.length; i++){
            if (data[i].length != columns){
                throw new InvalidMatrixException("Matrix must have always the same number of columns and rows");
            }
        }
    }
}

```

#### Test (Utest)
```java

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
}

```

#### Common Mistakes

#### Notes

#### Project Integration
Base Class for the Project (input validation)

### Activity 3 – Print matrix

#### Objective
To be able to see the matrix with we are going to work
#### Glossary

#### Explanation
We would do a Forloop in order to see every column and row of the matrix 
#### Code
```java

public void printMatrix(){
        for(int i = 0; i < data.length; i++){ // er checkt die Zeilen(filas)
            for(int j = 0; j < data[i].length;j++) { //checkt die Spalten der Zeile
                System.out.print(data[i][j]+" "); //druckt jeder nummer von der selben Linien
            }
            System.out.println();//Springt zur der nächsten Linie
        }
    }

```

#### Test(main)
```java

public class Main {
    public static void main(String[] args) {

        int[][] values = {
                {1, 2},
                {3, 4}
        };

        Matrix m = new Matrix(values);
        m.printMatrix();//Druckmethode probieren
    }
}

```

#### Example
C:\Users\Lenovo\.jdks\openjdk-25.0.2\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2025.3.1\lib\idea_rt.jar=56111" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "F:\INFORMATIK\3BKIF\WMC\State of play\MatrixWeb\backend\matrixWeb\target\classes" edu.nicolasQuintero.matrixWeb.Main
1 2 
3 4 

Process finished with exit code 0
#### Common Mistakes

#### Notes

#### Project Integration
That way we are going to be able to see the matrix
---

### Activity 4 – Get dimensions

#### Objective

#### Glossary

#### Explanation

#### Code
```java

public int getRows(){
        return data.length;
    };

    public int getColumns(){
        return data[0].length;
    };


```

#### Test (Main)
```java

public class Main {
    public static void main(String[] args) {

        int[][] values = {
                {1, 2, 3, 4},
                {3, 4, 5, 6}
        };

        Matrix m = new Matrix(values);
        m.printMatrix();//Druckmethode probieren
        System.out.println("Rows: "+ m.getRows());//getRows
        System.out.println("Columns: "+ m.getColumns());//getColumns
    }
}

```

#### Example
1 2 3 4 
3 4 5 6 
Rows: 2
Columns: 4
#### Common Mistakes

#### Notes

#### Project Integration

GetRows and GetColums will allowd us to create diferent methods for our Matrix-Calculator and to define the Matrix.

### Activity 5 – Addition

### Objective
Start to create basic methods that would allow us to implement other complex methods for the Algorithms. Thats why we implemented a new administration class wo will manage everything what has to do with the graphs.
#### Glossary

#### Explanation
This administration class work with a list of matrices that allow us to get important information throwth basic methods like countMatrix or getMatrix(index) about the same list or list items and to do different operations between themself. 
#### Code new class
```java
package edu.nicolasQuintero.matrixWeb;

import java.util.ArrayList;

public class MatrixWorkspace {
    public ArrayList<Matrix> matrices;

    public MatrixWorkspace() {
        matrices = new ArrayList<>(2);
    }

    public int matrixCount(){
        return matrices.size();
    }

    public void addMatrix(Matrix m){
            matrices.add(m);
    }

    public void removeMatrix(Matrix m){
        matrices.remove(m);
    }

    public Matrix getMatrix(int index){
        return matrices.get(index);
    }

    public Matrix matrixAddition(Matrix a, Matrix b)throws InvalidMatrixException{
        if ((a.getRows() != b.getRows()) || (a.getColumns() != b.getColumns())){
            throw new InvalidMatrixException("The matrices must have the same dimentions");
        }
        int [][] result = new int [a.getRows()][a.getColumns()];
        for (int i = 0; i < a.getRows(); i++){
            for (int j = 0; j < a.getColumns(); j++){
                result [i][j]= a.getData()[i][j]+ b.getData()[i][j];
            }
        }
        return new Matrix(result);
    }

}


```

#### Test(main)
```java

public class Main {
    public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {1,2,3,4},
                {3,4,5,6}
        };
        int[][] b = {
                {1,5,6,7},
                {5,4,5,6}
        };
        MatrixWorkspace mw = new MatrixWorkspace();
        Matrix m0 = new Matrix(a);
        Matrix m1 = new Matrix(b);
        mw.addMatrix(m0);
        mw.addMatrix(m1);
        Matrix result= mw.matrixAddition(m0, m1);
        System.out.println("Matrix m0:");
        m0.printMatrix();//Druckmethode probieren
        System.out.println("Rows: "+ m0.getRows());//getRows
        System.out.println("Columns: "+ m0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("Matrix m1:");
        m1.printMatrix();
        System.out.println("Rows: "+ m1.getRows());
        System.out.println("Columns: "+ m1.getColumns());
        System.out.println("-------------------");
        System.out.println("Matrix Result:");
        result.printMatrix();
        System.out.println("Rows: "+ result.getRows());
        System.out.println("Columns: "+ result.getColumns());
    }
}

```
#### Test (Utest)
```java

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

}

```
#### Example
Matrix m0:
1 2 3 4 
3 4 5 6 
Rows: 2
Columns: 4
-------------------
Matrix m1:
1 5 6 7 
5 4 5 6 
Rows: 2
Columns: 4
-------------------
Matrix Result:
2 7 9 11 
8 8 10 12 
Rows: 2
Columns: 4
#### Common Mistakes

#### Notes
the exceptions where changed to extends Exceptions and not RuntimeExceptions in order to understand more the try, throw, catch, etc.
#### Project Integration
This addition method and the creation of the new class will allow us to understand really how the program works and to create shorter classes that are easy to understand.
---

### Activity 6 – Subtraction
#### Objective

#### Glossary

#### Explanation

#### Code
```java

public Matrix matrixSubstraction(Matrix a, Matrix b)throws InvalidMatrixException{
        if ((a.getRows() != b.getRows()) || (a.getColumns() != b.getColumns())){
            throw new InvalidMatrixException("The matrices must have the same dimentions");
        }
        int [][] result = new int [a.getRows()][a.getColumns()];
        for (int i = 0; i < a.getRows(); i++){
            for (int j = 0; j < a.getColumns(); j++){
                result [i][j]= a.getData()[i][j]- b.getData()[i][j];
            }
        }
        return new Matrix(result);
    }

```

#### Test (Utest)
```java

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

```
#### Test (main)
```java

public class Main {
    public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {1,2,3,4},
                {3,4,5,6}
        };
        int[][] b = {
                {1,5,6,7},
                {5,4,5,6}
        };
        MatrixWorkspace mw = new MatrixWorkspace();
        Matrix m0 = new Matrix(a);
        Matrix m1 = new Matrix(b);
        mw.addMatrix(m0);
        mw.addMatrix(m1);
        Matrix result= mw.matrixSubstraction(m0, m1);
        System.out.println("Matrix m0:");
        m0.printMatrix();//Druckmethode probieren
        System.out.println("Rows: "+ m0.getRows());//getRows
        System.out.println("Columns: "+ m0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("Matrix m1:");
        m1.printMatrix();
        System.out.println("Rows: "+ m1.getRows());
        System.out.println("Columns: "+ m1.getColumns());
        System.out.println("-------------------");
        System.out.println("Matrix Result:");
        result.printMatrix();
        System.out.println("Rows: "+ result.getRows());
        System.out.println("Columns: "+ result.getColumns());
    }
}


```
#### Example
Matrix m0:
1 2 3 4 
3 4 5 6 
Rows: 2
Columns: 4
-------------------
Matrix m1:
1 5 6 7 
5 4 5 6 
Rows: 2
Columns: 4
-------------------
Matrix Result:
0 -3 -3 -3 
-2 0 0 0 
Rows: 2
Columns: 4
#### Common Mistakes

#### Notes
Negative results are valid.
#### Project Integration

---
### Activity 7 – Multiplication 

#### Objective
This is actually the most important operation that we are going to need for our Graph Algorithms, it will allow us to calculate the square matrix and to elevate our matrix in order to find the shorter distance and other important graph values.
#### Glossary

#### Explanation
I order to do this methode we do have to write 3 diferent loops, one that let us advance between the rows and between the columns another to multiplicate them and a last one that add this multiplications in order to create a result in the expected position. In this case, the nomber of rows and columns must be the same or it wont work.
#### Code
```java

public Matrix matrixMultiplication(Matrix a, Matrix b)throws InvalidMatrixException {
        if (a.getColumns() != b.getRows()) {
            throw new InvalidMatrixException("Matrix multiplication not possible");
        }
        int[][] result = new int[a.getRows()][b.getColumns()];
        for (int i = 0; i < a.getRows(); i++) { //it records the rows 
            for (int j = 0; j < b.getColumns(); j++) {//it records the columns
                for (int k = 0; k < a.getColumns(); k++) { //it create the result of the next operation in the correct position
                    result[i][j] = result[i][j] + (a.getData()[i][k] * b.getData()[k][j]);
                }
            }
        }
        return new Matrix(result);
    }

```

#### Test (Utest)
```java

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

```
#### Test (main)
```java

public class Main {
    public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {1,2,3,4},
                {3,4,5,6},
                {1,5,3,4},
                {3,4,3,6}
        };
        int[][] b = {
                {1,5,6,7},
                {5,4,5,6},
                {8,5,6,7},
                {5,4,7,6}
        };
        MatrixWorkspace mw = new MatrixWorkspace();
        Matrix m0 = new Matrix(a);
        Matrix m1 = new Matrix(b);
        mw.addMatrix(m0);
        mw.addMatrix(m1);
        Matrix result= mw.matrixMultiplication(m0, m1);
        System.out.println("Matrix m0:");
        m0.printMatrix();//Druckmethode probieren
        System.out.println("Rows: "+ m0.getRows());//getRows
        System.out.println("Columns: "+ m0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("Matrix m1:");
        m1.printMatrix();
        System.out.println("Rows: "+ m1.getRows());
        System.out.println("Columns: "+ m1.getColumns());
        System.out.println("-------------------");
        System.out.println("Matrix Result:");
        result.printMatrix();
        System.out.println("Rows: "+ result.getRows());
        System.out.println("Columns: "+ result.getColumns());
    }

```
#### Example

Matrix m0:
1 2 3 4 
3 4 5 6 
1 5 3 4 
3 4 3 6 
Rows: 4
Columns: 4
-------------------
Matrix m1:
1 5 6 7 
5 4 5 6 
8 5 6 7 
5 4 7 6 
Rows: 4
Columns: 4
-------------------
Matrix Result:
55 44 62 64 
93 80 110 116 
70 56 77 82 
77 70 98 102 
Rows: 4
Columns: 4

#### Common Mistakes
Write the wrong number of columns or rows
#### Notes

#### Project Integration
All the basic operations for the Graphalgorithms are ready.
---

