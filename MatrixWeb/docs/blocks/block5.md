# Block 5 – Frontend (HTML, CSS, JavaScript)

## Description
User interface for matrix and graph interaction.

## Technologies
- HTML
- CSS
- JavaScript

## Learning Goals
- Build UI
- Handle input
- Display results

---
## Template

#### Objective

#### Glossary

#### Explanation

#### Code (HTML)
```html



```

#### Code (javascript)
```javascript



```

#### Example

#### Common Mistakes

#### Notes

#### Project Integration

---

## Activities

### Activity 28 – Basic HTML structure

#### Objective
to create the basic structure from the calculatorMatrix, where we are able to add values to the matrix, add or remove rows or columns and that the program identify the data as a matrix.
#### Glossary

#### Explanation
the html file have a table that would contain the data from the rows and columns from the matrix. It will start with 2x2 format and rows and columns can be added and removed with a button. For the buttons we would use our javascript code app.js as script and we would give that way a function to every button.
#### Code (HTML)
```html

<!DOCTYPE html>
<html>
<head>
    <title>Matrix Calculator</title>
</head>
<body>

<h1>Matrix Calculator</h1>

<label>
    <input type="radio" name="matrixType" value="matrix" checked>
    Matrix
</label>

<label>
    <input type="radio" name="matrixType" value="graph">
    GraphMatrix
</label>

<br><br>

<table id="matrixTable" border="1">
    <tr>
        <td><input type="number" value="0"></td>
        <td><input type="number" value="0"></td>
    </tr>
    <tr>
        <td><input type="number" value="0"></td>
        <td><input type="number" value="0"></td>
    </tr>
</table>

<br>

<button onclick="addRow()">+ Row</button>
<button onclick="removeRow()">- Row</button>

<button onclick="addColumn()">+ Column</button>
<button onclick="removeColumn()">- Column</button>
<button onclick="showMatrix()">Show Matrix</button>
<script src="../app.js"></script>

</body>
</html>

```

#### Code (javascript)
```javascript

function addRow(){
    const table = document.getElementById("matrixTable");
    const columns = table.rows[0].cells.length;
    const row = table.insertRow();
    for (let i = 0; i< columns; i++){
        const cell = row.insertCell();
        cell.innerHTML = '<input type="number" value="0">';
    }
}

function removeRow(){
    const table = document.getElementById("matrixTable");
    if(table.rows.length > 2){
        table.deleteRow(table.rows.length -1);
    }
}

function addColumn(){
    const table = document.getElementById("matrixTable");
    for(let row of table.rows){
        const cell = row.insertCell();
        cell.innerHTML = '<input type= "number" value="0">';
    }
}

function removeColumn(){
    const table = document.getElementById("matrixTable");
    if(table.rows[0].cells.length > 2){
        for(let row of table.rows){
            row.deleteCell(row.cells.lenght - 1);
        }
    }
}

function getMatrixData(){
    const table = document.getElementById("matrixTable");
    let matrix = [];
    for (let row of table.rows){
        let currentRow = [];
        for(let cell of row.cells){
            const value = parseInt(cell.firstElementChild.value);
            currentRow.push(value);
        }
        matrix.push(currentRow);
    }
    return matrix;
}//it interpretates the table data as a matrix

function showMatrix(){
    const matrix = getMatrixData();
    console.log(matrix);
}//just to test in the console

```

#### Example

#### Common Mistakes

#### Notes

#### Project Integration

this is tha basic html configuration that allow us to give the data from the matrix as a table in order to start to give the different methods from the backend.

### Activity 29 – Matrix vs GraphMatrix

