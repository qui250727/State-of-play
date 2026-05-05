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
        Matrix m = new Matrix(data);
        assertNotNull(m);
    }
    @Test
    void testValidateMatrixNull() {
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

```

#### Example

#### Common Mistakes

#### Notes

#### Project Integration


### Activity 3 – Constructor and data storage
### Activity 4 – Print matrix
### Activity 5 – Get dimensions
### Activity 6 – Validate matrix
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
