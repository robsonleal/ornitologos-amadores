import { AxiosResponse } from 'axios';

export const responseInterceptor = (response: AxiosResponse) => {
  //Configurando interceptor para requisições bem sucedidas
  return response;
};
