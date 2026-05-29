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

### Activity 47 – Basic HTML structure

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

### Activity 48 – Matrix vs GraphMatrix

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

### Activity 49 – Dynamic table generation
### Activity 50 – Read input values
### Activity 51 – Input validation
### Activity 52 – File upload (CSV)
### Activity 53 – Display matrix
### Activity 54 – Operation buttons
### Activity 55 – Display results
### Activity 56 – Error handling
### Activity 57 – Step-by-step explanation

---

