# Block 4 – Input / Output (CSV)

## Description
Reading adjacency matrices from CSV files.

## Technologies
- Java

## Learning Goals
- File handling
- Parsing
- Validation

---

## Template

#### Objective

#### Glossary

#### Explanation

#### Code
```java
```

#### Example

#### Common Mistakes

#### Notes

#### Project Integration

---

## Activities

### Activity 26 – Read CSV file

#### Objective
to be able to export a matrix as a csv file
#### Glossary

#### Explanation
We use the MatrixWorkspace in order to create a method who exports a matrix as a csv file. In order to do it we use a printwriter and a filewriter that uses a loop who checks the matrix and separate the columns of every node with a ";"
#### Code 
```java

public void exportCSV(Matrix m, String path) throws IOException{
        PrintWriter pw = new PrintWriter(new FileWriter(path));
        for (int i = 0; i<m.getRows();i++){
            for(int j = 0; j<m.getColumns();j++){
                pw.print(m.getData()[i][j]);
                if (j<m.getColumns()-1){
                    pw.print(";");
                }
            }
            pw.println();
        }
        pw.close();
    }

```

#### Code (main)
```java

public class Main {
    public static void main(String[] args) throws InvalidMatrixException, IOException {
        int[][] a = {
                {0,1,0,1,0,0,0,0,0,0},
                {1,0,1,0,0,0,0,0,0,0},
                {0,1,0,1,0,0,0,0,0,0},
                {1,0,1,0,1,0,0,0,0,0},

                {0,0,0,1,0,1,0,0,0,0},

                {0,0,0,0,1,0,1,0,0,0},
                {0,0,0,0,0,1,0,1,0,0},
                {0,0,0,0,0,0,1,0,0,0},

                {0,0,0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0,1,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        MatrixWorkspace mw = new MatrixWorkspace();
        mw.addMatrix(gm0);
        mw.exportCSV(gm0, "matrixTest.csv");
    }

```

#### Example
0;1;0;1;0;0;0;0;0;0
1;0;1;0;0;0;0;0;0;0
0;1;0;1;0;0;0;0;0;0
1;0;1;0;1;0;0;0;0;0
0;0;0;1;0;1;0;0;0;0
0;0;0;0;1;0;1;0;0;0
0;0;0;0;0;1;0;1;0;0
0;0;0;0;0;0;1;0;0;0
0;0;0;0;0;0;0;0;0;1
0;0;0;0;0;0;0;0;1;0
#### Common Mistakes

#### Notes

#### Project Integration
now we are able to export a csv file with a matrix, what can be usefull in the frontend later and also to test the import method.
---

### Activity 27 – Impot CSV

#### Objective

#### Glossary

#### Explanation

#### Code
```java
```

#### Example

#### Common Mistakes

#### Notes

#### Project Integration

---
---