#### Objective
To be able to differenciate what a Matrix and Graphmatrix can do, we differenciate the functions when we define what kind of graph are we going to use
#### Explanation
We needed to modify the html file and the javascript file in order to add a matrix b that is only visible when a Matrix at the  beginning was choosed, because matrixes can be operated with other matrixes. We also created a updateOptions() function in javascript that let us see which options or methods are we able to use for every kind of Matrixes.
#### Code (HTML)
```html

<!DOCTYPE html>
<html>
<head>
    <title>Matrix Calculator</title>
</head>
<body>

<h1>Matrix Calculator</h1>

<label>
    <input
        type="radio"
        name="matrixType"
        value="matrix"
        checked
        onchange="updateOptions()">
    Matrix
</label>

<label>
    <input
        type="radio"
        name="matrixType"
        value="graph"
        onchange="updateOptions()">
    GraphMatrix
</label>

<br><br>

<h3>Matrix A</h3>
<table id="matrixA" border="1">
    <tr>
        <td><input type="number" value="0"></td>
        <td><input type="number" value="0"></td>
    </tr>
    <tr>
        <td><input type="number" value="0"></td>
        <td><input type="number" value="0"></td>
    </tr>
</table>

<button onclick="addRow('matrixA')">+ Row A</button>
<button onclick="removeRow('matrixA')">- Row A</button>
<button onclick="addColumn('matrixA')">+ Column A</button>
<button onclick="removeColumn('matrixA')">- Column A</button>
<button onclick="showMatrix('matrixA')">Show Matrix A</button>

<div id="matrixBContainer" style="display: none;">
    <h3>Matrix B</h3>
    <table id="matrixB" border="1">
    <tr>
        <td><input type="number" value="0"></td>
        <td><input type="number" value="0"></td>
    </tr>
    <tr>
        <td><input type="number" value="0"></td>
        <td><input type="number" value="0"></td>
    </tr>
    </table>

    <button onclick="addRow('matrixB')">+ Row B</button>
    <button onclick="removeRow('matrixB')">- Row B</button>
    <button onclick="addColumn('matrixB')">+ Column B</button>
    <button onclick="removeColumn('matrixB')">- Column B</button>
    <button onclick="showMatrix('matrixB')">Show Matrix B</button>
</div>

<br>

<div id="optionsContainer"></div>


<script src="../app.js"></script>

</body>
</html>

```

#### Code (javascript)
```javascript

function addRow(tableId){
    const table = document.getElementById(tableId);
    const columns = table.rows[0].cells.length;
    const row = table.insertRow();
    for (let i = 0; i< columns; i++){
        const cell = row.insertCell();
        cell.innerHTML = '<input type="number" value="0">';
    }
}

function removeRow(tableId){
    const table = document.getElementById(tableId);
    if(table.rows.length > 2){
        table.deleteRow(table.rows.length -1);
    }
}

function addColumn(tableId){
    const table = document.getElementById(tableId);
    for(let row of table.rows){
        const cell = row.insertCell();
        cell.innerHTML = '<input type= "number" value="0">';
    }
}

function removeColumn(tableId){
    const table = document.getElementById(tableId);
    if(table.rows[0].cells.length > 2){
        for(let row of table.rows){
            row.deleteCell(row.cells.length - 1);
        }
    }
}

function getMatrixData(tableId){
    const table = document.getElementById(tableId);
    let matrix = [];
    for (let row of table.rows){
        let currentRow = [];
        for(let cell of row.cells){
            const value = parseInt(cell.firstElementChild.value);
            currentRow.push(value);
        }
        matrix.push(currentRow);
    }
    return matrix;
}//it interpretates the table data as a matrix

function showMatrix(tableId){
    const matrix = getMatrixData(tableId);
    console.log(matrix);
}//just to test in the console

function updateOptions(){
    const type = document.querySelector('input[name="matrixType"]:checked').value;
    const container = document.getElementById("optionsContainer");
    const matrixBContainer = document.getElementById("matrixBContainer");
    if(type === "matrix"){
        matrixBContainer.style.display = "block";
        container.innerHTML = `
            <h3>Matrix Operations</h3>
            <button>Addition</button>
            <button>Substraction</button>
            <button>Multiplication</button>
        `;    
    }
    else{
        matrixBContainer.style.display="none";
        container.innerHTML =`
            <h3>Graph Algorithm</h3>
            <button>Graph Properties</button>
            <button>Distance Matrix</button>
            <button>Articulations</button>
            <button>Bridges</button>
            <button>Blocks</button>
        `;
    }
}

updateOptions();

```
#### Example

