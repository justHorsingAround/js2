let userIdEl;

function onTitleResponse() {
    const mainContentDivEl = document.getElementById("main-content");
    if (this.status === OK) {
        const poems = JSON.parse(this.responseText);

        onPoemsLoad(poems);
    }
    else {
        onOtherResponse(mainContentDivEl, this);
    }
}

function onProfileLoad(user) {
    clearMessages();

    showContents(['main-content']);


    userIdEl = document.getElementById('id');
    const userEmailEl = document.getElementById('email');
    const userPasswordEl = document.getElementById('password');
    const userNameEl = document.getElementById('name');


    userEmailEl.textContent = user.email;
    userPasswordEl.textContent = user.passw;
    userNameEl.textContent = user.name;
    userIdEl.textContent = user.id;


    requestTitleContent();

}

function requestTitleContent() {
    const params = new URLSearchParams();
    params.append('id', userIdEl.innerText);

    const xhr = new XMLHttpRequest();
        xhr.addEventListener('load', onTitleResponse);
        xhr.addEventListener('error', onNetworkError);
        xhr.open('POST', 'profile');
        xhr.send(params);

}
