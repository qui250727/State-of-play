package edu.nicolasQuintero.matrixWeb;

import java.util.ArrayList;

public class GraphPropertiesResponse {
    private ArrayList<ArrayList<Integer>> components;
    private ArrayList<Integer> radius;
    private ArrayList<Integer> diameter;
    private ArrayList<ArrayList<Integer>> center;
    private boolean isWeighted;
    private boolean isDirected;
    private boolean selfLoops;

    public ArrayList<ArrayList<Integer>> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<ArrayList<Integer>> components) {
        this.components = components;
    }

    public ArrayList<Integer> getRadius() {
        return radius;
    }

    public void setRadius(ArrayList<Integer> radius) {
        this.radius = radius;
    }

    public ArrayList<Integer> getDiameter() {
        return diameter;
    }

    public void setDiameter(ArrayList<Integer> diameter) {
        this.diameter = diameter;
    }

    public ArrayList<ArrayList<Integer>> getCenter() {
        return center;
    }

    public void setCenter(ArrayList<ArrayList<Integer>> center) {
        this.center = center;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public void setWeighted(boolean weighted) {
        isWeighted = weighted;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }

    public boolean isSelfLoops() {
        return selfLoops;
    }

    public void setSelfLoops(boolean selfLoops) {
        this.selfLoops = selfLoops;
    }
}
