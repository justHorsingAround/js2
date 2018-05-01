function onFilterLoad(text){
    const filterDivEl = document.getElementById('search-content');
    const filterButtonEl = document.getElementById('filter-btn');
    filterButtonEl.addEventListener('click', function(){onFilterButtonClicked(text);});
}


function onFilterButtonClicked(text) {
    const filterFormEl = document.forms['filter-form'];

    const filterInputEl = filterFormEl.querySelector('input[name="keyword"]');

    const keywords = filterInputEl.value;

    var temp = text;
    var regex = new RegExp("\\b" + keywords + "\\b", "g");
    var count = (temp.match(regex) || []).length;

    addToWebpage(count);
}

function addToWebpage(count){
    resultDivEl = document.getElementById('result');


    const pEl = document.createElement('p');
    pEl.textContent = "Words found " + count.toString() + "times";
    resultDivEl.appendChild(pEl);
}