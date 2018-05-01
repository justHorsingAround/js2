let divEl;


function onPoemsLoad(poems) {
    divEl = document.getElementById('titles');
    const titleListEl = document.getElementById('title-list');
    const divContEl = document.getElementById('poem-content');

    for(let i = 0; i < poems.length; ++i) {
        let poem = poems[i];
        console.log(poem);

        titleListEl.appendChild(createContentList(poem));
    }

    divEl.appendChild(titleListEl);
    divEl.appendChild(divContEl);

}


function createContentList(poem) {
    const ulEl = document.createElement('ul');

    const pEl = document.createElement('p');
    pEl.textContent = poem.title;

    const liEl = document.createElement('li');
    onMouseAction(pEl, function(){getPoemBody(poem);});
    liEl.appendChild(pEl);

    ulEl.appendChild(liEl);

    return ulEl;

}

function onMouseAction(pEl, callback) {
    pEl.addEventListener("click", callback);
    pEl.addEventListener("mouseover", function(){pEl.style.backgroundColor="blue"}, false);
    pEl.addEventListener("mouseout", function(){pEl.style.backgroundColor="white"}, false);
}

function getPoemBody(poem){
    showContents(['main-content', 'search-content']);

    const divContEl = document.getElementById('poem-content');

    while (divContEl.firstChild) {
        divContEl.removeChild(divContEl.firstChild);
    }

    const ulEl = document.createElement('ul');

    const pEl = document.createElement('p');
    pEl.textContent = poem.text;

    const liEl = document.createElement('li');
    liEl.appendChild(pEl);

    ulEl.appendChild(liEl);
    divContEl.appendChild(ulEl);

    onFilterLoad(poem.text);

}