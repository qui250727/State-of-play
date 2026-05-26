# Block 3 – Graph Algorithms 

## Description
Implementation of required graph algorithms.

## Technologies
- Java
- JUnit

## Learning Goals
- Graph traversal
- Distance computation
- Structural analysis

---

## Activities

### Activity 14 – BFS

#### Objective
#### Objective
The BFS explores the graph level by level until all the visited nodes are closed (breadht).
#### Glossary
Visited node: Graph node that have been already reach.
Closed node: Visited node that can not be visited anymore.
#### Explanation
We create a new class who contains all the alghoritms from the graph. For the BFS it is necesary to define 3 Arraylists and one boolean array the nodes. The boolean array define if the nodes have already visited or not and the array list contains the visited nodes, the open nodes and the closed nodes. 
#### Code
```java

public ArrayList<Integer> bfs(int startNode){
        ArrayList<Integer> visitedOrder = new ArrayList<>(); //order of the visited nodes (product list)
        ArrayList<Integer> closed = new ArrayList<>();//list of the closed nodes
        boolean[] visited = new boolean[graph.getRows()];//list of nodes that have been or haven't been already visited
        ArrayList<Integer> open = new ArrayList<>();//list of nodes that have been already visited but are not closed
        visited[startNode]=true; //firstnode would be marked as visited
        open.add(startNode);//startNode goes to the open list
        while(open.isEmpty()==false){//the open list have an element in then:
            int currentNode = open.remove(0);//we take out that element from the  open list
            closed.add(currentNode);//the element that we took goes to the closed list
            ArrayList<Integer> neighbors = graph.getNeighbors(currentNode); //list of the nodes who have a connection with a node
            for(int neighbor:neighbors){
                if(visited[neighbor]==false){
                    visited[neighbor]=true;
                    visitedOrder.add(neighbor);
                    open.add(neighbor);
                }//we take the element who has a connection with the previous node and he goes to the visited order list, what starts a loop who adds it to the product list point by point.
            }
            System.out.println("Open: "+ open);
            System.out.println("Visited: "+ visitedOrder);
            System.out.println("Closed: "+ closed);
            //it prints the process step by step
        }
        return closed;
    }

```

#### Test (Main)
```java

public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,0,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);

        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("Node 1 neighbors:");
        System.out.println(gm0.getNeighbors(1));
        System.out.println("-------------------");
        System.out.println("\"BFS with startnode 1: ");
        System.out.println(ga.bfs(1));
    }

```

#### Test (Utest)
```java

 @Test
    void testbfs() throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,0,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[1, 4, 2, 3, 6, 7, 8, 9, 0, 5]", ga.bfs(1).toString());
    }

```

#### Example
Open: [4]
Visited: [4]
Closed: [1]
Open: [2, 3, 6, 7]
Visited: [4, 2, 3, 6, 7]
Closed: [1, 4]
Open: [3, 6, 7, 8, 9]
Visited: [4, 2, 3, 6, 7, 8, 9]
Closed: [1, 4, 2]
Open: [6, 7, 8, 9, 0, 5]
Visited: [4, 2, 3, 6, 7, 8, 9, 0, 5]
Closed: [1, 4, 2, 3]
Open: [7, 8, 9, 0, 5]
Visited: [4, 2, 3, 6, 7, 8, 9, 0, 5]
Closed: [1, 4, 2, 3, 6]
Open: [8, 9, 0, 5]
Visited: [4, 2, 3, 6, 7, 8, 9, 0, 5]
Closed: [1, 4, 2, 3, 6, 7]
Open: [9, 0, 5]
Visited: [4, 2, 3, 6, 7, 8, 9, 0, 5]
Closed: [1, 4, 2, 3, 6, 7, 8]
Open: [0, 5]
Visited: [4, 2, 3, 6, 7, 8, 9, 0, 5]
Closed: [1, 4, 2, 3, 6, 7, 8, 9]
Open: [5]
Visited: [4, 2, 3, 6, 7, 8, 9, 0, 5]
Closed: [1, 4, 2, 3, 6, 7, 8, 9, 0]
Open: []
Visited: [4, 2, 3, 6, 7, 8, 9, 0, 5]
Closed: [1, 4, 2, 3, 6, 7, 8, 9, 0, 5]

#### Common Mistakes

#### Notes

#### Project Integration
 
---

### Activity 15 – DFS

#### Objective
The DFS explores the graph deeply through one branch until it reaches the end of the branch and begins backtracking until all visited nodes are moved to the closed list.
#### Glossary

#### Explanation

