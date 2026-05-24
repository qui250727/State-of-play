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



}
