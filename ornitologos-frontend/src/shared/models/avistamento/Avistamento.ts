export interface IListagemAvistamento {
  id: number;
  data: string;
  horario: string;
  local: string;
  ave: string;
}

export interface IDetalheAvistamento {
  id?: number;
  data: string;
  horario: string;
  local: string;
  ave: string;
}

export type IAvistamentoComTotalCount = {
  data: IListagemAvistamento[];
  totalCount: number;
};
