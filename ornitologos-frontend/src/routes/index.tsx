import { Navigate, Route, Routes } from 'react-router-dom';

import { useEffect } from 'react';
import { Catalago } from '../pages';
import { PaginaInicial } from '../pages/pagina-inicial/PaginaInicial';
import { SignIn } from '../pages/signin/SignIn';
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
        label: 'Meus avistamentos',
        icon: 'visibility',
        path: '/avistamento',
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
    ]);
  }, []);

  return (
    <Routes>
      <Route path='/pagina-inicial' element={<PaginaInicial />} />
      <Route path='/catalogo' element={<Catalago />} />
      <Route path='/login' element={<SignIn />} />
      <Route path='/cadastro-usuario' element={<SignUp />} />
      <Route path='*' element={<Navigate to='/pagina-inicial' />} />
    </Routes>
  );
};
