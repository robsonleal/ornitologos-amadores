import { Navigate, Route, Routes } from 'react-router-dom';

import { useEffect } from 'react';
import {
  Avistamentos,
  Catalago,
  PaginaInicial,
  SignIn,
  SignUp,
} from '../pages';
import { useBarraTopoContext, useDrawerContext } from '../shared/contexts';

export const AppRoutes = () => {
  const { setDrawerOption } = useDrawerContext();
  const { setBarraTopoOption } = useBarraTopoContext();

  useEffect(() => {
    setDrawerOption([
      {
        label: 'Meus avistamentos',
        icon: 'visibility',
        path: '/avistamentos',
      },
    ]);
  }, []);

  useEffect(() => {
    setBarraTopoOption([
      {
        label: 'Página Inicial',
        path: '/',
      },
      {
        label: 'Ver catálogo',
        path: '/aves',
      },
    ]);
  }, []);

  return (
    <Routes>
      <Route path='/' element={<PaginaInicial />} />
      <Route path='/aves' element={<Catalago />} />
      <Route path='/avistamentos' element={<Avistamentos />} />
      <Route path='/login' element={<SignIn />} />
      <Route path='/cadastro' element={<SignUp />} />
      <Route path='*' element={<Navigate to='/' />} />
    </Routes>
  );
};
