import { Api } from '../axios-config';

export const cadastroUsuario = async (dados: any, setDado: any) => {
  await Api.post('/api/v1/auth/cadastro', dados)
    .then((response) => {
      setDado(response.data);
    })
    .catch((error) => {
      console.log(error.response.data);
    });
};
