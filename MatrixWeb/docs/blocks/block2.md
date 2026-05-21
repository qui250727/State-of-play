# Block 2 – Graph Fundamentals (Java)

## Description
This block introduces graphs using adjacency matrices.

## Technologies
- Java

## Learning Goals
- Understand graphs
- Extract nodes and edges
- Identify graph types

---

## Activities

### Activity 8 – GraphMatrix Class

#### Objective
Create a subclass from Matrix that is a valid Matrix but has his owns qualities that validate himself and is also able to participate in the methods of the MatrixWorkspace
#### Glossary

#### Explanation

####  Code
```java

package edu.nicolasQuintero.matrixWeb;

public class GraphMatrix extends Matrix{
    public GraphMatrix(int[][] data) throws InvalidMatrixException {
        super(data);
    }

    @Override
    public void validateMatrix(int[][] data) throws InvalidMatrixException {
        super.validateMatrix(data);
        if (data.length != data[0].length) {
            throw new InvalidMatrixException("The matrices must have the same dimentions(same number of rows and columns)");
        }
        for (int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                if(data[i][j]<0){
                    throw new InvalidMatrixException("The values should not be negatives in a GrapMatrix");
                }
            }
        }
    }
}

```
#### Test (Utest)
```java

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
    void testValidateGraphMatrixNegativeValues() throws InvalidMatrixException{
        int [][] data = {
                {1,2,3},
                {2,3,3},
                {2,3,-2}
        };
        try{
            GraphMatrix gm = new GraphMatrix(data);
            fail ("expected InvalidMatrixException");
        }catch(InvalidMatrixException e){
            assertEquals("The values should not be negatives in a GrapMatrix",e.getMessage());
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

```
#### Example

#### Common Mistakes

#### Notes

#### Project Integration
This will be the class that will specify the propierties from a graph matrix.
---

### Activity  9 – Extract nodes

#### Objective

#### Glossary

#### Explanation

####  Code
```java

public ArrayList<Integer> extractNodes(){//Integer is an object
        ArrayList<Integer> nodes = new ArrayList<>();
        for(int i = 0; i < getRows();i++){//every row of the graph is a node(it could also work with getColumns because the graph already validate himself)
            nodes.add(i);
        }
        return nodes;
    }

```
#### Test (Utest)
```java

@Test
    public void testExtractNodes() throws InvalidMatrixException {
        int[][] data = {
                {1, 2, 3},
                {2, 3, 5},
                {2, 5, 4}
        };
        GraphMatrix gm = new GraphMatrix(data);
        ArrayList<Integer> nodes = gm.extractNodes();
        assertEquals(3, nodes.size());
        assertEquals(0, nodes.get(0));
        assertEquals(1, nodes.get(1));
        assertEquals(2, nodes.get(2));
    }

```
#### Test (Main)
```java

public class Main {
    public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {1,2,3,4},
                {3,4,5,6},
                {1,5,3,4},
                {3,4,3,6}
        };
        GraphMatrix gm0 = new GraphMatrix(a);

        System.out.println("GraphMatrix gm0:");
        gm0.printMatrix();//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("nodes:" + gm0.extractNodes());
    }

```
#### Example

GraphMatrix gm0:
1 2 3 4 
3 4 5 6 
1 5 3 4 
3 4 3 6 
Rows: 4
Columns: 4
-------------------
nodes:[0, 1, 2, 3]

#### Common Mistakes

#### Notes

#### Project Integration

---

### Activity 10 – Extract edges

#### Objective
With this Method we will able to see witch node conects with another one or with him self by checking every cell. 
#### Glossary

