const docs = [
    "block1",
    "block2",
    "block3",
    "block4",
    "block5"
];

async function loadDocumentation(){

    try{

        const params =
            new URLSearchParams(window.location.search);

        const doc =
            params.get("doc") || "block1";

        const response =
            await fetch(`../../docs/blocks/${doc}.md`);

        if(!response.ok){
            throw new Error("Markdown file not found");
        }

        const markdown =
            await response.text();

        document.getElementById(
            "documentationContent"
        ).innerHTML =
            marked.parse(markdown);

        addCopyButtons();
        updateNavigationButtons();
    }
    catch(error){

        document.getElementById(
            "documentationContent"
        ).innerHTML = `
            <h2>Error</h2>
            <p>${error.message}</p>
        `;

        updateNavigationButtons();
    }
}

function goHome(){

    window.location.href =
        "../index.html";
}

function nextDoc(){

    const params =
        new URLSearchParams(window.location.search);

    const current =
        params.get("doc") || "block1";

    const index =
        docs.indexOf(current);

    if(index < docs.length - 1){

        window.location.href =
            `documentation.html?doc=${docs[index + 1]}`;
    }
}

function previousDoc(){

    const params =
        new URLSearchParams(window.location.search);

    const current =
        params.get("doc") || "block1";

    const index =
        docs.indexOf(current);

    if(index > 0){

        window.location.href =
            `documentation.html?doc=${docs[index - 1]}`;
    }
}

function updateNavigationButtons(){

    const params =
        new URLSearchParams(window.location.search);

    const current =
        params.get("doc") || "block1";

    const index =
        docs.indexOf(current);

    const prevButton =
        document.getElementById("prevButton");

    const nextButton =
        document.getElementById("nextButton");

    if(prevButton){

        prevButton.style.display =
            index === 0
                ? "none"
                : "inline-block";
    }

    if(nextButton){

        nextButton.style.display =
            index === docs.length - 1
                ? "none"
                : "inline-block";
    }
}

function addCopyButtons(){

    document.querySelectorAll("pre").forEach(pre => {

        const button = document.createElement("button");

        button.textContent = "COPY";
        button.className = "copy-button";

        button.onclick = () => {

            const textarea =
                document.createElement("textarea");

            textarea.value = pre.innerText;

            document.body.appendChild(textarea);

            textarea.select();

            document.execCommand("copy");

            document.body.removeChild(textarea);

            button.textContent = "COPIED!";

            setTimeout(() => {

                button.textContent = "COPY";

            },1500);
        };

        pre.style.position = "relative";

        pre.appendChild(button);
    });
}

loadDocumentation();