#### Common Mistakes

#### Notes

#### Project Integration
Now we have te basic interface that we are going to use in order to conect the buttons wth the backend functions.

### Activity 30 – Connecting backend with frontend

#### Objective
To be able to bring the methods that we wrote on the backend to the frontend.
#### Glossary

#### Explanation
First, the Maven project was converted into a Spring Boot project by modifying the `pom.xml` file and adding the required dependencies. A Spring Boot application class (`MatrixWebApplication`) was then created to start the backend server, while a REST controller (`GraphController`) was implemented to handle requests from the frontend. To transfer matrix data, a data transfer object (`MatrixRequest`) was created, allowing matrices entered in the HTML interface to be sent to the backend as JSON objects using JavaScript's Fetch API. CORS support was enabled to allow communication between the frontend and backend running on different ports. To verify that the connection was working correctly, a test endpoint was implemented and successfully accessed from the browser. Finally, a matrix was sent from the frontend to the backend and returned unchanged, confirming that the communication between the user interface and the Java matrix and graph algorithms was functioning correctly.

#### Code (Java) POM file
```java

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         https://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.5</version>
    </parent>

    <groupId>edu.nicolasQuintero</groupId>
    <artifactId>matrixWeb</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <java.version>21</java.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>

            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>

        </plugins>
    </build>

</project>

```

#### Code (java) MatrixWebApplication
```javascript

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MatrixWebApplication {
    public static void main(String[] args){
        SpringApplication.run(MatrixWebApplication.class, args);
    }
}

```
#### Code (java) MatrixRequest
```javascript

public class MatrixRequest {
    private int[][] matrix;
    public int[][] getMatrix(){
        return matrix;
    }
    public void setMatrix(int[][] matrix){
        this.matrix = matrix;
    }
}

```
#### Code (java) GraphController
```javascript

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
}

```

#### Example

#### Common Mistakes

#### Notes

#### Project Integration
Now that backend and frontend are connected, we can start to assign the java methods to the html buttons 
---

### Activity 31 – Graph Properties Frontend

#### Objective
to connect the java methods with the java functions in order to show it in the website.
#### Glossary

#### Explanation
In order to show the result of the Alghoritms in the website it is needed to create a new javaclass GraphPropertiesResponse that contains the elements that we are going to show in the website as getters and setter and they would be called then in the Graphcontroller class. Then we added a aysinc function in the javascript that calls the java functions and show them in the website by adding a new div in the html code.
#### Code (Java) GraphPropertiesResponse
```java

import java.util.ArrayList;

public class GraphPropertiesResponse {
    private ArrayList<ArrayList<Integer>> components;
    private ArrayList<Integer> radius;
    private ArrayList<Integer> diameter;
    private ArrayList<ArrayList<Integer>> center;

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
}


```
#### Code (Java) GraphController
```java

 @PostMapping("graphProperties")
    public GraphPropertiesResponse graphProperties(@RequestBody MatrixRequest request) throws InvalidMatrixException{
        GraphMatrix gm = new GraphMatrix(request.getMatrix(), false);
        GraphAlghoritm ga= new GraphAlghoritm(gm);
        GraphPropertiesResponse response = new GraphPropertiesResponse();
        response.setComponents(ga.components());
        response.setRadius(ga.radiuses());
        response.setDiameter(ga.diameters());
        response.setCenter(ga.center());
        return response;
    }

```

#### Code (javascript)
```javascript

async function graphProperties(){
    const matrix = getMatrixData("matrixA");
    const response = await fetch("http://localhost:8080/graphProperties",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            matrix:matrix
        })
    });
    const result = await response.json();
    document.getElementById("result").innerHTML=
    `<h3>Graph Properties</h3>
    <p><b>Components:</b>
    ${JSON.stringify(result.components)}
    </p>
    <p><b>Radius:</b>
    ${JSON.stringify(result.radius)}
    </p>
    <p><b>Diameter:</b>
    ${JSON.stringify(result.diameter)}
    </p>
    <p><b>Center:</b>
    ${JSON.stringify(result.center)}
    </p>
    `;
}

```
#### Code (html)
```html

<div id="result"></div>

```

