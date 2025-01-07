function collect() {
    event.preventDefault();

    const nome = document.getElementById("nome").value;
    const cognome = document.getElementById("cognome").value;
    const datanascita = document.getElementById("datanascita").value;
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    const user = {
        nome: nome,
        cognome: cognome,
        datanascita: datanascita,
        username: username,
        password: password
    };

    var users = JSON.parse(localStorage.getItem("users")) || [];

    users.push(user);

    localStorage.setItem("users", JSON.stringify(users));

    alert("Registrazione completata!");

    window.location = "login.html";
}
function verifica(){
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    if (localStorage.getItem("users")) {
        var datiUtente = localStorage.getItem("users");
        var containerDati = JSON.parse(datiUtente);
        flag=false;
        for (let i = 0; i < containerDati.length; i++) {
            if (containerDati[i].username === username && containerDati[i].password === password) {
                user = {
                    username: username,
                    password: password
                }
                flag=true;
                if(!sessionStorage.getItem("user")){
                    alert("Hai fatto il login");
                    sessionStorage.setItem("user", user)
                    window.location = "http://127.0.0.1:5500/home.html";
                }
                else{
                    alert("Un account è già loggato")
                }
                break;
            }
        }
        if(!flag) {
            alert("Hai sbagliato ad inserire le credenziali");
        }
    } else {
        alert("Account non esistente, effettuare la registrazione");
        window.location = "http://127.0.0.1:5500/login/register.html"
    }
    event.preventDefault();
}
function elimina(){
    localStorage.removeItem("users");
    alert("Dati eliminati...")
}
function checklogin() {
    if(!sessionStorage.getItem("user"))
    {
        window.location = "http://127.0.0.1:5500/login/login.html"
    } else{
        showProfile()
    }
}

function logout(){
    sessionStorage.removeItem("user");
    window.location = "http://127.0.0.1:5500/login/login.html"
}