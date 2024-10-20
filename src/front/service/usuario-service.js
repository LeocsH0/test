export class UserService {

    constructor() {
        this.urlBase = "http://localhost:8080/api/v1/usuarios";
        this.token = null;
        this.init();
    }

    async init(){
        try{
            this.token = await this.getToken();
        } catch(e){
            console.error('Erro ao obter o token: ', e);
        }
    }
  
    async getUsers() {
        const response = await fetch(this.urlBase, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${this.token}`
            }
        });
  
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
    
        const users = await response.json();
        return users;
    }
  
    async getUserDetail() {
        const response = await fetch(`${this.urlBase}/detail`, {
            headers: {
                'Content-Type': 'application/json',
                'Authorization': `Bearer ${this.token}`
            }
        });
    
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        
        const user = await response.json();
        return user;
    }

    async getToken(){
        return localStorage.getItem('token');
    }
}