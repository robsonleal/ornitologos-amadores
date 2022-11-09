import { BarraDeFerramentas } from '../../shared/components';
import { LayoutBaseDePagina } from '../../shared/layouts';

export const Catalago = () => {
  return (
    <LayoutBaseDePagina
      titulo='Catálogo'
      barraDeFerramentas={<BarraDeFerramentas />}
    >
      Aqui vai os cards de aves
    </LayoutBaseDePagina>
  );
};
