import { Usuario } from '../../../models';
import { Api } from '../axios-config';

export const cadastroUsuario = async (dados: Usuario) => {
  try {
    const { data } = await Api.post('/auth/cadastro', dados);

    if (data) {
      return { data };
    }

    return new Error('Erro no cadastro!');
  } catch (error) {
    console.log(error);
    return new Error(
      (error as { message: string }).message || 'Erro no cadastro.'
    );
  }
};