#### Code
```java

public ArrayList<Integer> dfs(int startNode){
        ArrayList<Integer> visitedOrder = new ArrayList<>(); //order of the visited nodes (product list)
        ArrayList<Integer> closed = new ArrayList<>();//list of the closed nodes
        boolean[] visited = new boolean[graph.getRows()];//list of nodes that have been or haven't been already visited
        ArrayList<Integer> open = new ArrayList<>();//list of nodes that have been already visited but are not closed
        visited[startNode]=true; //firstnode would be marked as visited
        open.add(startNode);//startNode goes to the open list
        while(open.isEmpty()==false){//the open list have an element in then:
            int currentNode = open.remove(open.size()-1);//we take out the last element of the branch to the open list
            closed.add(currentNode);//the element that we took goes to the closed list
            ArrayList<Integer> neighbors = graph.getNeighbors(currentNode); //list of the nodes who have a connection with a node
            for(int neighbor:neighbors){
                if(visited[neighbor]==false){
                    visited[neighbor]=true;
                    visitedOrder.add(neighbor);
                    open.add(neighbor);
                }//we take the element who has a connection with the previous node and he goes to the visited order list, what starts a loop who adds it to the product list point by point.
            }
            System.out.println("Open: "+ open);
            System.out.println("Visited: "+ visitedOrder);
            System.out.println("Closed: "+ closed);
            //it prints the process step by step
        }
        return closed;
    }

```

#### Test (Main)
```java

 public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,0,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);

        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("Node 1 neighbors:");
        System.out.println(gm0.getNeighbors(1));
        System.out.println("-------------------");
        System.out.println("DFS with startnode 1: ");
        System.out.println(ga.dfs(1));
    }

```

#### Test (Utest)
```java

@Test
    void testdfs() throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,0,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[1, 4, 7, 6, 3, 5, 0, 2, 9, 8]", ga.dfs(1).toString());
    }

```

#### Example

Open: [4]
Visited: [4]
Closed: [1]
Open: [2, 3, 6, 7]
Visited: [4, 2, 3, 6, 7]
Closed: [1, 4]
Open: [2, 3, 6]
Visited: [4, 2, 3, 6, 7]
Closed: [1, 4, 7]
Open: [2, 3]
Visited: [4, 2, 3, 6, 7]
Closed: [1, 4, 7, 6]
Open: [2, 0, 5]
Visited: [4, 2, 3, 6, 7, 0, 5]
Closed: [1, 4, 7, 6, 3]
Open: [2, 0]
Visited: [4, 2, 3, 6, 7, 0, 5]
Closed: [1, 4, 7, 6, 3, 5]
Open: [2]
Visited: [4, 2, 3, 6, 7, 0, 5]
Closed: [1, 4, 7, 6, 3, 5, 0]
Open: [8, 9]
Visited: [4, 2, 3, 6, 7, 0, 5, 8, 9]
Closed: [1, 4, 7, 6, 3, 5, 0, 2]
Open: [8]
Visited: [4, 2, 3, 6, 7, 0, 5, 8, 9]
Closed: [1, 4, 7, 6, 3, 5, 0, 2, 9]
Open: []
Visited: [4, 2, 3, 6, 7, 0, 5, 8, 9]
Closed: [1, 4, 7, 6, 3, 5, 0, 2, 9, 8]

#### Common Mistakes

#### Notes

#### Project Integration

---

### Activity 16 – Shortest paths

#### Objective

To finf the shortest papath betwwen a node a to a node b.
#### Glossary

#### Explanation

#### Code

```java

public ArrayList<Integer> shortestPath(int startNode, int endNode){
        ArrayList<Integer> path = new ArrayList<>(); //order of the shortest path (product list)
        boolean[] visited = new boolean[graph.getRows()];//list of nodes that have been or haven't been already visited
        ArrayList<Integer> open = new ArrayList<>();//list of nodes that have been already visited
        visited[startNode]=true; //firstnode would be marked as visited
        int[] previusNode = new int [graph.getRows()];
        for (int i = 0; i < previusNode.length; i++){
            previusNode[i]=-1;
        }//loop that checks the previus node of a node
        visited[startNode]=true;//the start node is markt as true
        open.add(startNode);//then it goes to the open list
        boolean found = false; //has it found the endnode?
        while(open.isEmpty()==false){//the open list have an element in then:
            int currentNode = open.remove(0);//we take out the first element of the open list
            if(currentNode == endNode){
                found = true;
                break;
            }//if this node is the endnode break the loop
            ArrayList<Integer> neighbors = graph.getNeighbors(currentNode); //list of the nodes who have a connection with a node
            for(int neighbor:neighbors){
                if(visited[neighbor]==false){
                    visited[neighbor]=true;
                    previusNode[neighbor]=currentNode;
                    open.add(neighbor);
                }//we take the element who has a connection with the previous node and he goes to the visited order list, what starts a loop who adds it to the product list.
        }
        }if (found == false){
            return path;
        }//if the endnode was not found it returns an empry path
        int current = endNode; //it starts the reconstruction from the endnode
        while (current !=-1){
            path.add(0,current);
            current = previusNode[current];
        }//it reconstruct the shortest path backwards from the endnode
        return path;
    }

```

