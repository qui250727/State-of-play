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

### Activity 31 – BFS

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

### Activity 32 – DFS

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

### Activity 33 – Shortest paths

### Activity 32 – DFS

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

### Activity 34 – Distance matrix

### Activity 32 – DFS

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

### Activity 35 – Eccentricity

### Activity 32 – DFS

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

### Activity 36 – Radius

### Activity 32 – DFS

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

### Activity 37 – Diameter

### Activity 32 – DFS

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

### Activity 38 – Graph center

### Activity 32 – DFS

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

### Activity 39 – Connected components

### Activity 32 – DFS

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

### Activity 41 – Articulation points

### Activity 32 – DFS

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

### Activity 42 – Bridges

### Activity 32 – DFS

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
