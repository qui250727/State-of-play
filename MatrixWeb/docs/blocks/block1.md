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

## Template

#### Objective

#### Glossary

#### Explanation

#### Code
```java
```

#### Test
```java
```

#### Example

#### Common Mistakes

#### Notes

#### Project Integration

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

### Activity 7 – Addition
### Activity 8 – Test addition
### Activity 9 – Subtraction
### Activity 10 – Test subtraction
### Activity 11 – Multiplication (theory)
### Activity 12 – Multiplication (implementation)
### Activity 13 – Test multiplication
### Activity 14 – Transpose
### Activity 15 – Test transpose
### Activity 16 – Scalar multiplication
### Activity 17 – Test scalar
### Activity 18 – Validations
### Activity 19 – Exceptions
### Activity 20 – Refactor

---
