import {UserService} from "../../service/usuario-service.js";

const userService = new UserService();
const inputFields = ["name", "email", "cellphone"]

const toolbarRoutes = {
    admin: [
        {
            href: "./admin/dashboard.html",
            text: "Dashboard"
        }
    ],
    coletor: [
        {
            href: "./coletador/lista-demandas.html",
            text: "Coletas Disponíveis"
        },
        {
            href: "./coletador/minhas-demandas.html",
            text: "Minhas Coletas"
        }
    ],
    produtor: [
        {
            href: "./produtor/meus-residuos.html",
            text: "Meus Residuos"
        },
        {
            href: "./produtor/criar-demanda.html",
            text: "Cadastrar Residuo"
        }
    ]
}

async function setupPageUserProfile() {
    const user = await userService.getUserDetail();

    updateToolBarForTypeUser();
    
    for (let i = 0; i < inputFields.length; i++) {
        changeInputValue(inputFields[i], user[inputFields[i]]);
    }

    document.getElementById('edit-button').addEventListener('click', handleEditFields);
    document.getElementById('save-button').addEventListener('click', handleSaveFields);
    document.getElementById('cancel-button').addEventListener('click', handleCancelFields);
    document.getElementById("logout-button").addEventListener('click', handleLogout);
}

function getUserId(){
    return localStorage.getItem("id");
}

function getUserType(){
    return localStorage.getItem("userType");
}

function changeInputValue(inputId, newValue) {
    const inputElement = document.getElementById(inputId);
    inputElement.value = newValue;
}

function handleEditFields() {
    viewButtonLogout()
    const inputFields = document.querySelectorAll('input');
    inputFields.forEach((input) => {
        input.classList.remove('form-control-plaintext');
        input.classList.add('form-control');
        input.removeAttribute('readonly');
    });

    const saveButtonElement = document.getElementById("save-button");
    saveButtonElement.classList.remove("d-none");
    
    const cancelButtonElement = document.getElementById("cancel-button");
    cancelButtonElement.classList.remove("d-none");

    const editButtonElement = document.getElementById("edit-button");
    editButtonElement.classList.add("d-none");

}

async function handleSaveFields() {
    const userId = getUserId();
    const userData = await userService.getUser(userId);

    const inputFields = document.querySelectorAll('input');
    inputFields.forEach(function(input) {
        userData[input.id] = input.value;
    });
    
    await userService.putUser(userData);
    window.location.reload();
}

function handleCancelFields(){
    window.location.reload();
}

function updateToolBarForTypeUser() {
    const itensToolbar = toolbarRoutes[getUserType()]

    adicionarItensNavbar(itensToolbar)
}

function viewButtonLogout(){
    const buttonLogout = document.getElementById("logout-button")
    if (buttonLogout.classList.contains("d-none")) {
        buttonLogout.classList.remove("d-none");
    } else {
        buttonLogout.classList.add("d-none");
    }
}

function handleLogout() {
    localStorage.removeItem("token");
    localStorage.removeItem("userType");
    window.location.href = "../index.html";
}

function adicionarItensNavbar(itens) {
    const navbar = document.getElementById("navbar-ul");

    itens.forEach(item => {
        const li = document.createElement("li");
        li.className = "nav-item";

        const a = document.createElement("a");
        a.className = "nav-link";
        a.href = item.href;
        a.textContent = item.text;

        li.appendChild(a);
        navbar.appendChild(li);
    });
}

window.addEventListener("load", setupPageUserProfile);