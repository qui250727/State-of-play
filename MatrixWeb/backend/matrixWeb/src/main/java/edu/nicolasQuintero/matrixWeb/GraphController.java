package edu.nicolasQuintero.matrixWeb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;

@CrossOrigin(origins="*")
@RestController
public class GraphController {
    @GetMapping("/test")
    public String test(){
        return "Backend works!";
    }

    @PostMapping("/matrix")
    public int[][] matrix(@RequestBody MatrixRequest request){
        return request.getMatrix();
    }

    @PostMapping("graphProperties")
    public GraphPropertiesResponse graphProperties(@RequestBody MatrixRequest request) throws InvalidMatrixException{
        GraphMatrix gm = new GraphMatrix(request.getMatrix(), false);
        GraphAlghoritm ga= new GraphAlghoritm(gm);
        GraphPropertiesResponse response = new GraphPropertiesResponse();
        response.setWeighted(gm.isWeighted());
        response.setDirected(gm.isDirected());
        response.setSelfLoops(gm.hasSelfloops());
        response.setComponents(ga.components());
        response.setRadius(ga.radiuses());
        response.setDiameter(ga.diameters());
        response.setCenter(ga.center());
        return response;
    }

    @PostMapping("/distanceMatrix")
    public int [][] distanceMatrix(@RequestBody MatrixRequest request) throws InvalidMatrixException{
        GraphMatrix gm = new GraphMatrix(request.getMatrix(), false);
        GraphAlghoritm ga= new GraphAlghoritm(gm);
        return ga.distanceMatrix().getData();
    }

    @PostMapping("/articulations")
    public ArrayList<Integer> articulations(@RequestBody MatrixRequest request) throws InvalidMatrixException{
        GraphMatrix gm = new GraphMatrix(request.getMatrix(), false);
        GraphAlghoritm ga= new GraphAlghoritm(gm);
        return ga.articulations();
    }

    @PostMapping("/bridges")
    public ArrayList<ArrayList<Integer>> bridges(@RequestBody MatrixRequest request) throws InvalidMatrixException{
        GraphMatrix gm = new GraphMatrix(request.getMatrix(), false);
        GraphAlghoritm ga= new GraphAlghoritm(gm);
        return ga.bridges();
    }

    @PostMapping("/blocks")
    public ArrayList<ArrayList<Integer>> blocks(@RequestBody MatrixRequest request) throws InvalidMatrixException{
        GraphMatrix gm = new GraphMatrix(request.getMatrix(), false);
        GraphAlghoritm ga= new GraphAlghoritm(gm);
        return ga.blocks();
    }

    @PostMapping("/bfs")
    public ArrayList<Integer> bfs(@RequestBody GraphTransversalRequest request) throws InvalidMatrixException {
        GraphMatrix graph = new GraphMatrix(request.getMatrix(), false);
        GraphAlghoritm ga = new GraphAlghoritm(graph);
        return ga.bfs(request.getStartNode());
    }

    @PostMapping("/dfs")
    public ArrayList<Integer> dfs(@RequestBody GraphTransversalRequest request) throws InvalidMatrixException {
        GraphMatrix graph = new GraphMatrix(request.getMatrix(), false);
        GraphAlghoritm ga = new GraphAlghoritm(graph);
        return ga.dfs(request.getStartNode());
    }

    @PostMapping("/eccentricity")
    public int eccentricity(@RequestBody NodeRequest request)
            throws InvalidMatrixException {
        GraphMatrix graph = new GraphMatrix(request.getMatrix(), false);
        GraphAlghoritm ga = new GraphAlghoritm(graph);
        return ga.eccentricity(request.getNode());
    }
}
