import { useEffect, useMemo, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import { BarraDeFerramentas, GridCard } from '../../shared/components';
import { useDebounce } from '../../shared/hooks';
import { LayoutBaseDePagina } from '../../shared/layouts';
import { IListagemAve } from '../../shared/models';
import { AvesService } from '../../shared/services/api/aves/AvesService';

export const Catalago = () => {
  const [searchParams, setSearchParams] = useSearchParams();
  const { debounce } = useDebounce();
  const [cards, setCards] = useState<IListagemAve[]>([]);
  const [totalCount, setTotalCount] = useState(0);
  const [isLoading, setIsLoading] = useState(true);

  const busca = useMemo(() => {
    return searchParams.get('busca') || '';
  }, [searchParams]);

  useEffect(() => {
    setIsLoading(true);
    debounce(() => {
      AvesService.getAll(1, busca).then((result) => {
        setIsLoading(false);
        if (result instanceof Error) {
          alert(result.message);
        } else {
          console.log(result);
          setCards(result.data);
          setTotalCount(result.totalCount);
        }
      });
    });
  }, [busca]);

  return (
    <LayoutBaseDePagina
      titulo='Catálogo'
      barraDeFerramentas={
        <BarraDeFerramentas
          textoDaBusca={busca}
          aoMudarTextoDeBusca={(texto) =>
            setSearchParams({ busca: texto }, { replace: true })
          }
        />
      }
    >
      <GridCard cards={cards} totalCount={totalCount} />
    </LayoutBaseDePagina>
  );
};