#### Explanation
Where the number is not 0. To identify if a node conect with his self we have a hasSelfloops method also.
####  Code
```java

 public boolean hasSelfloops(){ //A node conects with himself
        for(int i = 0;i < getRows();i++){
            if (getData()[i][i]!= 0){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> extractEdges(){//this object list has Strings in
        ArrayList<String> edges = new ArrayList<>();
        for(int i = 0;i < getRows();i++){ //check the rows
            for(int j = 0; j < getColumns();j++){ //check the columns
                if (getData()[i][j]!=0) { //when the columns and the rows hit each other and the result is not 0
                    edges.add(i + " -> " + j); //it print witch node have a conection with another node(a node could also conect with himself)
                }
            }
        }
        return edges;
    }
```
#### Test (Utest)
```java

@Test
    public void testHasSelfLoopsFalse() throws InvalidMatrixException {
        int[][] data = {
                {0, 2, 3},
                {2, 0, 5},
                {2, 5, 0}
        };
        GraphMatrix gm = new GraphMatrix(data);
        assertEquals(false, gm.hasSelfloops());
    }

    @Test
    public void testExtractEdges() throws InvalidMatrixException {
        int[][] data = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data);
        ArrayList<String> edges = gm.extractEdges();
        assertEquals(12, edges.size());
        assertEquals("0 -> 1", edges.get(0));
        assertEquals("0 -> 2", edges.get(1));
        assertEquals("0 -> 3", edges.get(2));
        assertEquals("1 -> 0", edges.get(3));
        assertEquals("1 -> 2", edges.get(4));
        assertEquals("1 -> 3", edges.get(5));
        assertEquals("2 -> 0", edges.get(6));
        assertEquals("2 -> 1", edges.get(7));
        assertEquals("2 -> 3", edges.get(8));
        assertEquals("3 -> 0", edges.get(9));
        assertEquals("3 -> 1", edges.get(10));
        assertEquals("3 -> 2", edges.get(11));
    }
}

```
#### Test (Main)
```java

public class Main {
    public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,1,1,1},
                {1,0,1,1},
                {1,1,0,1},
                {1,1,1,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a);

        System.out.println("GraphMatrix gm0:");
        gm0.printMatrix();//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("nodes: " + gm0.extractNodes());
        System.out.println("edges: " + gm0.extractEdges());
        System.out.println("Has it a selfloop?: " + gm0.hasSelfloops());
    }
}

```
#### Example

GraphMatrix gm0:
0 1 1 1 
1 0 1 1 
1 1 0 1 
1 1 1 0 
Rows: 4
Columns: 4
-------------------
nodes: [0, 1, 2, 3]
edges: [0 -> 1, 0 -> 2, 0 -> 3, 1 -> 0, 1 -> 2, 1 -> 3, 2 -> 0, 2 -> 1, 2 -> 3, 3 -> 0, 3 -> 1, 3 -> 2]
Has it a selfloop?: false

#### Common Mistakes

#### Notes

#### Project Integration
Now we can see the relation between every node(also with himself)
---

### Activity 11 – Directed vs undirected

#### Objective
To define if the graph is directed or not, becasuse some algorithms work just with directed graphs.
#### Glossary

#### Explanation
A directed graph would have a conection between a and b but you can just go from a to b, it is not posible to go to the other direction. Even if there ist just one edge with this condition, the graph would be directed. 
####  Code
```java

public boolean isDirected(){
        for(int i = 0; i < getRows();i++){
            for(int j = 0; j < getColumns();j++){
                if(getData()[i][j]!=getData()[j][i]){ //if has a conection between a and b but not between b and a is directed.
                    return true;
                }
            }
        }
        return false;
    }

```
#### Test (Utest)
```java

@Test
    public void testIsDirectTrue() throws InvalidMatrixException {
        int[][] data = {
                {0, 1, 1, 1},
                {0, 0, 1, 1},
                {0, 1, 0, 1},
                {0, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data);
        assertEquals(true, gm.isDirected());
    }

    @Test
    public void testIsDirectFalse() throws InvalidMatrixException {
        int[][] data = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data);
        assertEquals(false, gm.isDirected());
    }

```
#### Test (Main)
```java

public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,1,1,1},
                {0,0,1,1},
                {0,1,0,1},
                {1,1,1,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a);

        System.out.println("GraphMatrix gm0:");
        gm0.printMatrix();//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("nodes: " + gm0.extractNodes());
        System.out.println("edges: " + gm0.extractEdges());
        System.out.println("Has it a selfloop? " + gm0.hasSelfloops());
        System.out.println("Is it directed? " + gm0.isDirected());
    }

```
#### Example

GraphMatrix gm0:
0 1 1 1 
0 0 1 1 
0 1 0 1 
1 1 1 0 
Rows: 4
Columns: 4
-------------------
nodes: [0, 1, 2, 3]
edges: [0 -> 1, 0 -> 2, 0 -> 3, 1 -> 2, 1 -> 3, 2 -> 1, 2 -> 3, 3 -> 0, 3 -> 1, 3 -> 2]
Has it a selfloop? false
Is it directed? true

#### Common Mistakes

#### Notes

#### Project Integration
there are Algorithms that just can be used by directed Graphs.
---

### Activity 12 – Node degrees

#### Objective
The node degrees indicate how many vertices has a node in a graph. That would be really usefull in the future algorithms like TFS and DFS.
#### Glossary

