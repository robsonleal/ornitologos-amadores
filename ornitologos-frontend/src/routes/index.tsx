import { Navigate, Route, Routes } from 'react-router-dom';

import { useEffect } from 'react';
import { Catalago } from '../pages';
import SignIn from '../pages/SignIn';
import SignUp from '../pages/SignUp';
import { useDrawerContext } from '../shared/contexts';

export const AppRoutes = () => {
  const { setDrawerOption } = useDrawerContext();

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

  return (
    <Routes>
      <Route path='/pagina-inicial' element={<Catalago />} />
      <Route path='*' element={<Navigate to='/pagina-inicial' />} />
      <Route path='/login' element={<SignIn />} />
      <Route path='/cadastro' element={<SignUp />} />
    </Routes>
  );
};