#### Test (Main)
```java

public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,0,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);

        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("Node 1 neighbors:");
        System.out.println(gm0.getNeighbors(1));
        System.out.println("-------------------");
        System.out.println("Shortest path with startnode 1 and endnode 9: ");
        System.out.println(ga.shortestPath(1,9));
    }

```

#### Test (Utest)
```java

@Test
    void testShortestPath() throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,0,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[1, 4, 2, 9]", ga.shortestPath(1,9).toString());
    }

```

#### Example

GraphMatrix gm0:
0 0 0 1 0 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 0 0 1 0 0 0 1 1 
1 0 0 0 0 1 1 0 0 0 
0 1 1 1 0 0 1 1 0 0 
0 0 0 1 0 0 0 0 0 0 
0 0 0 1 1 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
It is NOT a weight graph.
Rows: 10
Columns: 10

Node 1 neighbors:
[4]

Shortest path with startnode 1 and endnode 9: 
[1, 4, 2, 9]

Process finished with exit code 0
#### Common Mistakes

#### Notes

#### Project Integration

Now we are able to fin the shortest path between a node a to a node b of a graph.
---

### Activity 17 – Distance matrix

#### Objective

to build a matrix that shows the distance between a node a and a node b.
#### Glossary

#### Explanation

We will call a method that makes a loop for every node that calls the shortestPath methode in order to see the shortest path distance between every node. 
#### Code
```java

public Matrix distanceMatrix() throws InvalidMatrixException{
        int [][] distances = new int [graph.getRows()][graph.getColumns()];
        for(int i = 0; i < graph.getRows();i++){
           for (int j = 0; j < graph.getColumns();j++){
               ArrayList<Integer> path = shortestPath(i,j);
               if(path.isEmpty()){
                   distances[i][j]=-1;
               }
               else{
                   distances[i][j]=path.size()-1;
               }
           }
        }
        return new Matrix(distances);
    }

```

#### Test (Main)
```java

public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,1,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);

        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("Distance Matrix:");
        System.out.println(ga.distanceMatrix());
    }

```

#### Test (Utest)
```java

@Test
    void testDistanceMatrx()throws InvalidMatrixException{
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,1,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        String expected =
                "0 3 3 1 2 2 2 3 4 4 \n" +
                "3 0 2 2 1 3 2 2 3 3 \n" +
                "3 2 0 2 1 3 2 2 1 1 \n" +
                "1 2 2 0 1 1 1 2 3 3 \n" +
                "2 1 1 1 0 2 1 1 2 2 \n" +
                "2 3 3 1 2 0 2 3 4 4 \n" +
                "2 2 2 1 1 2 0 2 3 3 \n" +
                "3 2 2 2 1 3 2 0 3 3 \n" +
                "4 3 1 3 2 4 3 3 0 2 \n" +
                "4 3 1 3 2 4 3 3 2 0 \n";
        assertEquals(expected, ga.distanceMatrix().toString());
    }

```

#### Example

GraphMatrix gm0:
0 0 0 1 0 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 0 0 1 0 0 0 1 1 
1 0 0 0 1 1 1 0 0 0 
0 1 1 1 0 0 1 1 0 0 
0 0 0 1 0 0 0 0 0 0 
0 0 0 1 1 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
It is NOT a weight graph.
Rows: 10
Columns: 10

Distance Matrix:
0 3 3 1 2 2 2 3 4 4 
3 0 2 2 1 3 2 2 3 3 
3 2 0 2 1 3 2 2 1 1 
1 2 2 0 1 1 1 2 3 3 
2 1 1 1 0 2 1 1 2 2 
2 3 3 1 2 0 2 3 4 4 
2 2 2 1 1 2 0 2 3 3 
3 2 2 2 1 3 2 0 3 3 
4 3 1 3 2 4 3 3 0 2 
4 3 1 3 2 4 3 3 2 0 

#### Common Mistakes

#### Notes

#### Project Integration

Now it is posible to show a Matrix with the shortest distance between every node.
---

### Activity 18 – Eccentricity

#### Objective
To find the farest node where a node can go.
#### Glossary

