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

const thage = document.getElementById("thage");
thage.addEventListener("click", () => {
    console.log("thage was clicked");
    persons.sort((a, b) => {
        return a.alter - b.alter;
    });
    renderPersons();
});

const thid = document.getElementById("thid");
thid.addEventListener("click", () => {
    console.log("thid was clicked dude");
    persons.sort((a,b) => {
        return a.id - b.id;
    });
    renderPersons();
});

const thname = document.getElementById("thname");
thname.addEventListener("click", () => {
    console.log ("This time was thname :)");
    persons.sort((a, b) => {
    return a.name.localeCompare(b.name);
    });
    renderPersons();
});


const thsize = document.getElementById("thsize");
thsize.addEventListener("click", () => {
    console.log ("Now thgroesse");
    persons.sort((a,b)=> {
        return a.groesse - b.groesse;
    });
    renderPersons();
});

const thbirth = document.getElementById("thbirth");
thbirth.addEventListener("click", () =>{
    console.log("you just clicked thbirth");
    persons.sort((a,b) => {
        return a.geburtsdatum.localeCompare(b.geburtsdatum);
    });
    renderPersons();
});

const thorigin = document.getElementById("thorigin");
thorigin.addEventListener("click", () =>{
    console.log("Be careful, this time is thorigin");
    persons.sort((a,b)=> {
        return a.herkunft.localeCompare(b.herkunft);
    });
    renderPersons();
});

const thweight = document.getElementById("thweight");
thweight.addEventListener("click", () =>{
    console.log ("now it is thweight");
    persons.sort((a,b) => {
        return a.gewicht - b.gewicht;
    });
    renderPersons();
});


// renderPersons();
window.renderPersons = renderPersons;
renderPersons();
