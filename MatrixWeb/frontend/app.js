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