#### Explanation
We use the method distance matrix in order to see what is the longest distance that a node is able to achieve using a loop.
#### Code
```java

 public int eccentricity(int node)throws InvalidMatrixException{
        int max = -999;
        for(int i = 0;i < graph.getColumns();i++){
            int distance = distanceMatrix().getData()[node][i];
            if(distance>max){
                max=distance;
            }
        }
        return max;
    }

```

#### Test (Main)
```java

public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,1,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);

        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("Distance Matrix:");
        System.out.println(ga.distanceMatrix());
        System.out.println("Eccentricity node 5:");
        System.out.println(ga.eccentricity(5));
    }

```

#### Test (Utest)
```java

@Test
    void testEccentricity()throws InvalidMatrixException {
        int[][] a = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals(4, ga.eccentricity(5));
    }

```

#### Example

GraphMatrix gm0:
0 0 0 1 0 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 0 0 1 0 0 0 1 1 
1 0 0 0 1 1 1 0 0 0 
0 1 1 1 0 0 1 1 0 0 
0 0 0 1 0 0 0 0 0 0 
0 0 0 1 1 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
It is NOT a weight graph.
Rows: 10
Columns: 10

Distance Matrix:
0 3 3 1 2 2 2 3 4 4 
3 0 2 2 1 3 2 2 3 3 
3 2 0 2 1 3 2 2 1 1 
1 2 2 0 1 1 1 2 3 3 
2 1 1 1 0 2 1 1 2 2 
2 3 3 1 2 0 2 3 4 4 
2 2 2 1 1 2 0 2 3 3 
3 2 2 2 1 3 2 0 3 3 
4 3 1 3 2 4 3 3 0 2 
4 3 1 3 2 4 3 3 2 0 

Eccentricity node 5:
4

#### Common Mistakes

#### Notes

#### Project Integration
now we are able to now the maximal distance that a node is able to reach.
---

### Activity 19 – Radius

#### Objective
to find the lowest eccentricity from the graph
#### Glossary

#### Explanation
We use the eccentricity method and we create a loop that checks the graph in order to find the minimal eccentricity.
#### Code
```java

public int radius() throws InvalidMatrixException{
        int min = 99999999;
        for(int i = 0;i< graph.getRows();i++){
            int eccentricity=eccentricity(i);
            if (eccentricity<min){
                min=eccentricity;
            }
        }
        return min;
    }

```

#### Test (Main)
```java

public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,1,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);

        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("Distance Matrix:");
        System.out.println(ga.distanceMatrix());
        System.out.println("Radius");
        System.out.println(ga.radius());
        System.out.println("Eccentricity node 5:");
        System.out.println(ga.eccentricity(5));

    }

```

#### Test (Utest)
```java

@Test
    void testRadius()throws InvalidMatrixException {
        int[][] a = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals(2, ga.radius());
    }

```

#### Example

GraphMatrix gm0:
0 0 0 1 0 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 0 0 1 0 0 0 1 1 
1 0 0 0 1 1 1 0 0 0 
0 1 1 1 0 0 1 1 0 0 
0 0 0 1 0 0 0 0 0 0 
0 0 0 1 1 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
It is NOT a weight graph.
Rows: 10
Columns: 10

Distance Matrix:
0 3 3 1 2 2 2 3 4 4 
3 0 2 2 1 3 2 2 3 3 
3 2 0 2 1 3 2 2 1 1 
1 2 2 0 1 1 1 2 3 3 
2 1 1 1 0 2 1 1 2 2 
2 3 3 1 2 0 2 3 4 4 
2 2 2 1 1 2 0 2 3 3 
3 2 2 2 1 3 2 0 3 3 
4 3 1 3 2 4 3 3 0 2 
4 3 1 3 2 4 3 3 2 0 

Radius
2
Eccentricity node 5:
4

#### Common Mistakes

#### Notes

#### Project Integration
it will help us to find the center or centers of the graph
---

### Activity 37 – Diameter

#### Objective
to find the biggest eccentricity of the graph
#### Glossary

#### Explanation
we do a loop who check the graph in order to find the biggest eccentricity that a node can reach
#### Code
```java

public int diameter() throws InvalidMatrixException{
        int max = -999;
        for(int i = 0;i< graph.getRows();i++){
            int eccentricity=eccentricity(i);
            if (eccentricity>max){
                max=eccentricity;
            }
        }
        return max;
    }

```

#### Test (Main)
```java

 public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,1,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);

        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("Distance Matrix:");
        System.out.println(ga.distanceMatrix());
        System.out.println("Radius: "+ ga.radius());
        System.out.println("Diameter: "+ ga.diameter());
        System.out.println("Center: "+ ga.center());

    }

```

#### Test (Utest)
```java

@Test
    void testCenter()throws InvalidMatrixException {
        int[][] a = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[4]", ga.center().toString());
    }

```

