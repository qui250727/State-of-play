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
to be able to read a csv file in order to use it in our program. 
#### Glossary

#### Explanation
this method takes the original csv file and thanks to the Bufferreader and the Filereader check the matrix of the file with a loop and separate the rows with the ";" in order to change ot to a valid Matrix. In order to be able to use the different algorithms or matrix operator, we also create 2 methods that can make a matrix a graphmatrix or a Graphmatrix a matrix.
#### Code
```java

 public Matrix importCSV(String path)throws InvalidMatrixException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(path));
        ArrayList<int[]> rows = new ArrayList<>();
        String line;
        while((line = br.readLine()) != null){
            String[] values = line.split(";");
            int[] row = new int[values.length];
            for(int i =0;i< values.length;i++){
                row[i]= Integer.parseInt(values[i]);
            }
            rows.add(row);
        }
        br.close();
        int[][] data= new int [rows.size()][rows.get(0).length];
        for (int i = 0;i <rows.size();i++){
            data[i]= rows.get(i);
        }
        return new Matrix(data);
    }

    public GraphMatrix matrixToGraph(Matrix m, boolean isWeightGraph) throws InvalidMatrixException{
        return new GraphMatrix(m.getData(), isWeightGraph);
    }

    public Matrix GraphToMatrix(GraphMatrix gm) throws InvalidMatrixException{
        return new Matrix(gm.getData());
    }

```
#### Code (Main)
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
        Matrix imported = mw.importCSV("matrixTest.csv");
        System.out.println(imported.toString());
        
    }

```
#### Example

0 1 0 1 0 0 0 0 0 0 
1 0 1 0 0 0 0 0 0 0 
0 1 0 1 0 0 0 0 0 0 
1 0 1 0 1 0 0 0 0 0 
0 0 0 1 0 1 0 0 0 0 
0 0 0 0 1 0 1 0 0 0 
0 0 0 0 0 1 0 1 0 0 
0 0 0 0 0 0 1 0 0 0 
0 0 0 0 0 0 0 0 0 1 
0 0 0 0 0 0 0 0 1 0 

#### Common Mistakes

#### Notes

#### Project Integration
Now we are ready to start the frontend.
---
---

