import { Navigate, Route, Routes } from 'react-router-dom';

import { useEffect } from 'react';
import { Catalago } from '../pages';
import { PaginaInicial } from '../pages/pagina-inicial/PaginaInicial';
import SignIn from '../pages/SignIn';
import SignUp from '../pages/SignUp';
import { useBarraTopoContext, useDrawerContext } from '../shared/contexts';

export const AppRoutes = () => {
  const { setDrawerOption } = useDrawerContext();
  const { setBarraTopoOption } = useBarraTopoContext();

  useEffect(() => {
    setDrawerOption([
      {
        label: 'Ver Perfil',
        icon: 'person',
        path: '/pagina-inicial',
      },
      {
        label: 'Sair',
        icon: 'logout',
        path: '/pagina-inicial',
      },
    ]);
  }, []);

  useEffect(() => {
    setBarraTopoOption([
      {
        label: 'Página Inicial',
        path: '/pagina-inicial',
      },
      {
        label: 'Ver catálogo',
        path: '/catalogo',
      },
      {
        label: 'Avistamentos',
        path: '/avistamentos',
      },
    ]);
  }, []);

  return (
    <Routes>
      <Route path='/pagina-inicial' element={<PaginaInicial />} />
      <Route path='/catalogo' element={<Catalago />} />
      <Route path='/login' element={<SignIn />} />
      <Route path='/cadastro' element={<SignUp />} />
      <Route path='*' element={<Navigate to='/pagina-inicial' />} />
    </Routes>
  );
};