#### Example

GraphMatrix gm0:
0 0 0 1 0 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 0 0 1 0 0 0 1 1 
1 0 0 0 1 1 1 0 0 0 
0 1 1 1 0 0 1 1 0 0 
0 0 0 1 0 0 0 0 0 0 
0 0 0 1 1 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
It is NOT a weight graph.
Rows: 10
Columns: 10
Distance Matrix:
0 3 3 1 2 2 2 3 4 4 
3 0 2 2 1 3 2 2 3 3 
3 2 0 2 1 3 2 2 1 1 
1 2 2 0 1 1 1 2 3 3 
2 1 1 1 0 2 1 1 2 2 
2 3 3 1 2 0 2 3 4 4 
2 2 2 1 1 2 0 2 3 3 
3 2 2 2 1 3 2 0 3 3 
4 3 1 3 2 4 3 3 0 2 
4 3 1 3 2 4 3 3 2 0 

Radius: 2
Diameter: 4
Center: [4]

#### Common Mistakes

#### Notes

#### Project Integration
Now we are able to find the biggest eccentricity of the graph that a node van reach
---

### Activity 20 – Graph center

#### Objective
find the list of nodes who have the minimal eccentricity of the graph.
#### Glossary

#### Explanation
We create a Arraylist with a loop which check the nodes of the graph in order to check wich node or nodes have the smallest eccentricity
#### Code
```java

public ArrayList<Integer> center() throws InvalidMatrixException{
        ArrayList<Integer> eccentricities = new ArrayList<>();
        for(int i = 0;i< graph.getRows();i++){
            if(eccentricity(i) == radius()){
                eccentricities.add(i);
            }
        }
        return eccentricities;
    }

```

#### Test (Main)
```java

public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,1,1},
                {1,0,0,0,1,1,1,0,0,0},
                {0,1,1,1,0,0,1,1,0,0},
                {0,0,0,1,0,0,0,0,0,0},
                {0,0,0,1,1,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);

        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("-------------------");
        System.out.println("Distance Matrix:");
        System.out.println(ga.distanceMatrix());
        System.out.println("Radius");
        System.out.println(ga.radius());
        System.out.println("Center");
        System.out.println(ga.center());

    }

```

#### Test (Utest)
```java

@Test
    void testCenter()throws InvalidMatrixException {
        int[][] a = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[4]", ga.center().toString());
    }

```

#### Example

GraphMatrix gm0:
0 0 0 1 0 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 0 0 1 0 0 0 1 1 
1 0 0 0 1 1 1 0 0 0 
0 1 1 1 0 0 1 1 0 0 
0 0 0 1 0 0 0 0 0 0 
0 0 0 1 1 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
0 0 1 0 0 0 0 0 0 0 
It is NOT a weight graph.
Rows: 10
Columns: 10

Distance Matrix:
0 3 3 1 2 2 2 3 4 4 
3 0 2 2 1 3 2 2 3 3 
3 2 0 2 1 3 2 2 1 1 
1 2 2 0 1 1 1 2 3 3 
2 1 1 1 0 2 1 1 2 2 
2 3 3 1 2 0 2 3 4 4 
2 2 2 1 1 2 0 2 3 3 
3 2 2 2 1 3 2 0 3 3 
4 3 1 3 2 4 3 3 0 2 
4 3 1 3 2 4 3 3 2 0 

Radius
2
Center
[4]

#### Common Mistakes

#### Notes

#### Project Integration
Now it is posible to find the nodes with the shortest eccentricity.
---

### Activity 21 – Connected components

#### Objective
to show if the graph is coneccted or it divide itself in diferent components
#### Glossary

