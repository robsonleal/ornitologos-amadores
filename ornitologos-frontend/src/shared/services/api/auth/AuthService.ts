import { Usuario } from '../../../models';
import { Api } from '../axios-config';

const fazerLogin = async (user: Usuario): Promise<Usuario | Error> => {
  try {
    const { data } = await Api.post('/api/v1/auth/login', user);

    if (data) {
      return data;
    }

    return new Error('Erro no login!');
  } catch (error) {
    console.log(error);
    return new Error(
      (error as { message: string }).message || 'Erro no login.'
    );
  }
};

export const AuthService = {
  fazerLogin,
};
