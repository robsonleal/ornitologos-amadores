import axios from 'axios';

export const api = axios.create({
    baseURL: 'http://localhost:8080',
    timeout:5000
 } );

export const fazerLogin = async(url: any,dados: any,setDado:any,setToken:any) => { 

    await api.post(url,dados)
    .then(response => {
        setDado(response.data)
        setToken(response.data.token)
    })
    .catch((error) =>{
        console.log(error.response.data)
    });
} 

export const sair = () => { 
    localStorage.removeItem('token');
}
  