#### Explanation
we needed to create a copy of the method bfs and give it the propierty boolean visited in order to create a loop that check the bfs of the graph for every node. That way it will check if all the nodes are conected or not and it will separete it in a list of components. In order to follow that logic, it was better to change the diameter, center and radius method, they dont return just a value now, they return the value for every component becausewe change them to arraylist for every component.
#### Code
```java

public ArrayList<Integer> bfsComponents(int startNode, boolean[] visited){
        ArrayList<Integer> visitedOrder = new ArrayList<>(); //order of the visited nodes (product list)
        ArrayList<Integer> closed = new ArrayList<>();//list of the closed nodes
        ArrayList<Integer> open = new ArrayList<>();//list of nodes that have been already visited but are not closed
        visited[startNode]=true; //firstnode would be marked as visited
        open.add(startNode);//startNode goes to the open list
        while(open.isEmpty()==false){//the open list have an element in then:
            int currentNode = open.remove(0);//we take out that element from the  open list
            closed.add(currentNode);//the element that we took goes to the closed list
            ArrayList<Integer> neighbors = graph.getNeighbors(currentNode); //list of the nodes who have a connection with a node
            for(int neighbor:neighbors){
                if(visited[neighbor]==false){
                    visited[neighbor]=true;
                    visitedOrder.add(neighbor);
                    open.add(neighbor);
                }//we take the element who has a connection with the previous node and he goes to the visited order list, what starts a loop who adds it to the product list point by point.
            }
        }
        return closed;
    }

    public ArrayList<ArrayList<Integer>> components(){
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();//we have a arraylist from another array list
        boolean[] visited = new boolean[graph.getRows()];//it marks a node as visited to avoid to repeat components
        for(int i = 0;i< graph.getRows();i++){//check the graph
            if(visited[i]==false){
                ArrayList<Integer> component = bfsComponents(i,visited);//it searches the connected nodes
                components.add(component);//it adds it to component list
            }
        }
        return components; //it returns the list of components of a graph
    }

    public ArrayList<Integer> radiuses() throws InvalidMatrixException{
        ArrayList<Integer> radius = new ArrayList<>();
        for(ArrayList<Integer> component: components()){
            int min = 99999999;
            for(int node: component){
                int eccentricity = eccentricity(node);
                if(eccentricity < min){
                    min = eccentricity;
                }
            }
            radius.add(min);
        }
        return radius;
    }


    public ArrayList<ArrayList<Integer>>center() throws InvalidMatrixException{
        ArrayList<ArrayList<Integer>> centers = new ArrayList<>();
        ArrayList<Integer> radius = radiuses();
        ArrayList<ArrayList<Integer>> components = components();
        for (int i = 0; i<components.size();i++){
            ArrayList<Integer> center = new ArrayList<>();
            int radiuses = radius.get(i);
            for(int node: components.get(i)){
                if (eccentricity(node)==radiuses){
                    center.add(node);
                }
            }
            centers.add(center);
        }
        return centers;
    }

    public ArrayList<Integer> diameters() throws InvalidMatrixException{
        ArrayList<Integer> diameter = new ArrayList<>();
        for(ArrayList<Integer> component: components()){
            int max = -99999999;
            for(int node: component){
                int eccentricity = eccentricity(node);
                if(eccentricity > max){
                    max = eccentricity;
                }
            }
            diameter.add(max);
        }
        return diameter;
    }

```

#### Test (Main)
```java

public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,1,0,0,0,0,0,0,0,0},
                {1,0,1,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,0,0,0,0},

                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0},
                {0,0,0,0,1,0,1,0,0,0},
                {0,0,0,0,0,1,0,0,0,0},

                {0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,1,0,0},

                {0,0,0,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);

        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("Distance Matrix:");
        System.out.println(ga.distanceMatrix());
        System.out.println("Components:");
        System.out.println(ga.components());
        System.out.println("Radius: "+ ga.radiuses());
        System.out.println("Diameter: "+ ga.diameters());
        System.out.println("Center: "+ ga.center());

    }

```

#### Test (Utest)
```java

 @Test
    void testRadiuses()throws InvalidMatrixException {
        int[][] a = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[2]", ga.radiuses().toString());
    }

    @Test
    void testCenters()throws InvalidMatrixException {
        int[][] a = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[[4]]", ga.center().toString());
    }

    @Test
    void testDiameters()throws InvalidMatrixException {
        int[][] a = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[4]", ga.diameters().toString());
    }

```

#### Example

GraphMatrix gm0:
0 1 0 0 0 0 0 0 0 0 
1 0 1 0 0 0 0 0 0 0 
0 1 0 0 0 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 0 1 0 1 0 0 0 0 
0 0 0 0 1 0 1 0 0 0 
0 0 0 0 0 1 0 0 0 0 
0 0 0 0 0 0 0 0 1 0 
0 0 0 0 0 0 0 1 0 0 
0 0 0 0 0 0 0 0 0 0 
It is NOT a weight graph.
Rows: 10
Columns: 10
Distance Matrix:
0 1 2 -1 -1 -1 -1 -1 -1 -1 
1 0 1 -1 -1 -1 -1 -1 -1 -1 
2 1 0 -1 -1 -1 -1 -1 -1 -1 
-1 -1 -1 0 1 2 3 -1 -1 -1 
-1 -1 -1 1 0 1 2 -1 -1 -1 
-1 -1 -1 2 1 0 1 -1 -1 -1 
-1 -1 -1 3 2 1 0 -1 -1 -1 
-1 -1 -1 -1 -1 -1 -1 0 1 -1 
-1 -1 -1 -1 -1 -1 -1 1 0 -1 
-1 -1 -1 -1 -1 -1 -1 -1 -1 0 

