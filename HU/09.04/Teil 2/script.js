
//Teil 2

import persons from "./persons.json" with { type: "json" };

function renderPersons() {
    // persons in den tbody hineinrendern

    const tbody = document.querySelector("#tbody");
    tbody.innerHTML = "";

    for (const person of persons) {
        const tr = document.createElement("tr");

        const tdId = document.createElement("td");
        tdId.textContent = person.id;
        tr.appendChild(tdId);
        const tdName = document.createElement("td");
        tdName.textContent = person.name;
        tr.appendChild(tdName);
        const tdAge = document.createElement("td");
        tdAge.textContent = person.alter;
        tr.appendChild(tdAge);
        const tdHeight = document.createElement("td");
        tdHeight.textContent = person.groesse;
        tr.appendChild(tdHeight);
        const tdBirthDate = document.createElement("td");
        tdBirthDate.textContent = person.geburtsdatum;
        tr.appendChild(tdBirthDate);
        const tdOrigin = document.createElement("td");
        tdOrigin.textContent = person.herkunft;
        tr.appendChild(tdOrigin);
        const tdWeight = document.createElement("td");
        tdWeight.textContent = person.gewicht;
        tr.appendChild(tdWeight);

        tbody.appendChild(tr);
    }
}

let clickCountThage = 0;
thage.addEventListener("click", () => {
     clickCountThage++;
    if (clickCountThage % 2 === 1) { //Modul wechselt zwischen 1 und 2
        console.log("Thage was even clicked");
        persons.sort((a, b) => a.alter - b.alter);
    } 
    else {
        console.log("Thage was odd clicked");
        persons.sort((a, b) => b.alter - a.alter);
    }
renderPersons();
});

let clickCountThid = 0;
thid.addEventListener( "click", ()=> {
    clickCountThid++;
    if (clickCountThid % 2 === 1) {
        console.log("Thid was even clicked");
        persons.sort((a,b) => a.id - b.id);
    }
    else {
        console.log("thid was odd clicked");
        persons.sort((a,b)=> b.id - a.id);
    }
renderPersons();
});

let clickCountName = 0;
thname.addEventListener("click", () => {
    clickCountName++;
    if (clickCountName % 2 === 1){
        console.log ("Thname was even clicked");
        persons.sort((a, b) => {
    return a.name.localeCompare(b.name);
    })}
    else {
        console.log ("Thname was odd clicked");
        persons.sort((a, b) => {
    return b.name.localeCompare(a.name);
    })}
    renderPersons();
});


let clickCountSize = 0;
thsize.addEventListener("click", () => {
    clickCountSize++;
    if (clickCountSize % 2 === 1){
        console.log ("thsize was even clicked");
        persons.sort((a,b)=> {
        return a.groesse - b.groesse;
    })}
    else {
        console.log ("thsize was odd clcked");
        persons.sort((a,b) => (b.groesse - a.groesse))
    }
    renderPersons();
});

let clickCountBirth = 0;
thbirth.addEventListener("click", () =>{
    clickCountBirth++;
    if (clickCountBirth % 2 === 1){
        console.log("thbirth even was clicked");
        persons.sort((a,b) => {
        return a.geburtsdatum.localeCompare(b.geburtsdatum);
    })}
    else {
        console.log("thbirth even was clicked");
        persons.sort((a,b) => {
        return b.geburtsdatum.localeCompare(a.geburtsdatum);
    })}
    renderPersons();
});

let clickCounterOrigin = 0;
thorigin.addEventListener("click", () =>{
    clickCounterOrigin++;
    if(clickCounterOrigin % 2 === 1){
        console.log("thorigin even");
        persons.sort((a,b)=> {
        return a.herkunft.localeCompare(b.herkunft);
    })}
    else{
        console.log("thorigin odd");
        persons.sort((a,b)=> {
        return b.herkunft.localeCompare(a.herkunft);
    })}
    renderPersons();
});

let clickCountWeight = 0;
thweight.addEventListener("click", () =>{
    clickCountWeight++;
    if(clickCountWeight % 2 === 1){
        console.log ("thweight even");
        persons.sort((a,b) => {
        return a.gewicht - b.gewicht;
    })}
    else{
        console.log ("thweight odd");
        persons.sort((a,b) => {
        return b.gewicht - a.gewicht;
    })}
    renderPersons();
});


// renderPersons();
window.renderPersons = renderPersons;
renderPersons();
