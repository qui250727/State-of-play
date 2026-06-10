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

    const currentCols = table.rows[0].cells.length;

    const maxCols = window.innerWidth <= 768 ? 10 : 20;

    if(currentCols >= maxCols){

        document.getElementById("result").innerHTML = `
            <h3>Warning</h3>
            <p>Maximum number of columns reached (${maxCols}).</p>
        `;

        return;
    }

    for(let row of table.rows){
        const cell = row.insertCell();
        cell.innerHTML = '<input type="number" value="0">';
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
            <div class="card">
                <h3>Matrix Operations</h3>

                <button onclick="matrixOperation('addition')">Addition</button>
                <button onclick="matrixOperation('substraction')">Substraction</button>
                <button onclick="matrixOperation('multiplication')">Multiplication</button>
            </div>
        `;
    }
    else{
        matrixBContainer.style.display="none";
        container.innerHTML = `
            <div class="card">

                <h3>Graph Algorithm</h3>

                <input type="file" id="csvFile">
                <button onclick="importCSV()">Load CSV</button>

                <br><br>

                <button onclick="graphProperties()">Graph Properties</button>
                <button onclick="distanceMatrix()">Distance Matrix</button>
                <button onclick="showBFSInput()">BFS</button>
                <button onclick="showDFSInput()">DFS</button>
                <button onclick="showEccentricityInput()">Eccentricity</button>
                <button onclick="articulations()">Articulations</button>
                <button onclick="bridges()">Bridges</button>
                <button onclick="blocks()">Blocks</button>

            </div>
        `;
    }
}
if(document.querySelector('input[name="matrixType"]')){
    updateOptions();
}

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

async function importCSV() {
    try{
        const file=document.getElementById("csvFile").files[0];
        const formData = new FormData();
        formData.append("file",file);
        const response = await fetch("http://localhost:8080/importCSV",
        {
        method:"POST",
        body:formData});
        console.log(response);
        const matrix=await response.json();
        fillMatrix("matrixA", matrix);
    }
    catch(error){
        document.getElementById("result").innerHTML=`
        <h3>Error</h3>
        <p>${error.message}</p>`
    }
}

function fillMatrix(tableId, matrix){
    const table =document.getElementById(tableId);
    table.innerHTML = "";
    for(const row of matrix){
        const tr = document.createElement("tr");
        for(const value of row){
            const td = document.createElement("td");
            const input = document.createElement("input");
            input.type = "number";
            input.value = value;
            td.appendChild(input);
            tr.appendChild(td);
        }
        table.appendChild(tr);
    }
}

async function bfs() {
    try{
        const matrix=getMatrixData("matrixA");
        const startNode=parseInt(document.getElementById("startNode").value);
        const response=await fetch("http://localhost:8080/bfs",
        {
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                matrix:matrix,
                startNode:startNode
            })
        });
        const result=await response.json();
        document.getElementById("result").innerHTML=`
        <h3>Breadth First Search (BFS)</h3>
        <p>${result.join(" → ")}</p>
        `;
    }
    catch(error){
        document.getElementById("result").innerHTML=`
        <h3>Error</h3>
        <p>${error.message}</p>
        `;
    }
}

async function dfs() {
    try{
        const matrix=getMatrixData("matrixA");
        const startNode=parseInt(document.getElementById("startNode").value);
        const response=await fetch("http://localhost:8080/dfs",
        {
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                matrix:matrix,
                startNode:startNode
            })
        });
        const result=await response.json();
        document.getElementById("result").innerHTML=`
        <h3>Depth First Search (DFS)</h3>
        <p>${result.join(" → ")}</p>
        `;
    }
    catch(error){
        document.getElementById("result").innerHTML=`
        <h3>Error</h3>
        <p>${error.message}</p>
        `;
    }
}

function showBFSInput(){
     document.getElementById("result").innerHTML=`
        <h3>Breadth First Search (BFS)</h3>
        <label>Start Node:</label>
        <input type="number" id="startNode" value="0" min="0">
        <br><br>
        <button onclick="bfs()">Run BFS</button>
    `;
}

function showDFSInput(){
    document.getElementById("result").innerHTML=`
        <h3>Depth First Search (DFS)</h3>
        <label>Start Node:</label>
        <input type="number" id="startNode" value="0" min="0">
        <br><br>
        <button onclick="dfs()">Run DFS</button>
    `;
}

function showEccentricityInput(){
    document.getElementById("result").innerHTML=`
        <h3>Eccentricity</h3>
        <label>Node:</label>
        <input type="number" id="node" value="0" min="0">
        <br><br>
        <button onclick="eccentricity()">Calculate</button>
    `;
}

async function eccentricity() {
    try{
        const matrix=getMatrixData("matrixA");
        const node=parseInt(document.getElementById("node").value);
        const response=await fetch("http://localhost:8080/eccentricity",{
            method:"POST",
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify({
                matrix:matrix,
                node:node
            })
        });
        const result=await response.json();
        document.getElementById("result").innerHTML=`
        <h3>Eccentricity</h3>
        <p><b>Node ${node}:</b> ${result}</p>
        `;
    }
    catch(error){
        document.getElementById("result").innerHTML=`
        <h3>Error</h3>
        <p>${error.message}</p>
        `;
    }
}

function toggleDocumentation(){

    const sideMenu=document.getElementById("sideMenu");
    const documentationTab=document.getElementById("documentationTab");

    sideMenu.classList.toggle("open");

    if(sideMenu.classList.contains("open")){
        documentationTab.classList.add("hidden");
    }
    else{
        documentationTab.classList.remove("hidden");
    }
}

document.addEventListener("click", function(event){

    console.log("CLICK DETECTED");

    const sideMenu=document.getElementById("sideMenu");
    const documentationTab=document.getElementById("documentationTab");

    if(
        sideMenu.classList.contains("open")
        &&
        !sideMenu.contains(event.target)
        &&
        !documentationTab.contains(event.target)
    ){

        console.log("CLOSING MENU");

        sideMenu.classList.remove("open");
        documentationTab.classList.remove("hidden");
    }
});

const docs = [
    {
        title:"Java Matrices",
        link:"pages/documentation.html?doc=block1"
    },
    {
        title:"Graph Fundamentals",
        link:"pages/documentation.html?doc=block3"
    },
    {
        title:"pages/documentation.html?doc=block4",
        link:"pages/block3.html"
    },
    {
        title:"Input / Output",
        link:"pages/documentation.html?doc=block4"
    },
    {
        title:"Frontend (HTML, CSS, JS)",
        link:"pages/documentation.html?doc=block5"
    }
];

function showSuggestions(){

    const results =
        document.getElementById("searchResults");

    results.innerHTML="";

    docs.forEach(doc=>{

        results.innerHTML += `
            <a class="search-item"
               href="${doc.link}">
               ${doc.title}
            </a>
        `;
    });

    results.style.display="block";
}

function filterDocumentation(){

    const search =
        document.getElementById("searchInput")
        .value
        .toLowerCase();

    const results =
        document.getElementById("searchResults");

    results.innerHTML="";

    const filtered =
        docs.filter(doc =>
            doc.title
            .toLowerCase()
            .includes(search)
        );

    filtered.forEach(doc=>{

        results.innerHTML += `
            <a class="search-item"
               href="${doc.link}">
               ${doc.title}
            </a>
        `;
    });

    results.style.display =
        filtered.length > 0
        ? "block"
        : "none";
}

document.addEventListener("click",function(event){

    const searchInput =
        document.getElementById("searchInput");

    const searchResults =
        document.getElementById("searchResults");

    if(
        !searchInput.contains(event.target)
        &&
        !searchResults.contains(event.target)
    ){
        searchResults.style.display="none";
    }
});