Components:
[[0, 1, 2], [3, 4, 5, 6], [7, 8], [9]]
Radius: [1, 2, 1, 0]
Diameter: [2, 3, 1, 0]
Center: [[1], [4, 5], [7, 8], [9]]


#### Common Mistakes

#### Notes

#### Project Integration
Now it is posible to interpretate a graph as a conected or a desconected graph and to interpretate his propierties as components.
---

### Activity 22 – Articulation points

#### Objective
to find witch nodes create new components in the graph if we take them off.
#### Glossary

#### Explanation
We needed to create a removeNode method in the GraphMatrix class in order to use it in the GRaphalgoritm class in a loop that compares a graph without a node and one with the node in order to see if it has more conponents or not and define de node as an articulation.
#### Code (GraphMatrix)
```java

public GraphMatrix removeNode(int node) throws InvalidMatrixException{
       int[][] newMatrix = new int[getRows()-1][getColumns()-1];
       int newRow = 0;
       for(int i = 0; i<getRows();i++){
           if(i == node){
               continue;
           }
           int newColumn = 0;
           for (int j = 0;j<getColumns();j++){
               if(j==node){
                   continue;
               }
               newMatrix[newRow][newColumn] = getData()[i][j];
               newColumn++;
           }
           newRow++;
       }
       return new GraphMatrix(newMatrix,false);
    }

```
#### Code (GraphAlghoritm)
```java

public ArrayList<Integer> articulations()throws InvalidMatrixException{
        ArrayList<Integer> articulations = new ArrayList<>();
        int originalComponents = components().size();
        for(int i = 0; i< graph.getRows();i++){
            GraphMatrix newGraph = graph.removeNode(i);
            GraphAlghoritm ga = new GraphAlghoritm(newGraph);
            int newComponents=ga.components().size();
            if(newComponents>originalComponents){
                articulations.add(i);
            }
        }
        return articulations;
    }

```

#### Test (Main)
```java

    public static void main(String[] args) throws InvalidMatrixException {
        int[][] a = {
                {0,1,0,0,0,0,0,0,0,0},
                {1,0,1,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,0,0,0,0},

                {0,0,0,0,1,0,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0},
                {0,0,0,0,1,0,1,0,0,0},
                {0,0,0,0,0,1,0,0,0,0},

                {0,0,0,0,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,1,0,0},

                {0,0,0,0,0,0,0,0,0,0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);

        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("Distance Matrix:");
        System.out.println(ga.distanceMatrix());
        System.out.println("Components:");
        System.out.println(ga.components());
        System.out.println("Radius: "+ ga.radiuses());
        System.out.println("Diameter: "+ ga.diameters());
        System.out.println("Center: "+ ga.center());
        System.out.println("Articulations: "+ga.articulations());

    }

```

#### Test (Utest)
```java

@Test
    void testArticulations()throws InvalidMatrixException {
        int[][] a = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[2, 3, 4]", ga.articulations().toString());
    }

```

#### Example

GraphMatrix gm0:
0 1 0 0 0 0 0 0 0 0 
1 0 1 0 0 0 0 0 0 0 
0 1 0 0 0 0 0 0 0 0 
0 0 0 0 1 0 0 0 0 0 
0 0 0 1 0 1 0 0 0 0 
0 0 0 0 1 0 1 0 0 0 
0 0 0 0 0 1 0 0 0 0 
0 0 0 0 0 0 0 0 1 0 
0 0 0 0 0 0 0 1 0 0 
0 0 0 0 0 0 0 0 0 0 
It is NOT a weight graph.
Rows: 10
Columns: 10
Distance Matrix:
0 1 2 -1 -1 -1 -1 -1 -1 -1 
1 0 1 -1 -1 -1 -1 -1 -1 -1 
2 1 0 -1 -1 -1 -1 -1 -1 -1 
-1 -1 -1 0 1 2 3 -1 -1 -1 
-1 -1 -1 1 0 1 2 -1 -1 -1 
-1 -1 -1 2 1 0 1 -1 -1 -1 
-1 -1 -1 3 2 1 0 -1 -1 -1 
-1 -1 -1 -1 -1 -1 -1 0 1 -1 
-1 -1 -1 -1 -1 -1 -1 1 0 -1 
-1 -1 -1 -1 -1 -1 -1 -1 -1 0 

Components:
[[0, 1, 2], [3, 4, 5, 6], [7, 8], [9]]
Radius: [1, 2, 1, 0]
Diameter: [2, 3, 1, 0]
Center: [[1], [4, 5], [7, 8], [9]]
Articulations: [1, 4, 5]


