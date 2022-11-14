import { useEffect, useMemo } from 'react';
import { useSearchParams } from 'react-router-dom';
import { BarraDeFerramentas } from '../../shared/components';
import { LayoutBaseDePagina } from '../../shared/layouts';
import { AvesService } from '../../shared/services/api/aves/AvesService';

export const Catalago = () => {
  const [searchParams, setSearchParams] = useSearchParams();

  const busca = useMemo(() => {
    return searchParams.get('busca') || '';
  }, [searchParams]);

  useEffect(() => {
    AvesService.getAll(1, busca).then((result) => {
      if (result instanceof Error) {
        alert(result.message);
      } else {
        console.log(result);
      }
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
      Aqui vai os cards de aves
    </LayoutBaseDePagina>
  );
};
