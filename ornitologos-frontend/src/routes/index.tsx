import { useEffect } from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import { Catalago } from '../pages';
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
    </Routes>
  );
};
