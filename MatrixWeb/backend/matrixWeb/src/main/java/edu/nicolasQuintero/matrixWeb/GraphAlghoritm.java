package edu.nicolasQuintero.matrixWeb;

import java.util.ArrayList;

public class GraphAlghoritm {
    public GraphMatrix graph;

    public GraphAlghoritm(GraphMatrix graph) {
        this.graph = graph;
    }

    public GraphMatrix getGraph() {
        return graph;
    }

    public void setGraph(GraphMatrix graph) {
        this.graph = graph;
    }

    @Override
    public String toString() {
        return "Graph= " + graph;
    }

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
        }//it reconstructs the shortest path backwards from the endnode
        return path;
    }

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

}