#### Example

#### Common Mistakes

#### Notes

#### Project Integration
Now it is possibe to show the Graph Propierties in the website.
---

### Activity 32 – DistanceMatrix, Articulations, Blocks, Bridges

#### Objective
To show in the website the rest of the graph properties 
#### Glossary

#### Explanation
It was needed to add in the javaclass GraphController a method for every alghoritm method that we wanted to call as a reMatrixrequest that would be later called in the js code aysinc functions and showed in the website.
#### Code (HTML)
```html

<div id="result"></div>

```

#### Code (javascript)
```javascript

async function distanceMatrix(){
    const matrix = getMatrixData("matrixA");
    const response = await fetch("http://localhost:8080/distanceMatrix",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            matrix:matrix
        })
    });
    const result = await response.json();
    document.getElementById("result").innerHTML=
    `<h3>Distance Matrix</h3>
    <pre>${JSON.stringify(result)}</pre>
    `;
}

async function articulations(){
    const matrix = getMatrixData("matrixA");
    const response = await fetch("http://localhost:8080/articulations",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            matrix:matrix
        })
    });
    const result = await response.json();
    document.getElementById("result").innerHTML=
    `<h3>Articulations</h3>
    <p>${JSON.stringify(result)}</p>
    `;
}

async function bridges(){
    const matrix = getMatrixData("matrixA");
    const response = await fetch("http://localhost:8080/bridges",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            matrix:matrix
        })
    });
    const result = await response.json();
    document.getElementById("result").innerHTML=
    `<h3>Bridges</h3>
    <p>${JSON.stringify(result)}</p>
    `;
}

async function blocks(){
    const matrix = getMatrixData("matrixA");
    const response = await fetch("http://localhost:8080/blocks",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            matrix:matrix
        })
    });
    const result = await response.json();
    document.getElementById("result").innerHTML=
    `<h3>Blocks</h3>
    <p>${JSON.stringify(result)}</p>
    `;
}

```

#### Code (Java) GraphController
```java

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

```
#### Common Mistakes

#### Notes

#### Project Integration

Now we are able to show in the result div from the html the left graph propierties.

### Activity 52 – Matrix Operations 

#### Objective
To be able to show the results of the operations between 2 matrizes
#### Glossary

