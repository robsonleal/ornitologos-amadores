export interface IListagemAve {
  id: number;
  nomePt: string;
  nomeEn: string;
  nomeLt: string;
  tamanho: number;
  genero: string;
  cor: string;
  familia: string;
  habitat: string[];
}

export interface IDetalheAve {
  id: number;
  nomePt: string;
  nomeEn: string;
  nomeLt: string;
  tamanho: number;
  genero: string;
  cor: string;
  familia: string;
  habitat: string[];
}

export type IAvesComTotalCount = {
  data: IListagemAve[];
  totalCount: number;
};
