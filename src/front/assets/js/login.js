import { AutenticacaoService } from "../../service/autenticacao-service.js";

const autenticacaoService = new AutenticacaoService();

const rotas = {
    admin: "views/admin/dashboard.html",
    produtor: "views/produtor/meus-residuos.html",
    coletor: "views/coletor/coletas.html"
}

function observerSubmitForm() {
    const formLogin = document.getElementById("login_form");
    formLogin.addEventListener('submit', handleLogin)
}

async function handleLogin(event) {
    event.preventDefault(); 
    try {
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;
        validateFormFields(email, password)
        
        const userLogin = {
            email: email,
            password: password,
        }

        const response = await autenticacaoService.login(userLogin);
        autenticacaoService.setToken(response.token);

        const token = jwt_decode(response.token);
        autenticacaoService.setTipoUsuario(token.type);

        window.location.href = rotas[token.type]; 

    } catch (error) {
        alert(error.message)
        console.error(error)
    }
}

function validateFormFields(email, password) {
    if (!email) throw new Error("O campo email é obrigatório.");
    if (!password) throw new Error("O campo senha é obrigatório.");
}


window.addEventListener("load", observerSubmitForm);