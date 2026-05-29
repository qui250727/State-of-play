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