import { Enviroment } from '../../../environment';
import { IAvesComTotalCount, IDetalheAve } from '../../../models';
import { Api } from '../axios-config';

const getAll = async (
  page = 1,
  filter = ''
): Promise<IAvesComTotalCount | Error> => {
  try {
    const urlRelativa = `/aves?_page=${page}&_limit=${Enviroment.LIMITE_AVES}&nomePt_like=${filter}`;

    const { data, headers } = await Api.get(urlRelativa);

    if (data) {
      return {
        data,
        totalCount: Number(headers['x-total-count'] || Enviroment.LIMITE_AVES),
      };
    }

    return new Error('Erro ao listar os registros.');
  } catch (error) {
    return new Error(
      (error as { message: string }).message || 'Erro ao listar os registros'
    );
  }
};

const getById = async (id: number): Promise<IDetalheAve | Error> => {
  try {
    const { data } = await Api.get(`/aves/${id}`);

    if (data) {
      return data;
    }

    return new Error('Erro ao consultar o registro.');
  } catch (error) {
    console.error(error);
    return new Error(
      (error as { message: string }).message || 'Erro ao consultar o registro.'
    );
  }
};

const create = async (dados: IDetalheAve): Promise<number | Error> => {
  try {
    const { data } = await Api.post('/aves', dados);

    if (data) {
      return data.id;
    }

    return new Error('Erro ao criar o registro.');
  } catch (error) {
    console.error(error);
    return new Error(
      (error as { message: string }).message || 'Erro ao criar o registro.'
    );
  }
};

const updateById = async (
  id: number,
  dados: IDetalheAve
): Promise<void | Error> => {
  try {
    await Api.put(`/aves/${id}`, dados);
  } catch (error) {
    console.error(error);
    return new Error(
      (error as { message: string }).message || 'Erro ao atualizar o registro.'
    );
  }
};

const deleteById = async (id: number): Promise<void | Error> => {
  try {
    await Api.delete(`/aves/${id}`);
  } catch (error) {
    console.error(error);
    return new Error(
      (error as { message: string }).message || 'Erro ao apagar o registro.'
    );
  }
};

export const AvesService = {
  getAll,
  getById,
  create,
  updateById,
  deleteById,
};
