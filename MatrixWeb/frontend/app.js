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
            <button onclick="graphProperties()">Graph Properties</button>
            <button onclick="distanceMatrix()">Distance Matrix</button>
            <button onclick="articulations()">Articulations</button>
            <button onclick="bridges()">Bridges</button>
            <button onclick="blocks()">Blocks</button>
        `;
    }
}
updateOptions();

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