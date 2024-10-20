export class AutenticacaoService {

    constructor(){
      this.urlBase = "http://localhost:8080/api/v1/auth";
    }
  
    async cadastrar(user){
        const REGISTER_URL = "/register";

        const response = await fetch(this.urlBase + REGISTER_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(user),
        });
  
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
  
        return;
    }

    async login(user){
        const REGISTER_URL = "/login";

        const response = await fetch(this.urlBase + REGISTER_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(user),
        });
  
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
  
        const data = await response.json();

        return data;
    }

    async setToken(token){
        localStorage.setItem('token', token);
    }

    async getToken(){
        localStorage.getItem('token');
    }

    async setTipoUsuario(userType){
        localStorage.setItem('userType', userType);
    }

    async getTipoUsuario(){
        localStorage.getItem('userType');
    }
}