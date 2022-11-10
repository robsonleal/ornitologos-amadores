import axios from 'axios';

export const api = axios.create({
    baseURL: 'http://localhost:8080',
    timeout:5000
 } );

export const cadastroUsuario = async(url: any,dados: any,setDado:any) => { 

    await api.post(url,dados)
    .then(response => {
        setDado(response.data)
    })
    .catch((error) =>{
        console.log(error.response.data)
    });
} 


export const sair = () => { 
    localStorage.removeItem('token');
}
  







