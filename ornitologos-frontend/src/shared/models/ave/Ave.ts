let tHabitat: 'BCA' | 'BSA' | 'CAA' | 'CAU' | 'CSA' | 'CSB';

export interface IListagemAve {
  id: number;
  nomePt: string;
  nomeEn: string;
  nomeLt: string;
  tamanho: number;
  genero: string;
  cor: string;
  familia: string;
  imagem: string;
  habitat?: typeof tHabitat[];
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
  imagem: string;
  habitat?: typeof tHabitat[];
}

export type IAvesComTotalCount = {
  data: IListagemAve[];
  totalCount: number;
};
