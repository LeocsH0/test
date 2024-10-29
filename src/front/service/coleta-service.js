export class ColetaService {

    constructor(){
      this.urlBase = "http://localhost:8080/api/v1/coletas";
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
  
    async postColeta(coleta){
      const response = await fetch(this.urlBase, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${this.token}`
        },
        body: JSON.stringify(coleta),
      });
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const data = await response.json();
      return data;
    }
  
    async getColetasPorStatus(status){
      const response = await fetch(`${this.urlBase}?status=${status}`, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${this.token}`
        }
      });
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const coletas = await response.json();
      return coletas;
    }
  
    async getColeta(id){
      const response = await fetch(`${this.urlBase}/${id}`, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${this.token}`
        }
      });

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const coletas = await response.json();
      return coletas;
    }
  
    async putColeta(coleta){
      const response = await fetch(`${this.urlBase}/${coleta.id}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${this.token}`
        },
        body: JSON.stringify(coleta),
      });
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const data = await response.json();
      return data;
    }
  
    async deleteColeta(id){
      const response = await fetch(`${this.urlBase}/${id}`, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${this.token}`
        },
      });
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const data = await response.json();
      return data;
    }
  
    async alocarColetor(coletaId, coletorId) {
      const response = await fetch(`${this.urlBase}/${coletaId}`, {
        method: 'PATCH',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${this.token}`
        },
        body: JSON.stringify({collectorId: coletorId}),
      });
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      const data = await response.json();
      return data;
    }
  
    async getColetaProdutorId(produtorId) {
      const response = await fetch(`${this.urlBase}?producerId=${produtorId}`, {
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${this.token}`
        }
      });
  
      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }
      
      const coletas = await response.json();
      return coletas;
    }

    async getToken(){
      return localStorage.getItem('token');
    }
  
  }