#### Explanation
In order to show the results from the operations it was needed to create a TwoMatrixRequest javaclass that contains the info from the matrix a and b, then a MatrixController javaclass that contains the the methods that would be called by the javascript async operation function and showed in the website.
#### Code (Java) TwoMatrixRequest
```java

public class TwoMatrixRequest {
    private int[][] matrixA;
    private int[][] matrixB;

    public int[][] getMatrixA() {
        return matrixA;
    }

    public void setMatrixA(int[][] matrixA) {
        this.matrixA = matrixA;
    }

    public int[][] getMatrixB() {
        return matrixB;
    }

    public void setMatrixB(int[][] matrixB) {
        this.matrixB = matrixB;
    }
}

```
#### Code (Java) MatrixController
```java

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class MatrixController {
    @PostMapping("/addition")
    public int [][] addition(@RequestBody TwoMatrixRequest request) throws InvalidMatrixException{
        MatrixWorkspace mw = new MatrixWorkspace();
        Matrix a = new Matrix (request.getMatrixA());
        Matrix b = new Matrix (request.getMatrixB());
        return mw.matrixAddition(a,b).getData();
    }

    @PostMapping("/substraction")
    public int [][] substraction(@RequestBody TwoMatrixRequest request) throws InvalidMatrixException{
        MatrixWorkspace mw = new MatrixWorkspace();
        Matrix a = new Matrix (request.getMatrixA());
        Matrix b = new Matrix (request.getMatrixB());
        return mw.matrixSubstraction(a,b).getData();
    }

    @PostMapping("/multiplication")
    public int [][] multiplication(@RequestBody TwoMatrixRequest request) throws InvalidMatrixException{
        MatrixWorkspace mw = new MatrixWorkspace();
        Matrix a = new Matrix (request.getMatrixA());
        Matrix b = new Matrix (request.getMatrixB());
        return mw.matrixMultiplication(a,b).getData();
    }
}


```
#### Code (javascript)
```javascript

async function matrixOperation(operation) {
    const matrixA = getMatrixData("matrixA");
    const matrixB = getMatrixData("matrixB");
    const response = await fetch("http://localhost:8080/"+ operation,{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify({
            matrixA:matrixA, matrixB:matrixB
        })
    });
    const result = await response.json();
    document.getElementById("result").innerHTML = `
    <h3>Result</h3>
    <pre>${JSON.stringify(result)}</pre>
    `;
}

function updateOptions(){
    const type = document.querySelector('input[name="matrixType"]:checked').value;
    const container = document.getElementById("optionsContainer");
    const matrixBContainer = document.getElementById("matrixBContainer");
    if(type === "matrix"){
        matrixBContainer.style.display = "block";
        container.innerHTML = `
            <h3>Matrix Operations</h3>
            <button onclick="matrixOperation('addition')">Addition</button>
            <button onclick="matrixOperation('substraction')">Substraction</button>
            <button onclick="matrixOperation('multiplication')">Multiplication</button>
        `;    
    }
    else{
        matrixBContainer.style.display="none";
        container.innerHTML =`
            <h3>Graph Algorithm</h3>
            <button onclick="graphProperties()">Graph Properties</button>
            <button onclick="distanceMatrix()">Distance Matrix</button>
            <button onclick="articulations()">Articulations</button>
            <button onclick="bridges()">Bridges</button>
            <button onclick="blocks()">Blocks</button>
        `;
    }
}
updateOptions();
```
#### Code (html)
```html

<div id="result"></div>

```
#### Example

#### Common Mistakes

#### Notes

#### Project Integration

Now we are able to see the results of the operations between 2 matrix.

### Activity 33 – Matrix to html

#### Objective
to show the results that are easier to show as a matrix than as a list 
#### Glossary

#### Explanation
We wrote a javascript function that takes the results show as list as a matrix table using two loops.

#### Code (javascript)
```javascript

function matrixToHTML(matrix){
    let rows = [];
    rows.push("<table border='1'>");
    for(let row of matrix){
        rows.push("<tr>");
        for(let value of row){
            rows.push(`<td>${value}</td>`);
        }
        row.push("</tr>");
    }
    rows.push("</table>");
    return rows.join("");
}

```
#### Example

#### Common Mistakes

#### Notes

#### Project Integration
Now we are able to see the operations as a Matrix

### Activity 34 – Error handling

#### Objective
to be able to show the java exceptions as errors in the website in order to also verify that the csv files are valid or not.
#### Glossary

#### Explanation
We implemented a new GlobalExceptionsHandler javaclass that is able to send de exceptions messages to the javascript code trouth the SpringBoot and then we modified the async functions in the javascript with try and catch in order to receibe the messages as a result if the matrix is not valid
#### Code (Java)
```java

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(InvalidMatrixException.class)
   @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidMatrix(InvalidMatrixException e){
       return e.getMessage();
   }
}

```

