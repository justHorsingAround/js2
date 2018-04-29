const OK = 200;
const BAD_REQUEST = 400;
const UNAUTHORIZED = 401;
const NOT_FOUND = 404;
const INTERNAL_SERVER_ERROR = 500;

let loginDivEl;

function onLoginButtonClicked(){
    
}

function onLoad(){
    loginDivEl = document.getElementById('login');

    const loginButtonEl = document.getElementById('login-btn');
    loginButtonEl.addEventListener('click', onLoginButtonClicked);

}

document.addEventListener('DOMContentLoaded', onLoad);