#### Common Mistakes

#### Notes

#### Project Integration
It will help us to define the blocks and the bridges
---

### Activity 23 – Bridges

#### Objective
to find the edges that if we take them off, they create new components in a graph.
#### Glossary

#### Explanation
The proccess is kind of similar to the articulations method. But this time we create a method removeEdge in the graphMatrix class in order to use it in the GraphAlghoritm class as a find Bridges method wich create a loop that compares a graph with und without taking out an edge in order to see if there are more components or not.
#### Code(MatrixGraph)
```java

public GraphMatrix removeEdge(int node1, int node2) throws InvalidMatrixException{
        int[][] newMatrix = new int[getRows()][getColumns()];
        for(int i = 0; i<getRows();i++){
            for(int j = 0;j<getColumns();j++){
                newMatrix[i][j]=getData()[i][j];
            }
        }
        newMatrix[node1][node2]=0;
        if(isaWeightGraph==false){
            newMatrix[node2][node1]=0;
        }
        return new GraphMatrix(newMatrix,false);
    }

```
#### Code(GraphAlghorithm)
```java

public ArrayList<ArrayList<Integer>> bridges()throws InvalidMatrixException{
        ArrayList<ArrayList<Integer>> bridges = new ArrayList<>();
        int originalComponents = components().size();
        for(int i = 0; i< graph.getRows();i++){
            for (int j = i+1; j<graph.getColumns();j++){
                if (graph.getData()[i][j]==1){
                   GraphMatrix newGraph = graph.removeEdge(i,j);
                   GraphAlghoritm ga = new GraphAlghoritm(newGraph);
                   int newComponents = ga.components().size();
                   if(newComponents>originalComponents){
                       ArrayList<Integer> bridge = new ArrayList<>();
                       bridge.add(i);
                       bridge.add(j);
                       bridges.add(bridge);
                   }
                }
            }
        }
        return bridges;
    }

```

#### Test (Main)
```java

public static void main(String[] args) throws InvalidMatrixException {
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
        GraphAlghoritm ga = new GraphAlghoritm(gm0);

        System.out.println("GraphMatrix gm0:");
        System.out.println(gm0.toString());;//Druckmethode probieren
        System.out.println("Rows: "+ gm0.getRows());//getRows
        System.out.println("Columns: "+ gm0.getColumns());//getColumns
        System.out.println("Distance Matrix:");
        System.out.println(ga.distanceMatrix());
        System.out.println("Components:");
        System.out.println(ga.components());
        System.out.println("Radius: "+ ga.radiuses());
        System.out.println("Diameter: "+ ga.diameters());
        System.out.println("Center: "+ ga.center());
        System.out.println("Articulations: "+ga.articulations());
        System.out.println("Bridges: "+ga.bridges() );

    }

```

#### Test (Utest)
```java

@Test
    void testBridges()throws InvalidMatrixException {
        int[][] a = {
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}
        };
        GraphMatrix gm0 = new GraphMatrix(a, false);
        GraphAlghoritm ga = new GraphAlghoritm(gm0);
        assertEquals("[[0, 3], [1, 4], [2, 4], [2, 8], [2, 9], [3, 5], [4, 7]]", ga.bridges().toString());
    }
```

#### Example

GraphMatrix gm0:
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
It is NOT a weight graph.
Rows: 10
Columns: 10
Distance Matrix:
0 1 2 1 2 3 4 5 -1 -1 
1 0 1 2 3 4 5 6 -1 -1 
2 1 0 1 2 3 4 5 -1 -1 
1 2 1 0 1 2 3 4 -1 -1 
2 3 2 1 0 1 2 3 -1 -1 
3 4 3 2 1 0 1 2 -1 -1 
4 5 4 3 2 1 0 1 -1 -1 
5 6 5 4 3 2 1 0 -1 -1 
-1 -1 -1 -1 -1 -1 -1 -1 0 1 
-1 -1 -1 -1 -1 -1 -1 -1 1 0 

Components:
[[0, 1, 3, 2, 4, 5, 6, 7], [8, 9]]
Radius: [3, 1]
Diameter: [6, 1]
Center: [[4], [8, 9]]
Articulations: [3, 4, 5, 6]
Bridges: [[3, 4], [4, 5], [5, 6], [6, 7], [8, 9]]

#### Common Mistakes

#### Notes

#### Project Integration
Now we can use this method and the articulations for the blocks method
---

### Activity 24 – Blocks

#### Objective

#### Glossary

#### Explanation

#### Code
```java



```

#### Test (Main)
```java



```

#### Test (Utest)
```java



```

#### Example

#### Common Mistakes

#### Notes

#### Project Integration

---

---
