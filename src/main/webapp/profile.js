function onProfileLoad(user) {
    clearMessages();

    showContents(['main-content']);

    const userEmailEl = document.getElementById('email');
    const userPasswordEl = document.getElementById('password');
    const userNameEl = document.getElementById('name');

    userEmailEl.textContent = user.email;
    userPasswordEl.textContent = user.passw;
    userNameEl.textContent = user.name;
}