#### Explanation
The method nodeDegree look for every node how many vertices are not 0 and it counts it in every node.
####  Code
```java

public int nodeDegree(int node){
        int degree = 0;
        for (int i = 0; i < getRows(); i++){
            if (getData()[i][node]!=0){
                degree ++;
            }
        }
        return degree;
    }

```
#### Test (Utest)
```java

@Test
    public void testNodeDegree() throws InvalidMatrixException{
        int[][] data = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data);
        assertEquals(3, gm.nodeDegree(0));
        assertEquals(3, gm.nodeDegree(1));
        assertEquals(3, gm.nodeDegree(2));
        assertEquals(3, gm.nodeDegree(3));
    }

```
#### Test (Main)
```java

public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,1,1,1},
                {1,0,1,0},
                {1,1,0,1},
                {1,1,1,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a);

        System.out.println("GraphMatrix gm0:");
        gm0.printMatrix();//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("nodes: " + gm0.extractNodes());
        System.out.println("node 0 degree:"+gm0.nodeDegree(0));
        System.out.println("node 1 degree:"+gm0.nodeDegree(1));
        System.out.println("node 2 degree:"+gm0.nodeDegree(2));
        System.out.println("node 3 degree:"+gm0.nodeDegree(3));
        System.out.println("edges: " + gm0.extractEdges());
        System.out.println("Has it a selfloop? " + gm0.hasSelfloops());
        System.out.println("Is it directed? " + gm0.isDirected());
    }

```
#### Example

GraphMatrix gm0:
0 1 1 1 
1 0 1 0 
1 1 0 1 
1 1 1 0 
Rows: 4
Columns: 4
-------------------
nodes: [0, 1, 2, 3]
node 0 degree:3
node 1 degree:3
node 2 degree:3
node 3 degree:2
edges: [0 -> 1, 0 -> 2, 0 -> 3, 1 -> 0, 1 -> 2, 2 -> 0, 2 -> 1, 2 -> 3, 3 -> 0, 3 -> 1, 3 -> 2]
Has it a selfloop? false
Is it directed? true

#### Common Mistakes

#### Notes

#### Project Integration
This Method will allow us to find out diferent propierties that are important for the Algorithms.
---

### Activity 13 – Weighted graphs

#### Objective
In order to see the difference betweet to typ of graph it is better to add to the class the feature isaWeightGraph as boolean.
#### Glossary

#### Explanation
We change the printMatrix methode to a toSting methode because that way we would be able to heritage this methode to the subclass GraphMatrix and change it so that it can see the difference between a weigh graph and a not weight graph.
####  Code (Matrix class)
```java

@Override
    public String toString() {
        String content = "";
        for(int i = 0; i < data.length; i++) { // er checkt die Zeilen(filas)
            for (int j = 0; j < data[i].length; j++) { //checkt die Spalten der Zeile
                content = content + data[i][j] + " ";
            }
            content = content + "\n";
        }
        return content;
    }

```
####  Code (GraphMatrix class)
```java

@Override
    public String toString() {
        if (isaWeightGraph){
            return super.toString()+"It is a weight graph.";
        }
        else {
            return super.toString()+"It is NOT a weight graph.";
        }
    }

```

#### Test (Utest)
```java

@Test
    public void testToStringWeight() throws InvalidMatrixException {
        int[][] data = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data, true);
        String expected =
                "0 1 1 1 \n" +
                "1 0 1 1 \n" +
                "1 1 0 1 \n" +
                "1 1 1 0 \n" +
                "It is a weight graph.";
        assertEquals(expected, gm.toString());
    }

    @Test
    public void testToStringNotWeight() throws InvalidMatrixException {
        int[][] data = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        GraphMatrix gm = new GraphMatrix(data, false);
        String expected =
                "0 1 1 1 \n" +
                "1 0 1 1 \n" +
                "1 1 0 1 \n" +
                "1 1 1 0 \n" +
                "It is NOT a weight graph.";
        assertEquals(expected, gm.toString());
    }

```
#### Test (Main)
```java
public class Main {
    public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,1,1,1},
                {1,0,1,0},
                {1,1,0,1},
                {1,1,1,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, true);


        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("nodes: " + gm0.extractNodes());
        System.out.println("node 0 degree:"+gm0.nodeDegree(0));
        System.out.println("node 1 degree:"+gm0.nodeDegree(1));
        System.out.println("node 2 degree:"+gm0.nodeDegree(2));
        System.out.println("node 3 degree:"+gm0.nodeDegree(3));
        System.out.println("edges: " + gm0.extractEdges());
        System.out.println("Has it a selfloop? " + gm0.hasSelfloops());
        System.out.println("Is it directed? " + gm0.isDirected());
    }
}

```
#### Example

#### Common Mistakes

#### Notes

#### Project Integration
With this propertie frm the class we would be able to check the different typs of Graph, what is really important for some alghoritms.
---




