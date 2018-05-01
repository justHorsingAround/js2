function onPoemsLoad(poems) {
    const divEl = document.getElementById('title-list');

    for(let i = 0; i < poems.length; ++i) {
        let poem = poems[i];

        divEl.appendChild(createContentList(poem.title, function(){}));
    }

}

function createContentList(element, mouseCallback) {
    const ulEl = document.createElement('ul');

    const pEl = document.createElement('p');
    pEl.textContent = element;



    const liEl = document.createElement('li');
    onMouseAction(pEl, function(){getPoemBody();});
    liEl.appendChild(pEl);

    ulEl.appendChild(liEl);

    return ulEl;

}

function onMouseAction(pEl, callback) {
    pEl.addEventListener("click", callback);
    pEl.addEventListener("mouseover", function(){pEl.style.backgroundColor="blue"}, false);
    pEl.addEventListener("mouseout", function(){pEl.style.backgroundColor="white"}, false);
}

function getPoemBody(){
    console.log('in poembody');

}