#### Code (javascript)
```javascript

async function graphProperties(){
    try{
        const matrix = getMatrixData("matrixA");
        const response = await fetch("http://localhost:8080/graphProperties",{
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                matrix:matrix
            })
        });
        if(!response.ok){
            const errorMessage = await response.text();
            throw new Error(errorMessage);
        }
        const result = await response.json();
        document.getElementById("result").innerHTML=
        `<h3>Graph Properties</h3>
        <p><b>Weighted:</b>
        ${result.weighted}
        </p>
        <p><b>Directed:</b>
        ${result.directed}
        </p>
        <p><b>Self Loops:</b>
        ${result.selfLoops}
        </p>
        <p><b>Components:</b>
        ${JSON.stringify(result.components)}
        </p>
        <p><b>Radius:</b>
        ${JSON.stringify(result.radius)}
        </p>
        <p><b>Diameter:</b>
        ${JSON.stringify(result.diameter)}
        </p>
        <p><b>Center:</b>
        ${JSON.stringify(result.center)}
        </p>
        `;
    }
    catch(error){
        document.getElementById("result").innerHTML=`
        <h3>Error</h3>
        <p>${error.message}</p>`
    }
}

async function distanceMatrix(){
    try{
        const matrix = getMatrixData("matrixA");
        const response = await fetch("http://localhost:8080/distanceMatrix",{
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                matrix:matrix
            })
        });
        if(!response.ok){
            const errorMessage = await response.text();
            throw new Error(errorMessage);
        }
        const result = await response.json();
        document.getElementById("result").innerHTML=
        `<h3>Distance Matrix</h3>
        ${matrixToHTML(result)}
        `;
    }
    catch(error){
        document.getElementById("result").innerHTML=`
        <h3>Error</h3>
        <p>${error.message}</p>`
    }
}

async function articulations(){
    try{
        const matrix = getMatrixData("matrixA");
        const response = await fetch("http://localhost:8080/articulations",{
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                matrix:matrix
            })
        });
        if(!response.ok){
            const errorMessage = await response.text();
            throw new Error(errorMessage);
        }
        const result = await response.json();
        document.getElementById("result").innerHTML=
        `<h3>Articulations</h3>
        <p>${JSON.stringify(result)}</p>
        `;
    }
    catch(error){
        document.getElementById("result").innerHTML=`
        <h3>Error</h3>
        <p>${error.message}</p>`
    }
}

async function bridges(){
    try{
        const matrix = getMatrixData("matrixA");
        const response = await fetch("http://localhost:8080/bridges",{
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                matrix:matrix
            })
        });
        if(!response.ok){
            const errorMessage = await response.text();
            throw new Error(errorMessage);
        }
        const result = await response.json();
        document.getElementById("result").innerHTML=
        `<h3>Bridges</h3>
        <p>${JSON.stringify(result)}</p>
        `;
    }
    catch(error){
        document.getElementById("result").innerHTML=`
        <h3>Error</h3>
        <p>${error.message}</p>`
    }
}

async function blocks(){
    try{
        const matrix = getMatrixData("matrixA");
        const response = await fetch("http://localhost:8080/blocks",{
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                matrix:matrix
            })
        });
        if(!response.ok){
            const errorMessage = await response.text();
            throw new Error(errorMessage);
        }
        const result = await response.json();
        document.getElementById("result").innerHTML=
        `<h3>Blocks</h3>
        <p>${JSON.stringify(result)}</p>
        `;
    }
    catch(error){
        document.getElementById("result").innerHTML=`
        <h3>Error</h3>
        <p>${error.message}</p>`
    }
}

async function matrixOperation(operation) {
    try{
        const matrixA = getMatrixData("matrixA");
        const matrixB = getMatrixData("matrixB");
        const response = await fetch("http://localhost:8080/"+ operation,{
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                matrixA:matrixA, matrixB:matrixB
            })
        });
        if(!response.ok){
            const errorMessage=await response.text();
            throw new Error(errorMessage);
        }
        const result = await response.json();
        document.getElementById("result").innerHTML = `
        <h3>Result</h3>
        ${matrixToHTML(result)}
        `;
    }
    catch(error){
        document.getElementById("result").innerHTML=`
        <h3>Error</h3>
        <p>${error.message}</p>`
    }
}

```

#### Example

#### Common Mistakes

#### Notes

#### Project Integration
Now we are able to see if the graphMatrix that we inserted or generate is valid or not
### Activity 35 – import CSV 



### Activity 56 – Error handling
### Activity 57 – Step-by-step explanation

---

